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
    
    boolean Battle() {
        int damage = playerShip.getDefense() - otherShip.getPower();
        int hit = otherShip.getDefense() - playerShip.getPower();
        int playerHealth = playerShip.getHealth();
        while(!np.isDead() || playerHealth > 0) {
            playerHealth = playerShip.getHealth();
            np.attack(damage);
            np.takeHit(hit);
            if (playerShip.autoRepair())
                playerShip.setHealth(playerHealth+2);
        }
        if (np.isDead())
            return true;
        return false;
    }
    
    ArrayList<Good> getCargo() {
        return np.getCargo();
    }
    
    void Trade(String trans, Good good, int quantity) {
        if (trans.equals(0))
            np.buyFrom(good, quantity);
        else
            np.sellTo(good, quantity);
    }
    
    String Flee() {
        if(np.flee())
            return"Flee successful";
        return "Unable to Flee";
    }
    
    boolean bribable() {
        return np.bribe(false);
    }
    
    void Bribe() {
        np.bribe(true);
    }
    
    public String getEncounter() {
        if (np == null)
            return "None";
        return np.getEncounter();
    }
}

