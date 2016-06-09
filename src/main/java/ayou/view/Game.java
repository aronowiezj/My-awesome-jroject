package ayou.view;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;

import ayou.model.GameLoop;

@SuppressWarnings("serial")
public class Game extends Screen {

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

	public Game(Viewer view) {
		super(view);

		setLayout(null);

		JPanel panelGame = new JPanel();
		panelGame.setBounds(0, 0, Viewer.SCREEN_WIDTH, Viewer.SCREEN_HEIGHT);
		panelGame.setLayout(null);

		panelGame.add(GameCanvas.getInstance());

		panelGame.add(new Background());

		GameLoop.getInstance().start();
		
		GameCanvas.getInstance().createPlayers();

		this.add(panelGame);
	}

}