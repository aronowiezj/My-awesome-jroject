package ayou.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ayou.view.Background;
import ayou.view.GameCanvas;

public class Board extends Observable {
	final static Logger logger = LoggerFactory.getLogger(Board.class);

	private List<Card> cardList = new ArrayList<>();
	private Player player;

	public Player getPlayer() {
		return player;
	}

	public Board() {
		addObserver(GameCanvas.getInstance());
	}

	public Board(Player player) {
		this.player = player;
		addObserver(GameCanvas.getInstance());
	}

	public List<Card> getCards() {
		logger.debug("On est dans le GetCards poto");
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
