/*
 * Copyright (C) 2014 sydnipeterson
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

import java.io.Serializable;

/**
 *
 * @author sydnipeterson
 */
public class Player implements Serializable {

    // Name of Player

    private final String name;
    // Money of Player
    private double money;
    private final int INITIAL_MONEY = 1000;
    // Wanted Level of player
    private int wantedLevel;

    // The attribute stats of the mercenary
    private int pilot;
    private int fighter;
    private int trader;
    private int engineer;
    private int investor;

    private Ship ship;

    private Planet currentLocation;

    /**
     * Initializes Player Class
     *
     * @param name
     */
    public Player(String name) {
	this.name = name;
	money = INITIAL_MONEY;
	wantedLevel = 0;
	ship = new Gnat();
    }

    /**
     * returns players name
     *
     * @return name
     */
    public String getName() {
	return name;
    }

    /**
     * adds money to current money amount
     *
     * @param mon
     */
    public void addMoney(double mon) {
	money += mon;
    }

    /**
     * subtracts money from current money amount
     *
     * @param mon
     */
    public void subtractMoney(double mon) {
	money -= mon;
    }

    /**
     * returns total money player has
     *
     * @return money
     */
    public double getMoney() {
	return money;
    }

    /**
     * sets wanted level
     *
     * @param level
     */
    public void setWantedLevel(int level) {
	wantedLevel += level;
    }

    /**
     * returns wanted level
     *
     * @return wantedLevel
     */
    public int getWantedLevel() {
	return wantedLevel;
    }

    /**
     * @return the pilot
     */
    public int getPilot() {
	return pilot;
    }

    /**
     * @param pilot
     *            the pilot to set
     */
    public void setPilot(int pilot) {
	this.pilot = pilot;
    }

    /**
     * @return the fighter
     */
    public int getFighter() {
	return fighter;
    }

    /**
     * @param fighter
     *            the fighter to set
     */
    public void setFighter(int fighter) {
	this.fighter = fighter;
    }

    /**
     * @return the trader
     */
    public int getTrader() {
	return trader;
    }

    /**
     * @param trader
     *            the trader to set
     */
    public void setTrader(int trader) {
	this.trader = trader;
    }

    /**
     * @return the engineer
     */
    public int getEngineer() {
	return engineer;
    }

    /**
     * @param engineer
     *            the engineer to set
     */
    public void setEngineer(int engineer) {
	this.engineer = engineer;
    }

    /**
     * @return the investor
     */
    public int getInvestor() {
	return investor;
    }

    /**
     * @param investor
     *            the investor to set
     */
    public void setInvestor(int investor) {
	this.investor = investor;
    }

    /**
     * @return the ship
     */
    public Ship getShip() {
	return ship;
    }

    /**
     * @param ship
     *            the ship to set
     */
    public void setShip(Ship ship) {
	this.ship = ship;
    }

    public Planet getCurrentLocation() {
	return currentLocation;
    }

    public void setCurrentLocation(Planet currentLocation) {
	this.currentLocation = currentLocation;
    }

    @Override
    public String toString() {
	return name + " (" + pilot + "," + fighter + "," + trader + ","
		+ engineer + "," + investor + ") (" + money + "," + wantedLevel
		+ ") (" + ship + ")";
    }
}
