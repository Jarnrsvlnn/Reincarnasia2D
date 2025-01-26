package main;

import java.awt.Graphics;

import javax.swing.JPanel;

import inputs.KeyboardInputs;
import inputs.MouseInputs;

public class GamePanel extends JPanel{
	
	private MouseInputs mouseInputs;
	public int xDelta = 100, yDelta = 100;
	private int frames = 0;
	private long lastCheck = 0;
	
	
	//game panel acts as the content inside our frame (JFrame)
	public GamePanel() {
		
		mouseInputs = new MouseInputs(this);
		setFocusable(true);
		requestFocusInWindow();
		addKeyListener(new KeyboardInputs(this));
		addMouseListener(mouseInputs);
		addMouseMotionListener(mouseInputs);
	}
	
	public void changeXDelta(int value) {
		this.xDelta += value;
		repaint();
	}
	
	public void changeYDelta(int value) {
		this.yDelta += value;
		repaint();
	}
	public void setRectPos(int x, int y) {
		this.xDelta = x;
		this.yDelta = y;
		repaint();
	}
	
	//graphics allows us to draw on a JPanel
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		g.fillRect(xDelta, yDelta, 200, 50);
		
		frames++;
		if(System.currentTimeMillis() - lastCheck >= 1000) {
			lastCheck = System.currentTimeMillis();
			System.out.println("FPS: " + frames);
			frames = 0;
		}
		repaint();
	}
}
	