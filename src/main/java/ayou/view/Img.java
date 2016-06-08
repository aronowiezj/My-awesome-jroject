package ayou.view;

import java.awt.AlphaComposite;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import ayou.model.Card;

public class Img {

	private BufferedImage img = null;
	private String url;

	public Img(Card card) {
		try {
			img = ImageIO.read(new File("img/" + card.getImgID() + ".jpg"));
		} catch (IOException e) {
			System.err.println(card.getImgID() + ".jpg NOT FOUND");
		}

		img = resizeImage(img, Card.IMG_SIZE_X, Card.IMG_SIZE_Y);
		url = "img/" + card.getImgID() + ".png";
	}

	public BufferedImage getImg() {
		return img;
	}

	public static BufferedImage resizeImage(BufferedImage originalImage, int imgWidth, int imgHeight) {
		int type = originalImage.getType() == 0 ? BufferedImage.TYPE_INT_ARGB : originalImage.getType();
		BufferedImage resizedImage = new BufferedImage(imgWidth, imgHeight, type);
		Graphics2D g = resizedImage.createGraphics();
		g.drawImage(originalImage, 0, 0, imgWidth, imgHeight, null);
		g.dispose();
		g.setComposite(AlphaComposite.Src);

		return resizedImage;
	}

	public static void setRenderingHints(Graphics2D g) {
		g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		g.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
	}

	@Override
	public String toString() {
		return url;
	}
}
