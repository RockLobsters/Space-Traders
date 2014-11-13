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
package SpaceTrader;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import spacetrader.Market;
import spacetrader.Good;
import spacetrader.GoodType;

/**
 *
 * @author Addison Amiri
 */
public class ContainsGoodTest {

    /**
     *
     */
    public ContainsGoodTest() {
    }

    /**
     *
     */
    @BeforeClass
    public static void setUpClass() {
    }

    /**
     *
     */
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     *
     */
    @Before
    public void setUp() {
    }

    /**
     *
     */
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    /**
     *
     */
    @Test(timeout = 100)
    public void containsGoodTest() {
        Good[] list = new Good[GoodType.values().length];
        for (int i = 0; i < list.length; i++) {
            list[i] = new Good(GoodType.values()[i], 1);
        }
        for (int i = 0; i < list.length; i++) {
            assertTrue(Market.containsGood(list, new Good(GoodType.values()[i],
                                                          1)));
        }
    }

    /**
     *
     */
    @Test(timeout = 100)
    public void containsNothingTest() {
        Good[] list = new Good[GoodType.values().length];
        for (int i = 0; i < list.length; i++) {
            assertFalse(Market.containsGood(list, new Good(
                                            GoodType.values()[i], 1)));
        }
    }

    /**
     *
     */
    @Test(timeout = 100)
    public void containsNullTest() {
        Good[] list = new Good[GoodType.values().length];
        for (int i = 0; i < list.length; i++) {
            list[i] = new Good(GoodType.values()[i], 1);
        }
        assertFalse(Market.containsGood(list, null));
    }
}
