
// Ich bestaetige, dass ich diese Pruefung selbstaendig geloest habe.
// Ich weiss, dass bei Zuwiederhandlung die Note 1 erteilt wird.
//
// Name:
// Vorname:
//

import java.awt.*;
import java.awt.image.BufferedImage;

public class Figur {
	// 31
	private static final int RECHTS = 1000, UNTEN = 600;
	private double vx, vy, x, y;
	private int groesse = 80;
	Image bild; // fehlt im Vorlage

	/**
	 * <pre>
	 * - Zufällig eines der 4 Schoko-Kugel-Bilder in entsprechendes Attribut laden.
	 * - Methode zufall() mit level aufrufen.
	 * </pre>
	 */
	public Figur(int level) {
		// 2
		bild = Utility.loadResourceImage("kugel_" + (int) (4.0 * Math.random()) + ".png");
		zufall(level);

	}

	/**
	 * <pre>
	 * - Bild gegeben durch bildDatei in entsprechendes Attribut laden.
	 * - Methode zufall() mit level aufrufen.
	 * </pre>
	 */
	public Figur(int level, String bildDatei) {
		// 2
		bild = Utility.loadResourceImage(bildDatei);
		zufall(level);
	}

	/**
	 * <pre>
	 * - Bild mit Zentrum bei x,y und Breite und Höhe 
	 *   gleich dem Attribut groesse und observer gleich null mit der Methode 
	 *   drawImage(Image img, int x, int y, int width, int height, ImageObserver observer)
	 *   zeichnen.
	 * - Falls Attribut groesse nicht gleich 80
	 *     - Zeichenkette mit der Grösse der Figur etwa unten in der Mitte zeichnen.
	 * </pre>
	 * 
	 * @param g
	 */
	public void anzeigen(Graphics g) {
		// 3
		g.drawImage(bild, (int) (x - groesse / 2), (int) (y - groesse / 2), groesse, groesse, null);
		if (groesse != 80) {
			g.drawString("" + groesse, (int) x - 15, (int) (y + groesse / 2));// ?? groesse ist quasi score
		}

	}

//	/**
//	 * <pre>
//	 * - Falls die zwei kreisförmigen Figuren, gegeben durch das Argument figure und this kollidieren, 
//	 *     - wahr zurückgeben.
//	 *   Sonst 
//	 *     - unwahr zurückgeben.
//	 * </pre>
//	 * 
//	 * @param figur
//	 * @return
//	 */
	public boolean kollisionTesten(Figur figur) {
		// 5
		if (Math.pow((x - figur.x), 2.0) + Math.pow((y - figur.y), 2.0) < Math.pow((groesse + figur.groesse) / 2.0,
				2.0)) {
			return true;
		}

		return false; // um den Compiler glücklich zu machen.
	}
//
//	/**
//	 * <pre>
//	 * - Entsprechende Attribute setzen.
//	 * </pre>
//	 * 
//	 * @param x
//	 * @param y
//	 */
//	public void setPosition(int x, int y) {
//		// 2
//		this.x = x;
//		this.y = y;
//	}
//
//	/**
//	 * <pre>
//	 * - x um vx erhöhen.
//	 * - y um vy erhöhen.
//	 * - Falls die Figur den rechten Rand bei RECHTS überschreitet:
//	 *     - Figur an den rechten Rand zurück setzen.
//	 *     - Vorzeichen von vx wechseln.
//	 * - Sinngemäss für die restlichen drei Ränder verfahren.
//	 * </pre>
//	 * 
//	 */
//	public void update() {
//		// 12
//		x += vx;
//		y += vy;
//
//		if (x > RECHTS - groesse / 2) {
//			x = RECHTS - groesse / 2;
//			vx = -vx;
//		}
//		if (x < groesse / 2) {
//			x = groesse / 2;
//			vx *= -1;
//		}
//		if (y > UNTEN - groesse / 2) {
//			y = UNTEN - groesse / 2;
//			vy = -vy;
//		}
//		if (y < groesse / 2) {
//			y = groesse / 2;
//			vy = -vy;
//		}
//
//	}
//
//	/**
//	 * <pre>
//	 * - Attribut groesse um eins erhöhen.
//	 * </pre>
//	 * 
//	 */
//	public void wachsen() {
//		// 1
//		groesse = groesse + 1;
//
//	}
//
//	/**
//	 * <pre>
//	 * - Für Attribut x eine Zufallszahl im Bereich 0 ... RECHTS würfeln. 
//	 * - Für Attribut y eine Zufallszahl im Bereich 0 ... UNTEN würfeln.
//	 * - Für Attribut vx und vy je eine Zufallszahl im Bereich +/-4 mal (level plus Eins) würfeln.
//	 * </pre>
//	 * 
//	 * @param level
//	 */
//	private void zufall(int level) {
//		// 4
//		x = RECHTS * Math.random();
//		y = UNTEN * Math.random();
//		vx = (-4 + 8 * Math.random()) * (level + 1);
//		vy = 4 * (level + 1) * 2.0 * (Math.random() - 0.5);
//
//	}
//}

// Ich bestaetige, dass ich diese Pruefung selbstaendig geloest habe.
// Ich weiss, dass bei Zuwiederhandlung die Note 1 erteilt wird.
//
// Name:
// Vorname:
//
 
  
	/**
	 * <pre>
	 * - Entsprechende Attribute setzen.
	 * </pre>
	 * 
	 * @param x
	 * @param y
	 */
	public void setPosition(int x, int y) {
		// 2
		this.x = x;
		this.y = y;

	}

	/**
	 * <pre>
	 * - x um vx erhöhen.
	 * - y um vy erhöhen.
	 * - Falls die Figur den rechten Rand bei RECHTS überschreitet:
	 *     - Figur an den rechten Rand zurück setzen.
	 *     - Vorzeichen von vx wechseln.
	 * - Sinngemäss für die restlichen drei Ränder verfahren.
	 * </pre>
	 * 
	 */
	public void update() {
		// 12
		x += vx;
		y = y + vy;
		if (x > RECHTS - groesse / 2) {
			x = RECHTS - groesse / 2;
			vx = -vx;
		}
		if (x < groesse / 2) {
			x = groesse / 2;
			vx *= -1;
		}

		if (y > UNTEN - groesse / 2) {
			y = UNTEN - groesse / 2;
			vy = -vy;
		}
		if (y < groesse / 2) {
			y = groesse / 2;
			vy = -vy;
		}

	}

	/**
	 * <pre>
	 * - Attribut groesse um eins erhöhen.
	 * </pre>
	 * 
	 */
	public void wachsen() {
		// 1
		groesse = groesse + 1;
	}

	/**
	 * <pre>
	 * - Für Attribut x eine Zufallszahl im Bereich 0 ... RECHTS würfeln. 
	 * - Für Attribut y eine Zufallszahl im Bereich 0 ... UNTEN würfeln.
	 * - Für Attribut vx und vy je eine Zufallszahl im Bereich +/-4 mal (level plus Eins) würfeln.
	 * </pre>
	 * 
	 * @param level
	 */
	private void zufall(int level) {
		// 4
		x = RECHTS * Math.random();
		y = UNTEN * Math.random();
		vx = (-4.0 + 8.0 * Math.random()) * (level + 1);
		vy = 4 * (level + 1) * 2.0 * (Math.random() - 0.5);// beide Lösungen möglich

	}
}
