/*
 * Copyright (C) 2014 Addison
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
 * @author addison
 */
public class Mercenary implements Comparable, Serializable {

    /**
     * Name of the mercenary.
     */
    private String name;

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
     * The constructor for a mercenary. It takes an int and randomly allocates
     * them to different attributes.
     *
     * @param theName
     *            The name of the mercenary
     * @param totalAtrbtPts
     *            The total attribute points to be allocated
     */
    public Mercenary(final String theName, int totalAtrbtPts) {
        this.name = theName;
        int[] tmp = new int[2 + 2];
        for (int i = 2 + 2 + 1; i > 1; i--) {
            tmp[2 + 2 + 1 - i] = (int) (Math.random() * (totalAtrbtPts + 1) / i);
            totalAtrbtPts -= tmp[2 + 2 + 1 - i];
        }
        pilot = tmp[0];
        fighter = tmp[1];
        trader = tmp[2];
        engineer = tmp[2 + 1];
        investor = totalAtrbtPts;
    }

    /**
     * @return the name
     */
    public final String getName() {
        return name;
    }

    /**
     * @param theName
     *            the name to set
     */
    public final void setName(final String theName) {
        this.name = theName;
    }

    /**
     * @return the pilot
     */
    public final int getPilot() {
        return pilot;
    }

    /**
     * @param thePilot
     *            the pilot to set
     */
    public final void setPilot(final int thePilot) {
        this.pilot = thePilot;
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
     * Compares two mercenaries based on their names.
     *
     * @param that
     *            the mercenary to compare against
     * @return number
     */
    @Override
    public final int compareTo(final Object that) {
        return this.name.compareTo(((Mercenary) that).name);
    }

    /**
     * Gives a string representation of this player.
     *
     * @return "name (pilot,fighter,trader,engineer,investor)"
     */
    @Override
    public final String toString() {
        return name + " (" + pilot + "," + fighter + "," + trader + ","
                + engineer + "," + investor + ")";
    }
}
