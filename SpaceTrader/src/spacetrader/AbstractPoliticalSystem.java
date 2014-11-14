/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spacetrader;

import java.util.ArrayList;

/**
 * Political System abstract class.
 *
 * @author Kristen Lawrence
 */
public abstract class AbstractPoliticalSystem {

    /**
     * @return string of government type name
     */
    public abstract String type();

    /**
     * percent rate of un-corrupt-able police in this system.
     *
     * @return double rate of random police encounter
     */
    public abstract double policeRate();

    /**
     * percent rate of corrupt-able police in this system.
     *
     * @return double rate of random corrupt police encounter
     */
    public abstract double bribeRate();

    /**
     * percent rate of legal traders in this system.
     *
     * @return double rate of random trader encounter
     */
    public abstract double traderRate();

    /**
     * percent rate of illegal traders in this system.
     *
     * @return double rate of random illegal trader encounter
     */
    public abstract double illegalTradeRate();

    /**
     * establishes which goods are in high supply in this system.
     *
     * @return int array of key(s) of good(s) in high supply
     */
    public abstract int[] highSupply();

    /**
     * establishes which goods are in high demand in this system.
     *
     * @return int array of key(s) of good(s) in high demand
     */
    public abstract int[] highDemand();

    /**
     * creates and returns an array list of buy-able goods on the planet with.
     * proper quantities
     *
     * @return array list of goods availableSupply
     */
    public abstract ArrayList<Good> supply();

    /**
     * creates and returns an array list of sellable goods on the planet.
     *
     * @return array list of goods sellable
     */
    public abstract ArrayList<Good> demand();
}
