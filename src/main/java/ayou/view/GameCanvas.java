package ayou.view;

import java.awt.Graphics;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

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
		repaint();
	}
}