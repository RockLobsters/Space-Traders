/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package spacetrader;

import java.util.Random;

/**
 *
 * @author Jacqueline Foreman
 */

public class Police {
	
	public PoliticalSystem gov;
	public Player player;
	public int wanted;
    public Planet planet;

	public Police(Planet plan, Player player) {
		this.gov = plan.getPoliticalSystem();
		this.planet = plan;
		this.player = player;
		this.wanted = player.getWanted();

	}

	/**
	 * Asses if the police will stop player
	 * @return 		Boolean of if the police will stop player
	 */
	public boolean willStop() {
		Random rand = new Random();
		boolean value = rand.nextBoolean();

		if (wanted >= 30) {
			return value;
		} else {
			return false;
		}

	}

	/**
	 * Asses if the police will be bribed
	 * @return		Boolean of if hte police will be bribed
	 */
	public boolean willBribed() {
		if (gov.bribeRate() != 0) {
			return true;
		} else {
			return false;
		}
	}


	/**
	 * Bribing the police
	 * @return		Player with updated money count
	 */
	public Player bribe() {
		// will change based on transatction class later
		int money = player.getMoney();
		int amount = (int) (gov.bribeRate() * 1000);
		player.setMoney(money - amount);

		return player;
	}

	/**
	 * Bribing the police
	 * @return		Boolean of if police won
	 */
	public boolean attack() {
		Ship ship = player.getShip();
		if (planet.getTL() > ship.getTL()) {
			return true;
		}
		return false;
	}


	/**
	 * Police searching player
	 * @return		Player with updated wanted level
	 */
	public Player search() {
		if (player.getShip().hasIllegal()) {
			player.setArrested(true);
		} else {
			player.setWanted(wanted -10);
		}

		return player;

	}

	/**
	 * Asseses weather the police will attack the player
	 * @return		Boolean of if the police will attack
	 */
	public boolean willAttack() {
		if (wanted >= 75) {
			return true;
		} else {
			return false;
		}
	}
}


// An Encounter with the Police

// As long as you are an honest trader, the police will usually ignore you.
// They may ask you to submit to an inspection of your cargo bays. As long as
// you are not carrying illegal goods (firearms or narcotics), you have nothing to
// worry about: they will search your holds, apologize, and up the status on your police
// record, indicating that you are someone who doesn't need to be searched that often.
// However, if you are carrying illegal goods, you best not let them search you, because
// then they will impound the illegal goods and fine you. Instead of agreeing to an inspection,
// you can try to bribe them. Depending on the type of government of the system, this is either
// impossible (if they are incorruptible), or costs an amount of money depending on how easy
// police officers under such a government can be bribed. It is always a good idea to explore
// the option of bribery: you can decide not to bribe them when you see how much money they
// want, but you might get away cheap. The other options you have are to flee, or to attack
// them, in which case they will certainly attack you. Both fleeing and attacking will
// seriously damage your standing with the police. When your police record indicates that
// you are a criminal, police ships won't ask for an inspection anymore, but will attack
// you on sight. If your reputation indicates that you are too dangerous an opponent for
// them, they also might flee immediately. When they consider you a really dangerous criminal,
// they will send more and better ships after you. You can surrender to the police, as long
// as you are not considered a psychopath they rather take in dead. If you do, you will be
// taken to a court of law and tried. You will have to spend some time in prison and pay a
// fine. If you don't have the credits to settle your fine, the police will sell your ship
// and will pay the fine out of the profits. If they need to do that, they will usually
// supply you with a second-hand Flea when you leave prison. To avoid you having to pay
// huge interests on a loan, if you have the credits, the police will usually also settle
// those debts from your cash. Also remember that you can't pay your mercenaries and
// insurance from your cell, so your hired hands will leave you and your insurance will
// be stopped.

