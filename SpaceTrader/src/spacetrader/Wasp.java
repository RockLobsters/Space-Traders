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

/**
 *
 * @author Addison Amiri
 */
public class Wasp extends Ship
{
    public static final String NAME         = "Wasp";
    public static final int HULL_STRENGTH   = 30;
    public static final int CARGO_BAYS      = 35;
    public static final int WEAPON_SLOTS    = 3;
    public static final int SHIELD_SLOTS    = 2;
    public static final int GADGET_SLOTS    = 2;
    public static final int CREW_QUARTERS   = 3;
    public static final int FUEL_CAPACITY   = 14;
    public static final int BASE_PRICE      = 10000000;
    
    public Wasp()
    {
        super(NAME,
              HULL_STRENGTH,
              CARGO_BAYS,
              WEAPON_SLOTS,
              SHIELD_SLOTS,
              GADGET_SLOTS,
              CREW_QUARTERS,
              FUEL_CAPACITY, 
              BASE_PRICE);
    }
}
