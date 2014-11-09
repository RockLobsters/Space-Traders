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
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import spacetrader.SolarSystem;
import spacetrader.SolarSystemFactory;

/**
 *
 * @author Addison Amiri
 */
public class SolarSystemFactoryTest {
    
    public SolarSystemFactoryTest() {
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
    public void baicRandomTest() {
        SolarSystem instance = SolarSystemFactory.newRandomSolarSystem(4);
        assertTrue(instance instanceof SolarSystem);
    }
    
    @Test(timeout=1000)
    public void planetNumberRandomTest() {
        for(int i = 1; i <= 5; i++) {
            SolarSystem instance = SolarSystemFactory.newRandomSolarSystem(i);
            assertEquals(i, instance.getPlanets().size());
        }
    }
    
    @Test(timeout=10000)
    public void basicHighTest() {
        for(int i = 0; i < 100; i++) {
            SolarSystem instance = SolarSystemFactory.generateHigh(4);
            assertTrue(instance instanceof SolarSystem);
            assertTrue(instance.getTechLevel() >= 4);
        }
    }
    
    @Test(timeout=1000)
    public void planetNumberHighTest() {
        for(int i = 1; i <= 5; i++) {
            SolarSystem instance = SolarSystemFactory.generateHigh(i);
            assertEquals(i, instance.getPlanets().size());
        }
    }
    
        @Test(timeout=10000)
    public void basicLowTest() {
        for(int i = 0; i < 100; i++) {
            SolarSystem instance = SolarSystemFactory.generateLow(4);
            assertTrue(instance instanceof SolarSystem);
            assertTrue(instance.getTechLevel() < 4);
        }
    }
    
    @Test(timeout=1000)
    public void planetNumberLowTest() {
        for(int i = 1; i <= 5; i++) {
            SolarSystem instance = SolarSystemFactory.generateLow(i);
            assertEquals(i, instance.getPlanets().size());
        }
    }
}
