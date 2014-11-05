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
public class Defense {
    private Shield type = Shield.ENERGY;
    private double price;
    private int power;
    private int minTL;
    
    public Defense(int t) {
        if (t == 1) {
            type = Shield.REFLECTIVE;
        }
    }
    
    public double getPrice() {
        switch(type) {
            case ENERGY:
                price =  1000;
            case REFLECTIVE:
                price = 3000;
        }
        return price;
    }
    
    /**
     *
     * @return
     */
    public int getPower() {
        switch(type) {
            case ENERGY:
                power = 10;
            case REFLECTIVE:
                power = 25;
        }
        return power;
    }
    
    public int minTL() {
        switch(type) {
            case ENERGY:
                minTL = 5;
            case REFLECTIVE:
                minTL = 7;
        }
        return minTL;
    }
}
