package ayou.view;

import java.awt.Color;
import java.awt.TextField;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

import ayou.controller.Finger;
import ayou.model.Card;

@SuppressWarnings("serial")
public class VisualCard extends JPanel implements Observer {

	public final static int WIDTH = 90;
	public final static int HEIGHT = 150;

	private TextField name;
	private TextField power;
	private TextField life;

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
		life = new TextField(card.getHitPoints() + "");
		name.setBounds(0, HEIGHT / 8, WIDTH, HEIGHT / 8 * 3);
		power.setBounds(0, HEIGHT / 2, WIDTH / 2, HEIGHT / 2);
		life.setBounds(WIDTH / 2, HEIGHT / 2, WIDTH / 2, HEIGHT / 2);
		colorize();
		this.setLayout(null);
		this.add(name);
		this.add(power);
		this.add(life);
		this.setSize(WIDTH, HEIGHT);
		this.addMouseListener(Finger.getInstance());
		if (card.isEngaged())
			engaged = true;
	}

	private void colorize() {
		if (lockable)
			this.setBackground(Color.RED);
		/*
		 * else if (handed) { if (playable) this.setBackground(Color.GREEN);
		 * else this.setBackground(Color.GREEN); }
		 */
		else if (engaged)
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
		life.setText(card.getHitPoints() + "");
	}
}
