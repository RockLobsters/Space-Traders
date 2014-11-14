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
 * Gadgets for ship.
 *
 * @author Kristen Lawrence
 */
public enum Gadget {

    /**
     *
     */
    CARGO_BAYS("5 Cargo Bays", 500, 4),

    /**
     *
     */
    NAV_SYSTEM("Navigation System", 750, 5),
    /**
     *
     */
    AUTO_REPAIR_SYSTEM("Auto-Repair System", 1000, 6),
    /**
     *
     */
    TARGET_SYSTEM("Targeting System", 1000, 6),

    /**
     *
     */
    CLOAK_DEVICE("Cloaking Device", 2000, 7);

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
    private final int minTL;

    /**
     * Gadget constructor for enum.
     *
     * @param theName
     *            string rep
     * @param thePrice
     *            the price of gadget buying or selling
     * @param theMinTL
     *            the min tech level needed for a planet to sell
     */
    Gadget(final String theName, final double thePrice, final int theMinTL) {
        this.name = theName;
        this.price = thePrice;
        this.minTL = theMinTL;
    }

    /**
     * getter for price.
     *
     * @return price a double
     */
    double getPrice() {
        return price;
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
    String getName() {
        return name;
    }
}
