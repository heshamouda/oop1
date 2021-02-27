import java.awt.Color;
import java.awt.Graphics;
import java.util.GregorianCalendar;
import java.util.Calendar;

public class Uhr extends GrafikObjekt {
	private int stunde;
	private int minute;
	private int sekunde;
	private SiebenSegment[] siebenSegment = new SiebenSegment[6];
	
	
	/**
	 * <pre>
	 * - Setzt Attribute der Elternklasse
	 * - Erzeugt alle sechs siebenSegmente gemäss Skizze
	 * </pre>
	 */
	public Uhr(int x, int y) {
		super(x,y);
		
		siebenSegment[5] = new SiebenSegment(x + 8,y + 8);
		siebenSegment[4] = new SiebenSegment(x + 68,y + 8);
		siebenSegment[3] = new SiebenSegment(x + 132,y + 8);
		siebenSegment[2] = new SiebenSegment(x + 192,y + 8);
		siebenSegment[1] = new SiebenSegment(x + 256,y + 8);
		siebenSegment[0] = new SiebenSegment(x + 316,y + 8);
		
		
		
	}
	
	/**
	 * <pre>
	 * - zeigt alle siebenSegmente an
	 * - setzt Farbe auf rot
	 * - zeichnet mit fillRect alle vier Trennpunkte gemäss Skizze
	 *   Hinweis: x Koordinaten (x + 124), (x + 248)
	 *            y Koordinaten (y + 32), (y +72)
	 * </pre>
	 */
	public void anzeigen(Graphics g) {
		
		for(int i = 0; i < siebenSegment.length; i++) {
			siebenSegment[i].anzeigen(g);
		}
		//Trennpunkte für Uhr
		
		g.setColor(Color.red);
		g.fillRect(x + 124, y + 32, 4, 4);
		g.fillRect(x + 124, y + 72, 4, 4);
		g.fillRect(x + 248, y + 32, 4, 4);
		g.fillRect(x + 248, y + 72, 4, 4);
		
	}
	
	/**
	 * <pre>
	 * - GregorianCalendar calendar = new GregorianCalendar()
	 * - stunde = calendar.get(Calendar.HOUR_OF_DAY)
	 * - minute = calendar.get(Calendar.MINUTE)
	 * - sekunde = calendar.get(Calendar.SECOND)
	 * - setzt alle 6 Ziffern entsprechend der Zeit 
	 * </pre>
	 */
	public void setzeZeit() {
		GregorianCalendar calendar = new GregorianCalendar();
		stunde = calendar.get(Calendar.HOUR_OF_DAY);
		minute = calendar.get(Calendar.MINUTE);
		sekunde = calendar.get(Calendar.SECOND);
		
		siebenSegment[5].setzeWert(stunde / 10);
		siebenSegment[4].setzeWert(stunde % 10);
		siebenSegment[3].setzeWert(minute / 10);
		siebenSegment[2].setzeWert(minute % 10);
		siebenSegment[1].setzeWert(sekunde / 10);
		siebenSegment[0].setzeWert(sekunde % 10);
		
	}

}
