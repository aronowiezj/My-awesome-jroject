package ayou.view;

import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

import ayou.controller.Finger;
import ayou.model.Card;
import ayou.model.GameLoop;

@SuppressWarnings("serial")
public class GameCanvas extends JPanel implements Observer {

	private static GameCanvas instance;
	private JPanel hand1;
	private JPanel hand2;
	private JPanel board1;
	private JPanel board2;

	private GameCanvas() {
		setBounds(0, 0, Viewer.SCREEN_WIDTH, Viewer.SCREEN_HEIGHT);
		setOpaque(false);
		setLayout(null);

		hand1 = new JPanel();
		initialize(hand1);
		hand1.setBounds(Viewer.SCREEN_WIDTH / 8, Viewer.SCREEN_HEIGHT * 6 / 8 + 10, Viewer.SCREEN_WIDTH / 8 * 6, VisualCard.HEIGHT);

		hand2 = new JPanel();
		initialize(hand2);
		hand2.setBounds(Viewer.SCREEN_WIDTH / 8, 10, Viewer.SCREEN_WIDTH / 8 * 6, VisualCard.HEIGHT);

		board1 = new JPanel();
		initialize(board1);
		board1.setBounds(Viewer.SCREEN_WIDTH / 8, Viewer.SCREEN_HEIGHT * 4 / 8 + 10, Viewer.SCREEN_WIDTH / 8 * 6, VisualCard.HEIGHT);

		board2 = new JPanel();
		initialize(board2);
		board2.setBounds(Viewer.SCREEN_WIDTH / 8, Viewer.SCREEN_HEIGHT * 2 / 8 + 10, Viewer.SCREEN_WIDTH / 8 * 6, VisualCard.HEIGHT);

		repaint();
	}

	private void initialize(JPanel panel) {
		panel.setLayout(null);
		panel.setOpaque(false);
		this.add(panel);
	}

	public static GameCanvas getInstance() {
		if (instance == null) {
			instance = new GameCanvas();
		}
		return instance;
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		int i, size;

		hand1.removeAll();
		i = 0;
		size = GameLoop.getInstance().getPlayer1().getHandSize();
		for (Card card : GameLoop.getInstance().getPlayer1().getHand()) {
			VisualCard visualCard = new VisualCard(card);
			if (size == 1)
				visualCard.setBounds(hand1.getWidth() / 2 - VisualCard.WIDTH / 2, 0, VisualCard.WIDTH, VisualCard.HEIGHT);
			else
				visualCard.setBounds((hand1.getWidth() - VisualCard.WIDTH) / (size - 1) * i++, 0, VisualCard.WIDTH, VisualCard.HEIGHT);
			hand1.add(visualCard);
		}

		hand2.removeAll();
		i = 0;
		size = GameLoop.getInstance().getPlayer2().getHandSize();
		for (Card card : GameLoop.getInstance().getPlayer2().getHand()) {
			VisualCard visualCard = new VisualCard(card);
			if (size == 1)
				visualCard.setBounds(hand2.getWidth() / 2 - VisualCard.WIDTH / 2, 0, VisualCard.WIDTH, VisualCard.HEIGHT);
			else
				visualCard.setBounds((hand2.getWidth() - VisualCard.WIDTH) / (size - 1) * i++, 0, VisualCard.WIDTH, VisualCard.HEIGHT);
			hand2.add(visualCard);
		}

		board1.removeAll();
		i = 0;
		size = GameLoop.getInstance().getPlayer1().getBoardSize();
		for (Card card : GameLoop.getInstance().getPlayer1().getBoard()) {
			VisualCard visualCard = new VisualCard(card);
			if (size == 1)
				visualCard.setBounds(board1.getWidth() / 2 - VisualCard.WIDTH / 2, 0, VisualCard.WIDTH, VisualCard.HEIGHT);
			else
				visualCard.setBounds((board1.getWidth() - VisualCard.WIDTH) / (size - 1) * i++, 0, VisualCard.WIDTH, VisualCard.HEIGHT);
			board1.add(visualCard);
		}

		board2.removeAll();
		i = 0;
		size = GameLoop.getInstance().getPlayer2().getBoardSize();
		for (Card card : GameLoop.getInstance().getPlayer2().getBoard()) {
			VisualCard visualCard = new VisualCard(card);
			if (size == 1)
				visualCard.setBounds(board2.getWidth() / 2 - VisualCard.WIDTH / 2, 0, VisualCard.WIDTH, VisualCard.HEIGHT);
			else
				visualCard.setBounds((board2.getWidth() - VisualCard.WIDTH) / (size - 1) * i++, 0, VisualCard.WIDTH, VisualCard.HEIGHT);
			board2.add(visualCard);
		}

		repaint();
	}
}