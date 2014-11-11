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

    // Name of the mercenary

    private String name;

    // The attribute stats of the mercenary
    private int pilot;
    private int fighter;
    private int trader;
    private int engineer;
    private int investor;

    /**
     * The constructor for a mercenary. It takes an int and randomly allocates
     * them to different attributes.
     *
     * @param name
     *            The name of the mercenary
     * @param totalAttributePoints
     *            The total attribute points to be allocated
     */
    public Mercenary(String name, int totalAttributePoints) {
	this.name = name;

	int[] tmp = new int[4];
	for (int i = 5; i > 1; i--) {
	    tmp[5 - i] = (int) (Math.random() * (totalAttributePoints + 1) / i);
	    totalAttributePoints -= tmp[5 - i];
	}
	pilot = tmp[0];
	fighter = tmp[1];
	trader = tmp[2];
	engineer = tmp[3];
	investor = totalAttributePoints;
    }

    /**
     * @return the name
     */
    public String getName() {
	return name;
    }

    /**
     * @param name
     *            the name to set
     */
    public void setName(String name) {
	this.name = name;
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
     * Compares two mercenaries based on their names.
     *
     * @param that
     *            the mercenary to compare against
     * @return
     */
    @Override
    public int compareTo(Object that) {
	return this.name.compareTo(((Mercenary) that).name);
    }

    /**
     * Gives a string representation of this player
     *
     * @return "name (pilot,fighter,trader,engineer,investor)"
     */
    @Override
    public String toString() {
	return name + " (" + pilot + "," + fighter + "," + trader + ","
		+ engineer + "," + investor + ")";
    }
}
