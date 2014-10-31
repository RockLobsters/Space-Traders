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
public enum PlanetNames {
    A_PLANET_1("Gatech"),
    A_PLANET_2("Peachtree Planet"),
    A_PLANET_3("Gastate Universe City"),
    A_PLANET_4("Ponce"),
    A_PLANET_5("Turner Station"),
    
    B_PLANET_1("Elsinor"),
    B_PLANET_2("Titus"),
    B_PLANET_3("Verona"),
    B_PLANET_4("The Scottish Planet"),
    B_PLANET_5("Lear"),
    
    C_PLANET_1("Asimo"),
    C_PLANET_2("Hein-Lein"),
    C_PLANET_3("Pohl"),
    C_PLANET_4("Herbert"),
    C_PLANET_5("Rice Burroughs"),
         
    ;
    
    private final String name;
    private PlanetNames(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
}