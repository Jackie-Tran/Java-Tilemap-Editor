package ca.tran.editor;

import java.awt.Color;
import java.awt.Graphics2D;

public class Tile {
	
	private int x, y, width, height, id;
	
	public Tile (int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.id = 0;
	}
	
	public void render(Graphics2D g) {
		g.setColor(Color.WHITE);
		g.fillRect(x, y, width, height);
		g.setColor(new Color(195, 195, 195));
		g.drawRect(x, y, width, height);
	}
	
}
