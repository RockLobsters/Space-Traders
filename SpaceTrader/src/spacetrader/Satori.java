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
public class Satori extends PoliticalSystem{
    public String type(){
        return "State of Satori";
    }
    public double policeRate(){
        return 0;
    }
    public double bribeRate() {
        return 0;
    }
    public double traderRate(){
        return 25;
    }
    public double illegalTradeRate(){
        return 0;
    }
    public Object[] highSupply(){
        return null;
    }
    public Object[] lowSupply(){
        return new Object[]{"narcotics", "firearms"};
    }
    public Object[] highDemand(){
        return null;
    }
    public Object[] lowDemand(){
        return new Object[]{"narcotics"};
    }
}
