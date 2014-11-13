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
public class Trader implements nonPlayer{
    Player player;
    SolarSystem ss;
    PoliticalSystem ps;
    Ship ship;
    int techLevel;
    boolean fence = false;
    Random rand = new Random();
    
    public Trader(Player player, SolarSystem ss) {
        this.player = player;
        this.ss = ss;
        this.ps = ss.getPoliticalSystem();
        this.techLevel = ss.getTechLevel();
        this.ship = new Flea();
        if (rand.nextDouble() <= ps.illegalTradeRate())
            fence = true;
    }   
    @Override
    public boolean attack() {
        player.getShip().setHealth(-5);
        return true;
    }

    @Override
    public boolean bribe() {
        return false;
    }

    public ArrayList<Good> tradeCargo() {
        return ship.cargo;
    }
    
    @Override
    public boolean buy(Good good) {
        if(good.getPrice() <= player.getMoney()) {
            //player.getShip().  BUY GOOD?
        }
        return true;
    }

    @Override
    public boolean flee() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean sell() {
        return false;
    }

    @Override
    public Ship ship() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String type() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
