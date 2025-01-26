package main;

import javax.swing.JFrame;

public class GameWindow extends JFrame{ 
	private JFrame jframe;
	//JFrame will act as a frame for our game
	//set the parameter to gamepanel so that the game panel will run inside the window
	public GameWindow(GamePanel gamePanel) {//constructor containing the gamepanel inside the parameter for adding
		jframe = new JFrame();
		
		jframe.setSize(400, 400);
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//sets the window so that it exits when x is clicked
		jframe.setLocationRelativeTo(null);//sets the default location of the window to the center of the screen
		jframe.add(gamePanel);//adds the game panel/our canvas into our frame (JFrame)
		jframe.setVisible(true);//sets the window visible
	}
}
	