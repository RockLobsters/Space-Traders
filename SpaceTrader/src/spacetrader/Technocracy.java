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
public class Technocracy extends PoliticalSystem{
    public String type(){
        return "Technocracy";
    }
    public double policeRate(){
        return 0.25;
    }
    public double bribeRate() {
        return 0.25;
    }
    public double traderRate(){
        return 0.25;
    }
    public double illegalTradeRate(){
        return 0.25;
    }
    public Object[] highSupply(){
        return new Object[]{"machines","robots"};
    }
    public Object[] lowSupply(){
        return null;
    }
    public Object[] highDemand(){
        return new Object[]{"water"};
    }
    public Object[] lowDemand(){
        return null;
    }
}
