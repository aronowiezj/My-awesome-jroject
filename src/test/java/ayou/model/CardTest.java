package ayou.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CardTest {
	
	Card test;
	Card test2;
	Card test3;

	
	@Before
	public void setUp(){
		test = new Card(1, "card1", "img1", 6, 10, true, true, 0, false, 0, false, 0, false, 0);
		test2 = new Card(2, "card1", "img1", 5, 10, false, true, 3, true, 0, false, 0, false, 0);
		test3 = new Card(3, "card1", "img1", 4, 15, true, true, 0, true, 0, false, 0, false, 0);
	}

	@Test
	public void testGetId() {
		assertTrue(test.getCardID()==1);
	}

	@Test
	public void testAttack(){
		assertEquals(10, test2.getHitPoints());
		test.attack(test2);
		assertTrue(test2.getHitPoints()==4);
	}
	
	@Test
	public void testCanAttack(){
		assertFalse(test2.canAttaque()==true);
		assertEquals(10, test.getHitPoints());
		test2.attack(test);
		assertTrue(test.getHitPoints()==10);
	}
	
	@Test
	public void testGetHealed(){
		test.attack(test3);
		assertTrue(test3.getHitPoints()==9);
		test3.getHealed(3);
		assertTrue(test3.getHitPoints()==12);
	}
	
	@Test
	public void testToString(){
		assertEquals("card1 : 6 - 10", test.toString());
	}
	
	@Test
	public void testGetBuff(){
		assertEquals(4, test3.getPower());
		test3.getpowerBuffed(30);
		assertEquals(34, test3.getPower());
	}
	
	@Test
	public void testDead(){
		test.attack(test3);
		test.attack(test3);
		test.attack(test3);
		assertTrue(test3.isDead());
	}
}
