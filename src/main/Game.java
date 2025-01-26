package main;

public class Game {
	
	//declaring the necessary objects and set to private so it can only be accessed inside the game class
	private GameWindow gameWindow;
	private GamePanel gamePanel;
	
	public Game() {//game constructor for when calling Game object, it'll run all its objects inside
		gamePanel = new GamePanel();//aka the canvas for our painting(content)
		gameWindow = new GameWindow(gamePanel);//the game frame, contains the gamePanel object which contains all the functionalities
		gamePanel.requestFocus();
	}
}
