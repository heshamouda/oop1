import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.nio.file.FileAlreadyExistsException;

import javax.swing.JButton;

import util.ActivePanel;

public class PongBallPanel extends ActivePanel {

	private static final long serialVersionUID = 1L;

	static final int BALL_RADIUS = 20;
	static final double VELOCITY= 5;

	double x, y;
	double vx , vy; // Geschwindigkeit

	void drawBall(int x, int y, Color color, Graphics g) {
		g.setColor(color);
		g.fillOval(x - BALL_RADIUS / 2, y - BALL_RADIUS, BALL_RADIUS, BALL_RADIUS);

	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.black);
		g.fillRect(0, 0, getWidth(), getHeight());

		// method aufrufen

		drawBall((int) Math.round(x), (int) Math.round(y), Color.white, g);
	}

	@Override
	public void onInit() {
		
		x = getWidth() / 2;
		y = getHeight() / 2;
		
		vx= 0;
		vy= 0;

//		 repaint(); // to force paintComponent aufrufen

	}

	@Override
	public void onKeyDown(int keyCode) {
		System.out.println("Key Down" + keyCode);

		if (keyCode == KeyEvent.VK_UP || keyCode == KeyEvent.VK_W) {
			y = y - 10;
		} else if (keyCode == KeyEvent.VK_DOWN || keyCode == KeyEvent.VK_Y) {
			y = y + 10;
		} else if (keyCode == KeyEvent.VK_LEFT || keyCode == KeyEvent.VK_S) {
			x= x-10;
		} else if (keyCode == KeyEvent.VK_RIGHT || keyCode == KeyEvent.VK_D) {
			 x= x+10;
		} else if (keyCode == KeyEvent.VK_SPACE) {
			
//			vx= (int) (5 * Math.random() - 2); // -1 -2 0 1 2
//			vy= (int) (5* Math.random() - 2); // -1 -2 0 1 2
			double alpha= Math.random()*2 * Math.PI;
			 			
			vx= Math.cos(alpha)* VELOCITY;
			vy= Math.sin(alpha)* VELOCITY;
			
			x= getWidth()/2;
			y= getHeight()/2;
			
		}
		repaint();

	}
	
	@Override
	public void onTick() {
		
		if (x>= getWidth() || x <= 0) {
			vx *= -1;
		}  
		
		if (y >= getHeight() || y <= 0) {
			vy *= -1;
		} 
		x +=vx;
		y +=vy;
		 repaint();
	
	}
}
