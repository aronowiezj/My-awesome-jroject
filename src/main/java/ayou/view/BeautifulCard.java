package ayou.view;

import java.awt.Graphics;
import java.awt.TextField;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import ayou.controller.Finger;
import ayou.model.Card;

@SuppressWarnings("serial")
public class BeautifulCard extends JPanel {

	public final static int WIDTH = 90;
	public final static int HEIGHT = 112;

	private Card card;
	private Img img;
	private BufferedImage bgCard;
	private BufferedImage monster;
	//private ImageIcon picture = new ImageIcon("img/Go-Oushiwa.png");


	public BeautifulCard(Card card) {
		
		this.card = card;
		card.setIdImg(card.getName());
		img = new Img(card);
		monster = img.getImg();
		
		TextField name = new TextField(card.getName());
		TextField power = new TextField(card.getPower() + "");
		TextField life = new TextField(card.getHitPoints() + "");
		name.setBounds(13, 76, 74, 14);
		power.setBounds(75, 7, 12, 12);
		life.setBounds( 75, 20,12, 12);
		//this.setBackground(Color.BLUE);
		String effectsSTR = "Effets : \n\n";
		
		//heal
		if(this.card.getHealAlly()>0)
			effectsSTR += "Soin : " + this.card.getHealAlly();
		if(card.isHealAllAllies())
			effectsSTR += " sur tous les alliés";
		effectsSTR += "\n";
		
		//buff
		if(this.card.getBuffAlly()>0)
			effectsSTR += "Amélioration : " + this.card.getBuffAlly();
		if(card.isBuffAllAllies())
			effectsSTR += " sur tous les alliés";
		effectsSTR += "\n";
		
		//debuff
		if(this.card.getDebuffEnemy()>0)
			effectsSTR += "Entrave : " + this.card.getDebuffEnemy();
		if(card.isDebuffAllEnemies())
			effectsSTR += " sur tous les ennemis";
		effectsSTR += "\n";
				
		JLabel effects = new JLabel(effectsSTR);
		
		//JLabel bg = new JLabel(background);
		//JLabel img = new JLabel(picture);
		//img.setBounds(16, 7, 57, 66);
		this.setLayout(null);
				
		//this.add(bg);
		//this.add(img);
		this.add(name);
		this.add(power);
		this.add(life);
		this.add(effects);
		this.setSize(WIDTH, HEIGHT);
		this.addMouseListener(Finger.getInstance());
	}

	public Card getCard() {
		return card;
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		g.drawImage(bgCard, 0, 0, this);
	}
}
