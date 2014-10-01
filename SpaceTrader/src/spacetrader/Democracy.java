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
public class Democracy extends PoliticalSystem{
    public String type(){
        return "Democracy";
    }
    public double policeRate(){
        return 0.05;
    }
    public double bribeRate() {
        return 0.2;
    }
    public double traderRate(){
        return 0.2;
    }
    public double illegalTradeRate(){
        return 0.35;
    }
    public Object[] highSupply(){
        return new Object[]{"a","b","c"};
    }
    public Object[] lowSupply(){
        return new Object[]{"a","b","c"};
    }
    public Object[] highDemand(){
        return new Object[]{"games","food","ore","machines","water","robots","furs","narcotics","medicine","firearms"};
    }
    public Object[] lowDemand(){
        return null;
    }
}
