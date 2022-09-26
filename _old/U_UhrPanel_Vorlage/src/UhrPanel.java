import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;

public class UhrPanel extends JPanel implements SimpleTimerListener {

	private static final long serialVersionUID = 1L;
	private Uhr clock = new Uhr(10, 10);
//	private Segment test1= new Segment(100, 100, Segment.HORIZONTAL);
//	private Segment test2= new Segment(150, 100, Segment.VERTIKAL);
//	private SiebenSegment test = new SiebenSegment(40, 40);

	private SimpleTimer timer;

	/**
	 * <pre>
	 * - erzeugt timer mit Periode 1000 und startet ihn
	 * </pre>
	 */
	public UhrPanel() {
		timer = new SimpleTimer(1000,this);
		timer.start();

	}

	/**
	 * <pre>
	 * - setzt Hintergrundfarbe schwarz
	 * - zeigt Uhr an
	 * </pre>
	 */
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		setBackground(Color.black);
//		test1.anzeigen(g);
//		test2.anzeigen(g);
//		test.setzeWert(6);
//		test.anzeigen(g);
		clock.display(g);

	}

	/**
	 * <pre>
	 * - Setzt Zeit der Uhr
	 * - Neuzeichnen auslösen
	 * </pre>
	 */
	public void timerAction() {
		clock.setTime();
		repaint();


	}
}
