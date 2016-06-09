package ayou.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Observable;

import ayou.view.GameCanvas;

public abstract class CardCollection extends Observable {

	private List<Card> cardList;
	private Player player;

	public CardCollection(List<Card> cardList, Player player) {
		this.cardList = cardList;
		this.player = player;
		addObserver(GameCanvas.getInstance());
	}

	public CardCollection(Player player) {
		cardList = new ArrayList<>();
		this.player = player;
		addObserver(GameCanvas.getInstance());
	}

	public Player getPlayer() {
		return player;
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

	public void shuffle() {
		Collections.shuffle(cardList);
	}

	public boolean isEmpty() {
		return cardList.isEmpty();
	}

	public int getRemainingCards() {
		return cardList.size();
	}

	public Card get(int index) {
		return cardList.get(index);
	}

	public void removeCard(int i) {
		cardList.remove(0);
	}

	public List<Card> getCards() {
		return cardList;
	}

	public int size() {
		return cardList.size();
	}
	
	public void clean() {
		cardList.removeAll(cardList);
	}
}
