package ayou.model;

import java.util.List;

public class Deck extends CardCollection {

	// public Deck(){
	//
	// }

	public Deck(List<Card> cardList, Player player) {
		super(cardList, player);
	}

	public Card draw() {
		if (!isEmpty()) {
			Card cardDrawn = get(0);
			removeCard(0);
			return cardDrawn;
		} else {
			System.err.println("PLUS DE CARTES SALOPE LOL");
			return null;
		}
	}
}
