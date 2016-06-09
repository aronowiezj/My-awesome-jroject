package ayou.view;

import java.awt.Color;
import java.awt.Graphics;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;

import ayou.model.Board;
import ayou.model.Card;
import ayou.model.GameLoop;
import ayou.model.Hand;

@SuppressWarnings("serial")
public class GameCanvas extends JPanel implements Observer {

	private static GameCanvas instance;
	private JPanel hand1;
	private JPanel hand2;
	private JPanel board1;
	private JPanel board2;
	
	private JTextField turnPane;

	private GameCanvas() {
		setBounds(0, 0, Viewer.SCREEN_WIDTH, Viewer.SCREEN_HEIGHT);
		setOpaque(false);
		setLayout(null);

		hand1 = new JPanel();
		initialize(hand1, Viewer.SCREEN_WIDTH / 8, Viewer.SCREEN_HEIGHT * 6 / 8 + 10, Viewer.SCREEN_WIDTH / 8 * 6,
				VisualCard.HEIGHT);

		hand2 = new JPanel();
		initialize(hand2, Viewer.SCREEN_WIDTH / 8, 10, Viewer.SCREEN_WIDTH / 8 * 6, VisualCard.HEIGHT);

		board1 = new JPanel();
		initialize(board1, Viewer.SCREEN_WIDTH / 8, Viewer.SCREEN_HEIGHT * 4 / 8 + 10, Viewer.SCREEN_WIDTH / 8 * 6,
				VisualCard.HEIGHT);

		board2 = new JPanel();
		initialize(board2, Viewer.SCREEN_WIDTH / 8, Viewer.SCREEN_HEIGHT * 2 / 8 + 10, Viewer.SCREEN_WIDTH / 8 * 6,
				VisualCard.HEIGHT);
		
		turnPane=new JTextField("Joueur 1");
		turnPane.setBounds(65, Viewer.SCREEN_HEIGHT/2-10, 70, 20);
		add(turnPane);
				
		repaint();
	}
	
	public void changeTurn(){
		if (turnPane.getText().equals("Joueur 1")) {
			turnPane.setText("Joueur 2");
		}
		else
			turnPane.setText("Joueur 1");
	}
	
	public void createPlayers(){
		VisualCard visualPlayer1 = new VisualCard(new Card(0, "Hero1", null));
		initialize(visualPlayer1, Viewer.SCREEN_WIDTH - VisualCard.WIDTH, Viewer.SCREEN_HEIGHT * 6 / 8 + 10,
				VisualCard.WIDTH, VisualCard.HEIGHT);
		visualPlayer1.setOpaque(true);
		visualPlayer1.setBackground(Color.ORANGE);

		VisualCard visualPlayer2 = new VisualCard(new Card(0, "Hero2", null));
		initialize(visualPlayer2, 0, 10, VisualCard.WIDTH, VisualCard.HEIGHT);
		visualPlayer2.setOpaque(true);
		visualPlayer2.setBackground(Color.ORANGE);

		VisualCard visualEndTurn = new VisualCard(new Card(0, "EndTurn", null));
		initialize(visualEndTurn, Viewer.SCREEN_WIDTH - VisualCard.WIDTH,
				Viewer.SCREEN_HEIGHT / 2 - VisualCard.HEIGHT / 2, VisualCard.WIDTH, VisualCard.HEIGHT);
		

		visualEndTurn.setOpaque(true);
		visualEndTurn.setBackground(Color.BLACK);		
	}

	private void initialize(JPanel panel, int x, int y, int width, int height) {
		panel.setLayout(null);
		panel.setOpaque(false);
		panel.setBounds(x, y, width, height);
		this.add(panel);
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
	public void update(Observable observable, Object o) {

		if (observable instanceof Hand) {
			Hand hand = (Hand) observable;
			if (hand.getPlayer().equals(GameLoop.getInstance().getPlayer1())) {
				manage(hand1, hand.getCards());
			} else {
				manage(hand2, hand.getCards());
			}
		}
		if (observable instanceof Board) {
			Board board = (Board) observable;

			if (board.getPlayer() == GameLoop.getInstance().getPlayer1())
				manage(board1, board.getCards());
			else
				manage(board2, board.getCards());
		}

		repaint();
	}

	public void manage(JPanel panel, List<Card> cardList) {
		panel.removeAll();
		int i = 0;
		for (Card card : cardList) {
			VisualCard visualCard = new VisualCard(card);
			if (cardList.size() == 1)
				visualCard.setBounds(panel.getWidth() / 2 - VisualCard.WIDTH / 2, 0, VisualCard.WIDTH,
						VisualCard.HEIGHT);
			else
				visualCard.setBounds((panel.getWidth() - VisualCard.WIDTH) / (cardList.size() - 1) * i++, 0,
						VisualCard.WIDTH, VisualCard.HEIGHT);
			panel.add(visualCard);
		}
	}

}