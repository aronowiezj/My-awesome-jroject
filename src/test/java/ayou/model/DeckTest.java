package ayou.model;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class DeckTest {

	Card test;
	Card test2;
	Card test3;
	Card test4;
	List<Card> list;
	List<Card> list2;
	Deck jackson;
	Deck jack;
	boolean boole;
	Player player1;
	Player player2;
	
	@Before
	public void setUp(){
		test = new Card(1, "card1", "img1", 6, 10, true, true, 0, false, 0, false, 0, false,0);
		test2 = new Card(2, "card1", "img1", 5, 10, false, true, 3, true, 0, false, 0, false,0);
		test3 = new Card(3, "card1", "img1", 4, 15, true, true, 0, true, 0, false, 0, false,0);
		test4 = new Card(4, "card1", "img1", 4, 15, true, true, 0, true, 0, false, 0, false,0);
		list = new ArrayList<Card>();
		list2 = new ArrayList<Card>();
		jackson = new Deck(list, player1);
		jack = new Deck(list2, player2);
		boole=true;
	}

	@Test
	public void testIsEmpty(){
		assertTrue(jackson.isEmpty());
	}
	
	@Test
	public void testAddCard(){
		jackson.addCard(test);
		jackson.addCard(test2);
		assertEquals(2, jackson.getRemainingCards());
	
		assertEquals(null, jack.draw());
		assertTrue(jackson.draw()==test);
		jackson.removeCard(test3);
		assertEquals(1, jackson.getRemainingCards());
		
		jackson.addCard(test);
		jackson.addCard(test3);
		jackson.addCard(test4);
		jack.addCard(test2);
		jack.addCard(test);
		jack.addCard(test3);
		jack.addCard(test4);
		assertEquals(jackson.getRemainingCards(), jack.getRemainingCards());
		jack.shuffle();
		for(int i=0; i<jack.getRemainingCards(); i++){
			if(jack.draw()!=jackson.draw()){
				boole=false;
			}
		}
		assertFalse(boole);
	}

}
