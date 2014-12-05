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
    private Player player1 = GameInstance.getInstance().getPlayer();
    
    public Trader(Player player, SolarSystem ss) {
        super(player, ss);
        ps = ss.getPoliticalSystem();
        if (rand.nextDouble() <= ps.illegalTradeRate()) {
            fence = true;
            this.ship = sf.generateShip("ILLEGAL_TRADER", ss);
        } else {
            this.ship = sf.generateShip("TRADER", ss);
        }
    }   
    
    @Override
    public boolean buyFrom(Good good, int quantity) {
        double cost = quantity * good.getPrice();
        if(cost <= player1.getMoney() && (good.getQuantity() != 0) && (good.getQuantity() - quantity) >= 0) {
            good.setQuantity(good.getQuantity() - quantity);
            player1.subtractMoney(cost);
            boolean found = false;
            ArrayList<Good> playerCargo = player1.getShip().getCargo();
            for (int i = 0; i < playerCargo.size() && !found; i++) {
                if (playerCargo.get(i).getType() == good.getType()) {
                    playerCargo.get(i).setQuantity(playerCargo.get(i).getQuantity() + quantity);
                    ship.cargo.remove(good);
                    ship.adjustCargo(ship.cargo);
                    found = true;
                }
            }
            if (!found) {
                playerCargo.add(new Good(good.type,quantity));
            }
            player1.getShip().adjustCargo(playerCargo);
            return true;
        }
        return false;
    }

    @Override
    public boolean sellTo(Good good, int quantity) {
        return false;
    }
    
    @Override
    public String getEncounter() {
        return "TraderScreen.fxml";
    }
}
