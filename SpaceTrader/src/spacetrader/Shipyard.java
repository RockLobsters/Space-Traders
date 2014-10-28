/*
 * Copyright (C) 2014 Kristen Lawrence
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
package spacetrader;

import java.util.ArrayList;
import java.util.Random;
import java.io.Serializable;

/**
 * Creates a Shipyard for buying new Ships and selling old Ships + cargo
 * @author Kristen Lawrence
 */
public class Shipyard implements Serializable{
  public ArrayList<Ship> ships;
  public Planet planet;
  public ArrayList<Double> prices;
  public PoliticalSystem politicalSystem;
  public int techLevel;
  
  /**
   * Constructor sets planet
   * @param planet - Planet home of shipyard
   */
  public Shipyard(Planet planet) {
      this.ships = new ArrayList<>();
      ships.add(0, new Gnat());
      //ships.add(0, new Gnat());
      this.planet = planet;
  }
  
  /**
   * sets solarSystem to shipyard for retrieving techlevel and gov
   * @param solarSystem - solarSystem of the planet
   */
  public void setSolarSystem(SolarSystem solarSystem)
  {
      this.politicalSystem = solarSystem.getPoliticalSystem();
      this.techLevel = solarSystem.getTechLevel();
  }
  
  /**
   * Does Player have enough money to buy selected ship
   * @param price - cost of ship
   * @param player - player whose wallet will be checked
   * @return false if player cannot afford ship otherwise true
   */
  public boolean canBuyShip(int price, Player player){
    if(price > player.getMoney())
    {
      return false;
    }
    return true;
  }
  
  /**
   * Checks if player can afford ship and proceeds with transaction if true this
   * includes selling all cargo and equipment. Also transfers escape pod if 
   * there is one. 
   * @param player - to whom the new ship will go to
   * @param newShip - the new ship for player
   * @return true if transaction worked otherwise false (player cannot afford)
   * @throws Exception if cargo includes goods which are not accepted in planet's market
   */
  public boolean buyShip(Player player, Ship newShip) throws Exception{
    if(canBuyShip(newShip.getPrice(), player) == false)
    {
      return false;
    }
    else {
        ArrayList<Good> cargo = player.getShip().cargo;
        double cargoVal = 0;
        Market m = planet.getMarket();
        for (Good g : cargo) {
            if (m.getPrice(g) == -1) {
                throw new Exception("Unwanted Cargo");
            }
            cargoVal = cargoVal + m.getPrice(g);
        }
        double finalPrice = newShip.getPrice() - player.getShip().getPrice() - cargoVal; 
        player.subtractMoney(finalPrice);
        player.setShip(newShip);
    }
    return true;
  }
  
  public void refuel(Player player, int gallons) {
      Ship ship = player.getShip();
      int curFuelLevel = ship.getFuel();
      double cost = gallons * 2/techLevel;
      ship.setFuel(gallons + curFuelLevel);
      player.subtractMoney(cost);
  }
  
  public void repairs(Player player) {
      Ship ship = player.getShip();
      int curHealth;
  }
  
  public void equip(Player player) {
      Ship ship = player.getShip();
  }
  
  /**
   * Lets window now whether or not to display a shipyard option
   * @return true if techlevel is sufficient to support a shipyard otherwise false
   */
  public boolean makeVisible() {
      return (techLevel >= 3);
  }
  
  
  
}
