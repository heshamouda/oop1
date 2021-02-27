package lib;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import engine.Engine;

public class App {
	private static final Dimension DIMEN = new Dimension(800, 600);

	private final JFrame frame;
	private final JPanel panel;

	private final Sprite rocketIdle = new Sprite("rocket-idle.png", null);
	private final Sprite rocketExhaust = new Sprite("rocket-exhaust.png", null);
	private final Sprite space = new Sprite("space.jpg", null);
	private final Rocket rocket = new Rocket();

	private void setX(int x) {
		rocketIdle.setX(x);
		rocketExhaust.setX(x);
	}

	private void setY(int y) {
		rocketIdle.setY(y);
		rocketExhaust.setY(y);
	}

	private void setRot(double rot) {
		rocketIdle.setRot(rot);
		rocketExhaust.setRot(rot);
	}

	public App() throws IOException {
		rocketIdle.setX(350);
		rocketExhaust.setX(350);

		panel = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);

				Graphics2D g2d = (Graphics2D) g;

				g.setColor(Color.BLACK);
				g.fillRect(0, 0, getWidth(), getHeight());

				space.draw(g2d);

				if (rocket.getGasOutletLevel() > 0) {
					rocketExhaust.draw(g2d);
					rocket.setGasOutletLevel(0);
				} else {
					rocketIdle.draw(g2d);
				}
				
			    Toolkit.getDefaultToolkit().sync();

			}
		};
		panel.setPreferredSize(DIMEN);
		frame = new JFrame("Java Rocket Start");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setContentPane(panel);
		frame.setSize(DIMEN);
		frame.setLocationRelativeTo(null); // launch centered
		frame.setVisible(true);

		frame.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {

			}

			@Override
			public void keyReleased(KeyEvent e) {

			}

			@Override
			public void keyPressed(KeyEvent e) {
				switch (e.getKeyCode()) {
				case KeyEvent.VK_RIGHT:
					Engine.turnRight(rocket);
					setRot(rocket.getRotation());
					break;
				case KeyEvent.VK_LEFT:
					Engine.turnLeft(rocket);
					setRot(rocket.getRotation());
					break;
				case KeyEvent.VK_SPACE:
					Engine.gas(rocket);
				default:
					break;
				}
			}
		});
		panel.repaint();

		new Thread(new Runnable() {
			@Override
			public void run() {
				for (;;) {

					try {
						if (rocketIdle.getY() < panel.getHeight() - rocketIdle.getHeight()) {
							setY(rocketIdle.getY() + 2);
						}
						if (rocket.getRotation() != 0) {
							double dy = Math.cos(rocket.getRotation()) * rocket.getGasOutletLevel();
							double dx = Math.sin(rocket.getRotation()) * rocket.getGasOutletLevel();
							setY((int) (rocketIdle.getY() - dy));
							setX((int) (rocketIdle.getX() + dx));
						} else {
							setY(rocketIdle.getY() - rocket.getGasOutletLevel());

						}
						panel.repaint();
						
						Thread.sleep(16);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}

			}
		}).start();
	}
}
