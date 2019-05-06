package ca.tran.editor;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import javax.swing.JOptionPane;

public class Editor extends Canvas implements Runnable{

	private static final long serialVersionUID = 1L;
	public static int tileSize = 32;
	public static final int WIDTH = 1024;
	public static final int HEIGHT = 576;
	
	private BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_ARGB);
	private boolean running = false;
	private Thread editor;
	
	private Map map;
	
	public Editor() {
		System.out.println("Initialized Editor Canvas.");
	}
	
	public void init() {
		map = new Map(WIDTH, HEIGHT, tileSize);
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
		g.setColor(new Color(70, 70, 70));
		g.fillRect(0, 0, getWidth(), getHeight());
		map.render(g);
		// ///////////////////////////////
		g.dispose();
		bs.show();
	}

}
