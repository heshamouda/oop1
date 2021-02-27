import java.applet.AudioClip;
import java.awt.Graphics;
import java.awt.Image;

public class HGBildObjekt extends GrafikObjekt {
	// 21
	protected Image hgBild;
	protected Image[] blitzBild = new Image[3];
	protected AudioClip[] donnerClip = new AudioClip[3];
	protected final double SCHWELLE = 0.9;
	private double gewitterSchwelle = SCHWELLE;
	private double step = -0.25;
	private boolean gewitter = false;

	/**
	 * <pre>
	 * TEIL 1:
	 * - Hintergrundbild BigBenLondon.png mit Utility.loadResourceImage in entsprechendes Attribut laden. 
	 *
	 * 
	 * TEIL 2:
	 * - Die drei Blitz-Bilder(loadResourceImage) und die drei AudioClips(loadAudioClip) in die entsprechenden 
	 *   Arrays laden.
	 * </pre>
	 * 
	 * @param breite
	 * @param hoehe
	 */
	public HGBildObjekt(int breite, int hoehe) {
		// 1 + 3
		hgBild = Utility.loadResourceImage("BigBenLondon.png", breite, hoehe);

		// Teil 2
		for (int i = 0; i < blitzBild.length; i++) {
			blitzBild[i] = Utility.loadResourceImage("BigBenLondon_Light_" + i + ".png", breite, hoehe);
			donnerClip[i] = Utility.loadAudioClip("Donner_" + i + ".wav");
		}

	}

	/**
	 * <pre>
	 * TEIL 1:
	 * - Hintergrundbild an der Stelle x,y mit Observer null zeichnen.
	 * 
	 * Teil 2:
	 * - Falls Zufallszahl mit Bereich 0 ... 1.0 grösser der gewitterSchwelle:
	 *     - lokale int Variabler zufall im Bereich 0...2 erzeugen
	 *     - damit zufällg eines der drei Blitzbilder zeichnen
	 *     - und einen der drei AudioClips (play()) spielen.
	 *     - Wir sind nun im Gewitter - Modus: Entsprechendes Attribut auf wahr setzen.
	 * - Falls wir im Gewitter - Modus sind:
	 *     - gewitterSchwelle um step erhöhen
	 *     - Falls gewitterSchwelle kleiner gleich 0.5
	 *       - Vorzeichen von step drehen
	 *     - Falls gewitterSchwelle grösser gleich gleich 1.5 
	 *       - Vorzeichen von step drehen
	 *       - gewitterSchwelle auf SCHWELLE setzen 
	 *       - Gweitter- Modus verlassen: Entsprechendes Attribut auf unwahr setzen.
	 * </pre>
	 */
	public void anzeigen(Graphics g) {
		// 1 + 13
		g.drawImage(hgBild, x, y, null);if (Math.random() > gewitterSchwelle) {
			int zufall = (int) (Math.random() * 3.0);
			g.drawImage(blitzBild[zufall], x, y, null);
			donnerClip[zufall].play();
			gewitter = true;
		}
		if (gewitter) {
			gewitterSchwelle += step;
			if (gewitterSchwelle <= 0.5) {
				step *= -1.0;
			}
			if (gewitterSchwelle >= 1.5) {
				step *= -1.0;
				gewitterSchwelle = SCHWELLE;
				gewitter = false;
			}
		}
	}
}
