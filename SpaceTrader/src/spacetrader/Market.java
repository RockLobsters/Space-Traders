/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spacetrader;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Jacqueline Foreman
 */
public class Market
{

    public ArrayList<Good> goods;
    public Planet planet;
    public ArrayList<Integer> prices;
    public PoliticalSystem gov;
    public Player player;

    // public Market(Planet planet)
    // {
    //     this(new ArrayList(), planet);
    // }

    /**
     * @param goods  - an array list of goods that the market has
     * @param planet - on which the market is located
     */
    public Market(Planet planet, Player player)
    {
        this.player = player;
        this.goods = planet.getGoods();
        this.planet = planet;
        this.gov = planet.getSolarSystem().getPoliticalSystem();
        this.prices = priceList(goods);
    }

    /**
     * @param goods - list of goods the market has
     *
     * @reutrn	a list of the prices of the goods
     */
    public ArrayList<Integer> priceList(ArrayList<Good> goods)
    {
        ArrayList<Integer> out = new ArrayList();
        for (int i = 0; i < goods.size(); i++)
        {
            out.add(calcPrice(goods.get(i)));
            goods.get(i).setPrice(calcPrice(goods.get(i)));
        }
        return out;
    }

    /**
     * @param good - the particular good for which the price is being calculated
     *
     * @return	the price of the good
     */
    public int calcPrice(Good good)
    {
        Random rand = new Random();
        boolean value = Math.random() < .5;
        int var = rand.nextInt() % good.getVar();
        var = var / 10;
        int tl = planet.getSolarSystem().getTechLevel();
        int price = good.getBasePrice()
                    + (good.getIPL() * (tl - good.getMTLP()));

        if (value)
        {
            price = price + (good.getBasePrice() * var);
        }
        else
        {
            price = price - (good.getBasePrice() * var);
        }

        if (good.cr())
        {
            price = price / 2;
        }
        if (good.er())
        {
            price = price * 2;
        }
        if (good.ie())
        {
            price = price * price;
        }

        if (containsGood(gov.highSupply(), good))
        {
            price = price * .75;
        }
        if (containsGood(gov.lowSupply(), good))
        {
            price = price * 1.25;
        }
        if (containsGood(gov.highDemand(), good))
        {
            price = price * 1.5;
        }
        if (containsGood(gov.lowDemand(), good))
        {
            price = price * .5;
        }

        return price;
    }


    public ArrayList<Good> getGoods() {
        return goods;
    }

    /**
     * completes a buy transaction
     *
     */
    public boolean buy()
    {
        Ship ship = player.getShip();

        if (ship.isFull) {
            return false;
        } else {
            Transaction trans = new Transaction();
            trans.buy();
        }
    }

    /**
     * completes a trade transaction
     *
     * @param good - good to trade
     *
     * @return	whether or not the good was traded
     */
    public boolean trade(Good good)
    {
        int tl = planet.getSolarSystem().getTechLevel();

        if (good.getMTLU() > tl)
        {
            return false;
        }
        else
        {
            good.setPrice(calcPrice(good));
            goods.add(good);
            prices.add(new Integer(good.getPrice()));

            Tranaction trans = new Transaction();
            trans.sell();
            return true;
        }
    }

    public boolean containsGood(Good[] list, Good good)
    {
        for (int i = 0; i < list.length; i++)
        {
            if (list(i).getName().equals(good.getName()))
            {
                return true;
            }
        }
        return false;
    }
}
