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
public class CommunistState extends PoliticalSystem{
    public String type(){
        return "Communist State";
    }
    public double policeRate(){
        return 0.3;
    }
    public double bribeRate() {
        return 0.2;
    }
    public double traderRate(){
        return 0.25;
    }
    public double illegalTradeRate(){
        return 0.25;
    }
    public int[] highSupply(){
        return new int[0];
    }
    public int[] lowSupply(){
        return new int[0];
    }
    public int[] highDemand(){
        return new int[]{5,8};
    }
    public int[] lowDemand(){
        return new int[0];
    }
}
