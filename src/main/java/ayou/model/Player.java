package ayou.model;

import java.util.List;

/**
 * @author aronowij
 *
 */
public class Player {
	
	private Deck deck;
	private Hand hand;
	private Board board;
	private int shieldLevel;
	private String name;
	
	public Player(String name){
		deck = new Deck(RandomCardFactory.genereRandomDeck(GameLoop.DECK_SIZE));
		hand = new Hand();
		board = new Board();
		this.name = name;
		shieldLevel = 5;
	}
	
	public void draw() {
		hand.addCard(deck.draw());
	}
	
	public boolean isDefeated(){
		return /*deck.isEmpty() ||*/ shieldLevel < 0;
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

	public void play(Card card) {
		hand.removeCard(card);
		board.addCard(card);
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

}