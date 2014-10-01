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
    public Object[] highSupply(){
        return null;
    }
    public Object[] lowSupply(){
        return null;
    }
    public Object[] highDemand(){
        return new Object[]{"ore"};
    }
    public Object[] lowDemand(){
        return null;
    }
}
