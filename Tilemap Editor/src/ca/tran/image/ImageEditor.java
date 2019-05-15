package ca.tran.image;

import java.awt.AlphaComposite;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public final class ImageEditor {

	public static BufferedImage scaleImage(BufferedImage image, int newWidth, int newHeight) {
		// Creates an empty image with new dimensions
		BufferedImage scaled = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_INT_ARGB);
		
		// Creates a Graphics2D object to draw on our image
		Graphics2D g = scaled.createGraphics();
		g.drawImage(image, 0, 0, newWidth, newHeight, null);
		g.dispose();
		return scaled;
	}
	
	public static BufferedImage changeOpacity(BufferedImage image, double opacity) {
		BufferedImage newImage = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_INT_ARGB);
		Graphics2D g = newImage.createGraphics();
		g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, (float) opacity));
		g.drawImage(image, 0, 0, null);
		return newImage;
	}
	
}
