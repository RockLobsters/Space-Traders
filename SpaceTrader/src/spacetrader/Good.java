/*
 * Copyright (C) 2014 Kristen Lawrence
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package spacetrader;

/**
 *
 * @author Kristen Lawrence
 */
public class Good {
    
<<<<<<< HEAD
}
=======
    int basePrice; //what it sounds like
    int MTLP; //minimum tech level needed to produce the good
    int MTLU; //minimum tech level needed to use the good
    int TTP; //tech level that produces most of this good
    int IPL; //price increase per tech level
    int var; //max deviation from base price
    int CR; //condition in which good is cheaper
    int ER; //condiiton in which good is more expensive
    int MTL; //min price offered in space trade with random trader
    int MTH; //max price offered in space trade with random trader
    double price; //final price
    
    public Good(GoodType gType, int q) {
        this.type = gType;
        this.quantity = q;
        setValues();
    }
    
    protected void setValues() {
        switch (type) {
            case WATER:
                this.basePrice = 30;
                this.MTLP = 0;
                this.MTLU = 0;
                this.TTP = 2;
                this.IPL = 3;
                this.var = 4;
                this.CR = 4;
                this.ER = 3;
                break;
                    
            case FUR:
                this.basePrice = 250;
                this.MTLP = 0;
                this.MTLU = 0;
                this.TTP = 1;
                this.IPL = 10;
                this.var = 10;
                this.CR = 7;
                this.ER = 8;
                break;
                
            case FOOD:
                this.basePrice = 100;
                this.MTLP = 1;
                this.MTLU = 0;
                this.TTP = 0;
                this.IPL = 5;
                this.var = 5;
                this.CR = 5;
                this.ER = 6;
                break;
                
            case ORE:
                this.basePrice = 350;
                this.MTLP = 2;
                this.MTLU = 2;
                this.TTP = 3;
                this.IPL = 20;
                this.var = 10;
                this.CR = 1;
                this.ER = 2;
                break;
                
            case GAMES:
                this.basePrice = 250;
                this.MTLP = 3;
                this.MTLU = 1;
                this.TTP = 6;
                this.IPL = -10;
                this.var = -10;
                this.CR = 11;
                this.ER = -1;
                break;
            
            case FIREARMS:
                this.basePrice = 1250;
                this.MTLP = 3;
                this.MTLU = 1;
                this.TTP = 5;
                this.IPL = -75;
                this.var = 100;
                this.CR = 12;
                this.ER = -1;
                break;
                
            case MEDICINE:
                this.basePrice = 650;
                this.MTLP = 4;
                this.MTLU = 1;
                this.TTP = 6;
                this.IPL = -20;
                this.var = 10;
                this.CR = 10;
                this.ER = -1;
                break;
            
            case MACHINES:
                this.basePrice = 900;
                this.MTLP = 4;
                this.MTLU = 3;
                this.TTP = 5;
                this.IPL = -30;
                this.var = 5;
                this.CR = -1;
                this.ER = -1;
                break;    
            
            case NARCOTICS:
                this.basePrice = 3500;
                this.MTLP = 5;
                this.MTLU = 0;
                this.TTP = 5;
                this.IPL = -125;
                this.var = 150;
                this.CR = 9;
                this.ER = -1;
                break;    
                
            case ROBOTS:
                this.basePrice = 5000;
                this.MTLP = 6;
                this.MTLU = 4;
                this.TTP = 7;
                this.IPL = -150;
                this.var = 100;
                this.CR = -1;
                this.ER = -1;
                break; 
            
        }
    }
        
    protected GoodType getType() {
        return type;
    }
    
    protected int getQuantity() {
        return quantity;
    }
    
    protected void setQuantity(int newQ) {
        this.quantity = newQ;
    }
    
    protected int getBasePrice() {
        return basePrice;
    }
    protected int getMTLP() {
        return MTLP;
    }
    protected int getMTLU() {
        return MTLU;
    } 
    protected int getTTP() {
        return TTP;
    } 
    protected int getIPL() {
        return IPL;
    }
    protected int getVar() {
        return var;
    } 
    protected int getCR() {
        return CR;
    } 
    protected int getER() {
        return ER;
    }
    protected int getMTL() {
        return MTL;
    }
    protected int MTH() {
        return MTH;
    }   
    protected double getPrice() {
        return price;
    }
    protected void setPrice(double p){
        this.price = p;
    }
}
>>>>>>> master
