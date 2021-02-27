import java.awt.Color;
import java.awt.Graphics;

public class Segment extends GrafikObjekt {

	public static final int HORIZONTAL = 0;
	public static final int VERTIKAL = 1;

	protected int orientierung;
	protected boolean ein = false;

	/**
	 * <pre>
	 * - Setzt Attribute der Klasse und Elternklasse
	 * </pre>
	 */
	public Segment(int x, int y, int orientierung) {
		super(x, y);
		this.orientierung= orientierung;
		
	}

	/**
	 * <pre>
	 * - falls ein: Farbe auf rot setzen, sonst auf schwarz
	 * - für beide Orientierungen Segment zeichnen. hierzu jeweils:
	 * 	- int array der x Punkte des Segments erzeugen (Skizze)
	 * 	- int array der y Punkte des Segments erzeugen (Skizze)
	 * 	- mit fillPolygon das Segment zeichnen
	 * </pre>
	 */
	public void display(Graphics g) {
		if (ein) {
			g.setColor(Color.red);
			
		} else {
			g.setColor(Color.black);
		}
		if (orientierung == HORIZONTAL) {
			int[] px = { x + 2, x + 6, x + 34, x + 38, x + 38, x + 34, x + 6, x + 2 };
			int[] py = { y - 2, y - 6, y - 6, y - 2, y + 2, y + 6, y + 6, y + 2 };

			g.fillPolygon(px, py, px.length);

		} else {
			int[] px = { x - 2, x - 6, x - 6, x - 2, x + 2, x + 6, x + 6, x + 2 };
			int[] py = { y + 2, y + 6, y + 34, y + 38, y + 38, y + 34, y + 6, y + 2 };

			g.fillPolygon(px, py, px.length);
		}
		
 		
	}

	/**
	 * <pre>
	 * - Attribut setzen
	 * </pre>
	 */
	public void setzeZustand(boolean ein) {
		this.ein=ein;

	}

}
