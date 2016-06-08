package ayou.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import ayou.view.GameCanvas;

public class Board extends Observable {

	private List<Card> cardList;
	boolean isPlayer;

	public Board(boolean isPlayer) {
		cardList = new ArrayList<>();
		this.isPlayer = isPlayer;
		addObserver(GameCanvas.getInstance());
	}

	public List<Card> getCards() {
		return cardList;
	}

	public boolean isEmpty() {
		return cardList.isEmpty();
	}

	public void clean() {
		cardList.removeAll(cardList);
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

	public int size() {
		return cardList.size();
	}

	// deprecated
	public Card getBattler() {
		if (cardList.isEmpty())
		{
			return null;
		}
		return cardList.get(0);
	}

}
