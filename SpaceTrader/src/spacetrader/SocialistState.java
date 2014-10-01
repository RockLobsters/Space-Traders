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
public class SocialistState extends PoliticalSystem{
    public String type(){
        return "Socialist State";
    }
    public double policeRate(){
        return .05;
    }
    public double bribeRate() {
        return .2;
    }
    public double traderRate(){
        return 0.25;
    }
    public double illegalTradeRate(){
        return 0.75;
    }
    public int[] highSupply(){
        return new int[0];
    }
    public int[] lowSupply(){
        return new int[0];
    }
    public int[] highDemand(){
        return new int[0];
    }
    public int[] lowDemand(){
        return new int[0];
    }
}
