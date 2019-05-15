package ca.tran.editor;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

public class Tile {

	private int x, y, width, height, id;
	private BufferedImage tileImage;
	private Editor editor;

	private boolean isMouseOver = false;

	public Tile(int x, int y, int width, int height, int id, Editor editor) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.id = id;
		this.editor = editor;
	}

	public void render(Graphics2D g) {
		if (isMouseOver) {
			g.drawImage(editor.getTileImage(), x, y, null);
		} else {
			g.setColor(Color.WHITE);
			g.fillRect(x, y, width, height);
		}
		g.setColor(new Color(195, 195, 195));
		g.drawRect(x, y, width, height);
		g.setColor(Color.BLACK);
		g.drawString(Integer.toString(id), x + 3, y + 12);
	}

	public void mouseMoved(MouseEvent e) {
		int mouseX = e.getX();
		int mouseY = e.getY();

		// Mouse is over the tile
		if (mouseX >= x && mouseX < x + width && mouseY >= y && mouseY < y + height) {
			isMouseOver = true;
		} else {
			isMouseOver = false;
		}
	}

	public void mousePressed(MouseEvent e) {

	}

	public void mouseDragged(MouseEvent e) {

	}

}
