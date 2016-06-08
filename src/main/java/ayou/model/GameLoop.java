package ayou.model;

import java.util.Scanner;

import ayou.view.Displayer;
import ayou.view.GameCanvas;
import ayou.view.Viewer;

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
	
	public Player getPlayer1(){
		return player1;
	}
	
	public Player getPlayer2(){
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
		player.draw();
		while (true) {
			System.out.println("lol");
		}
	}

	private void startDraw(Player player) {
		for (int i = 0; i < START_HAND_SIZE; ++i)
			player.draw();
	}

}
