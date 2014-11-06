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
        PoliticalSystem[] govs = {new Anarchy(),
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
               

        gameUniverse = new SolarSystem[9];
        Random rand = new Random();
        
        //TODO
//        //fill game universe array with systems and fill those systems with planets
//        for (int i = 0; (i+1) < 9; i++) {
//            int r = rand.nextInt(highTL.size());
//            SolarSystem systemHigh = highTL.remove(r);
//            SolarSystem systemLow = lowTL.remove(r);
//            gameUniverse[i] = systemHigh;
//            gameUniverse[i+1] = systemLow;
//            for (int j = 0; j < NUMPLANETS[i]; j++) {
//                String name = allNames[r*5+j];
//                Planet p = new Planet(name);
//                p.setSolarSystem(system);
//                system.addPlanet(p);
//            }
//            wholeUniverse[r] = null;
//            this.add(system);
//            r = rand.nextInt(26);
//            system = wholeUniverse[r];
//        }
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
