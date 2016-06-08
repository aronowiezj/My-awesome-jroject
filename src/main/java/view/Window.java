package view;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;

public class Window extends JFrame {

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
	}

}