package ca.tran.editor;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import javax.swing.JOptionPane;

public class Editor extends Canvas implements Runnable{

	private static final long serialVersionUID = 1L;
	public static final int WIDTH = 1000;
	public static final int HEIGHT = 800;
	
	private BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_ARGB);
	private boolean running = false;
	private Thread editor;
	
	public Editor() {
		System.out.println("Initialized Editor Canvas.");
	}
	
	public void init() {
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
		System.out.println("Rendering to canvas.");
		BufferStrategy bs = this.getBufferStrategy();

		if (bs == null) {
			this.createBufferStrategy(3);
			return;
		}

		Graphics2D g = (Graphics2D) bs.getDrawGraphics();
		// ///////////////////////////////
		// DRAW HERE
		g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, getWidth(), getHeight());
		// ///////////////////////////////
		g.dispose();
		bs.show();
	}

}
