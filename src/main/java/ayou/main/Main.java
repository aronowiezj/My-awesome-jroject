package ayou.main;

import ayou.model.GameLoop;
import ayou.view.Viewer;

public class Main {

	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				new Viewer();
			}
		});

	}

	public static void run() {
		new GameLoop();
	}

}
