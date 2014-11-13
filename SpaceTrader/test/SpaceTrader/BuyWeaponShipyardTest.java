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
package SpaceTrader;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import spacetrader.Shipyard;
import spacetrader.Planet;
import spacetrader.Player;
import spacetrader.Laser;
import spacetrader.SolarSystem;
import spacetrader.PoliticalSystem;
import spacetrader.CapitalistState;

/**
 *
 * @author sydnipeterson
 */
public class BuyWeaponShipyardTest {
    
    public BuyWeaponShipyardTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    
    @Test(timeout=100)
    public void buyWeaponTest(){
        Player player = new Player("a");
        //Makes systems
        SolarSystem systemA = new SolarSystem("A", new CapitalistState(), 10);
        Planet a = new Planet("a", systemA);
        Shipyard shipyardA = new Shipyard(a);
        assertEquals(1, shipyardA.buyWeapon(player, Laser.BEAM));
        assertEquals(0, shipyardA.buyWeapon(player, Laser.BEAM));
        
        player.subtractMoney(1000);
        assertEquals(-1, shipyardA.buyWeapon(player, Laser.BEAM));
        
        //assertEquals(null, shipyardA.buyWeapon(player, null));
        
    }
}
