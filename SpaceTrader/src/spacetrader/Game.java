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

import java.io.Serializable;

/**
*
* @author sydnipeterson
*/
public class Game implements Serializable {

    /**
     *
     */
    private Player player;
    /**
     *
     */
    private Universe universe;
    /**
     *
     */
    private String currentScreen;

    /**
     * @param thePlayer
     *            the player to set
     */
    public final void setPlayer(final Player thePlayer) {
        this.player = thePlayer;
    }

    /**
     * @return the player
     */
    public final Player getPlayer() {
        return player;
    }

    /**
     * @param theUniverse
     *            the universe to set
     */
    public final void setUniverse(final Universe theUniverse) {
        this.universe = theUniverse;
    }

    /**
     * @return the universe
     */
    public final Universe getUniverse() {
        return universe;
    }

    /**
     * Creates a new universe.
     */
    public final void createUniverse() {
        universe = new Universe();
        universe.bigBang();
    }

    /**
     * @param theCurrentScreen
     *            the screen to set
     */
    public final void setCurrentScreen(final String theCurrentScreen) {
        this.currentScreen = theCurrentScreen;
    }

    /**
     * @return the currentScreen
     */
    public final String getCurrentScreen() {
        return currentScreen;
    }

    /**
     * @return "Player: player Universe: universe"
     */
    @Override
    public final String toString() {
        return "Player:\n" + player.toString() + "\n" + "\n" + "Universe:\n"
                + universe.toString();
    }
}
