import java.awt.Graphics;
import java.awt.Image;

public class BildObjekt {

	protected int x;
	protected int y;
	protected int breite;
	protected int hoehe;

	protected Image bild;

	/**
	 * <pre>
	 * - Attribute setzen
	 *   hoehe und breite aus bild auslesen z.B. getHeight(null)
	 * </pre>
	 */
	public BildObjekt(int x, int y, Image bild) {
		this.x = x;
		this.y = y;
		this.bild = bild;

		this.hoehe = bild.getHeight(null);
		this.breite = bild.getWidth(null);

	}

	/**
	 * <pre>
	 * - Bild mit drawImage mit Bildmittelpunkt als Referenz zeichnen
	 * </pre>
	 */
	public void anzeigen(Graphics g) {
		g.drawImage(bild, x - breite / 2, y - hoehe / 2, null);

	}
}
