package ayou.api;

import java.util.List;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import ayou.model.Board;
import ayou.model.Card;

@Path("/board")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class BoardRessource {
	
	private static BoardDao dao = BDDFactory.getDbi().open(BoardDao.class);
    
    public BoardRessource() {
		try {
			dao.createBoardTable();
		} catch (Exception e) {
			System.out.println("Board déjà existant !");
		}
	}
     
    @GET
    @Path("/{id}")
    public Board getBoard(@PathParam("id") int id) {
        return dao.findById(id);
    }
    
    @GET
    @Path("/{id}/card/")
    public List<Card> getCardsOnBoard(@PathParam("id") int id) {
        return dao.findById(id).getCards();
    }
    
    @POST
    @Path("{idBoard}/card/{idPlace}")
    public int addCard(@PathParam("idBoard") int idBoard, @PathParam("idPlace") int idPlace){
    	return 1;
    }
    
    @GET
    public List<Board> getBoard() {
        return dao.allBoards();
    }
	
}
