package ayou.view;

import java.awt.Graphics;
import java.awt.TextArea;

import javax.swing.JPanel;

import ayou.model.Card;

@SuppressWarnings("serial")
public class VisualCard extends JPanel {
	public final static int WIDTH = 100;
	public final static int HEIGHT = 200;

	public VisualCard(Card card) {
		TextArea name = new TextArea(card.getName());
		TextArea life = new TextArea(card.getHitPoints() + "");
		name.setBounds(0, 0, 100, 100);
		life.setBounds(0, 100, 100, 100);
		add(name);
		add(life);
		this.setSize(WIDTH, HEIGHT);
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
	}
}
