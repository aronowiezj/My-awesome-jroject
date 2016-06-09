package ayou.main;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;

import ayou.model.CardEntity;
import ayou.model.Player;

public class GameLoopRemote {
	
	public static void main(String[] args) {
		while (true) {
			/////
			//////
			
			CardEntity card = ClientBuilder.newClient().target("http://localhost:8080/v1/card/5").request().get(CardEntity.class);
			System.out.println(card.getCout());
			
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
			}
		}
	}
}
