package ayou.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.TextField;
import java.awt.image.BufferedImage;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JLabel;
import javax.swing.JPanel;

import ayou.controller.Finger;
import ayou.model.Card;
import ayou.model.GameLoop;

@SuppressWarnings("serial")
public class BeautifulCard extends JPanel implements Observer {

	public final static int WIDTH = 90;
	public final static int HEIGHT = 112;

	private Card card;
	private Img img;
	private BufferedImage bgCard;
	private BufferedImage monster;
	private boolean lockable;
	private boolean engaged;
	private TextField life;
	private boolean buffable;
	private TextField power;
	//private ImageIcon picture = new ImageIcon("img/Go-Oushiwa.png");


	public BufferedImage getMonster() {
		return monster;
	}

	public void setMonster(BufferedImage monster) {
		this.monster = monster;
	}

	public BeautifulCard(Card card) {
		
		this.card = card;
		//card.setIdImg(card.getName());
		
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
		
//		g.drawImage(bgCard, 0, 0, this);
		g.drawImage(monster, 0, 0, this);
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
		case 5:
			buffable();
			break;
		case 6:
			nonBuffable();
			break;
		}
	}
	
	private void colorize() {
		if (lockable&& !buffable)
			this.setBackground(Color.RED);
		else if (buffable && lockable) {
			this.setBackground(Color.CYAN);
		}
		/*
		 * else if (handed) { if (playable) this.setBackground(Color.GREEN);
		 * else this.setBackground(Color.GREEN); }
		 */
		else if (engaged)
			this.setBackground(Color.DARK_GRAY);
		else
			this.setBackground(Color.LIGHT_GRAY);
	}
	
	private void buffable() {
		buffable= true;
		colorize();
	}
	public void nonBuffable() {
		buffable = false;
		colorize();
	}

	private void updateEngagement() {
		engaged = card.isEngaged();
		colorize();
	}

	private void updatePower() {
		power.setText(card.getPower() + "");
	}
	public void lockable() {
		lockable = true;
		colorize();
	}

	public void nonlockable() {
		lockable = false;
		colorize();
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
