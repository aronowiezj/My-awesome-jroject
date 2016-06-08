package ayou.api;

import static org.junit.Assert.assertEquals;

import java.util.List;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.Application;

import org.glassfish.jersey.test.JerseyTest;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import ayou.model.Board;
import ayou.model.Card;

public class BoardResourceTest extends JerseyTest {
	
	/*@Override
    protected Application configure() {
        return new Api();
    }
	
	@Test
	public void should_return_board(){
		int port = getPort();
		Board newBoard = ClientBuilder.newClient().target("http://localhost:"+port+"/board/1")
        .request()
        .get(Board.class);
		Assert.assertEquals("Ma string de test", newBoard.getTestStr());
	}
	
	@Test @Ignore
	public void should_return_player1_numbercardsonboard(){
		Board board = new Board();
		board.add(1, new Card(8, 8, "lol"));
		List<Card> l = board.getP1cards();
		assertEquals(1, l.size());
	}*/
	
}
