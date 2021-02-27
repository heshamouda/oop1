import java.awt.Image;

public class Schlaeger extends BildObjekt {
	
	/**
	 * <pre>
	 * - Konstruktor der Super Klasse aufrufen
	 * </pre>
	 */
	public Schlaeger(int x, int y, Image bild) {
		super(x, y, bild);
	}
	
	/**
	 * <pre>
	 * - Attribute setzen
	 * </pre>
	 */
	public void setPosition(int x, int y) {
		this.x = x;
		this.y = y;
		
	}

	/**
	 * <pre>
	 * - falls sich Schläger und bewegtes Objekt berührt
	 * 		- vx Richtung des bewegten Objekts umkehren
	 * 		- bewegtesObjek.x auf x - (breite + bewegtesObjekt.breite) / 2  setzen
	 * 		- wahr zurückgeben
	 * - sonst
	 * 		- falsch zurückgeben
	 * </pre>
	 */
	public boolean kollisionTesten(BewegtesObjekt bewegtesObjekt) {
		if (Math.abs(x - bewegtesObjekt.x) < (breite + bewegtesObjekt.breite) / 2
				&& Math.abs(y - bewegtesObjekt.y) < (hoehe + bewegtesObjekt.hoehe) / 2) {
			bewegtesObjekt.vx *= -1;
			bewegtesObjekt.x = x - (breite + bewegtesObjekt.breite) / 2;
			return true;
		} else
			return false;
	}
}
