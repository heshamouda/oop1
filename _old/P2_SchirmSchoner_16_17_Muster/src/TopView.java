
// Name: 
// Vorname:

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JPanel;

public class TopView extends JPanel implements SimpleTimerListener, MouseMotionListener {
	// 21
	private Uhr uhr;
	private KontrollPanel kontrollPanel;
	private int zaehler;
	private SimpleTimer timer = new SimpleTimer(1000, this);

	/**
	 * <pre>
	 * - Ruft den Konstruktor der Superklasse mit Argument null auf und setzt somit das null-Layout.
	 * - Setzt XSCALAR des GrafikObjekt gleich Breite durch 1920 und YSCALAR gleich Höhe durch 1080.
	 * - Erzeugt die Uhr mit Zeigerposition 1623,530.
	 * - Erzeugt das Kontroll-Panel und fügt es an geeigneter Stelle hinzu.
	 * - Registriert entsprechenden Listener.
	 * - Startet den Timer mittels start();
	 * </pre>
	 * 
	 * @param breite
	 * @param hoehe
	 */
	public TopView(int breite, int hoehe) {
		// 8
		super(null);
		GrafikObjekt.XSCALAR = breite / 1920.0;
		GrafikObjekt.YSCALAR = hoehe / 1080.0;
		uhr = new Uhr(1623, 530, breite, hoehe);
		kontrollPanel = new KontrollPanel(uhr, breite, hoehe);
		add(kontrollPanel).setBounds(0, hoehe-100, breite, 100);
		addMouseMotionListener(this);
		timer.start();
	}

	/**
	 * <pre>
	 * - ruft Methode setHighRenderQuality mit entsprechendem Argument auf.
	 * - ruft Anzeigen Methode der Uhr auf.
	 * </pre>
	 */
	public void paintComponent(Graphics g) {
		// 3
		super.paintComponent(g);
		setHighRenderQuality(g);
		uhr.anzeigen(g);
		
	}

	/**
	 * <pre>
	 * - Methode update() der Uhr aufrufen.
	 * - Falls zaehler gleich Null
	 *   - Kontroll-Panel mittels der Methode setVisible() unsichtbar machen.
	 *   - Den unsichtbaren Cursor mittels Utility.getInvisibleCursor() holen und mittels setCursor() setzen.
	 * - Sonst 
	 *   - zaehler dekrementieren.
	 * - Neuzeichnen auslösen.
	 * </pre>
	 */
	public void timerAction() {
		// 7
		uhr.update();
		if(zaehler == 0) {
			kontrollPanel.setVisible(false);
			setCursor(Utility.getInvisibleCursor());
		}
		else {
			zaehler--;
			
		}
		repaint();
		
	}

	/**
	 * <pre>
	 * - zaehler auf 10 setzen.
	 * - Kontroll-Panel mittels der Methode setVisible() sichtbar machen.
	 * - Den default Cursor mittels Utility holen und mittels setCursor() setzen.
	 * </pre>
	 */
	public void mouseMoved(MouseEvent arg0) {
		// 3
		zaehler = 10;
		kontrollPanel.setVisible(true);
		setCursor(Utility.getDefaultCursor());
	}

	public void mouseDragged(MouseEvent arg0) {
	}

	private void setHighRenderQuality(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
		g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		g2d.setRenderingHint(RenderingHints.KEY_ALPHA_INTERPOLATION, RenderingHints.VALUE_ALPHA_INTERPOLATION_QUALITY);
		g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);
		g2d.setRenderingHint(RenderingHints.KEY_COLOR_RENDERING, RenderingHints.VALUE_COLOR_RENDER_QUALITY);
	}
}
