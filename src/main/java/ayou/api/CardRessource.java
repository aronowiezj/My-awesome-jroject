package ayou.api;


import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;

import ayou.model.CardEntity;

@Path("/card")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CardRessource {
	
	private static CardDao dao = BDDFactory.getDbi().open(CardDao.class);
    
    public CardRessource() {
		try {
			dao.createCardTable();
			dao.insert(new CardEntity("Kiran","De-Kiran", 5, 15, true, false, 10, false, 0, false, 0, false, 1));
			dao.insert(new CardEntity("Torren", "De-Torren", 4, 10, true, false, 10, false, 0, false, 0, false, 0));
			dao.insert(new CardEntity("Danir", "De-Danir", 3, 8, true, false, 10, false, 0, false, 0, false, 0));
			dao.insert(new CardEntity("Aponir", "Dr-Aponir", 15, 15, true, false, 10, false, 0, false, 0, false, 2));
			dao.insert(new CardEntity("Balnar", "Dr-Balnar", 10, 12, true, false, 10, false, 0, false, 0, false, 1));
			dao.insert(new CardEntity("Agrion", "Dr-Agrion", 11, 9, true, false, 10, false, 0, false, 0, false, 1));
			dao.insert(new CardEntity("Norbert", "Dr-Norbert", 4, 4, true, false, 10, false, 0, false, 0, false, 0));
			dao.insert(new CardEntity("Solas", "An-Solas", 7, 6, true, false, 10, true, 0, false, 0, false, 1));
			dao.insert(new CardEntity("Muilas", "An-Muilas", 5, 5, true, false, 10, true, 0, false, 0, false, 0));
			dao.insert(new CardEntity("Nebin", "An-Nebin", 6, 5, true, false, 10, true, 0, false, 0, false, 0));
			dao.insert(new CardEntity("Lego-Das", "An-Lego-das", 4, 5, true, true, 10, true, 0, false, 0, false, 0));
			dao.insert(new CardEntity("Nahial", "Wa-Nahial", 8, 8, true, false, 10, false, 0, false, 0, false, 0));
			dao.insert(new CardEntity("Liddas", "Wa-Liddas", 7, 7, true, false, 10, false, 0, false, 0, false, 0));
			dao.insert(new CardEntity("Zastal", "Wa-Zastal", 6, 8, true, false, 10, false, 0, false, 0, false, 0));
			dao.insert(new CardEntity("Maro", "Ma-Maro", 5, 5, true, false, 10, false, 2, true, 0, false, 0));
			dao.insert(new CardEntity("Aper", "Ma-Aper", 4, 5, true, false, 10, false, 2, true, 0, false, 0));
			dao.insert(new CardEntity("Nepos", "Ma-Nepos", 5, 4, true, false, 10, false, 2, true, 0, false, 0));
			dao.insert(new CardEntity("Grun", "Ba-Grun", 10, 6, true, true, 10, false, 0, false, 0, false, 1));
			dao.insert(new CardEntity("Herim", "Ba-Herim", 8, 5, true, true, 10, false, 0, false, 0, false, 0));
			dao.insert(new CardEntity("Corog", "Ba-Corog", 8, 5, true, true, 10, false, 0, false, 0, false, 0));
			dao.insert(new CardEntity("Fourmiz", "Go-Fourmiz", 7, 20, true, true, 10, false, 0, false, 0, false, 3));
			dao.insert(new CardEntity("LadyBio", "Go-Ladybio", 9, 9, true, false, 10, false, 2, true, 2, true, 3));
			dao.insert(new CardEntity("Oushiwa", "Go-Oushiwa", 20, 3, false, false, 10, false, 0, false, 0, false, 3));
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("La table des cartes est déjà existante !");
		}
	}                                                                                                                                                       
    
    @GET
    @Path("/{id}")
    public CardEntity getCard(@PathParam("id") int id){
    	CardEntity card = dao.findCardById(id);
		if (card == null) {
			throw new WebApplicationException(404);
		}
        card.setIdCard(id);
		return card;
    }   
    
    @GET
    @Path("/random")
    public CardEntity getNbCard(){
		int max = dao.countCard();
		return dao.findCardById((int)(Math.random()*max)+1);
    }
    
	@GET
	public List<CardEntity> getAllCards() {
		return dao.allCards();
	}
	
}
