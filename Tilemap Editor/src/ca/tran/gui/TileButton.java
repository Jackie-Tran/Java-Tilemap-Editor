package ca.tran.gui;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class TileButton extends JButton{
	private static final long serialVersionUID = 1L;
	
	private BufferedImage buttonImage;
	private int id; // integer id for this specific tile
	
	public TileButton(BufferedImage tileImage, int id, MainWindow window) {
		this.buttonImage = tileImage;
		this.id = id;
		setMinimumSize(new Dimension(32, 32));
		setMaximumSize(new Dimension(32, 32));
		setPreferredSize(new Dimension(32, 32));
		setIcon(new ImageIcon(buttonImage));
		
		// When we click the button, we want to update information in main window
		addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				window.changeBrushInfo(tileImage, id);
			}
		});
	}
	
	public BufferedImage getButtonImage() {
		return buttonImage;
	}

	public void setImage(BufferedImage tileImage) {
		this.buttonImage = tileImage;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
	
}
