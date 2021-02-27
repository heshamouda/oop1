import java.awt.Image;

public class BewegtesObjekt extends BildObjekt {
	protected double vx;
	protected double vy;
	
	/**
	 * <pre>
	 * - Konstruktor der Superklasse aufrufen
	 * </pre>
	 */
	public BewegtesObjekt(int x, int y, Image bild) {
		super(x, y, bild);
		
	}

	/**
	 * <pre>
	 * - Konstruktor der Super Klasse aufrufen
	 * - Attribute setzen
	 * </pre>
	 */
	public BewegtesObjekt(int x, int y, double vx, double vy, Image bild) {
		super(x, y, bild);
		this.vx = vx;
		this.vy = vy;		
	}
	
	/**
	 * <pre>
	 * - x und y um entsprechende Geschwindigkeiten erhöhen
	 * </pre>
	 */
	public void update() {
		x += vx;
		y += vy;
		
	}
}
