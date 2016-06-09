package ayou.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PlayerTest {
	
	Player p1;
	Deck deck;
	Hand hand;
	Board board;
	Card test;
	Card test2;
	Card test3;
	GraveYard graveYard;
	Player player;
	
	@Before
	public void setUp(){
		p1 = new Player("michel");
		graveYard = new GraveYard(player);
		board = new Board(player);
		test = new Card(1, "card1", "img1", 6, 10, true, true, 0, false, 0, false, 0, false,0);
		test2 = new Card(2, "card1", "img1", 5, 10, false, true, 3, true, 0, false, 0, false,0);
		test3 = new Card(3, "card1", "img1", 4, 15, true, true, 0, true, 0, false, 0, false,0);
	}

	@Test
	public void testToString() {
		assertEquals("michel", p1.toString());
	}
	
	@Test
	public void testIsDefeated(){
		
	}
}
