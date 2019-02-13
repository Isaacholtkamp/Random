package Game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.io.InputStream;
import java.util.Scanner;

public class Player extends GameObject {

	public Player(int x, int y, int sizex, int sizey, ID id) {
		super(x, y, sizex, sizey, id);
		targetX = 0;
		targetY = 0;
	}

	@Override
	public void tick(Handler handler) {
		if(targetX > 0){
			x++;
			targetX--;
		}else if(targetX < 0) {
			x--;
			targetX++;
		}else {
			//System.out.println(x+centerX);
		}
		if(targetY > 0) {
			y++;
			targetY--;
		}else if(targetY < 0) {
			y--;
			targetY++;
		}else {
			//System.out.println(y+centerY);
		}
		
		Collision(handler);
		
	}
	
	private void Collision(Handler handler){
		int choice = -1;
		Scanner scan = new Scanner(System.in);
		
		for(int i = 0; i < handler.object.size(); i++){
			GameObject object = handler.object.get(i);
			if(object.getID() == ID.Boundry){
				if(x < object.getX()){
					this.targetX = 0;
					this.setX(object.getX()+1);
				}else if(x > object.getSizeX() + object.getX() - this.sizex){
					this.targetX = 0;
					this.setX(object.getSizeX() + object.getX() - this.sizex);
				}
				if(y < object.getY()){
					this.targetY = 0;
					this.setY(object.getY()+1);
				}else if(y > object.getSizeY() + object.getY() - this.sizey){
					this.targetY = 0;
					this.setY(object.getSizeY() + object.getY() - this.sizey);
				}
			}
			
			if(object.getID() == ID.Town){
				Town temp = (Town) object;
				if(temp.getSelected() == true){
					if(this.targetX == 0 && this.targetY == 0){
						System.out.println("in town");
						temp.setSelected(false);
						handler.makeMenu();
					}
				}
			}	
		}
	}


	@Override
	public void render(Graphics g) {
		g.setColor(Color.red);
		g.fillRect(x, y, sizex, sizey);
	}

}
