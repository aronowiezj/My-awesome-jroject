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
		player1 = new Player("Player1", true);
		player2 = new Player("Player2", false);

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

	// private void doTurn(Player player, Player enemy) {
	// player.draw();
	//
	// System.out.println(player + " hand :");
	// Displayer.display(player.getHand());
	// System.out.println();
	//
	// if (player.isBoardEmpty())
	// player.invoke(player.getHand().get(Integer.parseInt(new
	// Scanner(System.in).nextLine()) - 1));
	//
	// System.out.println(player + " board :");
	// System.out.println(player.getBattler());
	// if (!enemy.isBoardEmpty()) {
	// System.out.println(enemy + " board :");
	// System.out.println(enemy.getBattler());
	// }
	// System.out.println();
	//
	// if (!enemy.isBoardEmpty()) {
	// player.getBattler().attack(enemy.getBattler());
	// Displayer.attackCard(player.getBattler(), enemy.getBattler());
	// if (player.getBattler().getHitPoints() <= 0) {
	// player.takeDamages(1);
	// Displayer.die(player.getBattler());
	// player.cleanBoard();
	// }
	// if (enemy.getBattler().getHitPoints() <= 0) {
	// enemy.takeDamages(1);
	// Displayer.die(enemy.getBattler());
	// enemy.cleanBoard();
	// }
	// }
	// System.out.println(player + " " + player.getShield());
	// System.out.println(enemy + " " + enemy.getShield());
	// }
	private void doTurn(Player player, Player enemy) {
		// logger.debug(player.toString() + " vs " + enemy.toString());
		player.draw();
		// logger.debug("hand : " + Displayer.buildCards(player.getHand()));

		System.out.println(player + " hand :");
		Displayer.display(player.getHand());
		System.out.println();

		System.out.println("Quelle carte jouer?");
		
		player.invoke(selectCard(player.getHand()));

		System.out.println(player + " board :");
		System.out.println(player.getBoard());
		if (!enemy.isBoardEmpty()) {
			System.out.println(enemy + " board :");
			System.out.println(enemy.getBattler());
		}
		System.out.println();

		// if (!enemy.isBoardEmpty()) {
		//
		// player.invoke(player.getHand().get(Integer.parseInt(new
		// Scanner(System.in).nextLine()) - 1));
		// player.getBattler().attack(enemy.getBattler());
		// Displayer.attackCard(player.getBattler(), enemy.getBattler());
		// if (player.getBattler().getHitPoints() <= 0) {
		// player.takeDamages(1);
		// Displayer.die(player.getBattler());
		// player.cleanBoard();
		// }
		// if (enemy.getBattler().getHitPoints() <= 0) {
		// enemy.takeDamages(1);
		// Displayer.die(enemy.getBattler());
		// enemy.cleanBoard();
		// }
		// }
		for (Card c : player.getBoard()) {
			// if (c.isCanAttack()) {
			System.out.println("Qui attaquer? 0 pour le héros");
			int cible = Integer.parseInt(new Scanner(System.in).nextLine()) - 1;
			if (cible >= 0) {
				if (cible < enemy.getBoard().size()) {
					c.attack(enemy.getBoard().get(cible));
				}

			} else {
				enemy.takeDamages(1);
			}
			// } else {
			// c.setCanAttack(true);
			// }

		}
		System.out.println(player + "    " + player.getShield());
		System.out.println(enemy + "    " + enemy.getShield());

	}

	private Card selectCard(List<Card> cardList) {
		Card card = null;
		while(!cardList.contains(card))
			card = Finger.selectCard();
		return card;
	}

	private void startDraw(Player player) {
		for (int i = 0; i < START_HAND_SIZE; ++i)
			player.draw();
	}

}
