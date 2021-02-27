
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

	private double amp = 1.0, freq = 2.0;
	private Image formel = Utility.loadResourceImage("Impuls.png", 450, 100);
	private double[] signal = {};
	// ToDo: hier die fehlenden Objekte ergänzen und erzeugen
	// die Anzeigetexte entnehmen Sie der Skizze auf dem Aufgabenlatt.
	// 5P

	private JTextField tfHarm = new JTextField("7");
	private JButton btCalculate = new JButton("Calculate");
	private JButton btCalcHarm = new JButton("CalcHarm");
	private JButton btNoise = new JButton("Noise");
	private PlotPanel plotPanel = new PlotPanel();

	/**
	 * <pre>
	 * - Baut GUI  gemäss folgenden Koordinaten
	 *      Button CalcHarm: (525, 25, 125, 25)
	 * 		Label #Harmonics: (500, 75, 125, 25)
	 * 		TextField tfHarm: (580, 75, 100, 25)
	 * 		Button Calculate: (250, 150, 200, 75)
	 *      Button Noise: (500, 150, 100, 75)
	 * 		PlotPanel: (20, 250, 600, 400)
	 * - Registriert Listener
	 * </pre>
	 */
	public SignalGenerator() {

		setLayout(null);
		// 9
		// ToDo

		add(btCalcHarm).setBounds(525, 25, 125, 25);
		add(new JLabel("#Harmonics")).setBounds(500, 75, 125, 25);
		add(tfHarm).setBounds(580, 75, 100, 25);
		add(btCalculate).setBounds(250, 150, 200, 75);
		add(btNoise).setBounds(500, 150, 100, 75);
		add(plotPanel).setBounds(20, 250, 600, 400);
		btCalculate.addActionListener(this);
		btCalcHarm.addActionListener(this);
		btNoise.addActionListener(this);
	}

	/**
	 * <pre>
	 * - Falls btCalcHarm Quelle des Event 
	 *   - int zufall zwischen 0...9 erzeugen
	 *   - tfHarm mit Zufallszahl belegen (mit setText(),Achtung String Konvertierung!)
	 * - Falls btCalculate Quelle des Event
	 *   - int nHarm mit Wert aus Textfeld belegen
	 *   - signal gleich berechneImpuls(...) mit entsprechenden Parametern berechnen
	 * - Falls btNoise Quelle des Event
	 *   - signal gleich berechneNoise(...) mit entsprechenden Parametern berechnen
	 * - Setzt Signal des PlotPanels mit entprechender Klassenmethode.
	 * - Löst Neuzeichnen aus.
	 * </pre>
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		int N = 620; // Anzahl Punkte auf der x Achse
		// 10
		// ToDo

		if (e.getSource() == btCalcHarm) {
			int zufall = (int) (10 * Math.random());
			tfHarm.setText(Integer.toString(zufall));
		}
		if (e.getSource() == btCalculate) {

			int nHarm = Integer.parseInt(tfHarm.getText());

			signal = berechneImpuls(amp, freq, nHarm, N);

		}
		if (e.getSource() == btNoise) {
			signal = berechneNoise(amp, N);
		}
		plotPanel.setSignal(signal);
		repaint();

	}

	/**
	 * <pre>
	 * - mit drawImage formel bei (x=0,y=20) zeichnen
	 * </pre>
	 */
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		// 1
		// ToDo
		g.drawImage(formel, 0, 20, null);
	}

	/**
	 * <pre>
	 * 	-Berechnet aufgrund der Parameter Impulssignal
	 * </pre>
	 */
	private double[] berechneImpuls(double amp, double freq, int nHarm, int N) {

		double[] y = new double[N];
		double alpha = Math.PI / 3.0;
		// 5
		// ToDo
		for (int n = 0; n < N; n++) {
			for (int k = 1; k <= nHarm; k++) {
				y[n] += 4 * amp / Math.PI * Math.cos(alpha * (2 * k - 1))
						* Math.sin(2 * Math.PI * (2 * k - 1) * freq * n / (N - 1)) / (2 * k - 1);
				
				
			}

		}
		
		
		
		
		
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
		for (int n = 0; n < N; n++) {
			y[n] = 2 * amp * (Math.random() - 0.5);
		}
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