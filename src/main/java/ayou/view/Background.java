package ayou.view;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SuppressWarnings("serial")
public class Background extends JPanel {

	private final String BACKGROUND_URL = "bg_hearthstone.jpg";
	private BufferedImage bg;
	final static Logger logger = LoggerFactory.getLogger(Background.class);

	public Background() {
		setBounds(0, 0, Viewer.SCREEN_WIDTH, Viewer.SCREEN_HEIGHT);
		try {
			bg = ImageIO.read(getClass().getResource("/img/" + BACKGROUND_URL));
			//logger.debug("load bg file success");
		} catch (Exception e) {
			logger.error(BACKGROUND_URL + " NOT FOUND ");
		}
		
		bg = Img.resizeImage(bg, 1280, 720);
		
		repaint();
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		g.drawImage(bg, 0, 0, this);
	}

}
