
// Name: 
// Vorname:

import java.applet.AudioClip;
import java.awt.Graphics;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Uhr extends GrafikObjekt {
	// 28
	private HGBildObjekt hgBildObjekt;
	private AudioClip threeQuarterClip = Utility.loadAudioClip("ThreeQuarter.wav");
	private AudioClip halfClip = Utility.loadAudioClip("Half.wav");
	private AudioClip quarterClip = Utility.loadAudioClip("Quarter.wav");
	private AudioClip[] strikesClips = new AudioClip[12];
	private SekundenZeiger zgrSekunde;
	private MinutenZeiger zgrMinute;
	private StundenZeiger zgrStunde;

	/**
	 * <pre>
	 * - Erzeugt das HGBildObjekt, sowie den Sekunden-, Minuten- und Stundenzeiger an 
	 *   entsprechender Position mit den Radien 23, 21 und 18.
	 * - Lädt sämtliche Strikes mit Utility.loadAudioClip in den entsprechenden AudionClip - Array.
	 * </pre>
	 * 
	 * @param xZeiger
	 * @param yZeiger
	 * @param breite
	 * @param hoehe
	 */
	public Uhr(int xZeiger, int yZeiger, int breite, int hoehe) {
		// 6
		hgBildObjekt = new HGBildObjekt(breite, hoehe);
		zgrSekunde = new SekundenZeiger(xZeiger, yZeiger, 23);
		zgrMinute = new MinutenZeiger(xZeiger, yZeiger, 21);
		zgrStunde = new StundenZeiger(xZeiger, yZeiger, 18);
		for (int i = 0; i < strikesClips.length; i++) {
			strikesClips[i] = Utility.loadAudioClip("Strikes_" + i + ".wav");

		}

	}

	/**
	 * <pre>
	 * - Ruft die Objekte der Klasse Uhr zu zeichnen auf.
	 * </pre>
	 */
	public void anzeigen(Graphics g) {
		// 4
		hgBildObjekt.anzeigen(g);
		zgrSekunde.anzeigen(g);
		zgrMinute.anzeigen(g);
		zgrStunde.anzeigen(g);

	}

	/**
	 * <pre>
	 * - GregorianCalendar calendar = new GregorianCalendar().
	 * - Die Sekunde, Minute und Stunde lässt sich mittels calendar.get(Calendar.SECOND),
	 *   get(Calendar.MINUTE) resp. get(Calendar.HOUR_OF_DAY) in lokale Variablen auslesen.
	 * - Setzt die Zeiger entsprechend Sekunde, Minute und Sekunde, Minute und Stunde, 
	 *   damit Minuten- und Stundenzeiger nicht springen.
	 *  -Methode schlag mit entsprechenden Parametern aufrufen
	 * </pre>
	 */
	public void update() {
		// 8
		GregorianCalendar calendar = new GregorianCalendar();
		int sekunde, minute, stunde;
		sekunde = calendar.get(Calendar.SECOND);
		minute = calendar.get(Calendar.MINUTE);
		stunde = calendar.get(Calendar.HOUR_OF_DAY);
		zgrSekunde.setzeSekunde(sekunde);
		zgrMinute.setzeMinute(minute + sekunde / 60.0);
		zgrStunde.setzeStunde(stunde + minute / 60.0);
		schlag(stunde, minute, sekunde);

	}

	/**
	 * <pre>
	 * - Falls Sekunde gleich Null:
	 *   - Verzweigung minute:
	 *     - Fall 0:
	 *       - Stundenschlag an der Stelle (stunde % 12) spielen.
	 *     - Fall 15:
	 *       - Quarter - Schlag spielen.
	 *     - Fall 30:
	 *       - Half - Schlag spielen.
	 *     - Fall 45:
	 *       - Three-Quarter - Schlag spielen.
	 * </pre>
	 * 
	 * @param stunde
	 * @param minute
	 * @param sekunde
	 */
	public void schlag(int stunde, int minute, int sekunde) {
		// 9
		if (sekunde == 0) {
			if (minute == 0) {
				switch (minute) {
				case 0:
					strikesClips[stunde % 12].play();
					break;
				case 15:
					quarterClip.play();
					break;
				case 30:
					halfClip.play();
					break;
				case 45:
					threeQuarterClip.play();
					break;
				}
			}
		}

	}
}
