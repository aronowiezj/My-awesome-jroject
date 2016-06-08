/**
 * 
 */
package ayou.model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author aronowij
 *
 */
public class Hand {
	
	private List<Card> cardList;
	
	public Hand(){
		cardList = new ArrayList<>();		
	}
	
	public void addCard(Card card) {
		cardList.add(card);
	}

	public void removeCard(Card card) {
		cardList.remove(card);
	}
	
	public boolean isEmpty() {
		return cardList.isEmpty();
	}
	
	public List<Card> getCards(){
		return cardList;
	}
	
	public int size() {
		return cardList.size();
	}
	
}
