package Game;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;


public class Window{

	public Window(int width, int height, String title, Game game) {
		JFrame frame = new JFrame(title);
		frame.setSize(Toolkit.getDefaultToolkit().getScreenSize());
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.add(game);
		frame.setVisible(true);
	}
}
