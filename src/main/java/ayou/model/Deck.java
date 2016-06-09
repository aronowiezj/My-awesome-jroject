package ayou.model;

import java.util.Collections;
import java.util.List;

/**
 * @author aronowij
 *
 */
public class Deck {

	List<Card> cardList = null;
	
	public Deck(){
		
	}

	public Deck(List<Card> cardList) {
		this.cardList = cardList;
	}

	public void addCard(Card card) {
		cardList.add(card);
	}

	public void removeCard(Card card) {
		cardList.remove(card);
	}

	public void shuffle() {
		Collections.shuffle(cardList);
	}

	public Card draw() {
		if(!cardList.isEmpty()){
			Card cardDrawn = cardList.get(0);
			cardList.remove(0);
			return cardDrawn;
		}
		else {
			System.err.println("PLUS DE CARTES SALOPE LOL");
			return null;
		}
	}

	public boolean isEmpty() {
		return cardList.isEmpty();
	}

	public int getRemainingCards() {
		return cardList.size();
	}
}
