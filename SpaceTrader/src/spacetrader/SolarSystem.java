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
/**
 *
 * @author Addison Amiri
 */
class SolarSystem
{
    private String name;
    private ArrayList<Planet> planets;
    private PoliticalSystem government;
    private int techLevel;
    
    public SolarSystem(String name, PoliticalSystem government, int techLevel)
    {
        this.name = name;
        planets = new ArrayList();
        this.government = government;
        this.techLevel = techLevel;
    }

    /**
     * @return the name
     */
    public String getName()
    {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name)
    {
        this.name = name;
    }
    
    /**
     * Add a planet to the SolarSystem
     * 
     * @param planet the planet to add
     */
    public void addPlanet(Planet planet)
    {
        planets.add(planet);
    }

    /**
     * @return the planets
     */
    public ArrayList<Planet> getPlanets()
    {
        return planets;
    }

    /**
     * @param planets the planets to set
     */
    public void setPlanets(ArrayList<Planet> planets)
    {
        this.planets = planets;
    }

    /**
     * @return the techLevel
     */
    public int getTechLevel()
    {
        return techLevel;
    }

    /**
     * @param techLevel the techLevel to set
     */
    public void setTechLevel(int techLevel)
    {
        this.techLevel = techLevel;
    }
    
    @Override
    public String toString()
    {
        String out = name + " ( " + government + " " + techLevel + " ) [ ";
        if(!planets.isEmpty())
        {
            out = out + "( " + planets.get(0);
            for(int i = 1; i < planets.size(); i++)
            {
                out = out + " ) , ( " + planets.get(i);
            }
            out = out + " ) ";
        }
        out = out + "]";
        return out;
        
    }
}
