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
    public Object[] highSupply(){
        return null;
    }
    public Object[] lowSupply(){
        return new Object[]{"narcotics"};
    }
    public Object[] highDemand(){
        return new Object[]{"robots"};
    }
    public Object[] lowDemand(){
        return new Object[]{"narcotics"};
    }
}
