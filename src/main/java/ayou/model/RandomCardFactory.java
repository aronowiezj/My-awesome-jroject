package ayou.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.ws.rs.client.ClientBuilder;

/**
 * @author aronowij
 *
 */
public class RandomCardFactory {

	public static Card genereRandomCard(){
		
		CardEntity card = ClientBuilder.newClient().target("http://localhost:8080/v1/card/random").request().get(CardEntity.class);
		//new Card(idCard, name, idImg, power, maxHitPoints, canAtk, celerity, healAlly, healAllAllies, buffAlly, buffAllAllies, debuffEnemy, debuffAllEnemies, cout)
		
		return new Card(card.getIdCard(), card.getName(),card.getIdImg(),card.getPower(),card.getMaxHitPoints(),
				card.isCanAtk(),card.isCelerity(),card.getHealAlly(),card.isHealAllAlly(),card.getBuffAlly(),card.isBuffAllAlly(),card.getDebuffEnemy(),card.isDebuffAllEnemies(),card.getCout());
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
