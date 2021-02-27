
// Ich bestaetige, dass ich diese Pruefung selbstaendig geloest habe.
// Ich weiss, dass bei Zuwiderhandlung die Note 1 erteilt wird.
//
// Name: Ouda
// Vorname: Hesham
//

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SpielPanel extends JPanel implements ActionListener, SimpleTimerListener, ItemListener {
	private static final long serialVersionUID = 1L;
	public static final int LEFT = 0, RIGHT = 1;
	public static int score;

	private Image imHintergrund = Utility.loadImage("hintergrund.png", 1200, 600);
	private Image imGameOver = Utility.loadImage("gameover.png", 1100, -1);
	private JButton btStart = new JButton("Start");
	private JButton btPause = new JButton("Pause");
	private JComboBox<String> cbLevel = new JComboBox<String>();
	private JTextField tfScore = new JTextField();
	private JTextField tfDauer = new JTextField("5");
	private String[] levelList = { "1", "2", "3" };

	private SimpleTimer updateTimer;

	private boolean gameOver = false, pause = false;
	private int count, timerCount, levelDauer = 20;

	private Fisch[] fisch = new Fisch[10];

	/**
	 * <pre>
	 * - Erzeugt und platziert Gui Komponenten gemaess Layout gegeben in der Beilage.
	 * - Registriert die Klasse als Listener fuer die Auswahl und die Buttons.
	 * - Setzt tfScore auf nicht editierbar ???
	 * </pre>
	 */
	public SpielPanel() {
		// 14
		setPreferredSize(new Dimension(1200, 750));// gegeben
		setLayout(null);// gegeben
		add(btStart).setBounds(20, 650, 100, 40);
		add(btPause).setBounds(20,700,100,40);
		add(new JLabel("Level")).setBounds(140,650,100,40);
		add(cbLevel).setBounds(180, 650, 100, 40);
		add(new JLabel("Dauer in Sekunden")).setBounds(300,650,150,40);
		add(tfDauer).setBounds(470, 650, 100, 40);
		add(new JLabel("Score")).setBounds(600,650,100,40);
		add(tfScore).setBounds(650, 650, 100, 40);
		btStart.addActionListener(this);
		btPause.addActionListener(this);
		tfDauer.addActionListener(this);
		tfScore.addActionListener(this);
		cbLevel.addItemListener(this);
		
	}

	/**
	 * <pre>
	 * - Zeichnet mit drawImage() das Hintergrundsbild an Stelle 5,5.
	 * - Fuer i von 0 bis kleiner der Laenge des Fisch - Arrays
	 *   - Falls der i-te Fisch nicht gleich null ist:
	 *     - i-ten Fisch mit entsprechender Methode malen.
	 * - setzt Textfeld tfscore mit Attribute score
	 * - Falls gameover wahr ist:
	 * 	 - zeichnet mit drawImage() das GameOverbild an Stelle 5,5.
	 * </pre>
	 */
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);// gegeben
		// 7
		g.drawImage(imHintergrund, 5, 5, null);
		for (int i = 0; i < fisch.length; i++) {
			if (fisch[i] != null) {
				fisch[i].paint(g);
			}
		}
		//SpielPanel.score=Integer.parseInt(tfScore.getText());
		if (gameOver == true) {
			g.drawImage(imGameOver, 5, 5, null);
		}


	}

	/**
	 * <pre>
	 * - Falls Button Start Quelle des Events:
	 *   - erzeugt und startet neuen updateTimer mit Periode 100 
	 *   - setzt gameover auf false.
	 *   - setzt score auf 0.
	 *   - deaktiviert den Start Button und das Spieldauer Textfeld
	 *  
	 * - Falls Button Pause Quelle des Events:
	 *   - Falls  Text von Button Pause gleich "Pause".
	 *     - setzt pause auf wahr
	 * 	   - setzt Text des Pause Buttons auf "Resume".
	 *   - sonst: 
	 *     - setzt pause auf false
	 * 	   - setzt Text des Pause Buttons auf "Pause".
	 * </pre>
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// 14
		if (e.getSource().equals(btStart)) {
			updateTimer= new SimpleTimer(100, this);
			updateTimer.start();
			gameOver=false;
			score=0;
			btStart.disable();
			tfDauer.disable();			
		}
		if (e.getSource().equals(btPause)) {
			if (btPause.getLabel()== "Pause" ) {
				pause=true;
				btPause.setLabel("Resume");				
				
			} else {
				pause=false;
				btPause.setLabel("Pause");	
			}
		}

	}

	/**
	 * <pre>
	 * - Falls pause unwahr:
	 *   - Falls timerCount kleiner als 10 mal eingegebener Dauer aus Textfeld:
	 *     - timerCount inkrementieren
	 * 	   - Falls timerCount gerade:
	 * 	     - calcRotation aufrufen und Ergebnis in lokale Variable rotation speichern
	 * 	     - setzt count auf Pr�fix-inkrementierten count Modulo 10; 
	 * 	     - erzeugt neuen Fisch mit ArrayIndex count mit folgenden Werten
	 * 		   x: Zufallszahl zwischen 50 und 1150
	 * 		   y: Zufallszahl zwischen 200 und 500
	 * 		   vx:Zufallszahl zwischen -10 und +10
	 * 		   vy:-5
	 * 		   rotation: lokale variable rotation
	 * 	     - fuegt Fisch mit ArrayIndex count als Mouselistener hinzu
	 *   - Sonst:
	 * 	   - setzt gameOver auf wahr
	 * 	   - entfernt TimerListener des updateTimer mittels updateTimer.removeTimerListener(this);
	 * 	   - setzt timerCount auf 0
	 * 	   - aktiviert den Start Button und das Dauer Textfeld
	 *   - ruft update() und repaint() auf
	 * 
	 * </pre>
	 */
	@Override
	public void timerAction() {
		// 16
		if (pause==false) {
			if (timerCount < 10* Integer.parseInt(tfDauer.getText())) {
				timerCount++;
				if(timerCount%2==0)
				calcRotation();
				count += count%10;
				for (int i = 0; i < fisch.length; i++) {
					//Fisch.x= Math.random()*1100+50;
					//Fisch.y= Math.random()*300+200;
					//Fisch.xv= Math.random()*-20+10;
					//Fisch.yv= -5;
					double rotation;
					
				}
				addMouseListener((fisch[count]));

			}
			else {
				gameOver=true;
				updateTimer.removeTimerListener(this);
				timerCount=0;
				btStart.enable();
				tfDauer.enable();
			}
			update();
			repaint();
		}

	}

	/**
	 * <pre>
	 * - F�r i von 0 bis kleiner Laenge des Fisch Arrays
	 *   - Falls der i-te Fisch nicht gleich null ist:
	 *     - i-ten Fisch updaten
	 * 	   - Falls updateCounter vom i-ten Fisch > levelDauer:
	 * 	     - entfernt Mouselistener vom i-ten Fisch (mittels removeMouseListener). 
	 * 	     - setzt i-ten Fisch auf null.
	 * </pre>
	 */
	private void update() {
		// 6
		for (int i = 0; i < fisch.length; i++) {
			if(fisch[i]!= null) {
				fisch[i].update();
				
			}
		}

	}

	/**
	 * <pre>
	 * - gibt mit Wahrscheinlichkeit von 50 % LEFT bzw. RIGHT zurueck
	 * </pre>
	 * 
	 * @return
	 */
	private int calcRotation() {
		// 4

		return 0; // damit compiler gluecklich
	}

	/**
	 * <pre>
	 * !!!Ist fuer Sie bereits implementiert und muss nicht veraendert werden!!!
	 * - Mit switch (cbLevel.getSelectedIndex()) fuer den Fall:
	 *   - 0
	 *     - setzt levelDauer auf 20.
	 *   - 1
	 * 	 - setzt levelDauer auf 12.
	 *   - default
	 *  	 - setzt levelDauer auf 7.
	 *
	 * </pre>
	 */
	@Override
	public void itemStateChanged(ItemEvent e) {
		// 9
		switch (cbLevel.getSelectedIndex()) {
		case 0:
			levelDauer = 20;
			break;
		case 1:
			levelDauer = 12;
			break;
		default:
			levelDauer = 7;

		}

	}
}
