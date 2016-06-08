package ayou.view;

import java.awt.Graphics;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

import ayou.model.Card;
import ayou.model.GameLoop;

@SuppressWarnings("serial")
public class GameCanvas extends JPanel implements Observer {

	private static GameCanvas instance;

	private GameCanvas() {
		setBounds(0, 0, Viewer.SCREEN_WIDTH, Viewer.SCREEN_HEIGHT);
		setOpaque(false);
		repaint();
	}

	public static GameCanvas getInstance() {
		if (instance == null) {
			instance = new GameCanvas();
		}
		return instance;
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		this.removeAll();
		for (Card card : GameLoop.getInstance().getPlayer1().getHand())
			add(new VisualCard(card));
		for (Card card : GameLoop.getInstance().getPlayer2().getHand())
			add(new VisualCard(card));
		for (Card card : GameLoop.getInstance().getPlayer1().getBoard())
			add(new VisualCard(card));
		for (Card card : GameLoop.getInstance().getPlayer2().getBoard())
			add(new VisualCard(card));
		repaint();
	}
}