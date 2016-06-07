package main;

import ayou.model.Card;
import ayou.model.Deck;
import ayou.model.RandomCardFactory;
import view.Displayer;

/**
 * @author aronowij
 *
 */
public class Main {

	static int DECK_SIZE = 10;

	public static void main(String[] args) {
		Deck deck1 = new Deck(RandomCardFactory.genereRandomDeck(DECK_SIZE));
		Deck deck2 = new Deck(RandomCardFactory.genereRandomDeck(DECK_SIZE));

		Card cardPlayer1 = null;
		Card cardPlayer2 = null;

		while (!deck1.isEmpty() && !deck2.isEmpty()) {
			if (cardPlayer1 == null)
				cardPlayer1 = deck1.draw();
			if (cardPlayer2 == null)
				cardPlayer2 = deck2.draw();

			Displayer.putCard(cardPlayer1, cardPlayer2);
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			cardPlayer1.attack(cardPlayer2);

			Displayer.attackCard(cardPlayer1, cardPlayer2);
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			if (cardPlayer1.getHitPoints() <= 0) {
				Displayer.die(cardPlayer1);
				cardPlayer1 = null;
			}
			if (cardPlayer2.getHitPoints() <= 0) {
				Displayer.die(cardPlayer2);
				cardPlayer2 = null;
			}
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			System.out.println("p1 : " + deck1.getRemainingCards() + " cards remain");
			System.out.println("p2 : " + deck2.getRemainingCards() + " cards remain");

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		if (deck1.isEmpty())
			System.out.println("player 1 win !");
		else
			System.out.println("player 2 win !");
	}

}
