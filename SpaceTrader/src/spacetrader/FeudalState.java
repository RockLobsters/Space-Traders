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
public class FeudalState extends PoliticalSystem{
    public String type(){
        return "Feudal State";
    }
    public double policeRate(){
        return 0.05;
    }
    public double bribeRate() {
        return 0.25;
    }
    public double traderRate(){
        return 0.35;
    }
    public double illegalTradeRate(){
        return 0.3;
    }
    public Object[] highSupply(){
        return null;
    }
    public Object[] lowSupply(){
        return new Object[]{"machines", "robots"};
    }
    public Object[] highDemand(){
        return new Object[]{"narcotics","firearms"};
    }
    public Object[] lowDemand(){
        return null;
    }
}
