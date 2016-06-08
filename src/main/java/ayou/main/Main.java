package ayou.main;

import ayou.model.GameLoop;
import ayou.view.Window;

public class Main {
	public static Window window;

	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				window=new Window(1300, 800, "Awesome");
				
				
			}
		});
		
	}
	
	public static void run(){
		//new GameLoop();
	}

}
