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
 *
 * @author addison
 */
public class Universe extends ArrayList<SolarSystem> implements Serializable {

    static final int[] NUMPLANETS = new int[]{4, 4, 3, 2, 4, 4, 3, 4, 5};

    /**
     *
     */
    public SolarSystem[] gameUniverse;

    /**
     * toString for this universe
     *
     * @return string representation of this game universe
     */
    @Override
    public String toString() {
        if (!this.isEmpty()) {
            String out = "[ ( " + this.get(0).toString();
            for (int i = 1; i < this.size(); i++) {
                out = out + " ) ,\n  ( " + this.get(i).toString();
            }
            out = out + " ) ]";
            return out;
        } else {
            return "";
        }
    }

    /**
     * Let there be light
     */
    public void bigBang() {
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
        boolean high = rand.nextBoolean();
        SolarSystemFactory fact = new SolarSystemFactory();
        for (int i = 0; i < 9; i++) {
            if (high) {
                gameUniverse[i] = fact.generateHigh(NUMPLANETS[i]);
            } else {
                gameUniverse[i] = fact.generateLow(NUMPLANETS[i]);
            }
            high = !high;
            this.add(gameUniverse[i]);
        }
    }

    /**
     * getter for gameUniverse
     *
     * @return array of the randomly selected solar systems
     */
    public SolarSystem[] getGameUniverse() {
        return gameUniverse;
    }
}
