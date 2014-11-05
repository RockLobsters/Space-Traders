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
 *
 * @author Kristen Lawrence
 */
public enum Gadget {
    CARGO_BAYS("5 Cargo Bays", 500, 4),
    NAV_SYSTEM("Navigation System", 750, 5),
    AUTO_REPAIR_SYSTEM("Auto-Repair System", 1000, 6),
    TARGET_SYSTEM("Targeting System", 1000, 6),
    CLOAK_DEVICE("Cloaking Device", 2000, 7);
    
    String name;
    double price;
    int minTL;
    
    Gadget(String name, double price, int minTL) {
        this.name = name;
        this.price = price;
        this.minTL = minTL;
    }
    
    double getPrice() {
        return price;
    }
    
    int getMinTL() {
        return minTL;
    }
}
