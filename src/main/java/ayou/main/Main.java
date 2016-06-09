package ayou.main;

import ayou.controller.Finger;
import ayou.model.GameLoop;
import ayou.view.Viewer;

public class Main {

	public static void main(String[] args) {

		GameLoop.getInstance().start();
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new Viewer();
			}
		});

	}
}
