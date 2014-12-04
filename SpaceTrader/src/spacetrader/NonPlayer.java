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
class NonPlayer {
    
    Player player;
    SolarSystem ss;
    PoliticalSystem ps;
    Ship ship;
    int techLevel;
    Random rand = new Random();
    
    public NonPlayer(Player player, SolarSystem ss) {
        this.player = player;
        this.ss = ss;
        this.ps = ss.getPoliticalSystem();
        this.ship = new Gnat();
        this.techLevel = ss.getTechLevel();
        setCargo();
    }
    
    public void attack(int hitPoints) { 
        int health = player.getShip().getHealth();
        player.getShip().setHealth(Math.max(0, health - hitPoints));
    }
    public boolean bribe(boolean check) {
        return false;
    }
    public boolean buyFrom(Good good, int quantity) {
        return false;
    }
    public boolean flee() {
        return rand.nextBoolean();
    }
    public boolean sellTo(Good good, int quantity) {
        return false;
    }
    public Ship ship() {
        return ship;
    }
    public void takeHit(int hitPoints) {
        ship.setHealth(Math.max(0,ship.getHealth() - hitPoints));
    }
    public boolean isDead() {
        return ship.getHealth() <= 0;
    }
    
    public ArrayList<Good> getCargo() {
        return ship.getCargo();
    }
    
    public String getEncounter() {
        return "None";
    }

    private void setCargo() {
        ship.adjustCargo(ps.supply());
    }
}
