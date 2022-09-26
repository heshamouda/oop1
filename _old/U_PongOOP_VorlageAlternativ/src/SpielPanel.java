import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;

public class SpielPanel extends JPanel implements SimpleTimerListener, KeyListener {

	private SimpleTimer timer;
	private Ball ball;
	private Schlaeger schlaeger;

	private boolean stop = false;

	/**
	 * <pre>
	 * - ball erzeugen mit new Ball(150, 350, zufall(-10, -5), zufall(-5, -1), Utility.loadResourceImage("ball.png", 50, 50));
	 * - schlaeger erzeugen mit new Schlaeger(900, 300, Utility.loadResourceImage("schlaeger.png", 25, 100));
	 * - timer mit Periode 20 erzeugen und starten
	 * - KeyListener an Klasse registrieren
	 * </pre>
	 */
	public SpielPanel() {
//		ball = new Ball(150, 300, -2, -2, Utility.loadResourceImage("ball.png", 50, 50));//Testball
		ball = new Ball(150, 350, zufall(-10, -5), zufall(-5, -1), Utility.loadResourceImage("ball.png", 50, 50));
		schlaeger = new Schlaeger(900, 300, Utility.loadResourceImage("schlaeger.png", 25, 100));
		timer = new SimpleTimer(20, this);
		timer.start();
		addKeyListener(this);

	}

	/**
	 * <pre>
	 * - falls KeyEvent VK_UP
	 * 		- y Position von Schlaeger um 20 reduzieren
	 * - falls KeyEvent VK_DOWN
	 * 		- y Position von Schlaeger um 20 reduzieren
	 * - falls y Position grösser 545 
	 * 		- y Position begrenzen
	 * - falls y Position kleiner 55 
	 * 		- y Position begrenzen 
	 * - Neuzeichnen auslösen
	 * </pre>
	 */
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			schlaeger.y -= 20;
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			// schlaeger.y += 20;
			schlaeger.setPosition(schlaeger.x, schlaeger.y + 20); // Ausführung mit setPosition() Methode
		}
		if (schlaeger.y > 545) {
			schlaeger.y = 545;
		}
		if (schlaeger.y < 55) {
			schlaeger.y = 55;
		}
		repaint();

	}
	public void keyReleased(KeyEvent e) {
	}

	public void keyTyped(KeyEvent e) {
	}

	/**
	 * <pre>
	 * - falls nicht stop
	 * 		- ball updaten
	 * 		- auf Kollision testen (Methode aufrufen)
	 * 		- falls ball ausserhalb Spielfeld (mit rect überprüfen)
	 * 			- neuen ball mit zufälliger Geschwindigkeit erzeugen
	 * 		- Neuzeichnen auslösen
	 * </pre>
	 */
	public void timerAction() {
		if (!stop) {
			ball.update();
			schlaeger.kollisionTesten(ball);
			if (ball.x > ball.rect.x + ball.rect.width - ball.breite / 2) {
				// ausserhalb Spielfeld: erzeuge neuen Ball
				ball = new Ball(150, 350, zufall(-10, -5), zufall(-5, -1),
						Utility.loadResourceImage("ball.png", 50, 50));
			}
			repaint();
		}

	}



	/**
	 * <pre>
	 * - ball anzeigen
	 * - schlaeger anzeigen
	 * </pre>
	 */
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		ball.anzeigen(g);
		schlaeger.anzeigen(g);

		

	}

	/**
	 * <pre>
	 * - Attribut setzen
	 * </pre>
	 */
	public void setStop(Boolean stop) {
		this.stop= stop;

	}

	/**
	 * <pre>
	 * - Zufallszahl zwischen von und bis zurückgeben
	 * </pre>
	 */
	protected int zufall(int von, int bis) {
		return (int) (von+ (bis-von+1)*Math.random()); //damit Compiler glücklich
		
	}

}
