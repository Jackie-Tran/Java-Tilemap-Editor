package ca.tran.gui;

import java.awt.Dimension;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class TileButton extends JButton{

	private BufferedImage tile;
	private int id;
	
	public TileButton(BufferedImage tile, int id) {
		this.tile = tile;
		this.id = id;
		setMinimumSize(new Dimension(32, 32));
		setMaximumSize(new Dimension(32, 32));
		setPreferredSize(new Dimension(32, 32));
		//setIcon(new ImageIcon(tile));
	}
	
	
	
}
