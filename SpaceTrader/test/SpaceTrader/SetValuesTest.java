package SpaceTrader;

/*
 * Copyright (C) 2014 Kristen Lawrence
 *
 * This program is free software: you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation, either version 3 of the License, or (at your option) any later
 * version.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details.
 *
 * You should have received a copy of the GNU General Public License along with
 * this program. If not, see <http://www.gnu.org/licenses/>.
 */
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import spacetrader.Good;
import spacetrader.GoodType;

/**
 *
 * @author Kristen Lawrence
 */
public class SetValuesTest {

    /**
     *
     */
    public SetValuesTest() {
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
    public void basePriceTest() {
        int[] vals = new int[]{30, 250, 100, 350, 250, 1250, 650, 900, 3500,
                               5000};
        GoodType[] types = GoodType.values();
        for (int i = 0; i < types.length; i++) {
            Good instance = new Good(types[i], 0);
            assertEquals(vals[i], instance.getBasePrice());
        }
    }

    /**
     *
     */
    @Test(timeout = 1000)
    public void mtlpTest() {
        int[] vals = new int[]{0, 0, 1, 2, 3, 3, 4, 4, 5, 6};
        GoodType[] types = GoodType.values();
        for (int i = 0; i < types.length; i++) {
            Good instance = new Good(types[i], 0);
            assertEquals(vals[i], instance.getMTLP());
        }
    }

    /**
     *
     */
    @Test(timeout = 10000)
    public void mtluTest() {
        int[] vals = new int[]{0, 0, 0, 2, 1, 1, 1, 3, 0, 4};
        GoodType[] types = GoodType.values();
        for (int i = 0; i < types.length; i++) {
            Good instance = new Good(types[i], 0);
            assertEquals(vals[i], instance.getMTLU());
        }
    }

    /**
     *
     */
    @Test(timeout = 1000)
    public void ttpTest() {
        int[] vals = new int[]{2, 1, 0, 3, 6, 5, 6, 5, 5, 7};
        GoodType[] types = GoodType.values();
        for (int i = 0; i < types.length; i++) {
            Good instance = new Good(types[i], 0);
            assertEquals(vals[i], instance.getTTP());
        }
    }

    /**
     *
     */
    @Test(timeout = 10000)
    public void iplTest() {
        int[] vals = new int[]{3, 10, 5, 20, -10, -75, -20, -30, -125, -150};
        GoodType[] types = GoodType.values();
        for (int i = 0; i < types.length; i++) {
            Good instance = new Good(types[i], 0);
            assertEquals(vals[i], instance.getIPL());
        }
    }

    /**
     *
     */
    @Test(timeout = 1000)
    public void varTest() {
        int[] vals = new int[]{4, 10, 5, 10, -10, 100, 10, 5, 150, 100};
        GoodType[] types = GoodType.values();
        for (int i = 0; i < types.length; i++) {
            Good instance = new Good(types[i], 0);
            assertEquals(vals[i], instance.getVar());
        }
    }

    /**
     *
     */
    @Test(timeout = 1000)
    public void crTest() {
        int[] vals = new int[]{4, 7, 5, 1, 11, 12, 10, -1, 9, -1};
        GoodType[] types = GoodType.values();
        for (int i = 0; i < types.length; i++) {
            Good instance = new Good(types[i], 0);
            assertEquals(vals[i], instance.getCR());
        }
    }

    /**
     *
     */
    @Test(timeout = 1000)
    public void erTest() {
        int[] vals = new int[]{3, 8, 6, 2, -1, -1, -1, -1, -1, -1};
        GoodType[] types = GoodType.values();
        for (int i = 0; i < types.length; i++) {
            Good instance = new Good(types[i], 0);
            assertEquals(vals[i], instance.getER());
        }
    }
}
