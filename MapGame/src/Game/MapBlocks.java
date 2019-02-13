package Game;

import java.awt.Color;
import java.awt.Graphics;

public class MapBlocks extends GameObject{

	public MapBlocks(int x, int y, int sizex, int sizey, ID id) {
		super(x, y, sizex, sizey, id);
	}

	@Override
	public void tick(Handler handler) {
		
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.white);
		g.drawRect(x, y, sizex, sizey);
	}

}
