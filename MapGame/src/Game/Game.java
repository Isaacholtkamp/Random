package Game;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;




public class Game extends Canvas implements Runnable{
	
	public static int WIDTH;
	public static int HEIGHT;
	public static int MapDim;
	public static float camX, camY;
	
	public String title = "Zombie Game";
	private Thread thread;
	private boolean isRunning = false;
	
	private Handler handler;
	private Camera cam;
	
	public Game(){
		handler = new Handler();
		cam = new Camera(0, 0);
		camX = camY = 0;
		
		//this.addKeyListener(new KeyInput(handler));
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		WIDTH = screenSize.width;
		HEIGHT = screenSize.height;
		MapDim = 64*64;
		new Window(WIDTH, HEIGHT, title, this);
		start();
		
		handler.createMap(this);
		
		Player player = new Player(128, 128, 64, 64, ID.Player);
		
		handler.addObject(player);
		this.addMouseListener(new MouseClick(handler, player));
	
		
	}
	

	@Override
	public void run() {
		this.requestFocus();
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int frames = 0;
		while(isRunning) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while(delta >= 1) {
				tick();
				delta--;
			}
			render();
			frames++;
			
			if(System.currentTimeMillis() - timer > 1000) {
				timer+=1000;
				frames = 0;
			}
		}
		stop();
	}
	
	private void tick() {
		handler.tick();
		for(int i = 0; i < handler.object.size(); i++) {
			if(handler.object.get(i).getID() == ID.Player) {
				cam.tick(handler.object.get(i));
			}
		}
	}
	
	private void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if(bs == null) {
			this.createBufferStrategy(3);
			return;
		}
		
		Graphics g = bs.getDrawGraphics();
		
		Graphics2D g2d = (Graphics2D) g;
		
		g.setColor(Color.black);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		camX = cam.getX();
		camY = cam.getY();
		g2d.translate(camX, camY);
		handler.render(g);
		g2d.translate(-camX, -camY);
		bs.show();
		g.dispose();
	}
	
	
	private synchronized void start() {
		if(isRunning) return;
		
		thread = new Thread(this);
		thread.start();
		isRunning = true;
		
	}
	
	private synchronized void stop() {
		if(!isRunning) return;
		
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		isRunning = false;
	}
	
	
	public static void main(String args[]) {
		 new Game();
		
	}
}
