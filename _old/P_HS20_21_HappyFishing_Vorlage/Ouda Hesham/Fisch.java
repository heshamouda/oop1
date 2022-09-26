
// Ich bestaetige, dass ich diese Pruefung selbstaendig geloest habe.
// Ich weiss, dass bei Zuwiderhandlung die Note 1 erteilt wird.
//
// Name: Ouda
// Vorname: Hesham
//
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.MouseInfo;
import java.awt.PointerInfo;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;

public class Fisch extends GraphikObjekt implements MouseListener {

	protected static final int LOWSCORE = 0, HIGHSCORE = 1;
	private static final int FISCH = 0, TREFFER = 1;

	public Image imFisch, imTreffer;
	protected int groesse = 81;

	public int updateCounter = 0;
	private int zustand = FISCH;
	private int rotation;
	private int trefCount = 0;
	private int type;
	private double phi = 0;

	/**
	 * <pre>
	 * - ruft Konstruktor der Superklase mit entsprechenden Parametern auf
	 * - Falls Wahrscheinlichkeit kleiner 20%:
	 *     - Lädt das grüne Fisch Bild mittels LoadImage mit Breite 81 und Höhe 81
	 *     - setzt type auf HIGHSCORE
	 * - sonst:
	 *     - Lädt das Fisch Bild mittels LoadImage mit Breite 81 und Höhe 81
	 *     - setzs type auf LOWSCORE
	 * - Lädt das Treffer Bild mittels LoadImage mit Breite 81 und Höhe 81
	 * - setzt Attribut rotation
	 * </pre>
	 */
	public Fisch(int x, int y, int vx, int vy, int rotation) {
		// 9
		this.x=x;
		this.y=y;
		this.vx=vx;
		this.vy=vy;
		if (Math.random() < 0.2) {
			imFisch=Utility.loadImage("fischgruen.png",81,81);
			type=HIGHSCORE;
		} else {
			imFisch=Utility.loadImage("fisch.png",81,81);
			type=LOWSCORE;
		}
		imTreffer=Utility.loadImage("treffer",81,81);
		this.rotation=rotation;

	}

	/**
	 * <pre>
	 * - Mit switch (zustand) für den Fall:
	 *   - FISCH:
	 *     - Falls rotation gleich SpielPanel.LEFT:
	 *       - phi um Pi/6 erhoehen
	 *     - sonst:
	 *       - phi um -Pi/6 erhoehen
	 *     - Zeichnet mittels drawImage() das um -phi rotierte imFisch Bild (rotateImage(...) verwenden) 
	 *       mit Mittelpunkt an der Stelle x, y, mit Breite und Hoehe gleich groesse.   
	 *   - TREFFER:
	 *     - Zeichnet mittels drawImage() das imTreffer Bild mit Mittelpunkt an der Stelle x, y mit 
	 *       mit Breite und Hoehe gleich groesse.
	 * </pre>
	 */
	public void paint(Graphics g) {
		// 11
		int zustand=0;
		switch (zustand) {
		case FISCH:
			if(rotation==SpielPanel.LEFT) {
				phi+=phi/6;
			} else {
				{
					phi-=phi/6;
				}
				g.drawImage(rotateImage(imFisch, -phi), 20, 20, null);
			}
			
			
			break;
		case TREFFER:
			g.drawImage(imTreffer, 20, 20, null);
			
			break;
		
		}

	}

	/**
	 * <pre>
	 * - ruft update Methode der Superklasse auf
	 * - inkrementiert updateCounter 
	 * - Falls zustand gleich Treffer:
	 *   - trefCount inkrementieren
	 *   - Falls trefCount gleich 10:
	 *     - zustand gleich FISCH setzen
	 * </pre>
	 */
	public void update() {
		// 6
		super.update();
		updateCounter++;
		if (zustand==TREFFER) {
			trefCount++;			
		} else if (trefCount==10){
			zustand= FISCH;
		}

	}

	/**
	 * <pre>
	 * - Falls Abstand der Mausposition zu Fischkoordinaten kleiner (0.75 * groesse / 2.0 ) && !e.isConsumed()
	 *   - zustand gleich TREFFER setzen
	 *   - trefCount gleich 0 setzen
	 *   - e.consume() aufrufen
	 *   - calcStore(type) aufrufen
	 * </pre>
	 */
	@Override
	public void mousePressed(MouseEvent e) {
		// 5
		if(e.getX() <(0.75*groesse/2.0) &&  !e.isConsumed()) {
			zustand=TREFFER;
			trefCount=0;
			e.consume();
			calcScore(type);
		}
		}
			
		

	/**
	 * <pre>
	 * - Falls type gleich LOWSCORE:
	 *   - SpielPanel.score um 10 erhoehen
	 * - Sonst:
	 *   - SpielPanel.score um 20 erhoehen
	 * </pre>
	 */
	private void calcScore(int type) {
		// 4
		if (type==LOWSCORE) {
			SpielPanel.score+=10;			
		} else {
			SpielPanel.score+=20;
		}

	}

	/**
	 * <pre>
	 *  Muss nicht veraendert werden!
	 * </pre>
	 */
	@Override
	public void mouseClicked(MouseEvent e) {

	}

	/**
	 * <pre>
	 *  Muss nicht veraendert werden!
	 * </pre>
	 */
	@Override
	public void mouseReleased(MouseEvent e) {

	}

	/**
	 * <pre>
	 *  Muss nicht veraendert werden!
	 * </pre>
	 */
	@Override
	public void mouseEntered(MouseEvent e) {

	}

	/**
	 * <pre>
	 *  Muss nicht veraendert werden!
	 * </pre>
	 */
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	/**
	 * <pre>
	 * - Gibt mittels bild = rotateImage(bild, phi) das um den Mittelpunk um phi rotierte Bild zurück.
	 * !! Diese Methode muss nicht veraendert werden !!
	 * </pre>
	 * 
	 * @param image
	 * @param angle
	 * @return
	 */
	protected Image rotateImage(Image image, double angle) {
		int h = image.getHeight(null);
		int w = image.getWidth(null);
		double alphaCenter = Math.atan2(h / 2, w / 2);
		int diag = (int) (Math.sqrt(w * w + h * h));
		BufferedImage bufferedImage = new BufferedImage((int) diag, (int) diag, BufferedImage.TYPE_INT_ARGB);
		Graphics2D g = (Graphics2D) (bufferedImage.createGraphics());
		g.setRenderingHint(RenderingHints.KEY_ALPHA_INTERPOLATION, RenderingHints.VALUE_ALPHA_INTERPOLATION_QUALITY);
		g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);
		g.translate(-(diag / 2.0) * Math.cos(alphaCenter - angle) + diag / 2.0,
				-(diag / 2.0) * Math.sin(alphaCenter - angle) + diag / 2.0);
		g.rotate(-angle);
		g.drawImage(image, 0, 0, null);
		return bufferedImage;
	}
}
