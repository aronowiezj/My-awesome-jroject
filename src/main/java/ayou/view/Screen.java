package ayou.view;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public abstract class Screen extends JPanel {

	Viewer view;

	abstract public class ClickListener extends MouseAdapter {

		int buttonID;

		public ClickListener(int buttonID) {
			this.buttonID = buttonID;
		}

		abstract public void mouseClicked(MouseEvent e);
	}

	public Screen(Viewer view) {
		this.view = view;
	}
}
