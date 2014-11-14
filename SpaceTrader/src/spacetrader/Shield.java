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
* Shield Enum.
*
* @author Kristen Lawrence
*/
public enum Shield {

    /**
     *
     */
    ENERGY("Energy Shield", 250, 5, 5),

    /**
     *
     */
    REFLECTIVE("Reflective Shield", 750, 10, 7);

    /**
     *
     */
    private final String name;
    /**
     *
     */
    private final double price;
    /**
     *
     */
    private final int power;
    /**
     *
     */
    private final int minTL;

    /**
     * Shield constructor.
     *
     * @param theName
     *            string rep of the obj
     * @param thePrice
     *            the thePrice to buy/sell this obj
     * @param thePower
     *            power of the shield (hp in battle)
     * @param theMinTL
     *            the min Tech Level a planet needs to sell this obj
     */
    Shield(final String theName, final double thePrice, final int thePower,
            final int theMinTL) {
        this.name = theName;
        this.price = thePrice;
        this.power = thePower;
        this.minTL = theMinTL;
    }

    /**
     * getter for the price of shield obj.
     *
     * @return price a double
     */
    double getPrice() {
        return price;
    }

    /**
     * getter for power (hp).
     *
     * @return int power
     */
    int getPower() {
        return power;
    }

    /**
     * getter for minTL.
     *
     * @return int minTL
     */
    int getMinTL() {
        return minTL;
    }

    /**
     *
     * @return name
     */
    Object getName() {
        return name;
    }
}
