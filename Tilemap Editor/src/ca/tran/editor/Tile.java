package ca.tran.editor;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

import javax.swing.SwingUtilities;

public class Tile {
	public static final int EMPTY_ID = -1;
	private int x, y, width, height, id;
	private BufferedImage tileImage = null;
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
		if (isMouseOver && id == EMPTY_ID) {
			g.drawImage(editor.getBrushImage(), x, y, null);
		} else if (id == EMPTY_ID) {
			g.setColor(Color.WHITE);
			g.fillRect(x, y, width, height);
		} else {
			g.drawImage(tileImage, x, y, null);
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
		int mouseX = e.getX();
		int mouseY = e.getY();

		if (SwingUtilities.isLeftMouseButton(e)) {
			if (mouseX >= x && mouseX < x + width && mouseY >= y && mouseY < y + height) {
				id = editor.getBrushId();
				tileImage = editor.getBrushImage();
			}
		}
		if (SwingUtilities.isRightMouseButton(e)) {
			if (mouseX >= x && mouseX < x + width && mouseY >= y && mouseY < y + height) {
				isMouseOver = false;
				id = EMPTY_ID;
				tileImage = null;
			}
		}
	}

	public void mouseDragged(MouseEvent e) {
		int mouseX = e.getX();
		int mouseY = e.getY();
		if (SwingUtilities.isLeftMouseButton(e)) {
			if (mouseX >= x && mouseX < x + width && mouseY >= y && mouseY < y + height) {
				id = editor.getBrushId();
				tileImage = editor.getBrushImage();
			}
		}
		if (SwingUtilities.isRightMouseButton(e)) {
			if (mouseX >= x && mouseX < x + width && mouseY >= y && mouseY < y + height) {
				isMouseOver = false;
				id = EMPTY_ID;
				tileImage = null;
			}
		}
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	

}
