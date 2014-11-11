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

    private Player player;
    private Universe universe;
    private String currentScreen;

    /**
     * @param player
     *            the player to set
     */
    public void setPlayer(Player player) {
	this.player = player;
    }

    /**
     * @return the player
     */
    public Player getPlayer() {
	return player;
    }

    /**
     * @param universe
     *            the universe to set
     */
    public void setUniverse(Universe universe) {
	this.universe = universe;
    }

    /**
     * @return the universe
     */
    public Universe getUniverse() {
	return universe;
    }

    /**
     * Creates a new universe
     */
    public void createUniverse() {
	universe = new Universe();
	universe.bigBang();
    }

    /**
     * @param currentScreen
     *            the screen to set
     */
    public void setCurrentScreen(String currentScreen) {
	this.currentScreen = currentScreen;
    }

    /**
     * @return the currentScreen
     */
    public String getCurrentScreen() {
	return currentScreen;
    }

    /**
     * @return "Player: player Universe: universe"
     */
    @Override
    public String toString() {
	return "Player:\n" + player.toString() + "\n" + "\n" + "Universe:\n"
		+ universe.toString();
    }
}
