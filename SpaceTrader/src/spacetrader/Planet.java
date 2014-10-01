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
 * The Planet object class.
 *
 * For convenience this is what each of the resource levels indicate:
 * 0 - NOSPECIALRESOURCES (the most common)
 * 1 - MINERALRICH
 * 2 - MINERALPOOR
 * 3 - DESERT
 * 4 - LOTSOFWATER
 * 5 - RICHSOIL
 * 6 - POORSOIL
 * 7 - RICHFAUNA
 * 8 - LIFELESS
 * 9 - WEIRDMUSHROOMS
 * 10 - LOTSOFHERBS
 * 11 - ARTISTIC
 * 12 - WARLIKE
 *
 * @author Addison Amiri
 */
public class Planet implements Comparable
{
    private String name;
    private int coordinateX;
    private int coordinateY;
    private int resources;
    private Market market;
    private ArrayList<Mercenary> personnelRoster;
    private SolarSystem solarSystem;

    public Planet(String name)
    {
        this(name, (int) (Math.random() * SolarSystem.SIZE_X), (int) (Math.random() * SolarSystem.SIZE_Y));
    }

    public Planet(String name, int minCoordinateX, int maxCoordinateX, int minCoordinateY, int maxCoordinateY, SolarSystem solarSystem)
    {
        this(name, (int) (Math.random() * (maxCoordinateX - minCoordinateX + 1) + minCoordinateX), (int) (Math.random() * (maxCoordinateY - minCoordinateY + 1) + minCoordinateY));
        this.setSolarSystem(solarSystem);
    }

    public Planet(String name, int coordinateX, int coordinateY)
    {
        this.name = name;
        this.coordinateX = coordinateX;
        this.coordinateY = coordinateY;
        this.resources = (int) (Math.random() * 25);
        if(resources < 0)
        {
            resources = 0;
        }
<<<<<<< HEAD
        market = new Market();
=======
        market = new Market(this);
>>>>>>> master
        personnelRoster = new ArrayList();
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
     * @return the coordinateX
     */
    public int getCoordinateX()
    {
        return coordinateX;
    }

    /**
     * @param coordinateX the coordinateX to set
     */
    public void setCoordinateX(int coordinateX)
    {
        this.coordinateX = coordinateX;
    }

    /**
     * @return the coordinateY
     */
    public int getCoordinateY()
    {
        return coordinateY;
    }

    /**
     * @param coordinateY the coordinateY to set
     */
    public void setCoordinateY(int coordinateY)
    {
        this.coordinateY = coordinateY;
    }

    /**
     * Adds a mercenary to the Personnel roster
     *
     * @param mercenary The mercenary to add
     */
    public void addMercenary(Mercenary mercenary)
    {
        getPersonnelRoster().add(mercenary);
    }

    /**
     * Remove a mercenary from the personnel roster
     *
     * @param name The name of the mercenary to remove
     * @return
     */
    public Mercenary removeMercenary(String name)
    {
        Mercenary toFind = new Mercenary(name, 0);
        for(int i = 0; i < getPersonnelRoster().size(); i++)
        {
            if(getPersonnelRoster().get(i).compareTo(toFind) == 0)
            {
                return getPersonnelRoster().remove(i);
            }
        }
        return null;
    }

    /**
     * @return the resources
     */
    public int getResources()
    {
        return resources;
    }

    /**
     * @param resources the resources to set
     */
    public void setResources(int resources)
    {
        this.resources = resources;
    }

    /**
     * @return the personnelRoster
     */
    public ArrayList<Mercenary> getPersonnelRoster()
    {
        return personnelRoster;
    }

    /**
     * @param personnelRoster the personnelRoster to set
     */
    public void setPersonnelRoster(
            ArrayList<Mercenary> personnelRoster)
    {
        this.personnelRoster = personnelRoster;
    }

    /**
     * @return the solarSystem
     */
    public SolarSystem getSolarSystem()
    {
        return solarSystem;
    }

    /**
     * @param solarSystem the solarSystem to set
     */
    public void setSolarSystem(SolarSystem solarSystem)
    {
        this.solarSystem = solarSystem;
    }

    /**
     * Compares two planets based on their names.
     *
     * @param that the planet to compare against
     * @return
     */
    @Override
    public int compareTo(Object that)
    {
        return this.name.compareTo(((Planet) that).getName());
    }

    @Override
    public String toString()
    {
        String out = name + " (" + coordinateX + "," + coordinateY + ") " + resources + " ( " + /*market +*/ " , [ " ;
        if(!personnelRoster.isEmpty())
        {
            out = out + "( " + personnelRoster.get(0);
            for(int i = 1; i < personnelRoster.size(); i++)
            {
                out = out + " ) , ( " + personnelRoster.get(i);
            }
            out = out + " ) ";
        }
        out = out + "] )";
        return out;
    }
}
