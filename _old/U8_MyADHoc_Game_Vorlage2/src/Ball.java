import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

public class Ball extends BewegtesObjekt {
	protected Rectangle rect;

	/**
	 * <pre>
	 * - Konstruktor der Super Klasse aufrufen
	 * - setRechteck mit  new Rectangle(5,5,980,590) aufrufen
	 * </pre>
	 */
	public Ball(int x, int y, int vx, int vy, Image bild) {
		super(x, y, vx, vy, bild);
		setRechteck(new Rectangle(5, 5, 980, 590));// setzt Rechteck auf quasi ganzes Panel

	}

	/**
	 * <pre>
	 * - anzeigen der Super Klasse aufrufen
	 * </pre>
	 */
	@Override
	public void anzeigen(Graphics g) {
		super.anzeigen(g);

	}

	/**
	 * <pre>
	 * - Attribut setzen
	 * </pre>
	 */
	public void setRechteck(Rectangle rect) {
		this.rect = rect;

	}

	/**
	 * <pre>
	 * - update der Super Klasse aufrufen
	 * - falls x kleiner linke Spielfeldgrenze
	 * 		- vx Richtung umkehren
	 * 		- x auf linke Spielfeldgrenze setzen
	 * - falls y kleiner obere Spielfeldgrenze
	 * 		- vy Richtung umkehren
	 * 		- y auf obere Spielfeldgrenze setzen
	 * - falls y grösser untere Spielfeldgrenze
	 * 		- vy Richtung umkehren
	 * 		- y auf untere Spielfeldgrenze setzen
	 * </pre>
	 */
	@Override
	public void update() {
		super.update();

		if (x < rect.x + breite / 2) {
			vx *= -1;
			x = rect.x + breite / 2;
		}

		if (y < rect.y + hoehe / 2) {
			vy *= -1;
			y = rect.y + hoehe / 2;
		}

		if (y > rect.y + rect.height - hoehe / 2) {
			vy *= -1;
			y = rect.y + rect.height - hoehe / 2;
		}
	}

}
