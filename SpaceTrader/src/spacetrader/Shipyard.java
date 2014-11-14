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
import java.io.Serializable;

/**
* Creates a Shipyard for buying new Ships and selling old Ships + cargo
*
* @author Kristen Lawrence
*/
public class Shipyard implements Serializable {

    /**
     *
     */
    public Planet planet;

    /**
     *
     */
    public AbstractPoliticalSystem politicalSystem;
    public static int techLevel;

    /**
     * Constructor sets planet
     *
     * @param planet
     *            - Planet home of shipyard
     */
    public Shipyard(Planet planet) {
        this.planet = planet;
    }

    /**
     * sets solarSystem to shipyard for retrieving techlevel and gov
     *
     * @param solarSystem
     *            - solarSystem of the planet
     */
    public void setSolarSystem(SolarSystem solarSystem) {
        this.politicalSystem = solarSystem.getPoliticalSystem();
        this.techLevel = solarSystem.getTechLevel();
    }

    /**
     * Calculates and returns a ship's price
     *
     * @param player
     *            whose cargo and current ship are deducted from ship price
     * @param newShip
     *            to be priced
     *
     * @return the total price of newShip minus cargo and price of current ship
     */
    public double shipPrice(Player player, Ship newShip) {
        ArrayList<Good> cargo = player.getShip().cargo;
        ArrayList<Laser> weapons = player.getShip().weapons;
        ArrayList<Shield> shields = player.getShip().shields;
        ArrayList<Gadget> gadgets = player.getShip().gadgets;
        double cargoVal = 0;
        double equipVal = 0;
        for (Laser l : weapons) {
            equipVal = equipVal + l.getPrice();
        }
        for (Shield s : shields) {
            equipVal = equipVal + s.getPrice();
        }
        for (Gadget g : gadgets) {
            equipVal = equipVal + g.getPrice();
        }
        Market m = planet.getMarket();
        for (Good g : cargo) {
            if (m.getPrice(g) != -1) {
                cargoVal = cargoVal + m.getPrice(g);
            }
        }
        double shipPrice = newShip.getPrice() - player.getShip().getPrice()
                - cargoVal - equipVal;
        return shipPrice;
    }

    /**
     * Checks if player can afford ship and proceeds with transaction if true
     * this includes selling all cargo and equipment. Also transfers escape pod
     * if there is one.
     *
     * @param player
     *            - to whom the new ship will go to
     * @param newShip
     *            - the new ship for player
     * @param userVerified if it was checked
     *
     * @return negative if not enough money, zero if cargo will be lost,
     *         otherwise positive (transaction went through)
     */
    public int buyShip(Player player, Ship newShip, boolean userVerified) {
        double cost = shipPrice(player, newShip);
        if (checkWallet(player, cost) == false) {
            return -1;
        } else {
            ArrayList<Good> cargo = player.getShip().cargo;
            Market m = planet.getMarket();
            for (Good g : cargo) {
                if (m.getPrice(g) == -1 && userVerified == false) {
                    return 0;
                }
            }
            if (player.getShip().getInsurance()) {
                newShip.setInsurance(true);
            }
            if (player.getShip().getEscapePod()) {
                newShip.setEscapePod(true);
            }
            player.subtractMoney(cost);
            player.setShip(newShip);
        }
        return 1;
    }

    /**
     * Refuel the ship
     *
     * @param player
     * @param gallons
     *            wished to be added to fuel tank
     *
     * @return true if transaction worked false if not enough money or amount
     *         requested exceeds fuel tank capacity
     */
    public boolean refuel(Player player, int gallons) {
        Ship ship = player.getShip();
        int curFuelLevel = ship.getFuel();
        if (curFuelLevel + gallons > ship.getFuelCapacity()) {
            return false;
        }
        double cost = gallons * ship.getFuelCost();
        if (checkWallet(player, cost)) {
            ship.setFuel(gallons + curFuelLevel);
            player.subtractMoney(cost);
            return true;
        }
        return false;
    }

    /**
     * Repair damage to Ship Hull
     *
     * @param player
     * @param amount
     *            to increase Ship
     *
     * @return
     */
    public boolean repairs(Player player, int amount) {
        Ship ship = player.getShip();
        int curHealth = ship.getHealth();
        double cost = amount * ship.getFuelCost();
        if (checkWallet(player, cost)) {
            ship.setHealth(curHealth + amount);
            player.subtractMoney(cost);
            return true;
        }
        return false;
    }

    /**
     * Sell a Weapon
     *
     * @param player
     *            making transaction
     * @param index
     *            of the weapon player wants to sell
     */
    public void sellWeapon(Player player, int index) {
        player.addMoney(player.getShip().removeWeapon(index));
    }

    /**
     *
     * @param player
     * @param name
     * @return
     */
    public boolean sellWeapon(Player player, String name) {
        int index = -1;
        ArrayList<Laser> weapons = player.getShip().weapons;
        for (int i = 0; i < weapons.size() && index == -1; i++) {
            if (weapons.get(i).getName().equals(name)) {
                index = i;
            }
        }
        if (index == -1) {
            return false;
        } else {
            sellWeapon(player, index);
            return true;
        }
    }

    /**
     * Sell a Shield
     *
     * @param player
     *            making transaction
     * @param index
     *            of Shield player wants to sell
     */
    public void sellShield(Player player, int index) {
        player.addMoney(player.getShip().removeShield(index));
    }

    /**
     *
     * @param player
     * @param name
     * @return
     */
    public boolean sellShield(Player player, String name) {
        int index = -1;
        ArrayList<Shield> shields = player.getShip().shields;
        for (int i = 0; i < shields.size() && index == -1; i++) {
            if (shields.get(i).getName().equals(name)) {
                index = i;
            }
        }
        if (index == -1) {
            return false;
        } else {
            sellShield(player, index);
            return true;
        }
    }

    /**
     * Sell a Gadget
     *
     * @param player
     *            making transaction
     * @param index
     *            of the gadget player wants to sell
     */
    public void sellGadget(Player player, int index) {
        player.addMoney(player.getShip().removeGadget(index));
    }

    /**
     *
     * @param player
     * @param name
     * @return
     */
    public boolean sellGadget(Player player, String name) {
        int index = -1;
        ArrayList<Shield> gadgets = player.getShip().shields;
        for (int i = 0; i < gadgets.size() && index == -1; i++) {
            if (gadgets.get(i).getName().equals(name)) {
                index = i;
            }
        }
        if (index == -1) {
            return false;
        } else {
            sellGadget(player, index);
            return true;
        }
    }

    /**
     * Sell Ship Insurance
     *
     * @param player
     *            making transaction
     */
    public void sellInsurance(Player player) {
        if (player.getShip().getInsurance()) {
            player.getShip().setInsurance(false);
            player.addMoney(500);
        }
    }

    /**
     * Sell Player's Escape Pod
     *
     * @param player
     *            making transaction
     * @return true if success
     */
    public boolean sellEscapePod(Player player) {
        if (player.getShip().getEscapePod()) {
            player.getShip().setEscapePod(false);
            player.addMoney(100);
            return true;
        }
        return false;
    }

    /**
     * Lets window know whether or not to display a shipyard option
     *
     * @return true if techLevel is sufficient to support a shipyard otherwise
     *         false
     */
    public boolean makeVisible() {
        return (techLevel >= 4);
    }

    /**
     * upgrades ship with a laser
     *
     * @param player
     *            whose money will pay for weapon
     * @param l
     *            the laser to buy
     * @return 1 success 0 check -1 fail
     */
    public int buyWeapon(Player player, Laser l) {
        Ship ship = player.getShip();
        double cost = l.getPrice();
        if (checkWallet(player, cost)) {
            if (ship.addWeapon(l)) {
                player.subtractMoney(cost);
                return 1;
            } else {
                return 0;
            }
        }
        return -1;
    }

    /**
     * upgrades ship with a shield
     *
     * @param player
     *            whose money will pay for defense
     * @param sheild
     *            the defense to buy
     * @return 1 success 0 check -1 fail
     */
    public int buyDefense(Player player, Shield sheild) {
        Ship ship = player.getShip();
        double cost = sheild.getPrice();
        if (checkWallet(player, cost)) {
            if (ship.addShield(sheild)) {
                player.subtractMoney(cost);
                return 1;
            } else {
                return 0;
            }
        }
        return -1;
    }

    /**
     * upgrades ship with a gadget
     *
     * @param player
     *            whose money will pay for gadget
     * @param g
     *            the gadget to buy
     * @return 1 if success 0 if needs check -1 if not
     */
    public int buyGadget(Player player, Gadget g) {
        Ship ship = player.getShip();
        double cost = g.getPrice();
        if (checkWallet(player, cost)) {
            if (ship.addGadget(g)) {
                player.subtractMoney(cost);
                return 1;
            } else {
                return 0;
            }
        }
        return -1;
    }

    /**
     * Buy an Escape Pod
     *
     * @param player
     *            making transaction
     * @return true if transaction was successful false if player already has
     *         escape pod or doesn't have enough money
     */
    public int buyEscapePod(Player player) {
        Ship ship = player.getShip();
        double cost = 200;
        if (checkWallet(player, cost)) {
            if (!(ship.getEscapePod())) {
                ship.setEscapePod(true);
                player.subtractMoney(cost);
                return 1;
            } else {
                return 0;
            }
        }
        return -1;
    }

    /**
     * Buy Ship Insurance
     *
     * @param player
     *            making transaction
     * @return true if transaction went through false if player doesn't have
     *         enough moolah or already has insurance
     */
    public boolean buyInsurance(Player player) {
        Ship ship = player.getShip();
        double cost = 750;
        if (checkWallet(player, cost)) {
            if (!(ship.getInsurance())) {
                ship.setInsurance(true);
                player.subtractMoney(cost);
            }
        }
        return false;
    }

    /**
     * Lets window know whether or not to display higher level weapons
     *
     * @return an ArrayList of visible lasers
     */
    public static ArrayList<Laser> visibleWeapons() {
        ArrayList<Laser> weapons = new ArrayList<>();
        for (Laser l : Laser.values()) {
            if (l.getMinTL() <= techLevel) {
                weapons.add(l);
            }
        }
        return weapons;
    }

    /**
     * Lets window know whether or not to display higher level shields
     *
     * @return an ArrayList of visible shields
     */
    public static ArrayList<Shield> visibleShields() {
        ArrayList<Shield> shields = new ArrayList<>();
        for (Shield s : Shield.values()) {
            if (s.getMinTL() <= techLevel) {
                shields.add(s);
            }
        }
        return shields;
    }

    /**
     * Lets window know whether or not to display higher level gadgets
     *
     * @return ArrayList of visible gadgets
     */
    public static ArrayList<Gadget> visibleGadgets() {
        ArrayList<Gadget> gadgets = new ArrayList<>();
        for (Gadget g : Gadget.values()) {
            if (g.getMinTL() <= techLevel) {
                gadgets.add(g);
            }
        }
        return gadgets;
    }

    /**
     * Helper that checks if Player has enough money to make transaction
     *
     * @param player
     *            whose wallet will be checked
     * @param price
     *            to check against player's money
     * @return
     */
    private boolean checkWallet(Player player, double price) {
        return (price <= player.getMoney());
    }
}
