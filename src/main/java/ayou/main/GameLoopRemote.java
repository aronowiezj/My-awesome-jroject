package ayou.main;

import java.util.List;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;

import ayou.model.Player;

public class GameLoopRemote {
	
	public static void main(String[] args) {
		int i = 0;
		while (true) {
			/////
			i++;
			Entity<Player> userEntity = Entity.entity(new Player("Papynou"+i), MediaType.APPLICATION_JSON);
			
			Player p = ClientBuilder.newClient()
					.target("http://localhost:8080/v1/player")
					.request()
					.post(userEntity)
					.readEntity(Player.class);
			
			System.out.println(p.getName());
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
