package Game;

import java.awt.Color;
import java.awt.Graphics;

public class Town extends GameObject{

	public boolean selected;
	
	public Town(int x, int y, int sizex, int sizey, ID id) {
		super(x, y, sizex, sizey, id);
		selected = false;
	}

	@Override
	public void tick(Handler handler) {
		
		
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.gray);
		g.fillRect(x, y, sizex, sizey);
		
	}
	
	public boolean getSelected(){return selected;}
	public void setSelected(boolean selected){this.selected = selected;}
	
}
