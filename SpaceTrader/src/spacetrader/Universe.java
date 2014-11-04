/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spacetrader;

import java.util.ArrayList;
import java.io.Serializable;
import java.util.Random;
/**
 * IN NEED OF FIXING!!!
 * @author addison
 */
public class Universe extends ArrayList<SolarSystem> implements Serializable
{
    
    static final int[] NUMPLANETS = new int[] {4,4,3,2,4,4,3,4,5};
    public SolarSystem[] gameUniverse;
    
    /**
     * toString for this universe
     * @return string representation of this game universe
     */
    @Override
    public String toString()
    {
        if(!this.isEmpty())
        {
            String out = "[ ( " + this.get(0).toString();
            for(int i = 1; i < this.size(); i++)
            {
                out = out + " ) ,\n  ( " + this.get(i).toString();
            }
            out = out + " ) ]";
            return out;
        }
        else
        {
            return "";
        }
    }
    
    /**
     * Let there be light
     */
    public void bigBang()
    {
        //Map<int,SolarSystem> lowTL = new ArrayList<>();
        //Map<SolarSystem> highTL = new ArrayList<>();
        SolarSystem systemA = new SolarSystem("Atlantia", new CapitalistState(), 6);
        highTL.add(systemA);
        SolarSystem systemB = new SolarSystem("Bardic Kingdom", new Monarchy(), 2);
        lowTL.add(systemB);
        SolarSystem systemC = new SolarSystem("Cyber Alliance", new Cybernetic(), 7);
        highTL.add(systemC);
        SolarSystem systemD = new SolarSystem("Disney System", new FacistState(), 3);
        lowTL.add(systemD);
        SolarSystem systemE = new SolarSystem("Engles Union", new CommunistState(), 4);
        highTL.add(systemE);
        SolarSystem systemF = new SolarSystem("Filigree Ltd", new Corporate(), 5);
        highTL.add(systemF);
        SolarSystem systemG = new SolarSystem("Golding Barrier Rim", new Anarchy(), 0);
        lowTL.add(systemG);
        SolarSystem systemH = new SolarSystem("Hipee Settlements", new PacifistState(), 1);
        lowTL.add(systemH);
        SolarSystem systemI = new SolarSystem("iGalaxy", new Technocracy(), 7);
        highTL.add(systemI);
        SolarSystem systemJ = new SolarSystem("Judean People's Front", new Theocracy(), 1);
        lowTL.add(systemJ);
        SolarSystem systemK = new SolarSystem("Kapital", new CapitalistState(), 5);
        highTL.add(systemK);
        SolarSystem systemL = new SolarSystem("Luder Planets", new Confederacy(), 3);
        lowTL.add(systemL);
        SolarSystem systemM = new SolarSystem("Myrdyn Cymru", new FeudalState(), 2);
        lowTL.add(systemM);
        SolarSystem systemN = new SolarSystem("New Caledonia", new Dictatorship(), 4);
        highTL.add(systemN);
        SolarSystem systemO = new SolarSystem("Otter Oligopoly", new Corporate(), 6);
        highTL.add(systemO);
        SolarSystem systemP = new SolarSystem("People's Front of Judea", new Theocracy(), 1);
        lowTL.add(systemP);
        SolarSystem systemQ = new SolarSystem("QI Panel Empire", new Dictatorship(), 5);
        highTL.add(systemQ);
        SolarSystem systemR = new SolarSystem("Retrofuturistic Battle Corp", new MilitaryState(), 6);
        highTL.add(systemR);
        SolarSystem systemS = new SolarSystem("Samsong Galaxy", new Technocracy(), 7);
        highTL.add(systemS);
        SolarSystem systemT = new SolarSystem("Tutu Tribes", new Anarchy(), 0);
        lowTL.add(systemT);
        SolarSystem systemU = new SolarSystem("Utopia", new Satori(), 0);
        lowTL.add(systemU);
        SolarSystem systemV = new SolarSystem("Volpone-Forze Armate", new MilitaryState(), 4);
        highTL.add(systemV);
        SolarSystem systemW = new SolarSystem("Worlds of Wodehosse", new Monarchy(), 3);
        lowTL.add(systemW);
        SolarSystem systemX = new SolarSystem("Xerxes Democratic Republic", new Democracy(), 2);
        lowTL.add(systemX);
        SolarSystem systemY = new SolarSystem("Yelle", new SocialistState(), 4);
        highTL.add(systemY);
        SolarSystem systemZ = new SolarSystem("Zcousers", new Confederacy(), 3);
        lowTL.add(systemZ);

        gameUniverse = new SolarSystem[9];
        Random rand = new Random();
        
        //make array containing all possible planet names
        String[] allNames = new String[26*5];
        int index = 0;
        for (PlanetNames n : PlanetNames.values()) {
            allNames[index] = n.getName();
            index++;
        }
        //fill game universe array with systems and fill those systems with planets
        for (int i = 0; (i+1) < 9; i++) {
            int r = rand.nextInt(highTL.size());
            SolarSystem systemHigh = highTL.remove(r);
            SolarSystem systemLow = lowTL.remove(r);
            gameUniverse[i] = systemHigh;
            gameUniverse[i+1] = systemLow;
            for (int j = 0; j < NUMPLANETS[i]; j++) {
                String name = allNames[r*5+j];
                Planet p = new Planet(name);
                p.setSolarSystem(system);
                system.addPlanet(p);
            }
            wholeUniverse[r] = null;
            this.add(system);
            r = rand.nextInt(26);
            system = wholeUniverse[r];
        }
    }

    /**
     * Helper that maintains balance of high and low techlevel systems
     * @param cur potential solar system to check tech level of
     * @param prev previous solar system selected to measure against
     * @return 
     */
    private boolean matchTechLevel(SolarSystem cur, SolarSystem prev) {
        if (cur.getTechLevel() < 4 && prev.getTechLevel() < 4) {
            return true;
        }
        if (cur.getTechLevel() >= 4 && prev.getTechLevel() >= 4) {
            return true;
        }
        return false;
    }
    
    /**
     * getter for gameUniverse
     * @return array of the randomly selected solar systems
     */
    public SolarSystem[] getGameUniverse() {
        return gameUniverse;
    }
}
