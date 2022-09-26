package util;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public abstract class ActivePanel extends JPanel {

	static final RenderingHints CONFIG = new RenderingHints(RenderingHints.KEY_ANTIALIASING,
			RenderingHints.VALUE_ANTIALIAS_ON);

	private static final long serialVersionUID = 1L;

	public ActivePanel() {
		new Timer(16, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				onTick();
			}
		}).start();

		addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				onMouseUp(e.getX(), e.getY());
			}

			@Override
			public void mousePressed(MouseEvent e) {
				onMouseDown(e.getX(), e.getY());
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// ignore
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// ignore
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// ignore
			}
		});

		addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyReleased(KeyEvent e) {
				onKeyUp(e.getKeyCode());
			}

			@Override
			public void keyPressed(KeyEvent e) {
				onKeyDown(e.getKeyCode());
			}
		});
	}

	/**
	 * repaints and syncs graphics pipeline
	 * 
	 */
	@Override
	public void repaint() {
		// TODO Auto-generated method stub
		super.repaint();
		Toolkit.getDefaultToolkit().sync();
	}

	/**
	 * Wird alle 16 ms ausgeführt. Später wird ein repaint ausgeführt.
	 */
	public void onTick() {

	}

	/**
	 * Wird ausgeführt, wenn die linke Maustaste nach unten gedrückt wird. Später
	 * wird ein repaint ausgeführt.
	 * 
	 * @param x x Koordinate des Mouseclicks
	 * @param y y Koordinate des Mouseclicks
	 */
	public void onMouseDown(int x, int y) {

	}

	/**
	 * Wird ausgeführt, wenn die linke Maustaste losgelassen wird. Später wird ein
	 * repaint ausgeführt.
	 * 
	 * @param x x Koordinate des Mouseclicks
	 * @param y y Koordinate des Mouseclicks
	 */
	public void onMouseUp(int x, int y) {

	}

	/**
	 * Wird ausgeführt nachdem das Fenster erstellt wurde.
	 */
	public void onInit() {

	}

	/**
	 * When Keyboard Key pressed down
	 * 
	 * @param keyCode check for instance if == KeyEvent.VK_LEFT
	 */
	public void onKeyDown(int keyCode) {

	}

	/**
	 * when Keyboard Key released
	 */
	public void onKeyUp(int keyCode) {

	}

	/**
	 * calls super and sets antialias
	 */
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		((Graphics2D) g).setRenderingHints(CONFIG);

	}
}
