/*
 * Copyright (C) 2014 Addison Amiri
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
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import spacetrader.Flea;
import spacetrader.Planet;
import spacetrader.Player;

/**
 *
 * @author Addison Amiri
 */
public class PlayerTest {

    public PlayerTest() {
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

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    @Test(timeout=100)
    public void getNameTest() {
        Player player = new Player("Johnny Hammersticks");
        assertEquals("Johnny Hammersticks", player.getName());
    }
    
    @Test(timeout=100)
    public void moneyTest() {
        Player player = new Player("Johnny Hammersticks");
        assertEquals(1000.0, player.getMoney(), 0.0);
        player.addMoney(200);
        assertEquals(1200.0, player.getMoney(), 0.0);
        player.subtractMoney(200);
        assertEquals(1000.0, player.getMoney(), 0.0);
    }
    
    @Test(timeout=100)
    public void wantedLevelTest() {
        Player player = new Player("Johnny Hammersticks");
        assertEquals(0, player.getWantedLevel());
        player.setWantedLevel(1);
        assertEquals(1, player.getWantedLevel());
    }

    @Test(timeout=100)
    public void statsTest() {
        Player player = new Player("Johnny Hammersticks");
        
        assertEquals(0, player.getPilot());
        assertEquals(0, player.getFighter());
        assertEquals(0, player.getTrader());
        assertEquals(0, player.getEngineer());
        assertEquals(0, player.getInvestor());
        
        player.setPilot(1);
        player.setFighter(2);
        player.setTrader(3);
        player.setEngineer(4);
        player.setInvestor(5);
        
        assertEquals(1, player.getPilot());
        assertEquals(2, player.getFighter());
        assertEquals(3, player.getTrader());
        assertEquals(4, player.getEngineer());
        assertEquals(5, player.getInvestor());
    }
    
    @Test(timeout=100)
    public void shipTest() {
        Player player = new Player("Johhny Hammersticks");
        assertEquals("Gnat", player.getShip().getName());
        player.setShip(new Flea());
        assertEquals("Flea", player.getShip().getName());
    }
    
    @Test(timeout=100)
    public void currentLocationTest() {
        Player player = new Player("Johnny Hammersticks");
        player.setCurrentLocation(new Planet("Tommy Noble"));
        assertEquals("Tommy Noble", player.getCurrentLocation().getName());
    }
}
