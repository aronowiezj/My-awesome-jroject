package ayou.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Menu extends Screen {

	public class ClickListener extends MouseAdapter {

		ScreenID buttonID;

		public ClickListener(ScreenID buttonID) {
			this.buttonID = buttonID;
		}

		public void mouseClicked(MouseEvent e) {
			view.nextScreen(buttonID);
		}
	}

	public Menu(Viewer view) {
		super(view);

		Dimension buttonD = new Dimension(100, 30);
		Dimension fillerD = new Dimension(100, 10);
		Dimension panelD = new Dimension(10, 200);

		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

		JPanel panelTitle = new JPanel();
		panelTitle.setLayout(new FlowLayout(FlowLayout.CENTER));
		JLabel titreLbl = new JLabel("Hearth of Magic Duel");
		titreLbl.setFont(new Font("Arial", Font.PLAIN, 80));
		panelTitle.add(titreLbl);
		this.add(panelTitle);

		/*
		 * Buttons Panel
		 */
		JPanel buttonsPanel = new JPanel();
		buttonsPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		this.add(buttonsPanel);

		/*
		 * Left Buttons Panel
		 */
		JPanel leftButtonsPanel = new JPanel();
		leftButtonsPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		leftButtonsPanel.setPreferredSize(new Dimension(100, 200));
		buttonsPanel.add(leftButtonsPanel);

		JButton gameBtn = new JButton("Game");
		gameBtn.setPreferredSize(buttonD);
		gameBtn.addMouseListener(new ClickListener(ScreenID.GAME));
		leftButtonsPanel.add(gameBtn);

		leftButtonsPanel.add(new Box.Filler(fillerD, fillerD, fillerD));

		JButton optionsBtn = new JButton("Options");
		optionsBtn.setForeground(Color.GRAY);
		optionsBtn.setPreferredSize(buttonD);
		// optionsBtn.addMouseListener(new ClickListener(ScreenID.OPTIONS));
		leftButtonsPanel.add(optionsBtn);

		buttonsPanel.add(new Box.Filler(panelD, panelD, panelD));

		/*
		 * Right Buttons Panel
		 */
		JPanel rightButtonsPanel = new JPanel();
		rightButtonsPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		rightButtonsPanel.setPreferredSize(new Dimension(100, 200));
		buttonsPanel.add(rightButtonsPanel);

		JButton rankBtn = new JButton("Ranking");
		rankBtn.setForeground(Color.GRAY);
		rankBtn.setPreferredSize(buttonD);
		// rankBtn.addMouseListener(new ClickListener(ScreenID.RANKING));
		rightButtonsPanel.add(rankBtn);

		rightButtonsPanel.add(new Box.Filler(fillerD, fillerD, fillerD));

		JButton quitBtn = new JButton("Quit");
		quitBtn.setPreferredSize(buttonD);
		quitBtn.addMouseListener(new ClickListener(ScreenID.QUIT));
		rightButtonsPanel.add(quitBtn);

		/*
		 * Sub Information Panel
		 */
		JPanel subPanel = new JPanel();
		subPanel.setLayout(new BorderLayout());
		subPanel.setMaximumSize(new Dimension(1280, 300));
		subPanel.add(new Box.Filler(buttonD, buttonD, buttonD), BorderLayout.SOUTH);
		this.add(subPanel);

		JPanel playerPanel = new JPanel();
		playerPanel.setLayout(new BoxLayout(playerPanel, BoxLayout.Y_AXIS));
		subPanel.add(playerPanel, BorderLayout.EAST);

	}

}
