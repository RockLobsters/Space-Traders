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
public class Pirate implements EncounterState {
    Player player;
    SolarSystem ss;
    PoliticalSystem ps;
    Ship ship;
    int techLevel;
    Random rand = new Random();
    ShipFactory sf = new ShipFactory();
    
    public Pirate(Player player, SolarSystem ss) {
        this.player = player;
        this.ss = ss;
        this.ps = ss.getPoliticalSystem();
        this.techLevel = ss.getTechLevel();
        this.ship = this.ship = sf.generateShip("PIRATE", ss);
    }
    
    @Override
    public boolean attack() {
        player.getShip().setHealth(-10);
        return true;
    }
    
    @Override
    public boolean bribe(boolean check) {
        return false;
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
    
    @Override
    public void takeHit(int hitPoints) {
        ship.setHealth(hitPoints);
    }

    @Override
    public String type() {
        return "Pirate Ship";
    }
}
