package main;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import javax.swing.JPanel;

import inputs.KeyboardInputs;
import inputs.MouseInputs;

public class GamePanel extends JPanel{
	
	private MouseInputs mouseInputs;
	public float xDelta = 100, yDelta = 100;//handles the position of our character
	private float xDir = 0.1f, yDir = 0.1f;
	private int frames = 0;
	private long lastCheck = 0;
	private Color color = new Color(15, 20, 90);
	private Random random;
	
	
	//game panel acts as the content inside our frame (JFrame)
	public GamePanel() {
		
		random = new Random();
		mouseInputs = new MouseInputs(this);//"this" is a way of telling GamePanel that an event has occurred in mouseinputs
		setFocusable(true);
		requestFocusInWindow();
		addKeyListener(new KeyboardInputs(this));//same as mouse inputs
		addMouseListener(mouseInputs);
		addMouseMotionListener(mouseInputs);
	}
	
	//this method initializes the position of the player based from the value taken (keyboard)
	public void changeXDelta(int value) {
		this.xDelta += value;
		repaint();
	}
	
	public void changeYDelta(int value) {
		this.yDelta += value;
		repaint();
	}
	//this method is similar to the method above but for mouse inputs
	public void setRectPos(int x, int y) {
		this.xDelta = x;
		this.yDelta = y;
		repaint();
	}
	
	//this method containing graphics allows us to draw on our canvas(JPanel0/GamePanel)
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		//pre-defined methods of the graphics object
		updateRectangle();
		g.setColor(color);
		g.fillRect((int)xDelta, (int)yDelta, 200, 50);
		
		//FPS handlers
		frames++;
		if(System.currentTimeMillis() - lastCheck >= 1000) {
			lastCheck = System.currentTimeMillis();
			System.out.println("FPS: " + frames);
			frames = 0;
		}
		repaint();
	}
	
	public void updateRectangle() {
		//checks if the position of the character is within our width and height value
		xDelta += xDir;
		if(xDelta > 400 || xDelta < 0) {
			//if xDelta(x position) > 400 || < 0,
			xDir*=-1;//then this will reverse the direction(if xDelta == 401 and xDir is 1 then xDir will become negative and decrease/reverse the xDelta's direction
			color = getRndColor();
		}

		
		yDelta += yDir;
		if(yDir > 400 || yDelta < 0) {
			yDir*=-1;
			color = getRndColor();
		}
	}

	private Color getRndColor() {
		int r = random.nextInt(255);
		int g = random.nextInt(255);
		int b = random.nextInt(255);
		
		return new Color(r, g, b);
	}
}
	