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

//import file writestream some stream

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Addison Amiri
 */
public class GameInstance
{
  private static Game instance = new Game();

  public static Game getInstance()
  {
    return instance;
  }
  public void saveModelBinary()  {
        try {
            try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("data.bin"))) {
                out.writeObject(instance);
            }
        } catch (IOException ex) {
            Logger.getLogger(GameInstance.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void loadModelBinary()  {
        try {
            try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("data.bin"))) {
                Game loadGame = (Game) in.readObject();
                instance = loadGame;
            }
        } catch (IOException ex) {
            Logger.getLogger(GameInstance.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GameInstance.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /*
    private void generateUniverse() {
          for (int i = 0; i < 10; ++i) {
              Planet p = new Planet((i*10), (i*2*10), "Planet " + i);
              planets.add(p);
          }
    }

    public Iterable<Planet> getPlanets() {
       return planets;
    }
    
    public Planet getSelectedPlanet() { return planets.get(selectedPlanet); }
    */
    
  //save game static savegame = new stream(create a file);//stream.write give game obj
  //catch filenotfound
  //load game static //stream.read game obj
  //catch filenotfound
}
