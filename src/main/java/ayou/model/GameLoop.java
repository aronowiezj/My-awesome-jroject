package ayou.model;

import ayou.controller.Finger;

public class GameLoop extends Thread {

	static public int DECK_SIZE = 40;
	static public int START_HAND_SIZE = 5;
	private Player player1;
	private Player player2;

	private static GameLoop instance;

	private GameLoop() {
	}

	public static GameLoop getInstance() {
		if (instance == null) {
			instance = new GameLoop();
		}
		return instance;
	}

	public Player getPlayer1() {
		return player1;
	}

	public Player getPlayer2() {
		return player2;
	}

	public void run() {
		player1 = new Player("Player1");
		player2 = new Player("Player2");

		startDraw(player1);
		startDraw(player2);

		while (!player1.isDefeated() && !player2.isDefeated()) {
			doTurn(player1, player2);
			doTurn(player2, player1);
		}

		if (player1.isDefeated())
			System.out.println("player 2 win !");
		else
			System.out.println("player 1 win !");

	}

	private void doTurn(Player player, Player enemy) {
		player.draw();
		player.disengage();
		boolean endOfTime = false;
		while (!endOfTime) {
			Card card=null;
			card = Finger.soloSelectCard();
			if (card.getName().equals("EndTurn")) {
				endOfTime = true;
			} else if (player.getCardsOnBoard().contains(card)) {
				if (card.canAttaque() && !card.isEngaged()) {
					Card cible=Finger.selectCard(enemy.getCardsOnBoard());
					card.attack(cible);
				}
			} else if (player.getCardsFromHand().contains(card) && !player.getHand().havePlayed()) {
				if(card.getCout()==0){
					player.invoke(card);
				}else {
					if(card.getCout()<=player.getBoardSize()){
						for (int i = 0; i < card.getCout(); i++) {
							Card sacrifice=Finger.selectCard(player.getCardsOnBoard());
							player.getCardsOnBoard().remove(sacrifice);
						}
						player.invoke(card);
					}
					else
						System.err.println("TROP CHER POUR TOI, BIATCH");
				}
				
			}
			
		}
	}

	private void startDraw(Player player) {
		for (int i = 0; i < START_HAND_SIZE; ++i)
			player.draw();
	}

}
