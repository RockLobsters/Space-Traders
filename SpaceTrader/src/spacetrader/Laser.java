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
public enum Laser {
    PULSE("Pulse Laser", 250, 4, 4),
    BEAM("Beam Laser", 500, 8, 6),
    MILITARY("Military Laser", 1000, 12, 7);
    
    String name;
    double price;
    int power;
    int minTL;
    
    Laser(String name, double price, int power, int minTL) {
        this.name = name;
        this.price = price;
        this.power = power;
        this.minTL = minTL;
    }
    
    double getPrice() {
        return price;
    }
    
    int getPower() {
        return power;
    }
    
    int getMinTL() {
        return minTL;
    }
}
