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
public class Gadget {
    private GadgetType type = GadgetType.CARGO_BAYS;
    private double price;
    private int minTL;
    
    public Gadget(int t) {
        if (t == 1) {
            type = GadgetType.NAV_SYSTEM;
        } else if (t == 2) {
            type = GadgetType.AUTO_REPAIR_SYSTEM;
        } else if (t == 3) {
            type = GadgetType.TARGET_SYSTEM;
        } else if (t == 4) {
            type = GadgetType.CLOAK_DEVICE;
        }
    }
    
    public double getPrice() {
        switch(type) {
            case CARGO_BAYS:
                price = 500;
            case NAV_SYSTEM:
                price = 1000;
            case AUTO_REPAIR_SYSTEM:
                price = 1500;
            case TARGET_SYSTEM:
                price = 2000;
            case CLOAK_DEVICE:
                price = 5000;
        }
        return price;
    }
       
    public int minTL() {
        switch(type) {
            case CARGO_BAYS:
                minTL = 4;
            case NAV_SYSTEM:
                minTL = 5;
            case AUTO_REPAIR_SYSTEM:
                minTL = 6;
            case TARGET_SYSTEM:
                minTL = 6;
            case CLOAK_DEVICE:
                minTL = 7;
        }
        return minTL;
    }
}
