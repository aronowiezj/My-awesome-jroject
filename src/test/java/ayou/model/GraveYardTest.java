package ayou.model;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class GraveYardTest {

	Card test;
	Card test2;
	Card test3;
	GraveYard tomb;
	List<Card> list;
	Player player;
	
	@Before
	public void setUp(){
		test = new Card(1, "card1", "img1", 6, 10, true, true, 0, false, 0, false, 0, false,0);
		test2 = new Card(2, "card1", "img1", 5, 10, false, true, 3, true, 0, false, 0, false,0);
		test3 = new Card(3, "card1", "img1", 4, 15, true, true, 0, true, 0, false, 0, false,0);
		tomb = new GraveYard(player);
		list= new ArrayList<>();
	}

	@Test
	public void test() {
		assertTrue(tomb.isEmpty());
		
		tomb.addCard(test);
		tomb.addCard(test2);
		tomb.addCard(test3);
		assertTrue(tomb.size()==3);
		
		tomb.removeCard(test2);
		assertTrue(tomb.size()==2);
		
		tomb.clean();
		assertTrue(tomb.isEmpty());
		
		assertEquals(tomb.getCards(), list);
	}

}
