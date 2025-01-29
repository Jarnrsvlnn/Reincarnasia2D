package main;

public class Game implements Runnable{
	
	//declaring the necessary objects and set to private so it can only be accessed inside the game class
	private GameWindow gameWindow;
	private GamePanel gamePanel;
	private Thread gameThread;
	private final int FPS_SET = 120;
	
	public Game() {//game constructor for when calling Game object, it'll run all its objects inside
		gamePanel = new GamePanel();//aka the canvas for our painting(content)
		gameWindow = new GameWindow(gamePanel);//the game frame, contains the gamePanel object which contains all the functionalities
		gamePanel.requestFocus();
		startGameLoop();
	}
	
	private void startGameLoop() {
		gameThread = new Thread(this);
	}

	public void run() {
		double timePerFrame = 1000000000.0 / FPS_SET;
		long lastFrame = System.nanoTime();
		long timeNow = System.nanoTime();
		
		
		while(true) {
			
			
			timeNow = System.nanoTime();
			if(timeNow - lastFrame >=timePerFrame) {
				gamePanel.repaint();
				lastFrame = timeNow;
			}
			
		}
		
	}
}
