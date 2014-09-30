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

  /**
   * @param goods  - an array list of goods that the market has
   * @param planet - on which the market is located
   */
  public Market(ArrayList<Good> goods, Planet planet)
  {
    this.goods = goods;
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
    int siz = goods.size();
    ArrayList<Integer> listP = new ArrayList<Integer>();
    boolean added = true;

    for(int i = 0; i < siz; i++)
    {
      added = listP.add(new Integer(calcPrice(goods.get(i))));
      goods.get(i).setPrice(calcPrice(goods.get(i)));
    }

    return listP;
  }

  /**
   * @param good - the particular good for which the price is being calculated
   *
   * @return	the price of the good
   */
  public int calcPrice(Good good)
  {
    Random rand = new Random();
    boolean value = randomno.nextBoolean();
    int var = rand.nextInt() % good.getVar();
    var = var / 10;
    int tl = planet.getSolarSystem().getTechLevel();
    int price = good.getBasePrice()
                        + (good.getIPL() * (tl - good.getMTLP()));

    if(value)
    {
      price = price + (good.getBasePrice() * var);
    }
    else
    {
      price = price - (good.getBasePrice() * var);
    }

    if(good.cr())
    {
      price = price / 2;
    }
    if(good.er())
    {
      price = price * 2;
    }
    if(good.ie())
    {
      price = price * price;
    }

    if(containsGood(gov.highSupply(), good))
    {
      price = price * .75;
    }
    if(containsGood(gov.lowSupply(), good))
    {
      price = price * 1.25;
    }
    if(containsGood(gov.highDemand(), good))
    {
      price = price * 1.5;
    }
    if(containsGood(gov.lowDemand(), good))
    {
      price = price * .5;
    }

    return price;
  }

  /**
   * completes a buy transaction
   *
   */
  public void buy()
  {
    Transaction trans = new Transaction();
    trans.buy();
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

    if(good.getMTLU() > tl)
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
    for(int i < 0; i< list.length; i++)
    {
			if(list(i).getName().equals(good.getName()))
      {
        return true;
      }
    }
    return false;
  }
  
  /**
   * Get the price of a good in this market
   * 
   * @param good  The good to query the price for
   * 
   * @return      The price of the good or -1 if the good is not found
   */
  public int getPrice(Good good)
  {
    for(int i = 0; i < goods.size(); i++)
    {
      if(good.type == goods.get(i).type)
      {
        return prices.get(i);
      }
    }
    return -1;
  }
  
  /**
   * Gets the index of a good in the goods ArrayList
   * 
   * @param good  The good to search for
   * 
   * @return      The index of the good or -1 if the good is not found
   */
  private int getIndex(Good good)
  {
    for(int i = 0; i < goods.size(); i++)
    {
      if(good.type == goods.get(i).type)
      {
        return i;
      }
    }
    return -1;
  }
  
  /**
   * @param good      The good in question
   * @param quantity  The amount of the good to be bought
   * @param player    The player buying the good
   * 
   * @return          True if the good is available at this Market
   */
  public boolean canBuy(Good good, int quantity, Player player)
  {
    //TODO
    int index = getIndex(good);
    if(index == -1)
    {
      return false;
    }
    return true;
  }
  
  /**
   * Buys a good
   * 
   * @param good      The good to buy
   * @param quantity  The amount of the good to buy
   * @param player    The player buying the good
   * 
   * @return          True if the buy was successful
   */
  public boolean Buy(Good good, int quantity, Player player)
  {
    //TODO
    return true;
  }
  
  /**
   * @param good      The good in question
   * @param quantity  The amount of the good to be sold
   * @param player    The player selling the good
   * 
   * @return          True if the player can sell the good
   */
  public boolean canSell(Good good, int quantity, Player player)
  {
    //TODO
    return true;
  }
  
  /**
   * Sells a good
   * 
   * @param good      The good to sell
   * @param quantity  The amount of the good to sell
   * @param player    The player selling the good
   * 
   * @return          True if the sell was successful
   */
  public boolean Sell(Good good, int quantity, Player player)
  {
    //TODO
    return true;
  }
}
