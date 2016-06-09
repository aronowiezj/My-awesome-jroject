package ayou.controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.List;

import ayou.model.Card;
import ayou.view.VisualCard;

public class Finger implements MouseMotionListener, MouseListener {

	private static Finger instance;
	private static boolean isActive;
	static private Card selection;

	private Finger() {
	}

	public static Finger getInstance() {
		if (instance == null) {
			instance = new Finger();
		}
		return instance;
	}

	@Override
	public void mouseDragged(MouseEvent e) {
	}

	@Override
	public void mouseMoved(MouseEvent e) {
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (isActive) {
			selection = ((VisualCard) e.getSource()).getCard();
			isActive = false;
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}

	private static Card privateSelectCard() {
		isActive = true;

		while (selection == null) {
			try {
				Thread.sleep(0);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		return selection;
	}

	public static Card selectCard(List<Card> cardList) {
		Card card = null;
		while (!cardList.contains(card))
			card = Finger.privateSelectCard();
		return card;
	}
}