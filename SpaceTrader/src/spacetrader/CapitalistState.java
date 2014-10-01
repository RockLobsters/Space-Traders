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
public class CapitalistState extends PoliticalSystem{
    public String type(){
        return "Capitalist State";
    }
    public double policeRate(){
        return .2;
    }
    public double bribeRate() {
        return 0.15;
    }
    public double traderRate(){
        return 0.5;
    }
    public double illegalTradeRate(){
        return 0.15;
    }
    public int[] highSupply(){
        return new int[0];
    }
    public int[] lowSupply(){
        return new int[0];
    }
    public int[] highDemand(){
        return new int[]{3};
    }
    public int[] lowDemand(){
        return new int[0];
    }
}
