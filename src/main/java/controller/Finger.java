package controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Observable;

import ayou.model.GameLoop;

public class Finger extends Observable implements MouseMotionListener, MouseListener {

	public static final int POWER_SIZE_MAX = 100;
	public static final double TIME_FOR_MAX_POWER = 1.0;

//	private boolean isActive;

	public Finger() {
		new GameLoop().start();
	}

	@Override
	public void mouseDragged(MouseEvent e) {
	}

	@Override
	public void mouseMoved(MouseEvent e) {
	}

	@Override
	public void mouseClicked(MouseEvent e) {
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
}