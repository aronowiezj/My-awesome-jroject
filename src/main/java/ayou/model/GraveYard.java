package ayou.model;

import java.util.ArrayList;
import java.util.List;

public class GraveYard {
	private List<Card> cardList = new ArrayList<>();

	private Player player;

	public Player getPlayer() {
		return player;
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

}
