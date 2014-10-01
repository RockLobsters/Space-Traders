/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package spacetrader;

import java.util.ArrayList;

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
    public abstract int[] highSupply();
    public abstract int[] highDemand();
    public abstract ArrayList<Good> supply();
    public abstract ArrayList<Good> demand();
}
