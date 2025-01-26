package main;

import javax.swing.JFrame;

public class GameWindow extends JFrame{
	private JFrame jframe;
	//JFrame will act as a frame for our game
	//set the parameter to gamepanel so that the game panel will run inside the window
	public GameWindow(GamePanel gamePanel) {
		jframe = new JFrame();
		
		jframe.setSize(400, 400);
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jframe.setLocationRelativeTo(null);
		jframe.add(gamePanel);
		jframe.setVisible(true);
	}
}
	