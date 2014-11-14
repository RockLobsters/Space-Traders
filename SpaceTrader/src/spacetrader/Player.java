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

    /**
     * Name of Player.
     */
    private final String name;
    /**
     * Money of Player.
     */
    private double money;
    /**
     * starting money.
     */
    private static final int INITIAL_MONEY = 1000;
    /**
     * Wanted Level of player.
     */
    private int wantedLevel;

    /**
     * The attribute stats of the mercenary.
     */
    private int pilot;
    /**
     *
     */
    private int fighter;
    /**
     *
     */
    private int trader;
    /**
     *
     */
    private int engineer;
    /**
     *
     */
    private int investor;
    /**
     *
     */
    private Ship ship;
    /**
     *
     */
    private Planet currentLocation;

    /**
     * Initializes Player Class.
     *
     * @param theName name
     */
    public Player(final String theName) {
        this.name = theName;
        money = INITIAL_MONEY;
        wantedLevel = 0;
        ship = new Gnat();
    }

    /**
     * returns players name.
     *
     * @return name
     */
    public final String getName() {
        return name;
    }

    /**
     * adds money to current money amount.
     *
     * @param mon the money
     */
    public final void addMoney(final double mon) {
        money += mon;
    }

    /**
     * subtracts money from current money amount.
     *
     * @param mon the dough
     */
    public final void subtractMoney(final double mon) {
        money -= mon;
    }

    /**
     * returns total money player has.
     *
     * @return money the mon
     */
    public final double getMoney() {
        return money;
    }

    /**
     * sets wanted level.
     *
     * @param level the lev
     */
    public final void setWantedLevel(final int level) {
        wantedLevel += level;
    }

    /**
     * returns wanted level.
     *
     * @return wantedLevel
     */
    public final int getWantedLevel() {
        return wantedLevel;
    }

    /**
     * @return the pilot
     */
    public final int getPilot() {
        return pilot;
    }

    /**
     * @param plt
     *            the pilot to set
     */
    public final void setPilot(final int plt) {
        this.pilot = plt;
    }

    /**
     * @return the fighter
     */
    public final int getFighter() {
        return fighter;
    }

    /**
     * @param theFighter
     *            the fighter to set
     */
    public final void setFighter(final int theFighter) {
        this.fighter = theFighter;
    }

    /**
     * @return the trader
     */
    public final int getTrader() {
        return trader;
    }

    /**
     * @param theTrader
     *            the trader to set
     */
    public final void setTrader(final int theTrader) {
        this.trader = theTrader;
    }

    /**
     * @return the engineer
     */
    public final int getEngineer() {
        return engineer;
    }

    /**
     * @param theEngineer
     *            the engineer to set
     */
    public final void setEngineer(final int theEngineer) {
        this.engineer = theEngineer;
    }

    /**
     * @return the investor
     */
    public final int getInvestor() {
        return investor;
    }

    /**
     * @param theInvestor
     *            the investor to set
     */
    public final void setInvestor(final int theInvestor) {
        this.investor = theInvestor;
    }

    /**
     * @return the ship
     */
    public final Ship getShip() {
        return ship;
    }

    /**
     * @param theShip
     *            the ship to set
     */
    public final void setShip(final Ship theShip) {
        this.ship = theShip;
    }

    /**
     * @return currentLocation
     */
    public final Planet getCurrentLocation() {
        return currentLocation;
    }

    /**
     *
     * @param theCurLocation current location
     */
    public final void setCurrentLocation(final Planet theCurLocation) {
        this.currentLocation = theCurLocation;
    }

    /**
     *
     * @return String rep of player
     */
    @Override
    public final String toString() {
        return name + " (" + pilot + "," + fighter + "," + trader + ","
                + engineer + "," + investor + ") (" + money + "," + wantedLevel
                + ") (" + ship + ")";
    }
}
