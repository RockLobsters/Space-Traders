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

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Kristen Lawrence
 */
public class ShipFactory {

    int tl;
    PoliticalSystem ps;
    CargoFactory cf = new CargoFactory();
    Shield[] shields = Shield.values();
    Laser[] weapons = Laser.values();
    ArrayList<Good> cargo;
    Random rand = new Random();
    Ship[] ships = {new Flea(), new Gnat(), new Firefly(), new Mosquito(),
            new Bumblebee(), new Beetle(), new Hornet(), new Grasshopper(),
            new Termite(), new Wasp()};
    
    Ship generateShip(String key, SolarSystem ss) {
        tl = ss.getTechLevel();
        double rate;
        if (key.equals("POLICE")) {
            rate = (ps.bribeRate() + ps.policeRate()) * 10;
        } else if (key.equals("PIRATE")) {
            rate = 5;
        } else {
            rate = (ps.traderRate() + ps.illegalTradeRate()) * 10;
        }
        Ship ship = ships[rand.nextInt((int) rate)];
        cargo = cf.generateCargo(key, ship.getCargoBays());
        ship.adjustCargo(cargo);
        ship.addWeapon(weapons[0]);
        ship.addShield(shields[0]);
        if (rand.nextBoolean()) {
            ship.addWeapon(weapons[1]);
                if (rand.nextBoolean())
                    ship.addShield(shields[1]);
        }
        return ship;
    }       
    
}
