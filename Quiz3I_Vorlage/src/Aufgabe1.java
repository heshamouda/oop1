
// Ich bestaetige, dass ich diese Pruefung selbstaendig geloest habe.
// Ich weiss, dass bei Zuwiderhandlung die Note 1 erteilt wird.
//
// Name:
// Vorname:
//
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class SignalGenerator extends JPanel implements ActionListener {

	private double amp = 1, freq = 2;
	private Image formel = Utility.loadResourceImage("Trapez.png", 450, 100);
	private double[] signal = {};
	// ToDo: hier die fehlenden Objekte ergänzen und erzeugen
	// die Anzeigetexte entnehmen Sie der Skizze auf dem Aufgabenlatt
	// 4
	

	/**
	 * <pre>
	 * - Baut GUI  gemäss folgenden Koordinaten
	 * 		Label Signal: (50, 25, 125, 25)
	 * 		TextField tfSig: (125, 25, 125, 25)
	 * 		Label #Harmonics: (50, 75, 125, 25)
	 * 		TextField tfHarm: (125, 75, 125, 25)
	 * 		Button Calculate: (50, 125, 200, 75)
	 * 		PlotPanel: (20, 250, 600, 400)
	 * - Registriert Listener
	 * </pre>
	 */
	public SignalGenerator() {

		setLayout(null);
		// 7
		// ToDo
		
	}

	/**
	 * <pre>
	 * - Liest Information aus GUI aus und legt sie in entsprechender lokalen Var. ab.
	 * - Verzweigung tfSig.getText()
	 * 	  - Fall zufall:
	 * 		- signal gleich berechneNoise(...) mit entsprechenden Parametern berechnen
	 * 	  - Fall trapez:
	 * 		- signal gleich berechneTrapez(...) mit entsprechenden Parametern berechnen
	 * 	  - default:
	 * 		- wie oben Noise zurückgeben
	 * - Setzt Signal des PlotPanels mit entprechender Klassenmethode.
	 * - Löst Neuzeichnen aus.
	 * </pre>
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		int N = 620; // Anzahl Punkte auf der x Achse
		// 12
		// ToDo
		

	}

	/**
	 * <pre>
	 * - mit drawImage formel bei x=255,y=20) zeichnen
	 * </pre>
	 */
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		// 1
		// ToDo
		
	}

	/**
	 * <pre>
	 * 	-Berechnet aufgrund der Parameter Trapezsignal
	 * </pre>
	 */
	private double[] berechneTrapez(double amp, double freq, int nHarm, int N) {

		double[] y = new double[N];
		double alpha = Math.PI / 3.0;
		// 5
		// ToDo
		
		return y;
	}

	/**
	 * <pre>
	 * 	-Berechnet aufgrund der Parameter mittelwertfreies Rauschsignal mit Amplitude amp
	 *   (Rauschen um Nulllinie mit Amplitude amp)
	 * </pre>
	 */
	private double[] berechneNoise(double amp, int N) {

		double[] y = new double[N];
		// 3
		// ToDo
		
		return y;
	}

}

// Muss nicht verändert werden!!
public class Aufgabe1 extends JFrame {

	private SignalGenerator view = new SignalGenerator();

	public Aufgabe1() {

		add(view);
		setSize(720, 720);

		setTitle("|FHNW|EIT|OOP|Aufgabe1|");
		setLocationRelativeTo(null);
		setResizable(true);
		setVisible(true);
	}

	public static void main(String args[]) {

		Aufgabe1 frame = new Aufgabe1();
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(1);
			}
		});

	}
}