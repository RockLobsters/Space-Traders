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
public class Trader extends NonPlayer {
    Player player;
    SolarSystem ss;
    PoliticalSystem ps;
    Ship ship;
    int techLevel;
    boolean fence = false;
    Random rand = new Random();
    ShipFactory sf = new ShipFactory();
    
    public Trader(Player player, SolarSystem ss) {
        super(player, ss);
        this.ship = sf.generateShip("TRADER", ss);
        if (rand.nextDouble() <= ps.illegalTradeRate())
            fence = true;
    }   
    public ArrayList<Good> tradeCargo() {
        return ship.cargo;
    }
    
    @Override
    public boolean buyFrom(Good good, int quantity) {
        if(good.getPrice() <= player.getMoney()) {
            good.setQuantity(good.getQuantity() - quantity);
            player.subtractMoney(good.TTP);
            boolean found = false;
            ArrayList<Good> playerCargo = player.getShip().cargo;
            for (int i = 0; i < playerCargo.size() && !found; i++) {
                if (playerCargo.get(i).getType() == good.getType()) {
                    playerCargo.get(i).setQuantity(playerCargo.get(i).getQuantity() + quantity);
                    found = true;
                }
            }
            if (!found) {
                playerCargo.add(good);
            }
            player.getShip().adjustCargo(playerCargo);
            return true;
        }
        return false;
    }

    @Override
    public boolean sellTo(Good good, int quantity) {
        return false;
    }
}
