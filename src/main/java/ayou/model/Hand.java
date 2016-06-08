/**
 * 
 */
package ayou.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

/**
 * @author aronowij
 *
 */
public class Hand extends Observable {

	private List<Card> cardList;

	public Hand() {
		cardList = new ArrayList<>();
	}

	public void addCard(Card card) {
		cardList.add(card);
		hasChanged();
		notifyObservers();
	}

	public void removeCard(Card card) {
		cardList.remove(card);
		hasChanged();
		notifyObservers();
	}

	public boolean isEmpty() {
		return cardList.isEmpty();
	}

	public List<Card> getCards() {
		return cardList;
	}

	public int size() {
		return cardList.size();
	}

}
