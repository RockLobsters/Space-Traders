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
public class MilitaryState extends PoliticalSystem{
    public String type(){
        return "Military State";
    }
    public double policeRate(){
        return 0.75;
    }
    public double bribeRate() {
        return 0;
    }
    public double traderRate(){
        return 0.2;
    }
    public double illegalTradeRate(){
        return 0.05;
    }
    public int[] highSupply(){
        return null;
    }
    public int[] lowSupply(){
        return new int[]{8};
    }
    public int[] highDemand(){
        return new int[]{9};
    }
    public int[] lowDemand(){
        return new int[]{8};
    }
}
