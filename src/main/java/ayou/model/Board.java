package ayou.model;

import java.util.ArrayList;
import java.util.List;

public class Board {

	private List<Card> cardList;

	public Board() {
		cardList = new ArrayList<>();
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
	}

	public void removeCard(Card card) {
		cardList.remove(card);
	}

	public int size() {
		return cardList.size();
	}

	// deprecated
	public Card getBattler() {
		if (cardList.isEmpty())
			return new Card(0, 0, "error");
		return cardList.get(0);
	}

}
