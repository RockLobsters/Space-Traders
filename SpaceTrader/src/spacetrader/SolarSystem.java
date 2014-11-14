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
class SolarSystem implements Serializable {

    /**
     *
     */
    private String name;
    /**
     *
     */
    private ArrayList<Planet> planets;
    /**
     *
     */
    private AbstractPoliticalSystem politicalSystem;
    /**
     *
     */
    private int techLevel;
    /**
     *
     */
    public static final int SIZE_X = 50;
    /**
     *
     */
    public static final int SIZE_Y = 50;
    /**
     *
     * @param theName name
     * @param thePoliticalSystem ps
     * @param theTechLevel tech Level
     */
    public SolarSystem(final String theName,
            final AbstractPoliticalSystem thePoliticalSystem,
            final int theTechLevel) {
        this.name = theName;
        planets = new ArrayList();
        this.politicalSystem = thePoliticalSystem;
        this.techLevel = theTechLevel;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param theName
     *            the name to set
     */
    public final void setName(final String theName) {
        this.name = theName;
    }

    /**
     * Add a planet to the SolarSystem.
     *
     * @param thePlanet
     *            the planet to add
     */
    public final void addPlanet(final Planet thePlanet) {
        planets.add(thePlanet);
    }

    /**
     * @return the planets
     */
    public final ArrayList<Planet> getPlanets() {
        return planets;
    }

    /**
     * @param thePlanets
     *            the planets to set
     */
    public final void setPlanets(final ArrayList<Planet> thePlanets) {
        this.planets = thePlanets;
    }

    /**
     * @return the techLevel
     */
    public int getTechLevel() {
        return techLevel;
    }

    /**
     * @param theTechLevel
     *            the techLevel to set
     */
    public final void setTechLevel(final int theTechLevel) {
        this.techLevel = theTechLevel;
    }

    @Override
    /**
     *
     */
    public final  String toString() {
        String out = name + " ( " + getPoliticalSystem() + " " + techLevel
                + " ) [ ";
        if (!planets.isEmpty()) {
            out = out + "( " + planets.get(0);
            for (int i = 1; i < planets.size(); i++) {
                out = out + " ) , ( " + planets.get(i);
            }
            out = out + " ) ";
        }
        out = out + "]";
        return out;

    }

    /**
     * @return the politicalSystem
     */
    public AbstractPoliticalSystem getPoliticalSystem() {
        return politicalSystem;
    }

    /**
     * @param ps
     *            the politicalSystem to set
     */
    public final void setPoliticalSystem(final AbstractPoliticalSystem ps) {
        this.politicalSystem = ps;
    }
}
