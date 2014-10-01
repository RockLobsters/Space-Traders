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
public class Corporate extends PoliticalSystem{
    public String type(){
        return "Corporate";
    }
    public double policeRate(){
        return 0.5;
    }
    public double bribeRate() {
        return 0;
    }
    public double traderRate(){
        return 0.5;
    }
    public double illegalTradeRate(){
        return 0;
    }
    public Object[] highSupply(){
        return null;
    }
    public Object[] lowSupply(){
        return null;
    }
    public Object[] highDemand(){
        return new Object[]{"robots"};
    }
    public Object[] lowDemand(){
        return null;
    }
}
