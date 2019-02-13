package Game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class TownMenu extends GameObject{
	private boolean state;
	private String townName;
	
	public TownMenu(int x, int y, int sizex, int sizey, ID id, String townName) {
		super(x, y, sizex, sizey, id);
		this.townName = townName;
		state = true;
	}

	public void setState(boolean state){this.state = state;}
	public boolean getState() {return state;}

	@Override
	public void tick(Handler handler) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		
		g.setColor(Color.DARK_GRAY);
		g.fillRect(x + Game.WIDTH/4, y + Game.HEIGHT/16, sizex, sizey);
		g.setColor(Color.BLACK);
		
		g2d.setFont(new Font("TimesRoman", Font.PLAIN, 64));
		
		int placeX = x+(Game.WIDTH/2);
		int placeY = y+Game.HEIGHT/8;
		
		g2d.drawString(townName, placeX-(townName.length()*16), placeY);
		
		g2d.setColor(Color.gray);
		g2d.fillRect(placeX-placeX/2, placeY+64, sizex+x, 64);
		
		String str = "Buy/Sell Goods";
		
		g2d.setColor(Color.BLACK);
		g2d.drawString(str, x+(x/2)+(str.length()*32), placeY+114);
	}
}
