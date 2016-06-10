package ayou.model;

import java.util.ArrayList;
import java.util.List;

public class CardFactory {

	public static List<Card> genereDeck(int size) {
		List<Card> cardList = new ArrayList<>(size);
		
		cardList.add(new Card(1, "Kinan",null,5,15, true,false,0,false,0,false,0,false,1));
		cardList.add(new Card(2, "Torren", null,4, 10, true, false,0,false,0,false,0,false,0));
		
		
		
		//cardList.add(new Card(idCard, name, idImg, power, maxHitPoints, canAtk, celerity, healAlly, healAllAllies, buffAlly, buffAllAllies, debuffEnemy, debuffAllEnemies, cout)
		return cardList;
	}

}
