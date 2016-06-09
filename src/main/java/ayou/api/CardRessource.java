package ayou.api;


import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/card")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CardRessource {
	
	private static CardDao dao = BDDFactory.getDbi().open(CardDao.class);
    
    public CardRessource() {
		try {
			dao.deleteCardTable();
			dao.createCardTable();
			dao.deleteEffectsTable();
			dao.createEffectsTable();
		} catch (Exception e) {
			System.out.println("Board déjà existant !");
		}
	}
    
    @POST
    public void fillCardTable(){
    	dao.fillCardTable();
    }
    
    @POST
    public void fillEffectsTable(){
    	dao.fillEffectsTable();
    }
    
    @PUT
    @Path("/{id}")
    public void updateCard(@PathParam("id") int id, int buffATK, int debuffATK, int buffDEF, int debuffDEF){
    	dao.updateCard(id, buffATK, debuffATK, buffDEF, debuffDEF);
    }
	
}
