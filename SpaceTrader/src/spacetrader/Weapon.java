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
public class Weapon {
    private Laser type = Laser.PULSE;
    private double price;
    private int power;
    private int minTL;
    
    public Weapon(int t) {
        if (t == 1) {
            type = Laser.BEAM;
        } else if (t == 2) {
            type = Laser.MILITARY;
        }
    }
    
    public double getPrice() {
        switch(type) {
            case PULSE:
                return 1000;
            case BEAM:
                return 2000;
            case MILITARY:
                return 3000;
        }
        return 0;
    }
    
    /**
     * getter for weapon's power factor
     * @return int hit power of laser
     */
    public int getPower() {
        switch(type) {
            case PULSE:
                return 10;
            case BEAM:
                return 15;
            case MILITARY:
                return 20;
        }
        return 0;
    }
    
    public int minTL() {
        switch(type) {
            case PULSE:
                minTL = 4;
            case BEAM:
                minTL = 5;
            case MILITARY:
                minTL = 7;
        }
        return minTL;
    }
}
