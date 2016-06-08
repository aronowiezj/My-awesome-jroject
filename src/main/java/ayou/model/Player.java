package ayou.model;

import java.util.List;

public class Player {

	private Deck deck;
	private Hand hand;
	private Board board;
	private int shieldLevel;
	private String name;

	public Player(String name, boolean isPlayer) {
		deck = new Deck(RandomCardFactory.genereRandomDeck(GameLoop.DECK_SIZE));
		hand = new Hand();
		board = new Board(isPlayer);
		this.name = name;
		shieldLevel = 5;
	}

	public void draw() {
		hand.addCard(deck.draw());
	}

	public boolean isDefeated() {
		return deck.isEmpty() || shieldLevel < 0;
	}

	@Override
	public String toString() {
		return name;
	}

	public List<Card> getHand() {
		return hand.getCards();
	}

	public boolean isBoardEmpty() {
		return board.isEmpty();
	}

	public void invoke(Card card) {
		hand.removeCard(card);
		board.addCard(card);
		card.invocation(this);
	}

	// deprecated
	public Card getBattler() {
		return board.getBattler();
	}

	public void cleanBoard() {
		board.clean();
	}

	public List<Card> getBoard() {
		return board.getCards();
	}

	public void takeDamages(int damages) {
		shieldLevel -= damages;

	}

	public int getShield() {
		return shieldLevel;
	}

}
