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
 *
 * @author Kristen Lawrence
 */
public class RandomEncounter {
    
    Player player;
    Ship playerShip;
    NonPlayer np;
    String npKey;
    Ship otherShip;
    SolarSystem ss;
    int tl;
    PoliticalSystem ps;
    Random rand = new Random();
    
    public RandomEncounter(Player player, SolarSystem ss) {
        this.player = player;
        this.playerShip = player.getShip();
        this.ss = ss;
        this.tl = ss.getTechLevel();
        this.ps = ss.getPoliticalSystem();
        double polRate = ps.bribeRate() + ps.policeRate();
        double tradeRate = ps.illegalTradeRate() + ps.traderRate();
        double pirateRate = ps.pirateRate();
        if (rand.nextDouble() <= polRate) {
            this.np = new Police(player, ss);
            otherShip = np.ship;
        } else if (rand.nextDouble() <= tradeRate) {
            this.np = new Trader(player,ss);
            otherShip = np.ship;
        } else if (rand.nextDouble() <= pirateRate) {
            this.np = new Pirate(player,ss);
            otherShip = np.ship;
        } else {
            this.np = null;
            otherShip = null;
        }
    }
    
    void Battle() {
        while(np.)
    }
    
    void Trade() {
        
    }
    
    void Flee() {
        
    }
    
    void Bribe() {
        
    }
}
