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

import java.io.Serializable;

/**
 *
 * @author Kristen Lawrence
 */
public class Good implements Serializable {

    /**
     * The type of good.
     */
    private GoodType type; 
    /**
     * Quantity of good.
     */
    private int quantity;
    /**
     * What it sounds like.
     */
    private int basePrice;
    /**
     * Minimum tech level needed to produce the good.
     */
    private int MTLP; 
    /**
     * Minimum tech level needed to use the good.
     */
    private int MTLU;
    /**
     * Tech level that produces most of this good.
     */
    private int TTP;
    /**
     * Price increase per tech level.
     */
    private int IPL;
    /**
     * Max deviation from base price.
     */
    private int var;
    /**
     * Condition in which good is cheaper.
     */
    private int CR;
    /**
     * Condition in which good is more expensive.
     */
    private int ER;
    /**
     * Min price offered in space trade with random trader.
     */
    private int MTL;
    /**
     * Max price offered in space trade with random trader.
     */
    private int maxRandTrade;
    /**
     * Final price.
     */
    private double price;

    /**
     * Good constructor.
     * @param gType the type
     * @param quant the quantity
     */
    public Good(final GoodType gType, final int quant) {
        this.type = gType;
        this.quantity = quant;
        setValues();
    }

    /**
     * sets the values for each good made.
     */
    protected final void setValues() {
	switch (type) {
	case WATER:
	    this.basePrice = 2 ^ 2 ^ 2 - 1;
	    this.MTLP = 0;
	    this.MTLU = 0;
	    this.TTP = 2;
	    this.IPL = 2 + 1;
	    this.var = 2 + 2;
	    this.CR = 2 + 2;
	    this.ER =  2 + 1;
            this.maxRandTrade = 10;
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
            this.maxRandTrade = 10;
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
            this.maxRandTrade = 10;
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
            this.maxRandTrade = 10;
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
            this.maxRandTrade = 10;
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
            this.maxRandTrade = 10;
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
            this.maxRandTrade = 10;
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
            this.maxRandTrade = 10;
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
            this.maxRandTrade = 10;
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
            this.maxRandTrade = 10;
	    break;
            default:
                throw new AssertionError(type.name());

	}
    }

    /**
     * Getter for type.
     * @return type
     */
    protected final GoodType getType() {
	return type;
    }

    /**
     * Getter for quantity.
     * @return quantity
     */
    protected final int getQuantity() {
	return quantity;
    }

    /**
     * Setter for quantity.
     * @param newQ to set
     */
    protected final void setQuantity(final int newQ) {
	this.quantity = newQ;
    }

    /**
     * Getter for basePrice.
     * @return basePrice
     */
    protected final int getBasePrice() {
	return basePrice;
    }

    /**
     * Getter for MTLP.
     * @return MTLP
     */
    protected final int getMTLP() {
	return MTLP;
    }

    /**
     * Getter for MTLU.
     * @return MTLU
     */
    protected final int getMTLU() {
	return MTLU;
    }

    /**
     * Getter for TTP.
     * @return TTP
     */
    protected final int getTTP() {
	return TTP;
    }

    /**
     * Getter for IPL.
     * @return IPL
     */
    protected final int getIPL() {
	return IPL;
    }

    /**
     * Getter for var.
     * @return var
     */
    protected final int getVar() {
	return var;
    }

    /**
     * Getter for CR.
     * @return CR
     */
    protected final int getCR() {
	return CR;
    }

    /**
     * Getter for ER.
     * @return ER
     */
    protected final int getER() {
	return ER;
    }

    /**
     * Getter for MTL.
     * @return MTL
     */
    protected final int getMTL() {
	return MTL;
    }

    /**
     * Getter for maxRandTrade.
     * @return maxRandTrade
     */
    protected final int getMaxRandTrade() {
	return maxRandTrade;
    }

    /**
     * Getter for Price.
     * @return price
     */
    protected final double getPrice() {
	return price;
    }

    /**
     * Setter for price.
     * @param newPrice to set
     */
    protected final void setPrice(final double newPrice) {
	this.price = newPrice;
    }
}
