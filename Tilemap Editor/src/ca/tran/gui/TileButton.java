package ca.tran.gui;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class TileButton extends JButton{

	private BufferedImage paletteImg, infoImg;
	private int id;
	
	public TileButton(BufferedImage tile, int id, MainWindow window) {
		this.paletteImg = tile;
		this.id = id;
		setMinimumSize(new Dimension(32, 32));
		setMaximumSize(new Dimension(32, 32));
		setPreferredSize(new Dimension(32, 32));
		setIcon(new ImageIcon(tile));
		infoImg = scaleImage(paletteImg, 64, 64);
		
		// When we click the button, we want to update information in main window
		addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				window.changeBrushInfo(infoImg, id);
			}
		});
	}

	private BufferedImage scaleImage(BufferedImage image, int newWidth, int newHeight) {
		// Creates an empty image with new dimensions
		BufferedImage scaled = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_INT_ARGB);
		
		// Creates a Graphics2D object to draw on our image
		Graphics2D g = scaled.createGraphics();
		g.drawImage(image, 0, 0, newWidth, newHeight, null);
		g.dispose();
		return scaled;
	}
	
	public BufferedImage getPaletteImg() {
		return paletteImg;
	}

	public void setTile(BufferedImage tile) {
		this.paletteImg = tile;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
	
}
