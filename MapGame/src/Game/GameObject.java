package Game;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

public abstract class GameObject {
	
	protected int x, y;
	protected int sizex, sizey;
	protected ID id;
	protected int velX, velY;
	protected int degrees;
	protected Image image;
	protected int targetX, targetY;
	
	public GameObject(int x, int y, int sizex, int sizey, ID id) {
		this.x = x;
		this.y = y;
		this.sizex = sizex;
		this.sizey = sizey;
		this.id = id;
	}
	
	public abstract void tick(Handler handler);
	public abstract void render(Graphics g);
	
	public Rectangle getBounds(){
		return new Rectangle(x, y, sizex, sizey);
	}
	
	public void setX(int x) {
		this.x = x;
	}
	public void setY(int y) {
		this.y = y;	
	}
	
	public int getX() {return x;}
	public int getY() {return y;}
	
	public void setID(ID id) {this.id = id;}
	public ID getID() {return id;}
	
	public void setVelX(int velX) {this.velX = velX;}
	public void setVelY(int velY) {this.velY = velY;}
	
	public int getVelX() {return velX;}
	public int getVelY() {return velY;}
	
	public int getSizeX() {return sizex;}
	public int getSizeY() {return sizey;}
	
	public void setSizeX(int sizex) {this.sizex = sizex;}
	public void setSizeY(int sizey) {this.sizey = sizey;}
	
	public void setDegrees(int degrees) {this.degrees = degrees;}
	public int getDegrees() {return degrees;}
	
	public Image getImage() {return image;}
	public void setImage(Image image) {this.image = image;}
	
	public void setTargetX(int targetX) {this.targetX = targetX;}
	public void setTargetY(int targetY) {this.targetY = targetY;}
	
	public int getTargetX() {return targetX;}
	public int getTargetY() {return targetY;}
	
	public int getCenterX() {return x + sizex/2;}
	public int getCenterY() {return y + sizey/2;}
	
}
