package oscilloscope.display;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.FontFormatException;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;
import java.io.IOException;

import javax.swing.JFrame;

import oscilloscope.frame.Frame;
import oscilloscope.schedule.Render;
import oscilloscope.schedule.Update;


public class Display extends Canvas implements Runnable{

	
	private static final long serialVersionUID = 1L;
	public static int tickspeed = 20;
	public static  JFrame frame;
	private Thread thread;
	private static boolean running = false;
	public static long startTime;
	static long endTime;
	public static Display display = new Display();
	public static Graphics2D g;
	
	public static void displaySetup() {
		frame = new Frame();
	}
	
	public Display() {
		Dimension size = new Dimension(WIDTH, HEIGHT);
		this.setPreferredSize(size);
	}
	
	public synchronized void start() {
		running = true;
		this.thread = new Thread(this, "Display");
		this.thread.start();
		
	}
	
	public synchronized void stop() {
		running = false;
		try {
			this.thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void run() {
		long lastTime = System.nanoTime();
		long timer = System.currentTimeMillis();
		final double ns = 1000000000.0 / tickspeed;
		@SuppressWarnings("unused")
		double delta = 0;
		@SuppressWarnings("unused")
		int frames = 0;
		
		while(running) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			update();
				try {
					render();
				} catch (FontFormatException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		
			frames++;
			if(System.currentTimeMillis() - timer > 1000) {
				timer += 10;
				Display.frame.setTitle("Plotter ");
				frames = 0;
			}
		}stop();
	}
	
	private void render() throws FontFormatException, IOException {
		BufferStrategy bs = this.getBufferStrategy();
		if(bs==null) {
			this.createBufferStrategy(2);
			return;
		}
	    g = (Graphics2D) bs.getDrawGraphics();
	    
		Render.render();
		g.dispose();
		bs.show();
		
	}
	
	private void update() {
		Update.update();
	}

	
	
	
	
	
}