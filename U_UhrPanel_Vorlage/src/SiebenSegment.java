import java.awt.Graphics;

public class SiebenSegment extends GrafikObjekt {
	private Segment[] segment = new Segment[7];

	/**
	 * <pre>
	 * - Setzt Attribute der Elternklasse
	 * - Erzeugt alle sieben Segmente gemäss Skizze
	 * </pre>
	 */
	public SiebenSegment(int x, int y) {
		super(x, y);
		segment[0] = new Segment(x + 6, y + 6, Segment.HORIZONTAL);
		segment[1] = new Segment(x + 46, y + 6, Segment.VERTIKAL);
		segment[2] = new Segment(x + 46, y + 46, Segment.VERTIKAL);
		segment[3] = new Segment(x + 6, y + 86, Segment.HORIZONTAL);
		segment[4] = new Segment(x + 6, y + 46, Segment.VERTIKAL);
		segment[5] = new Segment(x + 6, y + 6, Segment.VERTIKAL);
		segment[6] = new Segment(x + 6, y + 46, Segment.HORIZONTAL);

	}

	/**
	 * <pre>
	 *  
	 * - zeigt alle Segmente an
	 * </pre>
	 */
	public void display(Graphics g) {
		for (int i = 0; i < segment.length; i++) {
			segment[i].display(g);
		}

	}

	/**
	 * <pre>
	 * - setzt alle Segmente auf false
	 * - setzt Zustand der Segmente gemäss zahl (0-9) auf true oder false
	 *   Hinweis: switch case Anweisung verwenden
	 * </pre>
	 */
	public void setzeWert(int zahl) {
		for (int i = 0; i < segment.length; i++) {
			segment[i].setzeZustand(false);
		}
		switch (zahl) {
		case 0:
			segment[0].setzeZustand(true);
			segment[1].setzeZustand(true);
			segment[2].setzeZustand(true);
			segment[3].setzeZustand(true);
			segment[4].setzeZustand(true);
			segment[5].setzeZustand(true);
			break;
		case 1:
			segment[2].setzeZustand(true);
			segment[1].setzeZustand(true);
			break;
		case 2:
			segment[0].setzeZustand(true);
			segment[1].setzeZustand(true);
			segment[6].setzeZustand(true);
			segment[4].setzeZustand(true);
			segment[3].setzeZustand(true);
			break;
		case 3:
			segment[0].setzeZustand(true);
			segment[1].setzeZustand(true);
			segment[6].setzeZustand(true);
			segment[2].setzeZustand(true);
			segment[3].setzeZustand(true);
			break;
		case 4:
			segment[5].setzeZustand(true);
			segment[1].setzeZustand(true);
			segment[6].setzeZustand(true);
			segment[2].setzeZustand(true);
			break;
		case 5:
			segment[0].setzeZustand(true);
			segment[5].setzeZustand(true);
			segment[6].setzeZustand(true);
			segment[2].setzeZustand(true);
			segment[3].setzeZustand(true);
			break;
		case 6:
			segment[0].setzeZustand(true);
			segment[2].setzeZustand(true);
			segment[3].setzeZustand(true);
			segment[4].setzeZustand(true);
			segment[5].setzeZustand(true);
			segment[6].setzeZustand(true);
			break;
		case 7:
			segment[0].setzeZustand(true);
			segment[1].setzeZustand(true);
			segment[2].setzeZustand(true);
			break;
		case 8:
			segment[0].setzeZustand(true);
			segment[1].setzeZustand(true);
			segment[2].setzeZustand(true);
			segment[3].setzeZustand(true);
			segment[4].setzeZustand(true);
			segment[5].setzeZustand(true);
			segment[6].setzeZustand(true);
			break;
		case 9:
			segment[0].setzeZustand(true);
			segment[1].setzeZustand(true);
			segment[2].setzeZustand(true);
			segment[3].setzeZustand(true);
			segment[5].setzeZustand(true);
			segment[6].setzeZustand(true);
			break;
		}

	}
}
