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
public class MilitaryState extends PoliticalSystem implements Serializable{
    Random rand = new Random();
    
    /**
     * 
     * @return string of government type name
     */
    @Override
    public String type(){
        return "Military State";
    }
    
    /**
     * percent rate of un-corrupt-able police in this system
     * @return double  rate of random police encounter
     */
    @Override
    public double policeRate(){
        return 0.75;
    }
    
    /**
     * percent rate of corrupt-able police in this system
     * @return double  rate of random corrupt police encounter
     */
    @Override
    public double bribeRate() {
        return 0;
    }
    
    /**
     * percent rate of legal traders in this system
     * @return double  rate of random trader encounter
     */
    @Override
    public double traderRate(){
        return 0.2;
    }
    
    /**
     * percent rate of illegal traders in this system
     * @return double  rate of random illegal trader encounter
     */
    @Override
    public double illegalTradeRate(){
        return 0.05;
    }
    
    /**
     * establishes which goods are in high supply in this system
     * @return int array of key(s) of good(s) in high supply
     */
    @Override
    public int[] highSupply(){
        return null;
    }
    
    /**
     * establishes which goods are in high demand in this system
     * @return int array of key(s) of good(s) in high demand
     */
    @Override
    public int[] highDemand(){
        return new int[]{9};
    }
    
    /**
     * creates and returns an array list of buy-able goods on the planet with proper quantities
     * @return array list of goods availableSupply
     */
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
       //availableSupply.add(new Good(GoodType.NARCOTICS, rand.nextInt(100) * 100));
       availableSupply.add(new Good(GoodType.ROBOTS, rand.nextInt(100) * 100));
       return availableSupply;
    }
    
    /**
     * creates and returns an array list of sellable goods on the planet 
     * @return array list of goods sellable
     */
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
       //sellable.add(new Good(GoodType.NARCOTICS, 0));
       sellable.add(new Good(GoodType.ROBOTS, 0));
       return sellable;
    }
}
