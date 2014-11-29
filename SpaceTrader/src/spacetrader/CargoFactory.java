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
public class CargoFactory {
    
    Good g;
    Random rand = new Random();
    GoodType[] goods = GoodType.values();
    
    ArrayList<Good> generateCargo(String key, int limit) {
        ArrayList<Good> cargo = new ArrayList<>();
        for (int i = 0; i < rand.nextInt(goods.length); i++) {
            if (key.equals("TRADER")) {
                g = new Good(goods[rand.nextInt(goods.length)], rand.nextInt(10));
            }
            if (key.equals("POLICE")) {
                g = new Good(goods[rand.nextInt(goods.length)], rand.nextInt(5));
            } else {
                GoodType[] pirateBooty = {GoodType.NARCOTICS, GoodType.FIREARMS, goods[rand.nextInt(goods.length)]};
                g = new Good(pirateBooty[rand.nextInt(pirateBooty.length)], rand.nextInt(5));
            }
            if (!(cargo.contains(cargo.contains(g))) && cargo.size() < limit)
                    cargo.add(g);
        }
        return cargo;
    }
}
