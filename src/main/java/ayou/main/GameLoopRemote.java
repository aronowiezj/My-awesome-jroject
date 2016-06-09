package ayou.main;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;

import ayou.model.Board;
import ayou.model.Player;

public class GameLoopRemote {
	
	public static void main(String[] args) {
		while (true) {
			Entity<Player> userEntity = Entity.entity(new Player("OreWa"), MediaType.APPLICATION_JSON);
			
			ClientBuilder.newClient()
					.target("http://localhost:8080/v1/player")
					.request()
					.post(userEntity)
					.readEntity(Player.class);
			
			Player player = ClientBuilder.newClient().target("http://localhost:8080/v1/player").request().get(Player.class);
			System.out.print(player.toString());
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
			}
		}
	}
}
