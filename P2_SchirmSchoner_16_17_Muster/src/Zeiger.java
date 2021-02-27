import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Zeiger extends GrafikObjekt {
	// 5
	protected double winkel;
	protected int r;

	public Zeiger() {
	}

	/**
	 * <pre>
	 * - Entsprechenden Konstruktor der Superklasse aufrufen.
	 * - Attribut r gleich dem Minimum (Math.min) von r mal XSCALAR resp. r mal YSCALAR setzen.
	 * </pre>
	 * 
	 * @param x
	 * @param y
	 * @param r
	 */
	public Zeiger(int x, int y, int r) {
		// 2
		super(x,y);
		this.r = (int) Math.min(r * XSCALAR, r * YSCALAR);
		//this.r = (int) (r * Math.min(XSCALAR, YSCALAR));
	}

	/**
	 * <pre>
	 * - Entsprechendes Attribut setzen.
	 * </pre>
	 * 
	 * @param winkel
	 */
	public void setzeWinkel(double winkel) {
		// 1
		this.winkel = winkel;
	}

	/**
	 * <pre>
	 * - Zeiger mit drawLine mit Drehpunkt x,y und Radius r entsprechend Winkel zeichnen.
	 * - Kreis mit fillOval() mit Durchmesser 4 und Mitte bei x,y zeichnen.
	 * </pre>
	 */
	public void anzeigen(Graphics g) {
		// 2
		//g.drawLine(x, y, x + (int) (r * Math.sin(winkel)), y - (int) (r * Math.cos(winkel))); 
		g.drawLine(x, y, x + (int) (r * Math.sin(winkel)), y + (int) (-r * Math.cos(winkel)));
		//g.drawArc(x-2, y-2, 4, 4, 0, 360);//geht beides
		g.fillOval(x - 2, y - 2, 4, 4); // geht beides
	}
}

class StundenZeiger extends Zeiger {
	// 4

	/**
	 * Erzeugt via Konstruktor der Superklasse ein Objekt der Art StundenZeiger
	 * mit Position x, y und Radius r.
	 */
	public StundenZeiger(int x, int y, int r) {
		// 1
		super(x,y,r);
	}

	/**
	 * Setzt den Winkel (in Radiant!) des Zeigers entsprechend stunde mittels entsprechender Methode.
	 *
	 */
	public void setzeStunde(double stunde) {
		// 1
		
		setzeWinkel( 2.0 *Math.PI /12.0 * stunde);
//		winkel = 2.0 *Math.PI /12.0 * stunde;//geht auch
		
		
	}

	/**
	 * <pre>
	 * - Strichdicke mittels ((Graphics2D) g).setStroke(new BasicStroke(2.0f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
	 *   auf 2.0 setzen.
	 * - Methode anzeigen() der Superklasse aufrufen.
	 * </pre>
	 */
	public void anzeigen(Graphics g) {
		// 2
		((Graphics2D) g).setStroke(new BasicStroke(2.0f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
		super.anzeigen(g);
		
	}

}

class MinutenZeiger extends Zeiger {
	// 4

	/**
	 * Erzeugt via Konstruktor der Superklasse ein Objekt der Art MinutenZeiger
	 * mit Position x, y und Radius r.
	 */
	public MinutenZeiger(int x, int y, int r) {
		// 1
		super(x, y, r);
	}

	/**
	 * Setzt den Winkel (in Radiant) des Zeigers entsprechend minute.
	 *
	 */
	public void setzeMinute(double minute) {
		// 1
		setzeWinkel( 2.0 *Math.PI /60.0 * minute);
	}

	/**
	 * <pre>
	 * - Strichdicke mittels ((Graphics2D) g).setStroke(new BasicStroke(1.5f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
	 *   auf 1.5 setzen.
	 * - Methode anzeigen() der Superklasse aufrufen.
	 * </pre>
	 */
	public void anzeigen(Graphics g) {
		// 2
		((Graphics2D) g).setStroke(new BasicStroke(1.5f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
		super.anzeigen(g);
	}

}

class SekundenZeiger extends Zeiger {
	// 1

	/**
	 * Erzeugt via Konstruktor der Superklasse ein Objekt der Art SekundenZeiger
	 * mit Position x, y und Radius r.
	 */
	public SekundenZeiger(int x, int y, int r) {
		// 1
		super(x, y, r);
	}

	/**
	 * Setzt den Winkel (in Radiant) des Zeigers entsprechend sekunde.
	 *
	 */
	public void setzeSekunde(double sekunde) {
		// 1
		setzeWinkel( 2.0 *Math.PI /60.0 * sekunde);
	}

	/**
	 * <pre>
	 * - Strichdicke mittels ((Graphics2D) g).setStroke(new BasicStroke(1.0f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
	 *   auf 1.0 setzen.
	 * - Methode anzeigen() der Superklasse aufrufen.
	 * </pre>
	 */
	public void anzeigen(Graphics g) {
		// 2
		((Graphics2D) g).setStroke(new BasicStroke(1.0f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
		super.anzeigen(g);
	}

}
