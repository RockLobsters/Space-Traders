/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package spacetrader;

/**
 *
 * @author Kristen Lawrence
 */
public abstract class PoliticalSystem {
    public abstract String type();
    public abstract double policeRate();
    public abstract double bribeRate();
    public abstract double traderRate();
    public abstract double illegalTradeRate();
<<<<<<< HEAD
    public abstract Object[] highSupply();
    public abstract Object[] lowSupply();
    public abstract Object[] highDemand();
    public abstract Object[] lowDemand();
=======
    public abstract int[] highSupply();
    public abstract int[] highDemand();
    public abstract ArrayList<Good> supply();
    public abstract ArrayList<Good> demand();
>>>>>>> master
}
