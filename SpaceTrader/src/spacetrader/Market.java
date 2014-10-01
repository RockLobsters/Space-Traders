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
  public PoliticalSystem politicalSystem;
<<<<<<< HEAD
=======
  
  public Market(Planet planet)
  {
    this(planet.getSolarSystem().getPoliticalSystem().getSupply(), planet);
  }
>>>>>>> master

  /**
   * @param goods  - an array list of goods that the market has
   * @param planet - on which the market is located
   */
  public Market(ArrayList<Good> goods, Planet planet)
  {
    this.goods = goods;
    this.planet = planet;
    this.politicalSystem = planet.getSolarSystem().getPoliticalSystem();
    this.prices = priceList(goods);
  }

  /**
   * @param goods - list of goods the market has
   *
   * @return	a list of the prices of the goods
   */
  public ArrayList<Integer> priceList(ArrayList<Good> goods)
  {
    int siz = goods.size();
    ArrayList<Integer> listP = new ArrayList();
    for(int i = 0; i < siz; i++)
    {
      listP.add(calcPrice(goods.get(i)));
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
    /*
    Random rand = new Random();
    boolean value = rand.nextBoolean();
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

    if(containsGood(politicalSystem.highSupply(), good))
    {
      price = price * .75;
    }
    if(containsGood(politicalSystem.lowSupply(), good))
    {
      price = price * 1.25;
    }
    if(containsGood(politicalSystem.highDemand(), good))
    {
      price = price * 1.5;
    }
    if(containsGood(politicalSystem.lowDemand(), good))
    {
      price = price * .5;
    }

    return price;
    */
    return good.basePrice;
  }

  public static boolean containsGood(Good[] list, Good good)
  {
    for(Good listItem : list)
    {
      if(listItem == good)
      {
        return true;
      }
    }
    return false;
  }

  /**
   * Get the price of a good in this market
   *
   * @param good The good to query the price for
   *
   * @return The price of the good or -1 if the good is not found
   */
  public int getPrice(Good good)
  {
    int index = getIndex(good);
    if(index != -1)
    {
      return prices.get(index);
    }
    return -1;
  }

  /**
   * Gets the index of a good in the goods ArrayList
   *
   * @param good The good to search for
   *
   * @return The index of the good or -1 if the good is not found
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
   * @param good     The good in question
   * @param quantity The amount of the good to be bought
   * @param player   The player buying the good
   *
   * @return True if the good is available at this Market
   */
  public boolean canBuy(Good good, int quantity, Player player)
  {
    int index = getIndex(good);
    if(index == -1)
    {
      return false;
    }
    Good toBuy = goods.get(index);
    if(toBuy.quantity <= 0)
    {
      return false;
    }
    if(toBuy.quantity < quantity)
    {
      return false;
    }
    if(prices.get(index) * quantity > player.getMoney())
    {
      return false;
    }
    return true;
  }

  /**
   * Buys a good
   *
   * @param good     The good to buy
   * @param quantity The amount of the good to buy
   * @param player   The player buying the good
   *
   * @return True if the buy was successful
   */
  public boolean Buy(Good good, int quantity, Player player)
  {
    if(canBuy(good, quantity, player) == false)
    {
      return false;
    }
    else
    {
      int index = getIndex(good);
      good = goods.get(index);
      good.setQuantity(good.getQuantity() - quantity);
      player.subtractMoney(prices.get(index) * quantity);
      boolean found = false;
      ArrayList<Good> cargo = player.getShip().cargo;
      for(int i = 0; i < cargo.size() && !found; i++)
      {
        if(cargo.get(i) == good)
        {
          cargo.get(i).setQuantity(cargo.get(i).getQuantity() - quantity);
          found = true;
        }
      }
      good.setQuantity(quantity);
      cargo.add(good);
      return true;
    }
  }

  /**
   * @param good     The good in question
   * @param quantity The amount of the good to be sold
   * @param player   The player selling the good
   *
   * @return True if the player can sell the good
   */
  public boolean canSell(Good good, int quantity, Player player)
  {
    ArrayList<Good> cargo = player.getShip().cargo;
    int index = -1;
    for(int i = 0; index == -1 && i < cargo.size(); i++)
    {
      if(cargo.get(i) == good)
      {
        index = i;
      }
    }
    if(index == -1)
    {
      return false;
    }
    Good toSell = cargo.get(index);
    if(toSell.quantity < quantity)
    {
      return false;
    }
    return true;
  }

  /**
   * Sells a good
   *
   * @param good     The good to sell
   * @param quantity The amount of the good to sell
   * @param player   The player selling the good
   *
   * @return True if the sell was successful
   */
  public boolean Sell(Good good, int quantity, Player player)
  {
    if(canSell(good, quantity, player) == false)
    {
      return false;
    }
    else
    {
      ArrayList<Good> cargo = player.getShip().cargo;
      int index = -1;
      for(int i = 0; index == -1 && i < cargo.size(); i++)
      {
        if(cargo.get(i) == good)
        {
          index = i;
        }
      }
      if(cargo.get(index).quantity == quantity)
      {
        cargo.remove(index);
      }
      else
      {
        cargo.get(index).quantity -= quantity;
      }
      player.addMoney(prices.get(getIndex(good)) * quantity);
      return true;
    }
  }
}
