package ayou.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import ayou.view.GameCanvas;

public class Board extends Observable {

	

	private List<Card> cardList;
	private Player player;
	
	public Player getPlayer() {
		return player;
	}
	
	public Board() {
		cardList = new ArrayList<>();
		addObserver(GameCanvas.getInstance());
	}
	
	public Board(Player player){
		this.player=player;
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
		setChanged();
		notifyObservers();
	}

	public void removeCard(Card card) {
		cardList.remove(card);
		setChanged();
		notifyObservers();
	}

	public int size() {
		return cardList.size();
	}

	

}
