/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package spacetrader;

import java.util.ArrayList;
import java.util.Random;
import java.io.Serializable;

/**
 *
 * @author Kristen Lawrence
 */
public class Dictatorship extends PoliticalSystem implements Serializable{
    Random rand = new Random();
    
    @Override
    public String type(){
        return "Dictatorship";
    }
    
    @Override
    public double policeRate(){
        return 0.35;
    }
    
    @Override
    public double bribeRate() {
        return 0.35;
    }
    
    @Override
    public double traderRate(){
        return 0.2;
    }
    
    @Override
    public double illegalTradeRate(){
        return 0.1;
    }
    
    @Override
    public int[] highSupply(){
        return new int[0];
    }
    
    @Override
    public int[] highDemand(){
        return new int[0];
    }
    
    @Override
    public ArrayList<Good> supply() {
       ArrayList<Good> availableSupply = new ArrayList<>();
       availableSupply.add(new Good(GoodType.WATER, rand.nextInt(100) * 100));
       availableSupply.add(new Good(GoodType.FOOD, rand.nextInt(100) * 100));
       availableSupply.add(new Good(GoodType.FUR, rand.nextInt(100) * 100));
       availableSupply.add(new Good(GoodType.ORE, rand.nextInt(100) * 100));
       availableSupply.add(new Good(GoodType.GAMES, rand.nextInt(100) * 100));
       availableSupply.add(new Good(GoodType.FIREARMS, rand.nextInt(100) * 100));
       availableSupply.add(new Good(GoodType.MEDICINE, rand.nextInt(100) * 100));
       availableSupply.add(new Good(GoodType.MACHINES, rand.nextInt(100) * 100));
       availableSupply.add(new Good(GoodType.NARCOTICS, rand.nextInt(100) * 100));
       availableSupply.add(new Good(GoodType.ROBOTS, rand.nextInt(100) * 100));
       return availableSupply;
    }
    
    @Override
    public ArrayList<Good> demand() {
       ArrayList<Good> sellable = new ArrayList<>();
       sellable.add(new Good(GoodType.WATER, 0));
       sellable.add(new Good(GoodType.FOOD, 0));
       sellable.add(new Good(GoodType.FUR, 0));
       sellable.add(new Good(GoodType.ORE, 0));
       sellable.add(new Good(GoodType.GAMES, 0));
       sellable.add(new Good(GoodType.FIREARMS, 0));
       sellable.add(new Good(GoodType.MEDICINE, 0));
       sellable.add(new Good(GoodType.MACHINES, 0));
       sellable.add(new Good(GoodType.NARCOTICS, 0));
       sellable.add(new Good(GoodType.ROBOTS, 0));
       return sellable;
    }
}
