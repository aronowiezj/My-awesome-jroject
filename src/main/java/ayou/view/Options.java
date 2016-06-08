package ayou.view;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * @author Jeremie
 *
 */
@SuppressWarnings("serial")
public class Options extends Screen {

	public class ClickListener extends MouseAdapter {

		int buttonID;

		public ClickListener(int buttonID) {
			this.buttonID = buttonID;
		}

		public void mouseClicked(MouseEvent e) {
			if (buttonID == 1)
				view.nextScreen(ScreenID.MENU);
		}
	}

	/**
	 * @param view
	 *            Vision actuel du plateau
	 */
	public Options(Viewer view) {
		super(view);

		setLayout(null);

		/*
		 * panelFriend
		 */
		JPanel panelFriend = new JPanel();
		panelFriend.setBounds(0, 0, 340, 720);
		// panelFriend.setBackground(Color.GREEN);

		this.add(panelFriend);

		/*
		 * panelGame
		 */
		JPanel panelGame = new JPanel();
		panelGame.setBounds(340, 0, 600, 720);
		panelGame.setLayout(null);

		this.add(panelGame);

		/*
		 * panelEnemy
		 */
		JPanel panelEnemy = new JPanel();
		panelEnemy.setBounds(940, 0, 340, 720);
		// panelEnemy.setBackground(Color.RED);

		JButton buttonMenu = new JButton("Menu");
		buttonMenu.addMouseListener(new ClickListener(1));
		panelEnemy.add(buttonMenu);

		this.add(panelEnemy);
	}

}
