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
public class Dictatorship extends PoliticalSystem{
    public String type(){
        return "Dictatorship";
    }
    public double policeRate(){
        return 0.35;
    }
    public double bribeRate() {
        return 0.35;
    }
    public double traderRate(){
        return 0.2;
    }
    public double illegalTradeRate(){
        return 0.1;
    }
    public Object[] highSupply(){
        return null;
    }
    public Object[] lowSupply(){
        return null;
    }
    public Object[] highDemand(){
        return null;
    }
    public Object[] lowDemand(){
        return null;
    }
}
