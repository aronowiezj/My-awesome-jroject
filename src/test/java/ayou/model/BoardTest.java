package ayou.model;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class BoardTest {

	Card test;
	Card test2;
	Card test3;
	Board board;
	Player player;
	
	@Before
	public void setUp(){
		test = new Card(1, "card1", "img1", 6, 10, true, true, 0, false, 0, false, 0, false,0);
		test2 = new Card(2, "card1", "img1", 5, 10, false, true, 3, true, 0, false, 0, false,0);
		test3 = new Card(3, "card1", "img1", 4, 15, true, true, 0, true, 0, false, 0, false,0);
		board = new Board(player);
	}

	@Test
	public void test(){
		assertTrue(board.isEmpty());
	}

}
