/*
 * Copyright (C) 2014 Addison Amiri
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
import java.io.Serializable;

/**
 *
 * @author Addison Amiri
 */
public class Ship implements Serializable
{
    private final String NAME;
    final int CARGO_BAYS;
    private final int WEAPON_SLOTS;
    private final int SHIELD_SLOTS;
    private final int GADGET_SLOTS;
    private final int CREW_QUARTERS;
    private final int FUEL_CAPACITY;
    ArrayList<Good> cargo;

    public int fuel;

    /**
     * The flushed out Ship constructor
     * 
     * @param NAME the name of the ship
     * @param CARGO_BAYS the number of cargo bays the ship has
     * @param WEAPON_SLOTS the number of weapon slots the ship has
     * @param SHIELD_SLOTS the number of shield slots the ship has
     * @param GADGET_SLOTS the number of gadget slots the ship has
     * @param CREW_QUARTERS the number of crew quarters the ship has
     * @param FUEL_CAPACITY the fuel capacity the ship has
     */
    public Ship(String NAME, int CARGO_BAYS, int WEAPON_SLOTS, int SHIELD_SLOTS,
                int GADGET_SLOTS, int CREW_QUARTERS, int FUEL_CAPACITY)
    {
        this.NAME = NAME;
        this.CARGO_BAYS = CARGO_BAYS;
        this.WEAPON_SLOTS = WEAPON_SLOTS;
        this.SHIELD_SLOTS = SHIELD_SLOTS;
        this.GADGET_SLOTS = GADGET_SLOTS;
        this.CREW_QUARTERS = CREW_QUARTERS;
        this.FUEL_CAPACITY = FUEL_CAPACITY;
        cargo = new ArrayList(CARGO_BAYS);
        this.fuel = FUEL_CAPACITY;
    }

    /**
     * @return the fuel
     */
    public int getFuel() {
      return fuel;
    }
    
    /**
     * @param fuel the fuel to set
     */
    public void setFuel(int fuel) {
      this.fuel = fuel;
    }
    
    /**
     * @return the current number of items in the cargo
     */
    public int getCargoSize()
    {
      int out = 0;
      for(Good good : cargo)
      {
        if(good != null)
        {
          out += good.getQuantity();
        }
      }
      return out;
    }
    
    /**
     * @return good1, good2, good3, ...
     */
    public String cargoToString()
    {
        if(!cargo.isEmpty())
        {
          String out = "";
          for(Good good : cargo)
          {
            out = out + good.getType() + ", " + good.getQuantity() + "\n";
          }
          return out;
        }
        else
        {
            return "";
        }
    }

}
