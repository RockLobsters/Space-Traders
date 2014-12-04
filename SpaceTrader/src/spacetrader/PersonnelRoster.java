package spacetrader;


import java.util.ArrayList;
import java.util.List;

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

/**
 *
 * @author Addison Amiri
 */
public class PersonnelRoster {
    private static final String[] names = {
        "Jonny Boy",
        "Crazy Eyes",
        "Brass, the Monkey",
        "Mark Wahlberg",
        "Jason Bourne",
        "Andre the Giant",
        "John Cena",
        "Alladin",
        "Mary Lu",
        "Mulan",
        "Joan Jett",
        "Mary Jane",
        "Black Dynamite",
        "The girl from Brave",
        "Barbra Streisand",
        "Lain",
        "Inigo Montoya"};
    
    private final List<Mercenary> list;
    
    public PersonnelRoster() {
        list = new ArrayList();
    }
    
    /**
     * A getter for the List
     * 
     * @return list
     */
    public List<Mercenary> getList() {
        return list;
    }
    
    /**
     * Populates the PersonnelRoster with 0-3 mercenaries with random names and
     * total skill levels of the current tech level +/- 1
     * 
     * @param planet the planet the PersonnelRoster is on
     */
    public void populateList(Planet planet) {
        for(int i = (int)(Math.random()*4); i > 0; i--) {
            list.add(new Mercenary(names[(int)(Math.random()*names.length)], planet.getSolarSystem().getTechLevel() + (int)(Math.random()*3-1)));
        }
    }
    
    /**
     * Hires a mercenary out of the PersonnelRoster's array list
     * 
     * @param index the index in the array list that the user wants to hire
     * @return true if the hire was successful
     */
    public boolean hireMercenary(int index) {
        Ship ship = GameInstance.getInstance().getPlayer().getShip();
        if(ship.getCrew().size() < ship.getCrewQuarters()) {
            Mercenary toHire = list.remove(index);
            return ship.addCrew(toHire);
        } else {
            return false;
        }
    }
    
    /**
     * Fires a mercenary that the user has previously hired
     * 
     * @param toFire the mercenary to fire
     * @return true if the firing succeeded
     */
    public boolean fireMercenary(Mercenary toFire) {
        Ship ship = GameInstance.getInstance().getPlayer().getShip();
        return list.add(ship.getCrew().remove(ship.getCrewIndex(toFire)));
    }
}
