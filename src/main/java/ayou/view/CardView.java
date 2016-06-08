package ayou.view;

import java.awt.Graphics;
import java.awt.TextArea;

import javax.swing.JPanel;

import ayou.model.Card;

public class CardView extends JPanel{
	public final static int WIDTH=200;
	public final static int HEIGHT=100;
	
	
	public CardView(Card card) {
		TextArea name=new TextArea(card.getName());
		TextArea life=new TextArea(card.getHitPoints()+"");
		name.setBounds(0, 0, 99, 49);
		life.setBounds(100, 50, 99, 49);
		add(name);
		add(life);
		this.setSize(WIDTH, HEIGHT);
		
	}
	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		
	}
}
