package Game;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.MouseInfo;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;



public class Handler {
	ArrayList <GameObject> object = new ArrayList<GameObject>();
	ArrayList <GameObject> tempObject = new ArrayList<GameObject>();
	private boolean menuOpen;
	
	public Handler(){
		menuOpen = false;
	}
	
	
	public void tick() {
		for(int i = 0; i < object.size(); i++) {
			GameObject tempObject = object.get(i);
			tempObject.tick(this);
		}
	}
	
	public void render(Graphics g) {
		for(int i = 0; i < object.size(); i++) {
			GameObject tempObject =object.get(i);
			tempObject.render(g);
		}

	}
	
	public void addObject(GameObject object) {
		this.object.add(object);
	}
	
	public void removeObject(GameObject object) {
		this.object.remove(object);
	}
	
	public void createMap(Game game) {
		
		for(int i = 0; i < 10; i++) {
			for(int j = 0; j < 10; j++) {
				addObject(new MapBlocks(i*64, j*64, 64, 64, ID.MapBlocks));
			}
		}
		
		Town town1 = new Town(192, 192, 64, 64, ID.Town);
		
		addObject(new Town(192, 192, 64, 64, ID.Town));
		
		
		addObject(new Boundry(0, 0, 640, 640, ID.Boundry));
	}
	
	public void makeMenu(){
		menuOpen = true;
		
		tempObject = object;
		object = new ArrayList<GameObject>();
		int x = (int)-Game.camX;
		int y = (int)-Game.camY;
		
		addObject(new TownMenu(x, y, 1000, 1000, ID.TownMenu, "Town12345"));
		
		return;
	}
	public void closeMenu(){
		menuOpen = false;
		return;
	}
	public boolean isMenuOpen(){return menuOpen;}
}
