
// Ich bestaetige, dass ich diese Pruefung selbstaendig geloest habe.

// Ich weiss, dass bei Zuwiderhandlung die Note 1 erteilt wird.
//
// Name:OUDA
// Vorname:HESHAM
//
import java.awt.*;
import java.awt.event.*;

import javax.crypto.interfaces.DHPrivateKey;
import javax.swing.*;

import org.graalvm.compiler.lir.aarch64.AArch64BreakpointOp;

import sun.text.resources.cldr.ext.FormatData_el;



class SignalGenerator extends JPanel implements ActionListener {

	private double amp = 1.0, freq = 2.0;
	private Image formel = Utility.loadResourceImage("Impuls.png", 450, 100);
	private double[] signal = {};
	// ToDo: hier die fehlenden Objekte ergänzen und erzeugen
	// die Anzeigetexte entnehmen Sie der Skizze auf dem Aufgabenlatt.
	// 5P

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
	private JButton btCalcHarm = new JButton("CalcHarm");
	
	private JTextField tfHarm= new JTextField("10");
	private JButton calculate = new JButton("Calculate");
	private JButton noise = new JButton("Noise");
	private PlotPanel plotPanel= new PlotPanel();
	
	
	public SignalGenerator() {

		setLayout(null);
		// 9
		// ToDo
		 		
		add(new JLabel("#Harmonics")).setBounds(500,75,125,25);
		add(tfHarm).setBounds(580, 75, 100, 25);
		add(plotPanel).setBounds(20, 25, 600, 400);
		add(calculate).setBounds(250, 150, 200, 75);
		calculate.addActionListener(this);
		add(noise).setBounds(500, 150, 100, 75);
		noise.addActionListener(this);
		add(btCalcHarm).setBounds(525, 25, 125, 25);
		btCalcHarm.addActionListener(this);
			

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
		super.PlotPanel;
		if(btCalcHarm==e.getSource()) {
			int zufall= (int) (Math.random()*10);
			 			 
			tfHarm.setText(Integer.toString(zufall));
		}
		
		if(calculate==e.getSource()) {
			int nHarm = Integer.parseInt(tfHarm.getText());
			 			 
			 }
		
		if(noise==e.getSource()) {
			signal= berechneNoise(N, N);
			 			 
					}
		
		PlotPanel.setSignal(signal);
		
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