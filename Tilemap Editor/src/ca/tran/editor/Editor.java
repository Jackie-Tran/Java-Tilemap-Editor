package ca.tran.editor;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import ca.tran.gui.MainWindow;

public class Editor extends Canvas implements Runnable, MouseListener, MouseMotionListener{

	private static final long serialVersionUID = 1L;

	// Size in the main window
	public static final int WIDTH = 1024;
	public static final int HEIGHT = 576;
	
	private BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_ARGB);
	private boolean running = false;
	private Thread editor;
	
	private MainWindow window;
	private Map map;
	private int mouseX, mouseY;
	
	private int tileId;
	private int tileWidth = 32, tileHeight = 32;
	
	// Brush Images
	private BufferedImage tileImage;
	private BufferedImage brushImage;
	
	public Editor(MainWindow window) {
		this.window = window;
	}
	
	public void init() {
		addMouseListener(this);
		addMouseMotionListener(this);
		map = new Map(WIDTH, HEIGHT, window, this);
		map.createEmptyMap();
	}
	
	public synchronized void start() {
		if (running)
			return;
		running = true;
		editor = new Thread(this);
		editor.start();
	}
	
	public synchronized void stop() {
		running = false;
		if (editor != null) {
			try {
				editor.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	@Override
	public void run() {
		init();
		// Don't need game loop here because updates doesnt matter
		while (running) {
			render();
		}
		
	}
	
	public void render() {
		BufferStrategy bs = this.getBufferStrategy();

		if (bs == null) {
			this.createBufferStrategy(3);
			return;
		}

		Graphics2D g = (Graphics2D) bs.getDrawGraphics();
		// ///////////////////////////////
		// DRAW HERE
		g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
		g.setColor(new Color(0x4d648d));
		g.fillRect(0, 0, getWidth(), getHeight());
		map.render(g);
		// ///////////////////////////////
		g.dispose();
		bs.show();
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

	public int getTileId() {
		return tileId;
	}

	public void setTileId(int tileId) {
		this.tileId = tileId;
	}
	
	public BufferedImage getTileImage() {
		return tileImage;
	}

	public void setTileImage(BufferedImage tileImage) {
		this.tileImage = tileImage;
	}

	public BufferedImage getBrushImage() {
		return brushImage;
	}

	public void setBrushImage(BufferedImage brushImage) {
		this.brushImage = brushImage;
	}

	public Map getMap() {
		return map;
	}

	public void setMap(Map map) {
		this.map = map;
	}
	
	public int getMouseX() {
		return mouseX;
	}

	public int getMouseY() {
		return mouseY;
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		mouseX = e.getX();
		mouseY = e.getY();
		System.out.println("Mouse X: " + mouseX + "\t Mouse Y: " + mouseY);
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		mouseX = e.getX();
		mouseY = e.getY();
		System.out.println("Mouse X: " + mouseX + "\t Mouse Y: " + mouseY);
		for (Tile tile : map.tiles) {
			tile.mouseMoved(e);
		}
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	

}
