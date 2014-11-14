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

/**
 * Laser Weapon types
 *
 * @author Kristen Lawrence
 */
public enum Laser {

    PULSE("Pulse Laser", 250, 4, 4), BEAM("Beam Laser", 500, 8, 6), MILITARY(
	    "Military Laser", 1000, 12, 7);

    String name;
    double price;
    int power;
    int minTL;

    /**
     * Laser Constructor for enum type
     *
     * @param name
     *            the string rep
     * @param price
     *            the price of laser in shipyard buy/sell
     * @param power
     *            the power of the laser in battle
     * @param minTL
     *            the min tech level a planet needs to sell said laser
     */
    Laser(String name, double price, int power, int minTL) {
	this.name = name;
	this.price = price;
	this.power = power;
	this.minTL = minTL;
    }

    /**
     * getter for price of laser
     *
     * @return price a double
     */
    double getPrice() {
	return price;
    }

    /**
     * getter for power
     *
     * @return int power
     */
    int getPower() {
	return power;
    }

    /**
     * getter for minTL
     *
     * @return int minTL
     */
    int getMinTL() {
	return minTL;
    }
}
