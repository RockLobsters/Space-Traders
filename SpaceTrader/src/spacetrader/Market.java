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
 * @author Jacqueline Foreman
 */
public class Market implements Serializable {

    /**
     * 
     */
    private ArrayList<Good> goods;
    /**
     * 
     */
    private final Planet planet;
    /**
     * 
     */
    private ArrayList<Double> prices;

    /**
     *
     */
    private PoliticalSystem politicalSystem;

    /**
     * techLevel.
     */
    public int techLevel;

    /**
     * Constructor.
     * @param plnt the planet
     */
    public Market(final Planet plnt) {
        this.planet = plnt;
    }

    /**
     * Sets the solarSystem.
     * @param solarSystem the system
     */
    public final void setSolarSystem(final SolarSystem solarSystem) {
        this.politicalSystem = solarSystem.getPoliticalSystem();
        this.goods = politicalSystem.supply();
        this.techLevel = solarSystem.getTechLevel();
        this.prices = priceList(goods);
    }

    /**
     * @param goos
     *            - an array list of goods that the market has
     * @param plnt
     *            - on which the market is located
     */
    public Market(final ArrayList<Good> goos, final Planet plnt) {
        this.goods = goos;
        this.planet = plnt;
        this.politicalSystem = planet.getSolarSystem().getPoliticalSystem();
        this.techLevel = planet.getSolarSystem().getTechLevel();
        this.prices = priceList(goods);
    }

    /**
     * @param goodsList
     *            - list of goods the market has
     *
     * @return a list of the prices of the goods
     */
    public final ArrayList<Double> priceList(final ArrayList<Good> goodsList) {
	final int siz = goodsList.size();
	final ArrayList<Double> listP = new ArrayList();
	for (int i = 0; i < siz; i++) {
	    listP.add(calcPrice(goods.get(i)));
	}
	return listP;
    }

    /**
     * @param good
     *            - the particular good for which the price is being calculated
     *
     * @return the price of the good
     */
    public final double calcPrice(final Good good) {
	final Random rand = new Random(); // for variance calculations
	double price;
	double variance = 100 / rand.nextInt(Math.abs(good.getVar()));
        final boolean flip =  rand.nextBoolean();
	if (flip) {
	    variance = variance * -1; // determine plus or minus for variance
	}
	price = good.getBasePrice() + good.getIPL()
		* (techLevel - good.getMTLP())
		+ (variance * good.getBasePrice());

	if (planet.getResources() == good.getCR()) { // if resource condition
						     // present on planet cut
						     // price
	    price = price / 2;
	}

	if (planet.getResources() == good.getER()) { // if rescource conditino
						     // present on planet double
						     // price
	    price = price * 2;
	}

	final int[] hiSupply = politicalSystem.highSupply();
	if (hiSupply.length > 0) {
	    for (int i : hiSupply) {
		if (i == good.getType().ordinal()) {
		    price = price / 2; // if political system has high supply of
				       // good cut price
		}
	    }
	}

	final int[] hiDemand = politicalSystem.highDemand();
	if (hiDemand.length > 0) {
	    for (int i : hiDemand) {
		if (i == good.getType().ordinal()) {
		    price = price * 2; // if political system has high demand of
				       // good double price
		}
	    }
	}

	if (techLevel == good.getTTP()) {
	    price = price / 2; // if planet is techlevel that produces most of
			       // this good same result as high supply
	}
	good.setPrice(price);
	return price;
    }

    /**
     * Check if market contains good.
     * @param list of available goods
     * @param good to look for
     * @return true if found false if not
     */
    public static final boolean containsGood(final Good[] list,
            final Good good) {
        boolean out = false;
	for (Good listItem : list) {
	    if (listItem == good) {
		out = true;
	    }
	}
	return out;
    }

    /**
     * Get the price of a good in this market.
     *
     * @param good
     *            The good to query the price for
     *
     * @return The price of the good or -1 if the good is not found
     */
    public final double getPrice(final Good good) {
	final int index = getIndex(good);
        double out = -1;
	if (index != -1) {
	    out = prices.get(index);
	}
	return out;
    }

    /**
     * Gets the index of a good in the goods ArrayList.
     *
     * @param good
     *            The good to search for
     *
     * @return The index of the good or -1 if the good is not found
     */
    public final int getIndex(final Good good) {
	for (int i = 0; i < goods.size(); i++) {
	    if (good.getType() == goods.get(i).getType()) {
		return i;
	    }
	}
	return -1;
    }

    /**
     * @param good
     *            The good in question
     * @param quantity
     *            The amount of the good to be bought
     * @param player
     *            The player buying the good
     *
     * @return True if the good is available at this Market
     */
    public final boolean canBuy(final Good good, final int quantity,
            final Player player) {
	final int index = getIndex(good);
	if (index == -1) {
	    return false;
	}
	final Good toBuy = goods.get(index);
	if (toBuy.getQuantity() <= 0) {
	    return false;
	}
	if (toBuy.getQuantity() < quantity) {
	    return false;
	}
	if (prices.get(index) * quantity > player.getMoney()) {
	    return false;
	}
	if (player.getShip().getCargoBays() < player.getShip().getCargoSize()
		+ quantity) {
	    return false;
	}

	// tech level solar system must be equal or greater to good mtlp to buy
	if (planet.getSolarSystem().getTechLevel() < toBuy.getMTLP()) {
	    return false;
	}
	return true;
    }

    /**
     * Buys a good.
     *
     * @param good
     *            The good to buy
     * @param quantity
     *            The amount of the good to buy
     * @param player
     *            The player buying the good
     *
     * @return True if the buy was successful
     */
    public final boolean buy(final Good good, final int quantity,
            final Player player) {
	if (canBuy(good, quantity, player)) {
            final int index = getIndex(good);
            final Good newGood = goods.get(index);
            good.setQuantity(newGood.getQuantity() - quantity);
            player.subtractMoney(prices.get(index) * quantity);
            boolean found = false;
            final ArrayList<Good> cargo = player.getShip().cargo;
            for (int i = 0; i < cargo.size() && !found; i++) {
                if (cargo.get(i).getType() == good.getType()) {
                    cargo.get(i).setQuantity(
                            cargo.get(i).getQuantity() + quantity);
                    found = true;
                }
            }
            if (!found) {
                cargo.add(new Good(newGood.getType(), quantity));
            }
            return true;
        } else {
	    return false;
	}
    }

    /**
     * @param good
     *            The good in question
     * @param quantity
     *            The amount of the good to be sold
     * @param player
     *            The player selling the good
     *
     * @return True if the player can sell the good
     */
    public final boolean canSell(final Good good, final int quantity,
            final Player player) {
	final ArrayList<Good> cargo = player.getShip().cargo;
	int index = -1;
	for (int i = 0; index == -1 && i < cargo.size(); i++) {
	    if (cargo.get(i).getType() == good.getType()) {
		index = i;
	    }
	}
	if (index == -1) {
	    return false;
	}
	final Good toSell = cargo.get(index);
	if (toSell.getQuantity() < quantity) {
	    return false;
	}

	// tech level solar system must be equal or greater to good mtlu to sell
	if (planet.getSolarSystem().getTechLevel() < toSell.getMTLU()) {
	    return false;
	}
	return true;
    }

    /**
     * Sells a good.
     *
     * @param good
     *            The good to sell
     * @param quantity
     *            The amount of the good to sell
     * @param player
     *            The player selling the good
     *
     * @return True if the sell was successful
     */
    public final boolean sell(final Good good, final int quantity,
            final Player player) {
	if (canSell(good, quantity, player)) {
            final ArrayList<Good> cargo = player.getShip().cargo;
            int index = -1;
            for (int i = 0; index == -1 && i < cargo.size(); i++) {
                if (cargo.get(i).getType() == good.getType()) {
                    index = i;
                }
            }
            if (cargo.get(index).getQuantity() == quantity) {
                cargo.remove(index);
            } else {
                cargo.get(index).setQuantity(cargo.get(index).getQuantity()
                        - quantity);
            }
            player.addMoney(prices.get(getIndex(good)) * quantity);
            goods.get(getIndex(good)).setQuantity(cargo.get(index).getQuantity()
                        - quantity);
            return true;
        } else {
	    return false;
	}
    }

    /**
     * Buys a good in the market.
     *
     * @param goodType
     *            type of good
     * @param quantity
     *            quantity to buy
     * @param player player that's buying stuff
     *
     * @return boolean if transaction was successful
     */
    public final boolean buy(final GoodType goodType,
            final int quantity, final Player player) {
	return buy(new Good(goodType, 0), quantity, player);
    }

    /**
     * Buys a good in the market.
     *
     * @param goodType
     *            type of good
     * @param quantity
     *            quantity to sell
     * @param player player that's buying stuff
     *
     * @return boolean if transaction was successful
     */
    public final boolean sell(final GoodType goodType, final int quantity,
            final Player player) {
	return sell(new Good(goodType, 0), quantity, player);
    }

    /**
     * Quantity of good getter.
     * @param good the good
     * @return the quantity
     */
    public final int getQuantity(final Good good) {
	return goods.get(getIndex(good)).getQuantity();
    }
}
