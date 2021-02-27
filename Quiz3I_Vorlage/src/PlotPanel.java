// Ich bestaetige, dass ich diese Pruefung selbstaendig geloest habe.
// Ich weiss, dass bei Zuwiderhandlung die Note 1 erteilt wird.
//
// Name:
// Vorname:
//
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

public class PlotPanel extends JPanel  {

	private double[] signal = {};

	public PlotPanel() {
		
	}
 
	@Override
	/**
	 * <pre>
	 * - Erzeugt lokale Ganzzahl-Arrays x und y mit gleicher Länge wie das Signal signal.
	 * 
	 * - Für k gleich Null bis kleiner der Länge von x:
	 *   - x an der Stelle k gleich  k setzen.
	 *   - y an der Stelle k gleich dem Ganzzahlanteil von 200 minus 100 mal dem Signal an der Stelle k setzen.
	 *
	 * - Farbe von Graphics g gleich Schwarz setzen.
	 * - Mittels ((Graphics2D) g).setStroke(new BasicStroke(1)) die Strichdicke auf 1 setzen.
	 * - Achsen mittels drawLine() zeichnen.
	 *   
	 * - Farbe von Graphics g gleich Blau setzen.
	 * - Mittels ((Graphics2D) g).setStroke(new BasicStroke(3)) die Strichdicke auf 3 setzen.
	 * - Mittels drawPolyline() den Plot zeichnen.
	 * 
	 * </pre>
	 */
	public void paintComponent(Graphics g) {

		super.paintComponent(g);

		int[] x = new int[signal.length];
		int[] y = new int[signal.length];
		for (int k = 0; k < x.length; k++) {
			x[k] = k;
			y[k] = (int) (200 - 100 * signal[k]);
		}

		g.setColor(Color.black);
		((Graphics2D) g).setStroke(new BasicStroke(1));

		g.drawLine(0, 200, 625, 200); // x Achse
		g.drawLine(0, 0, 0, 400); // y Achse

		g.setColor(Color.blue);
		((Graphics2D) g).setStroke(new BasicStroke(3));

		g.drawPolyline(x, y, x.length);

	}

	public void setSignal(double[] signal) {

		this.signal = signal;
	}

	

	

}
