package ayou.view;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.LayoutManager;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

import ayou.main.Main;

public class Window extends JFrame {
	public static JPanel handJ1 = new JPanel();
	
	
	public Window(int large, int heigh, String string) {
		this.setTitle(string);
		this.setPreferredSize(new Dimension(large, heigh));
		this.setMaximumSize(new Dimension(large, heigh));
		this.setMinimumSize(new Dimension(large, heigh));
		this.setLayout(new BorderLayout());
		// this.add(game, BorderLayout.CENTER);
		this.pack();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		add(handJ1);
		//handJ1.setLayout(new BoxLayout(handJ1, BoxLayout.LINE_AXIS));
		handJ1.setLayout(null);
		Main.run();
	}
	
	@Override
	public void repaint() {
		// TODO Auto-generated method stub
		super.repaint();
	}

}