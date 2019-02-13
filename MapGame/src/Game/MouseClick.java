package Game;

import java.awt.MouseInfo;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseClick implements MouseListener{

	private Handler handler;
	private GameObject player;
	
	public MouseClick(Handler handler, GameObject player) {
		this.handler = handler;
		this.player = player;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		int mouseX = e.getX();
		int mouseY = e.getY();
		int targetX = mouseX - Game.WIDTH/2 - 32;
		int targetY = mouseY - Game.HEIGHT/2 - 32;
		player.setTargetX(targetX);
		player.setTargetY(targetY);
		
		
		if(handler.isMenuOpen()){
			
		}else{
			
			for(int i = 0; i < handler.object.size(); i++) {
				GameObject temp = handler.object.get(i);
				if(temp.getID() == ID.Town){
					Town t = (Town) temp;
					
					
					
					
					if(targetX + player.getCenterX() > temp.getX() + 10 && targetX + player.getCenterX() < temp.getX() + temp.getSizeX() - 10){
						if(targetY + player.getCenterY() > temp.getY() + 10 && targetY + player.getCenterY() < temp.getY() + temp.getSizeY() - 10){
							t.setSelected(true);
						}
					}
					temp = t;
				}
			}
		}
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
		
		
	}
	
}
