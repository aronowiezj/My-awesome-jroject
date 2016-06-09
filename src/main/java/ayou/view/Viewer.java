package ayou.view;

import java.awt.Dimension;

import javax.swing.JFrame;

public class Viewer {

	public static final int SCREEN_WIDTH = 1280;
	public static final int SCREEN_HEIGHT = (System.getProperty("os.name")).equals("Linux") ? 720 : 700;
	private JFrame frame = new JFrame("Hearth of Magic Duel");

	public Viewer() {
		if ((System.getProperty("os.name")).equals("Linux"))
			frame.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
		else
			frame.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT + 20));
		frame.setDefaultCloseOperation(3);
		frame.setResizable(false);

		// Beginning Screen
		frame.setContentPane(new Menu(this));

		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

	public void nextScreen(ScreenID screenID) {
		switch (screenID) {
		case MENU:
			frame.setContentPane(new Menu(this));
			break;
		case RANKING:
			frame.setContentPane(new Options(this));
			break;
		case OPTIONS:
			frame.setContentPane(new Options(this));
			break;
		case GAME:
			frame.setContentPane(new Game(this));
			break;
		case QUIT:
			System.exit(0);
			break;
		default:
			System.err.println("ERROR");
			break;
		}
		frame.repaint();
		frame.revalidate();
	}
}