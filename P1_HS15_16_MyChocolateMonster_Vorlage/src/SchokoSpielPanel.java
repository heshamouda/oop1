
// Ich bestaetige, dass ich diese Pruefung selbstaendig geloest habe.
// Ich weiss, dass bei Zuwiederhandlung die Note 1 erteilt wird.
//
// Name:
// Vorname:
//

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;
import javax.swing.plaf.DimensionUIResource;

 

public class SchokoSpielPanel extends JPanel implements MouseMotionListener, SimpleTimerListener {
	// 38 + 1
	private boolean gameOver = true;
	private Figur person, monster;
	private SimpleTimer timer;
	private double xIst, xSoll, yIst, ySoll;
	private int level;
	private Image hgBild;
	private Figur[] schokos= new Figur [100];

	/**
	 * <pre>
	 * - Grösse des Panels auf (1000, 600) setzen.
	 * - Listener Registrieren.
	 * - neuesSpiel() mit level und sex gleich Null aufrufen.
	 * - Hintergrundbild laden.
	 * - Erzeugt den SimpleTimer timer mittels new SimpleTimer(50, this) und startet ihn.
	 * </pre>
	 */
	public SchokoSpielPanel() {
		// 5
		this.setPreferredSize(new DimensionUIResource(1000, 600));
		addMouseMotionListener(this);
		neuesSpiel(0,0);
		hgBild= Utility.loadResourceImage("background.png");
		timer= new SimpleTimer(50, this);
		timer.start();		

	}

	public void mouseDragged(MouseEvent e) {
		
	}

	/**
	 * <pre>
	 * - xSoll gleich der x-Position der Maus setzen.
	 * - ySoll gleich der y-Position der Maus setzen.
	 * </pre>
	 * 
	 * @param e
	 */
	public void mouseMoved(MouseEvent e) {
		// 2
		xSoll= e.getX();
		ySoll=e.getY();

	}

	/**
	 * <pre>
	 * - Attribut level setzen.
	 * - Für i gleich Null bis kleiner der Länge des Schoko - Arrays:
	 *   - Neue Figur mit entsprechendem level erzeugen und i-tem Element 
	 *     des Schoko-Arrays zuordnen.
	 * - Monster-Figur mit entsprechendem level und entsprechender Bild-Datei erzeugen.
	 * - Falls sex gleich Null:
	 *     - Person-Figur mit entsprechendem level und  Bild-Datei (Mann) erzeugen.
	 *   Sonst:
	 *     - Person-Figur mit entsprechendem level und  Bild-Datei (Frau) erzeugen.
	 * - Neuzeichnen auslösen.
	 * </pre>
	 */
	public void neuesSpiel(int level, int sex) {
		// 9
		this.level=level;
		for (int i = 0; i < schokos.length; i++) {
			schokos[i] = new Figur (level);			
		} 
		monster= new Figur(level, "monster.png");
		if (sex == 0) {
			person= new Figur(level, "boy.png");
		} else {
			person= new Figur(level, "girl.png");
		}
		repaint();
	}

	/**
	 * <pre>
	 * - Hintergrundbild an der Stelle 0,0 zeichnen.
	 * - Für i gleich Null bis kleiner der Länge des Schoko - Arrays:
	 *     i-tes Element des Schoko-Arrays mittels anzeigen() zeichnen.
	 * - Person mittels anzeigen() zeichnen.
	 * - Monster mittels anzeigen() zeichnen.
	 * </pre>
	 */
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		// 5
		g.drawImage(hgBild, 0, 0, null);
		for (int i = 0; i < schokos.length; i++) {
			schokos[i].anzeigen(g);
		}
		person.anzeigen(g);
		monster.anzeigen(g);
	}

	/**
	 * <pre>
	 * - gameOver gleich unwahr setzen.
	 * </pre>
	 */
	public void start() {
		// 1
		gameOver= false;

	}

	/**
	 * <pre>
	 * - Falls NICHT gameOver:
	 *     - Für i gleich Null bis kleiner der Länge des Schoko - Arrays:
	 *         - update() des i-ten Elementes des Schoko-Array aufrufen.
	 *         - Falls i-tes Element des Schoko-Array mit Person kollidiert:
	 *   	     - Neue Figur mit entsprechendem level erzeugen und i-tem Element 
	 *             des Schoko-Arrays zuordnen.
	 *           - Person wachsen lassen.
	 *         - Falls i-tes Element des Schoko-Array mit Monster kollidiert:
	 *   	     - Neue Figur mit entsprechendem level erzeugen und i-tem Element 
	 *             des Schoko-Arrays zuordnen.
	 *           - Monster wachsen lassen.
	 *     - update() des Monsters aufrufen.
	 *     - xIst gleich 0.975 mal xIst + 0.025 mal xSoll setzen.
	 *     - yIst gleich 0.975 mal YIst + 0.025 mal YSoll setzen.
	 *     - Position der Person gleich xIst und yIst setzen.
	 *     - Falls Person mit Monster kollidiert:
	 *         - gameOver auf wahr setzen.
	 *     - Neuzeichnen auslösen.
	 * </pre>
	 */
	public void timerAction() {
		// 16
		if (!gameOver) {
			for (int i = 0; i < schokos.length; i++) {
				schokos[i].update();
				if (schokos[i].kollisionTesten(person)) {
					schokos[i] = new Figur(level);
					person.wachsen();
				}
				if (schokos[i].kollisionTesten(monster)) {
					schokos[i] = new Figur(level);
					monster.wachsen();
				}
			}
			monster.update();
			xIst = 0.975 * xIst + 0.025 * xSoll;
			yIst = 0.975 * yIst + 0.025 * ySoll;
			person.setPosition((int) xIst, (int) yIst);
			if (person.kollisionTesten(monster)) {
				gameOver = true;
			}
			repaint();
		}
	}

	// DIE FOLGENDEN ZWEI METHODEN VERHINDERN DAS FLICKERN UND ERHÖHEN DIE
	// ZEICHENQUALITÄT!!!
	public void update(Graphics g) {
		BufferedImage bufferedImage = new BufferedImage(this.getWidth(), this.getHeight(), BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2d = (Graphics2D) (bufferedImage.createGraphics());
		g2d.setFont(g.getFont().deriveFont(25.0f));
		g2d.setColor(getBackground());
		g2d.fillRect(0, 0, getWidth(), getHeight());
		g2d.setColor(Color.red);
		paint(g2d);
		((Graphics2D) g).drawImage(bufferedImage, 0, 0, null);
	}

}
