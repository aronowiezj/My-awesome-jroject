package ayou.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author aronowij
 *
 */
public class RandomCardFactory {

	public static Card genereRandomCard(){
		char[] chars = "abcdefghijklmnopqrstuvwxyz".toCharArray();
		StringBuilder stringBuilder = new StringBuilder();
		Random random = new Random();
		
		for (int i = 0; i < 20; i++) {
		    char c = chars[random.nextInt(chars.length)];
		    stringBuilder.append(c);
		}
		String name = stringBuilder.toString();
		return new Card(0, name,null,(int)(Math.random()*10+1),(int)(Math.random()*10+1), true,false,0,false,0,false,0,false,0);
	}

	/**
	 * @return
	 */
	public static List<Card> genereRandomDeck(int size) {
		List<Card> cardList = new ArrayList<>(size);
		
		for(int i = 0; i < size; ++i){
			cardList.add(genereRandomCard());
		}
		
		return cardList;
	}
	
}
