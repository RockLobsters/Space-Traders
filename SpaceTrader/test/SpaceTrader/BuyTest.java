/*
 * Copyright (C) 2014 Jacqueline Foreman
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package SpaceTrader;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import spacetrader.Flea;
import spacetrader.Planet;
import spacetrader.Player;
import spacetrader.Market;
import spacetrader.SolarSystem;
import spacetrader.CapitalistState;
import spacetrader.Good;
import spacetrader.GoodType;

/**
 *
 * @author Jacqueline Foreman
 */
public class BuyTest {

    public BuyTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Tests a valid buy of one item.
     */
    @Test(timeout = 100)
    public void validBuyTest() {
	// array list market and planet for shit
	Planet planet = new Planet("Planet", 1, 1);
	SolarSystem ss = new SolarSystem("SS", new CapitalistState(), 7);
	planet.setSolarSystem(ss);
	ArrayList<Good> goodList = new ArrayList<>();
	goodList.add(new Good(GoodType.WATER, 100));
	planet.getMarket().goods = goodList;
	Market market = planet.getMarket();

	Player player = new Player("Player");

	player.addMoney(10000000);
	Boolean bought = market.buy(GoodType.WATER, 1, player);
	ArrayList<Good> car = player.getShip().getCargo();
	assertEquals(car.isEmpty(), false);
	assertEquals(car.get(0).getQuantity(), 1);
	assertEquals(car.get(0).getType(), GoodType.WATER);
	assertEquals(bought, true);
	assertEquals(market.goods.get(0).getQuantity(), 99);
    }

    /**
     * Tests a buy that should fail due to no money.
     */
    @Test(timeout = 100)
    public void noMoneyTest() {
	Planet planet = new Planet("Planet", 1, 1);
	SolarSystem ss = new SolarSystem("SS", new CapitalistState(), 7);
	planet.setSolarSystem(ss);
	ArrayList<Good> goodList = new ArrayList<>();
	goodList.add(new Good(GoodType.WATER, 100));
	planet.getMarket().goods = goodList;
	Market market = planet.getMarket();

	// array list market and planet for shit
	// set ship to player
	Player player = new Player("Player");
	player.subtractMoney(1000);
	Boolean bought = market.buy(GoodType.WATER, 1, player);
	ArrayList<Good> car = player.getShip().getCargo();
	assertEquals(car.isEmpty(), true);
	assertEquals(bought, false);
	assertEquals(market.goods.get(0).getQuantity(), 100);
    }

    /**
     * Tests a buy that should fail due to lack of cargo space.
     */
    @Test(timeout = 100)
    public void noSpaceValues() {
	Planet planet = new Planet("Planet", 1, 1);
	SolarSystem ss = new SolarSystem("SS", new CapitalistState(), 7);
	planet.setSolarSystem(ss);
	ArrayList<Good> goodList = new ArrayList<>();
	goodList.add(new Good(GoodType.WATER, 100));
	planet.getMarket().goods = goodList;
	Market market = planet.getMarket();
	// array list market and planet for shit
	// set ship to player
	Player player = new Player("Player");
	player.addMoney(10000000);
	Boolean bought = market.buy(GoodType.WATER, 20, player);
	ArrayList<Good> car = player.getShip().getCargo();
	assertEquals(car.isEmpty(), true);
	assertEquals(bought, false);
	assertEquals(market.goods.get(0).getQuantity(), 100);
    }

    /**
     * Tests a buying the same good twice.
     */
    @Test(timeout = 100)
    public void sameGoodTwice() {
	Planet planet = new Planet("Planet", 1, 1);
	SolarSystem ss = new SolarSystem("SS", new CapitalistState(), 7);
	planet.setSolarSystem(ss);
	ArrayList<Good> goodList = new ArrayList<>();
	goodList.add(new Good(GoodType.WATER, 100));
	planet.getMarket().goods = goodList;
	Market market = planet.getMarket();
	// array list market and planet for shit
	// set ship to player
	Player player = new Player("Player");
	player.addMoney(10000000);
	Boolean bought = market.buy(GoodType.WATER, 1, player);
	bought = market.buy(GoodType.WATER, 1, player);
	ArrayList<Good> car = player.getShip().getCargo();
	assertEquals(bought, true);
	assertEquals(car.isEmpty(), false);
	assertEquals(car.get(0).getQuantity(), 2);
	assertEquals(car.get(0).getType(), GoodType.WATER);
	assertEquals(market.goods.get(0).getQuantity(), 98);
    }

    /**
     * Tests a buying two different goods.
     */
    @Test(timeout = 100)
    public void twoDifferentGoods() {
	Planet planet = new Planet("Planet", 1, 1);
	SolarSystem ss = new SolarSystem("SS", new CapitalistState(), 7);
	planet.setSolarSystem(ss);
	ArrayList<Good> goodList = new ArrayList<>();
	goodList.add(new Good(GoodType.WATER, 100));
	goodList.add(new Good(GoodType.FOOD, 100));
	planet.getMarket().goods = goodList;
	Market market = planet.getMarket();
	// array list market and planet for shit
	// set ship to player
	Player player = new Player("Player");
	player.addMoney(10000000);
	Boolean bought = market.buy(GoodType.WATER, 1, player);
	bought = market.buy(GoodType.FOOD, 1, player);
	ArrayList<Good> car = player.getShip().getCargo();

	int index1;
	int index2;
	if (car.get(0).getType().equals(GoodType.WATER)) {
	    index1 = 0;
	    index2 = 1;
	} else {
	    index2 = 0;
	    index1 = 1;
	}

	assertEquals(bought, true);
	assertEquals(car.isEmpty(), false);
	assertEquals(car.size(), 2);
	assertEquals(car.get(0).getQuantity(), 1);
	assertEquals(car.get(index1).getType(), GoodType.WATER);
	assertEquals(car.get(index2).getType(), GoodType.FOOD);

    }

    /**
     * Tests a valid buy after a sell.
     */
    @Test(timeout = 100)
    public void buyThenSellThenBuy() {
	Planet planet = new Planet("Planet", 1, 1);
	SolarSystem ss = new SolarSystem("SS", new CapitalistState(), 7);
	planet.setSolarSystem(ss);
	ArrayList<Good> goodList = new ArrayList<>();
	goodList.add(new Good(GoodType.WATER, 100));
	planet.getMarket().goods = goodList;
	Market market = planet.getMarket();

	Player player = new Player("Player");
	player.addMoney(10000000);
	Boolean bought = market.buy(GoodType.WATER, 1, player);
	bought = market.sell(GoodType.WATER, 1, player);
	bought = market.buy(GoodType.WATER, 1, player);

	ArrayList<Good> car = player.getShip().getCargo();

	assertEquals(bought, true);
	assertEquals(car.isEmpty(), false);
	assertEquals(car.size(), 1);
	assertEquals(car.get(0).getQuantity(), 1);
	assertEquals(car.get(0).getType(), GoodType.WATER);
	assertEquals(market.goods.get(0).getQuantity(), 99);
    }

    /**
     * Tests a buy that should fail due to the planet having too love of a TL.
     */
    @Test(timeout = 100)
    public void lowerMTLP() {
	Planet planet = new Planet("Planet", 1, 1);
	SolarSystem ss = new SolarSystem("SS", new CapitalistState(), 1);
	planet.setSolarSystem(ss);
	ArrayList<Good> goodList = new ArrayList<>();
	goodList.add(new Good(GoodType.ROBOTS, 100));
	planet.getMarket().goods = goodList;
	Market market = planet.getMarket();

	Player player = new Player("Player");
	player.addMoney(10000000);
	Boolean bought = market.buy(GoodType.ROBOTS, 1, player);
	ArrayList<Good> car = player.getShip().getCargo();
	assertEquals(car.isEmpty(), true);
	assertEquals(bought, false);
	assertEquals(market.goods.get(0).getQuantity(), 100);
    }

    /**
     * Tests a buy that should fail due to requesting a higher quantity than
     * available.
     */
    @Test(timeout = 100)
    public void noGoodMarketTest() {
	Planet planet = new Planet("Planet", 1, 1);
	SolarSystem ss = new SolarSystem("SS", new CapitalistState(), 1);
	planet.setSolarSystem(ss);
	ArrayList<Good> goodList = new ArrayList<>();
	goodList.add(new Good(GoodType.WATER, 0));
	planet.getMarket().goods = goodList;
	Market market = planet.getMarket();

	Player player = new Player("Player");
	player.addMoney(10000000);
	Boolean bought = market.buy(GoodType.WATER, 1, player);
	ArrayList<Good> car = player.getShip().getCargo();
	assertEquals(car.isEmpty(), true);
	assertEquals(bought, false);
    }

}
