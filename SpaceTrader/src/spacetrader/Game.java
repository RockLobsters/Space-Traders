/*
 * Copyright (C) 2014 sydnipeterson
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
 * @author sydnipeterson
 */
public class Game {

    private Player player;
    private Universe universe;
    
<<<<<<< HEAD

    public Game(Player player, Universe universe)
=======
    public void setPlayer(Player player)
>>>>>>> master
    {
      this.player = player;
    }
<<<<<<< HEAD

    public Game(String name, int pilot, int fighter, int trader, int engineer, int investor)
    {
        player = new Player(name);
        player.setPilot(pilot);
        player.setFighter(fighter);
        player.setTrader(trader);
        player.setEngineer(engineer);
        player.setInvestor(investor);
        player.setShip(new Gnat());
        universe = new Universe();
        universe.bigBang();
    }
=======
    
    public Player getPlayer()
    {
      return player;
    }
    
    public void setUniverse(Universe universe)
    {
      this.universe = universe;
    }
    
    public Universe getUniverse()
    {
      return universe;
    }
    
    public void createUniverse()
    {
      universe = new Universe();
      universe.bigBang();
    }
>>>>>>> master

    @Override
    public String toString()
    {
        return    "Player:\n"
                + player.toString() + "\n"
                + "\n"
                + "Universe:\n"
                + universe.toString();
    }

    public Game getInstance()
    {
      return this;
    }
}
