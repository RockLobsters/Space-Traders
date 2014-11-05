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
  public Planet planet;
  public PoliticalSystem politicalSystem;
  public int techLevel;
  
  /**
   * Constructor sets planet
   * @param planet - Planet home of shipyard
   */
  public Shipyard(Planet planet) {
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
   * Calculates and returns a ship's price
   * @param player whose cargo and current ship are deducted from ship price
   * @param newShip to be priced
   * @return the total price of newShip minus cargo and price of current ship
   */
  public double shipPrice(Player player, Ship newShip) {
      ArrayList<Good> cargo = player.getShip().cargo;
        double cargoVal = 0;
        Market m = planet.getMarket();
        for (Good g : cargo) {
            if (m.getPrice(g) != -1) {
                cargoVal = cargoVal + m.getPrice(g);
            }
        }
        double shipPrice = newShip.getPrice() - player.getShip().getPrice() - cargoVal; 
        return shipPrice;
  }
  
  /**
   * Checks if player can afford ship and proceeds with transaction if true this
   * includes selling all cargo and equipment. Also transfers escape pod if 
   * there is one. 
   * @param player - to whom the new ship will go to
   * @param newShip - the new ship for player
   * @return negative if not enough money, zero if cargo will be lost, otherwise
   * positive (transaction went through)
   */
  public int buyShip(Player player, Ship newShip, boolean userVerified) {
    double cost = shipPrice(player, newShip);
    if(checkWallet(player, cost) == false) {
      return -1;
    } else {
        ArrayList<Good> cargo = player.getShip().cargo;
        Market m = planet.getMarket();
        for (Good g : cargo) {
            if (m.getPrice(g) == -1 && userVerified == false) {
                return 0;
            }
        }
        player.subtractMoney(cost);
        player.setShip(newShip);
    }
    return 1;
  }
  
  /**
   * Refuel the ship
   * @param player 
   * @param gallons wished to be added to fuel tank
   * @return true if transaction worked false if not enough money or amount
   * requested exceeds fuel tank capacity
   */
  public boolean refuel(Player player, int gallons) {
    Ship ship = player.getShip();
    int curFuelLevel = ship.getFuel();
    if (curFuelLevel + gallons > ship.getFuelCapacity()) {
      return false;
    }
    double cost = gallons * ship.getFuelCost();
    if(checkWallet(player, cost)) {
      ship.setFuel(gallons + curFuelLevel);
      player.subtractMoney(cost);
      return true;
    }
    return false;
  }
  
  /**
   * Repair damage to Ship Hull
   * @param player
   * @param amount to increase Ship 
   * @return 
   */
  public boolean repairs(Player player, int amount) {
    Ship ship = player.getShip();
    int curHealth = ship.getHealth();
    double cost = amount * ship.getFuelCost();
    if(checkWallet(player, cost)) {
      ship.setHealth(curHealth + amount);
      player.subtractMoney(cost);
      return true;
    }
    return false;
  }
  
  /**
   * upgrades ship with a laser
   * @param player whose money will pay for weapon
   * @param l the laser to buy
   */
  public boolean buyWeapon(Player player, Laser l) {
      Ship ship = player.getShip();
      double cost = l.getPrice();
      if(checkWallet(player, cost)) {
          if(ship.addWeapon(l)) {
              player.subtractMoney(cost);
              return true;
          }
      }
      return false;
  }
  
  /**
   * upgrades ship with a shield
   * @param player whose money will pay for defense
   * @param d the defense to buy
   */
  public boolean buyDefense(Player player, Shield s) {
      Ship ship = player.getShip();
      double cost = s.getPrice();
      if(checkWallet(player, cost)) {
          if(ship.addDefense(s)) {
              player.subtractMoney(cost);
              return true;
          }
      }
      return false;
  }
  
  /**
   * upgrades ship with a gadget
   * @param player whose money will pay for gadget
   * @param g the gadget to buy
   */
  public boolean buyGadget(Player player, Gadget g) {
      Ship ship = player.getShip();
      double cost = g.getPrice();
      if(checkWallet(player, cost)) {
          if(ship.addGadget(g)) {
              player.subtractMoney(cost);
              return true;
          }
      }
      return false;
  }
  
  /**
   * Lets window now whether or not to display a shipyard option
   * @return true if techLevel is sufficient to support a shipyard otherwise false
   */
  public boolean makeVisible() {
      return (techLevel >= 4);
  }
  
  public ArrayList<Laser> visibleWeapons() {
      ArrayList<Laser> weapons = new ArrayList<>();
      return weapons;
  }
  
  /**
   * Helper that checks if Player has enough money to make transaction
   * @param player whose wallet will be checked
   * @param price to check against player's money
   * @return 
   */
  private boolean checkWallet(Player player, double price) {
      return (price <= player.getMoney());
  }
}
