package ca.tran.editor;

import java.awt.Graphics2D;
import java.util.LinkedList;

import com.sun.glass.ui.Window;

import ca.tran.gui.MainWindow;

public class Map {

	// In terms of tile size
	private int width, height, tileWidth, tileHeight;
	private MainWindow window;
	private Editor editor;
	public LinkedList<Tile> tiles = new LinkedList<Tile>();
	
	public Map (int canvasWidth, int canvasHeight, MainWindow window, Editor editor) {
		this.window = window;
		this.editor = editor;
		grabNewMapData();
	}
	
	public void createEmptyMap() {
		// Need to delete old map if it exists
		if (!tiles.isEmpty()) {
			tiles.removeAll(tiles);
		}
		int id = 0;
		for (int j = 1; j < height-1; j++) {
			for (int i = 1; i < width-1; i++) {
				addTile(new Tile(i * tileWidth, j * tileHeight, tileWidth, tileHeight, id, editor));
				id++;
			}
		}
	}
	
	public void render(Graphics2D g) {
		for (int i = 0; i < tiles.size(); i++) {
			tiles.get(i).render(g);
		}
	}
	
	public void grabNewMapData() {
		// Gets new tileWidth, tileHeight, width, and height values from data in the main window
		tileWidth = editor.getTileWidth();
		tileHeight = editor.getTileHeight();
		width = (int) Math.ceil(Editor.WIDTH/tileWidth);
		height = (int) Math.ceil(Editor.HEIGHT/tileHeight);
	}
	
	private void addTile(Tile tile) {
		this.tiles.add(tile);
	}
	
	private void removeTile(Tile tile) {
		this.tiles.remove(tile);
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getTileWidth() {
		return tileWidth;
	}

	public void setTileWidth(int tileWidth) {
		this.tileWidth = tileWidth;
	}

	public int getTileHeight() {
		return tileHeight;
	}

	public void setTileHeight(int tileHeight) {
		this.tileHeight = tileHeight;
	}
	
	
}
