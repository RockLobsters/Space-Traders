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

/**ncounter
 *
 * @author Kristen Lawrence
 */
public class Police implements nonPlayer {
    Player player;
    SolarSystem ss;
    PoliticalSystem ps;
    Ship ship;
    int techLevel;
    boolean corrupt = false;
    Random rand = new Random();
    
    public Police(Player player, SolarSystem ss) {
        this.player = player;
        this.ss = ss;
        this.ps = ss.getPoliticalSystem();
        this.techLevel = ss.getTechLevel();
        this.ship = new Flea();
        if (rand.nextDouble() <= ps.bribeRate()) {
            corrupt = true;
        }
    }
    
    @Override
    public boolean attack() {
        player.getShip().setHealth(-10);
        return true;
    }

    public double bribeCost() {
        return ps.bribeRate() * 100;
    }
    
    @Override
    public boolean bribe() {
        if (corrupt) {
            if (player.getMoney() >= bribeCost()) 
                player.subtractMoney(bribeCost());
        } else
            return false;
        return true;
    }

    @Override
    public boolean buy(Good good) {
        return false;
    }

    @Override
    public boolean flee() {
        return rand.nextBoolean();
    }

    @Override
    public boolean sell() {
        return false;
    }

    @Override
    public Ship ship() {
        return ship;
    }
    
    public void takeHit(int hitPoints) {
        ship.setHealth(hitPoints);
    }

    @Override
    public String type() {
        return "Police";
    }
}
