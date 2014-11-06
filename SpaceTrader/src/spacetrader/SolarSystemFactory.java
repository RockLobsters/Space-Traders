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
public class SolarSystemFactory
{
    PoliticalSystem[] govs =
    {
        new Anarchy(),
        new CapitalistState(),
        new CommunistState(),
        new Confederacy(),
        new Corporate(),
        new Cybernetic(),
        new Democracy(),
        new Dictatorship(),
        new FascistState(),
        new FeudalState(),
        new MilitaryState(),
        new Monarchy(),
        new PacifistState(),
        new SocialistState(),
        new Satori(),
        new Technocracy(),
        new Theocracy()
    };

    public SolarSystem newRandomSolarSystem(int numOfPlanets)
    {
        int random = (int) (Math.random() * SystemPool.values().length);
        SystemPool x = SystemPool.values()[random];
        SolarSystem out = new SolarSystem(x.name, govs[x.govType], x.techLevel);
        for(int i = 0; i < numOfPlanets; i++)
        {
            Planet newPlanet = new Planet(PlanetNames.values()[random * 5 + i]
                    .getName(), out);
            out.addPlanet(newPlanet);
        }
        return out;
    }

    public SolarSystem generateHigh(int numOfPlanets)
    {
        int random = (int) (Math.random() * SystemPool.values().length);
        while(SystemPool.values()[random].techLevel < 4)
        {
            random = (int) (Math.random() * SystemPool.values().length);
        }
        SystemPool x = SystemPool.values()[random];
        SolarSystem out = new SolarSystem(x.name, govs[x.govType], x.techLevel);
        for(int i = 0; i < numOfPlanets; i++)
        {
            Planet newPlanet = new Planet(PlanetNames.values()[random * 5 + i]
                    .getName(), out);
            out.addPlanet(newPlanet);
        }
        return out;
    }

    public SolarSystem generateLow(int numOfPlanets)
    {
        int random = (int) (Math.random() * SystemPool.values().length);
        while(SystemPool.values()[random].techLevel > 3)
        {
            random = (int) (Math.random() * SystemPool.values().length);
        }
        SystemPool x = SystemPool.values()[random];
        SolarSystem out = new SolarSystem(x.name, govs[x.govType], x.techLevel);
        for(int i = 0; i < numOfPlanets; i++)
        {
            Planet newPlanet = new Planet(PlanetNames.values()[random * 5 + i]
                    .getName(), out);
            out.addPlanet(newPlanet);
        }
        return out;
    }
}
