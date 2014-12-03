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
    String nextLocation;
    Random rand = new Random();
    
    public RandomEncounter(Player player, SolarSystem ss, String nextLocation) {
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
        if ((player.getEngineer() > 5) && playerShip.cloak()) {
            this.np = null;
            otherShip = null;
        }
        this.nextLocation = nextLocation;
    }
    
    void Battle() {
        int damage = playerShip.getDefense() - otherShip.getPower() - rand.nextInt(player.getFighter());
        int hit = otherShip.getDefense() - playerShip.getPower() + rand.nextInt(player.getFighter());
        int playerHealth = playerShip.getHealth();
        np.attack(damage); //Opponent attacks player
        np.takeHit(hit); //Player attacks opponent
        if (playerShip.autoRepair())
            playerShip.setHealth(playerHealth+2);
    }
    
    int battleOver() {
        if (np.isDead())
            if (!np.getEncounter().equals("PirateScreen.fxml")) {
                int wl = player.getWantedLevel();
                player.setWantedLevel(wl + 2);
                return 1; //player won
            }
        if (player.getShip().getEscapePod()) {
            boolean keepStuff = false;
            ArrayList<Good> cargo = player.getShip().getCargo();
            if (player.getShip().getInsurance()) {
                keepStuff = true;
            }
            player.setShip(new Flea());
            if (keepStuff) {
                player.getShip().adjustCargo(cargo);
            }
            return 0;//player lost but survives
        }
        return -1; //player lost game over
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
    
    public String getNextLocation() {
        return nextLocation;
    }
}

