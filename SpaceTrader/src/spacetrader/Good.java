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
    private int minTechLevProd;
    /**
     * Minimum tech level needed to use the good.
     */
    private int minTechLevUse;
    /**
     * Tech level that produces most of this good.
     */
    private int techLevMostProd;
    /**
     * Price increase per tech level.
     */
    private int priceInc;
    /**
     * Max deviation from base price.
     */
    private int var;
    /**
     * Condition in which good is cheaper.
     */
    private int cheapCond;
    /**
     * Condition in which good is more expensive.
     */
    private int expCond;
    /**
     * Min price offered in space trade with random trader.
     */
    private int minRandTrade;
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
            this.minTechLevProd = 0;
            this.minTechLevUse = 0;
            this.techLevMostProd = 2;
            this.priceInc = 2 + 1;
            this.var = 2 + 2;
            this.cheapCond = 2 + 2;
            this.expCond =  2 + 1;
            this.maxRandTrade = 10;
            break;

        case FUR:
            this.basePrice = 250;
            this.minTechLevProd = 0;
            this.minTechLevUse = 0;
            this.techLevMostProd = 1;
            this.priceInc = 10;
            this.var = 10;
            this.cheapCond = 7;
            this.expCond = 8;
            this.maxRandTrade = 10;
            break;

        case FOOD:
            this.basePrice = 100;
            this.minTechLevProd = 1;
            this.minTechLevUse = 0;
            this.techLevMostProd = 0;
            this.priceInc = 5;
            this.var = 5;
            this.cheapCond = 5;
            this.expCond = 6;
            this.maxRandTrade = 10;
            break;

        case ORE:
            this.basePrice = 350;
            this.minTechLevProd = 2;
            this.minTechLevUse = 2;
            this.techLevMostProd = 3;
            this.priceInc = 20;
            this.var = 10;
            this.cheapCond = 1;
            this.expCond = 2;
            this.maxRandTrade = 10;
            break;

        case GAMES:
            this.basePrice = 250;
            this.minTechLevProd = 3;
            this.minTechLevUse = 1;
            this.techLevMostProd = 6;
            this.priceInc = -10;
            this.var = -10;
            this.cheapCond = 11;
            this.expCond = -1;
            this.maxRandTrade = 10;
            break;

        case FIREARMS:
            this.basePrice = 1250;
            this.minTechLevProd = 3;
            this.minTechLevUse = 1;
            this.techLevMostProd = 5;
            this.priceInc = -75;
            this.var = 100;
            this.cheapCond = 12;
            this.expCond = -1;
            this.maxRandTrade = 10;
            break;

        case MEDICINE:
            this.basePrice = 650;
            this.minTechLevProd = 4;
            this.minTechLevUse = 1;
            this.techLevMostProd = 6;
            this.priceInc = -20;
            this.var = 10;
            this.cheapCond = 10;
            this.expCond = -1;
            this.maxRandTrade = 10;
            break;

        case MACHINES:
            this.basePrice = 900;
            this.minTechLevProd = 4;
            this.minTechLevUse = 3;
            this.techLevMostProd = 5;
            this.priceInc = -30;
            this.var = 5;
            this.cheapCond = -1;
            this.expCond = -1;
            this.maxRandTrade = 10;
            break;

        case NARCOTICS:
            this.basePrice = 3500;
            this.minTechLevProd = 5;
            this.minTechLevUse = 0;
            this.techLevMostProd = 5;
            this.priceInc = -125;
            this.var = 150;
            this.cheapCond = 9;
            this.expCond = -1;
            this.maxRandTrade = 10;
            break;

        case ROBOTS:
            this.basePrice = 5000;
            this.minTechLevProd = 6;
            this.minTechLevUse = 4;
            this.techLevMostProd = 7;
            this.priceInc = -150;
            this.var = 100;
            this.cheapCond = -1;
            this.expCond = -1;
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
     * Getter for minTechLevProd.
     * @return minTechLevProd
     */
    protected final int getMinTechLevProd() {
        return minTechLevProd;
    }

    /**
     * Getter for minTechLevUse.
     * @return minTechLevUse
     */
    protected final int getMinTechLevUse() {
        return minTechLevUse;
    }

    /**
     * Getter for techLevMostProd.
     * @return techLevMostProd
     */
    protected final int getTechLevMostProd() {
        return techLevMostProd;
    }

    /**
     * Getter for priceInc.
     * @return priceIncPerTechLev
     */
    protected final int getPriceInc() {
        return priceInc;
    }

    /**
     * Getter for var.
     * @return var
     */
    protected final int getVar() {
        return var;
    }

    /**
     * Getter for cheapCond.
     * @return cheapCond
     */
    protected final int getCheapCond() {
        return cheapCond;
    }

    /**
     * Getter for expCond.
     * @return expCond
     */
    protected final int getExpCond() {
        return expCond;
    }

    /**
     * Getter for minRandTrade.
     * @return minRandTrade
     */
    protected final int getMinRandTrade() {
        return minRandTrade;
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
