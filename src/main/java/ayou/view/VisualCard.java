package ayou.view;

import java.awt.Color;
import java.awt.TextField;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

import ayou.controller.Finger;
import ayou.model.Card;
import ayou.model.GameLoop;

@SuppressWarnings("serial")
public class VisualCard extends JPanel implements Observer {

	public final static int WIDTH = 90;
	public final static int HEIGHT = 150;

	private TextField name;
	private TextField power;
	private TextField life;
	private TextField price;

	private boolean lockable;
	private boolean engaged;
	// private boolean handed;
	// private boolean playable;
	// private boolean sacrifiable;

	private Card card;

	public VisualCard(Card card) {
		this.card = card;
		card.addObserver(this);
		name = new TextField(card.getName());
		power = new TextField(card.getPower() + "");
		life = new TextField();
		price = new TextField(card.getCout() + "");
		
		if (card.getName().equals("Hero1")) {
			life.setText(GameLoop.getInstance().getPlayer1().getShield() + "");
		} else if (card.getName().equals("Hero2")) {
			life.setText(GameLoop.getInstance().getPlayer2().getShield() + "");
		} else
			life.setText(card.getHitPoints() + "");
		
		name.setBounds(0, HEIGHT / 8, WIDTH, HEIGHT / 8 * 3);
		power.setBounds(0, HEIGHT / 2, WIDTH / 2, HEIGHT / 2 - 30);
		life.setBounds(WIDTH / 2, HEIGHT / 2, WIDTH / 2, HEIGHT / 2 - 30);
		price.setBounds(0, HEIGHT - 30, WIDTH, 30);
		
		this.setLayout(null);
		
		this.add(name);
		this.add(power);
		this.add(life);
		this.add(price);
		
		this.setSize(WIDTH, HEIGHT);
		this.addMouseListener(Finger.getInstance());
		
		engaged = card.isEngaged();
		colorize();
	}

	private void colorize() {
		if (lockable)
			this.setBackground(Color.RED);
		/*
		 * else if (handed) { if (playable) this.setBackground(Color.GREEN);
		 * else this.setBackground(Color.GREEN); }
		 */
		else if (!engaged)
			this.setBackground(Color.DARK_GRAY);
		else
			this.setBackground(Color.LIGHT_GRAY);
	}

	public void lockable() {
		lockable = true;
		colorize();
	}

	public void nonlockable() {
		lockable = false;
		colorize();
	}

	public Card getCard() {
		return card;
	}

	@Override
	public void update(Observable o, Object obj) {
		int i = (Integer) obj;

		switch (i) {
		case 0:
			lockable();
			break;
		case 1:
			nonlockable();
			break;
		case 2:
			updateLife();
			break;
		case 3:
			updatePower();
			break;
		case 4:
			updateEngagement();
			break;
		}
	}

	private void updateEngagement() {
		engaged = card.isEngaged();
		colorize();
	}

	private void updatePower() {
		power.setText(card.getPower() + "");
	}

	private void updateLife() {
		if (card.getName().equals("Hero1")) {
			life.setText(GameLoop.getInstance().getPlayer1().getShield() + "");
		} else if (card.getName().equals("Hero2")) {
			life.setText(GameLoop.getInstance().getPlayer2().getShield() + "");
		} else
			life.setText(card.getHitPoints() + "");
	}
}
