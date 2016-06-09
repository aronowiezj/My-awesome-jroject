package ayou.view;

import java.awt.Color;
import java.awt.TextField;

import javax.swing.JPanel;

import ayou.controller.Finger;
import ayou.model.Card;

@SuppressWarnings("serial")
public class VisualCard extends JPanel {

	public final static int WIDTH = 90;
	public final static int HEIGHT = 150;

	private Card card;

	public VisualCard(Card card) {
		this.card = card;
		TextField name = new TextField(card.getName());
		TextField power = new TextField(card.getPower() + "");
		TextField life = new TextField(card.getHitPoints() + "");
		name.setBounds(0, HEIGHT / 8, WIDTH, HEIGHT / 8 * 3);
		power.setBounds(0, HEIGHT / 2, WIDTH / 2, HEIGHT / 2);
		life.setBounds(WIDTH / 2, HEIGHT / 2, WIDTH / 2, HEIGHT / 2);
		this.setBackground(Color.BLUE);
		this.setLayout(null);
		this.add(name);
		this.add(power);
		this.add(life);
		this.setSize(WIDTH, HEIGHT);
		this.addMouseListener(Finger.getInstance());
	}

	public Card getCard() {
		return card;
	}
}
