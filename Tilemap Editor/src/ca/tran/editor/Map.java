package ca.tran.editor;

import java.awt.Graphics2D;
import java.util.LinkedList;

public class Map {

	// In terms of tile size
	private int width, height, tileWidth, tileHeight;
	public LinkedList<Tile> tiles = new LinkedList<Tile>();
	
	public Map (int canvasWidth, int canvasHeight, int tileWidth, int tileHeight) {
		this.width = (int) Math.ceil(canvasWidth/tileWidth);
		this.height = (int) Math.ceil(canvasHeight/tileHeight);
		this.tileWidth = tileWidth;
		this.tileHeight = tileHeight;
	}
	
	public void createEmptyMap() {
		for (int i = 1; i < width-1; i++) {
			for (int j = 1; j < height-1; j++) {
				addTile(new Tile(i * tileWidth, j * tileHeight, tileWidth, tileHeight));
			}
		}
	}
	
	public void render(Graphics2D g) {
		for (int i = 0; i < tiles.size(); i++) {
			tiles.get(i).render(g);
		}
	}
	
	private void addTile(Tile tile) {
		tiles.add(tile);
	}
	
	private void removeTile(Tile tile) {
		tiles.remove(tile);
	}
}
