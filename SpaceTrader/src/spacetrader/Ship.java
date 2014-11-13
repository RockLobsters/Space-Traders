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
 * @author Addison Amiri/Kristen Lawrence
 */
public class Ship implements Serializable {

    private final String NAME;
    private final int HULL_STRENGTH;
    private final int CARGO_BAYS;
    private final int WEAPON_SLOTS;
    private final int SHIELD_SLOTS;
    private final int GADGET_SLOTS;
    private final int CREW_QUARTERS;
    private final int FUEL_CAPACITY;
    private final int FUEL_COST;
    private final int BASE_PRICE;
    ArrayList<Good> cargo;
    ArrayList<Laser> weapons;
    ArrayList<Shield> shields;
    ArrayList<Gadget> gadgets;

    public int fuel;
    public int health;
    public boolean escapePod;
    public boolean insurance;

    /**
     * The flushed out Ship constructor
     *
     * @param NAME
     *            the name of the ship
     * @param HULL_STRENGTH
     *            the hull strength of the ship
     * @param CARGO_BAYS
     *            the number of cargo bays the ship has
     * @param WEAPON_SLOTS
     *            the number of weapon slots the ship has
     * @param SHIELD_SLOTS
     *            the number of shield slots the ship has
     * @param GADGET_SLOTS
     *            the number of gadget slots the ship has
     * @param CREW_QUARTERS
     *            the number of crew quarters the ship has
     * @param FUEL_CAPACITY
     *            the fuel capacity the ship has (space-gallons)
     * @param FUEL_COST
     *            the cost of refueling per space-gallon
     * @param BASE_PRICE
     *            the base price of the ship based on attributes
     */
    public Ship(String NAME, int HULL_STRENGTH, int CARGO_BAYS,
	    int WEAPON_SLOTS, int SHIELD_SLOTS, int GADGET_SLOTS,
	    int CREW_QUARTERS, int FUEL_CAPACITY, int FUEL_COST, int BASE_PRICE) {
	this.NAME = NAME;
	this.HULL_STRENGTH = HULL_STRENGTH;
	this.CARGO_BAYS = CARGO_BAYS;
	this.WEAPON_SLOTS = WEAPON_SLOTS;
	this.SHIELD_SLOTS = SHIELD_SLOTS;
	this.GADGET_SLOTS = GADGET_SLOTS;
	this.CREW_QUARTERS = CREW_QUARTERS;
	this.FUEL_CAPACITY = FUEL_CAPACITY;
	this.FUEL_COST = FUEL_COST;
	this.BASE_PRICE = BASE_PRICE;
	cargo = new ArrayList(CARGO_BAYS);
	weapons = new ArrayList<>();
	shields = new ArrayList<>();
	gadgets = new ArrayList<>();
	this.fuel = FUEL_CAPACITY;
	this.health = HULL_STRENGTH;
    }

    /**
     * @return the name
     */
    public String getName() {
	return NAME;
    }

    /**
     * @return the fuel
     */
    public int getFuel() {
	return fuel;
    }

    /**
     * @param fuel
     *            the fuel to set
     */
    public void setFuel(int fuel) {
	this.fuel = fuel;
    }

    /**
     * @return the current number of items in the cargo
     */
    public int getCargoSize() {
	int out = 0;
	for (Good good : cargo) {
	    if (good != null) {
		out += good.getQuantity();
	    }
	}
	return out;
    }

    /**
     * health getter
     *
     * @return health of ship
     */
    public int getHealth() {
	return health;
    }

    /**
     * health setter
     *
     * @param h
     *            new health
     */
    public void setHealth(int h) {
	this.health = h;
    }

    /**
     * price getter
     *
     * @return BASE_PRICE of ship
     */
    public int getPrice() {
	return BASE_PRICE;
    }

    /**
     * getter for max hull strength for ship
     *
     * @return HULL_STRENGTH
     */
    public int getHullStrength() {
	return HULL_STRENGTH;
    }

    /**
     * getter for max fuel capacity for ship
     *
     * @return FUEL_CAPACITY
     */
    public int getFuelCapacity() {
	return FUEL_CAPACITY;
    }

    /**
     * getter for fuel cost per space-gallon
     *
     * @return fuelcost
     */
    public int getFuelCost() {
	return FUEL_COST;
    }

    /**
     * @return good1, good2, good3, ...
     */
    public String cargoToString() {
	if (!cargo.isEmpty()) {
	    String out = "";
	    for (Good good : cargo) {
		out = out + good.getType() + ", " + good.getQuantity() + "\n";
	    }
	    return out;
	} else {
	    return "";
	}
    }

    /**
     *
     * @return
     */
    public int getCargoBays() {
	int cb = CARGO_BAYS;
	for (Gadget g : gadgets) {
	    if (g.equals(Gadget.CARGO_BAYS)) {
		cb += 5;
	    }
	}
	return cb;
    }

    /**
     * Is there an escape pod on the ship?
     *
     * @return true if there is false if not
     */
    public boolean getEscapePod() {
	return escapePod;
    }

    /**
     * Give the ship an escape pod
     *
     * @param b
     *            true if adding an escape pod false if selling one
     */
    public void setEscapePod(boolean b) {
	escapePod = b;
    }

    /**
     * is the ship insured?
     *
     * @return ture if it is false if not
     */
    public boolean getInsurance() {
	return insurance;
    }

    /**
     * Insurance price is 1% of ship price
     *
     * @return the insurance rate to be paid daily
     */
    public double getInsuranceRate() {
	return BASE_PRICE * .1;
    }

    /**
     * Set the Ship to insured or not
     *
     * @param b
     *            true if insured false otherwise
     */
    public void setInsurance(boolean b) {
	insurance = b;
    }

    /**
     * Upgrade ship with a weapon
     *
     * @param l
     *            the laser to add
     * @return true if laser added false if not enough slots
     */
    public boolean addWeapon(Laser l) {
	if (weapons.size() == WEAPON_SLOTS) {
	    return false;
	}
	weapons.add(l);
	return true;
    }

    /**
     * Upgrade ship with a shield
     *
     * @param s
     *            the shield to add
     * @return true if shield was added false if not enough slots left
     */
    public boolean addShield(Shield s) {
	if (shields.size() == SHIELD_SLOTS) {
	    return false;
	}
	shields.add(s);
	return true;
    }

    /**
     * Upgrade ship with a gadget
     *
     * @param g
     *            the gadget to add
     * @return true if gadget was added false if not enough slots left
     */
    public boolean addGadget(Gadget g) {
	if (gadgets.size() == GADGET_SLOTS) {
	    return false;
	}
	gadgets.add(g);

	return true;
    }

    /**
     * In case of selling remove a weapon from ship
     *
     * @param index
     *            of the weapon to remove
     * @return double price of the weapon removed
     */
    public double removeWeapon(int index) {
	Laser l = weapons.remove(index);
	return l.getPrice();
    }

    /**
     * In case of selling remove shield
     *
     * @param index
     *            of shield to remove
     * @return double price of the shield
     */
    public double removeShield(int index) {
	Shield s = shields.remove(index);
	return s.getPrice();
    }

    /**
     * In case of selling remove gadget
     *
     * @param index
     *            of the gadget to remove
     * @return double price of the gadget
     */
    public double removeGadget(int index) {
	Gadget g = gadgets.remove(index);
	return g.getPrice();
    }
}
