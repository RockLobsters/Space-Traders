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

    public int fuel;

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

    public int getFuel() {
      return fuel;
    }
    public void setFuel(int fuel) {
      this.fuel = fuel;
    }
    
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
