/**
 * 
 */
package ayou.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import ayou.view.GameCanvas;

/**
 * @author aronowij
 *
 */
public class Hand extends Observable {

	private List<Card> cardList;

	public Hand() {
		cardList = new ArrayList<>();
		addObserver(GameCanvas.getInstance());
	}

	public void addCard(Card card) {
		cardList.add(card);
		setChanged();
		notifyObservers();
	}

	public void removeCard(Card card) {
		cardList.remove(card);
		setChanged();
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
