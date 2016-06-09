package ayou.model;

import java.util.List;

public class Player {

	private Deck deck = new Deck(RandomCardFactory.genereRandomDeck(GameLoop.DECK_SIZE));
	private Hand hand = new Hand();
	private Board board = new Board();
	private int shieldLevel = 5;
	private String name = "";
	private int id = 0;

	public Player() {
	}

	public Player(String name) {
		this.name = name;
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

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setID(int id) {
		this.id = id;
	}

	public int getID() {
		return id;
	}

	public List<Card> getHand() {
		return hand.getCards();
	}
	
	public int getHandSize() {
		return hand.getCards().size();
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
	
	public int getBoardSize() {
		return board.getCards().size();
	}

	public void takeDamages(int damages) {
		shieldLevel -= damages;

	}

	public int getShield() {
		return shieldLevel;
	}

}
