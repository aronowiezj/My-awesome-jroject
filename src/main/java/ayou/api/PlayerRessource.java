package ayou.api;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import ayou.model.Player;

@Path("/player")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PlayerRessource {

	private static PlayerDao dao = BDDFactory.getDbi().open(PlayerDao.class);

	public PlayerRessource() {
		try {
			dao.createPlayersTable();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	/*
	 * @GET
	 * 
	 * @Path("/{id}") public Player getPlayer(@PathParam("id") int id) { return
	 * dao.findById(id); }
	 * 
	 * @GET
	 * 
	 * @Path("/{id}/card/") public List<Card> getCardsOnBoard(@PathParam("id")
	 * int id) { return dao.findById(id).getCards(); }
	 * 
	 */

	@POST
    public Player addPlayer(Player player){
    	player.setID(dao.insert(player));
    	return player;
    }

	@GET
	public List<Player> getPlayers() {
		return dao.allPlayers();
	}

}
