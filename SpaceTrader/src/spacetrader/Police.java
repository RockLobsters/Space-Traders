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

import java.util.Random;

/**
 * Random Encounter
 *
 * @author Kristen Lawrence
 */
public class Police extends NonPlayer {
    Player player;
    SolarSystem ss;
    PoliticalSystem ps;
    Ship ship;
    int techLevel;
    boolean corrupt = false;
    Random rand = new Random();
    ShipFactory sf = new ShipFactory();
    
    public Police(Player player, SolarSystem ss) {
        super(player, ss);
        ps = ss.getPoliticalSystem();
        this.ship = this.ship = sf.generateShip("POLICE", ss);
        if (rand.nextDouble() <= ps.bribeRate()) {
            corrupt = true;
        }
    }
    
    @Override
    public boolean bribe(boolean check) {
        if(corrupt && check) {
            player.subtractMoney(ps.bribeRate()*100);
            return true;
        }
        return false;
    }
    @Override
    public String getEncounter() {
        return "PoliceEncounter.fxml";
    }
}
