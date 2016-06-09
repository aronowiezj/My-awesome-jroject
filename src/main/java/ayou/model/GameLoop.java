package ayou.model;

import java.util.List;
import java.util.Scanner;

import ayou.controller.Finger;
import ayou.view.Displayer;

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
		boolean putCard=false;
		player.invoke(selectCard(player.getHand()));

		for (Card c : player.getBoard()) {
			if (c.isCelerity()) {
				Card cible=selectCard(enemy.getBoard());
				c.attack(cible);
				if(c.isDead()){
					player.toGraveYard(c);
				}
				if(cible.isDead()){
					enemy.toGraveYard(cible);
				}
			}else {
				c.setCelerity(true);
			}

		}
		System.out.println(player + "    " + player.getShield());
		System.out.println(enemy + "    " + enemy.getShield());

	}

	private Card selectCard(List<Card> cardList) {
		Card card = null;
		while (!cardList.contains(card))
			card = Finger.selectCard();
		return card;
	}

	private void startDraw(Player player) {
		for (int i = 0; i < START_HAND_SIZE; ++i)
			player.draw();
	}

}
