import java.awt.*;
import java.awt.event.*;
import java.util.Iterator;

import javax.swing.*;

class FourierPanel extends JPanel implements ActionListener {
	private TraceV7 trace = new TraceV7(this);
	private JTextField tfAmp = new JTextField("1.0");
	private JTextField tfFreq = new JTextField("1.0");
	private JTextField tfHarm = new JTextField("10");
	private JComboBox<String> cbForm = new JComboBox<String>();
	private JButton btBerechne = new JButton("Berechne");
	private PlotPanel plotPanel = new PlotPanel();
	private double[] signal = {};

	/**
	 * <pre>
	 * - Baut GUI 
	 * - Registriert Listener
	 * </pre>
	 */
	public FourierPanel() {
		trace.constructorCall();
		setLayout(null);
		int x = 50;
		int y = 25;
		add(new JLabel("Amplitude")).setBounds(x, y, 125,25);
		add(tfAmp).setBounds(x+125, y, 125, 25);
		
		x=350;
		add(new JLabel("Frequenz")).setBounds(x, y, 125, 25);
		add(tfFreq).setBounds(x+125, y, 125, 25);
		
		x=50;
		y=75;
		add(new JLabel("Signalformm")).setBounds(x, y, 125, 25);
		add(cbForm).setBounds(x+125, y, 125, 25);
		
		cbForm.addItem("Rechteck");
		cbForm.addItem("Dreieck");
		cbForm.addItem("Saegezahn");
		
		x=350;
		add(new JLabel("#Harmonischer")).setBounds(x, y, 125,25);
		add(tfHarm).setBounds(x+125, y, 125, 25);
		
		x=25;
		y=125;
		add(plotPanel).setBounds(x, y, 650, 400);
		
		x=25;
		y=550;
		add(btBerechne).setBounds(x, y, 650, 25);	
		btBerechne.addActionListener(this);	

	}

	/**
	 * <pre>
	 * - Liest Information aus GUI aus und legt sie in entsprechenden lokalen Var. ab.
	 * - Verzweigung cbForm.getSelectedIndex():
	 *   - Fall 0:
	 *     - signal gleich berechneRechteck() mit entsprechenden Parametern berechnen.
	 *   - Fall 1:
	 *     - signal gleich berechneDreieck() mit entsprechenden Parametern berechnen.
	 *   - Fall 2:
	 *     - signal gleich berechneSaegezahn() mit entsprechenden Parametern berechnen.
	 * - Setzt Signal des PlotPanels mittels setSignal().
	 * - Löst Neuzeichnen aus.
	 * </pre>
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		trace.eventCall();
		int N = 620; // Anzahl Punkte auf der x Achse
		double amp = Double.parseDouble(tfAmp.getText());
		double freq = Double.parseDouble(tfFreq.getText());
		int nHarm= Integer.parseInt(tfHarm.getText());
		switch (cbForm.getSelectedIndex()) {
		case 0:
			signal=berechneRechteck(amp, freq, nHarm, N);
			break;
		
		case 1:
			signal= berechneDreieck(amp, freq, nHarm, N);
			break;
			
		case 2:
			signal= berechneSaegezahn(amp, freq, nHarm, N);
			break;				
		}	
		
		plotPanel.setSignal(signal);
		repaint();
	}

	/**
	 * <pre>
	 * 	-Berechnet aufgrund der Parameter Rechtecksignal
	 * </pre>
	 * 
	 * @param amp
	 * @param freq
	 * @param nHarm
	 * @return
	 */
	private double[] berechneRechteck(double amp, double freq, int nHarm, int N) {
		trace.methodeCall();
		double[] y = new double[N];
		for (int n = 0; n < N; n++) {
			for(int k=1; k<= nHarm;k++) {
				y[n]+=4*amp/Math.PI*Math.sin(2*Math.PI*freq*(2*k-1)*n/(N-1))/(2*k-1);
			}
			
		}

		return y;
	}

	/**
	 * <pre>
	 * 	-Berechnet aufgrund der Parameter Dreiecksignal
	 * </pre>
	 * 
	 * @param amp
	 * @param freq
	 * @param nHarm
	 * @return
	 */
	private double[] berechneDreieck(double amp, double freq, int nHarm, int N) {
		trace.methodeCall();
		double[] y = new double[N];
		for (int n=0;n<N;n++) {
			for (int k=1;k<=nHarm;k++) {
				y[n]+= 4*amp/Math.PI * Math.pow(-1, k+1)
					   *(Math.sin(2*Math.PI * freq * (2*k-1)*n
							   /(N-1)) / Math.pow((2 * k-1), 2));
			}
		}
		return y;
	}

	/**
	 * <pre>
	 * 	-Berechnet aufgrund der Parameter Saegezahnsignal
	 * </pre>
	 * 
	 * @param amp
	 * @param freq
	 * @param nHarm
	 * @return
	 */
	private double[] berechneSaegezahn(double amp, double freq, int nHarm, int N) {
		trace.methodeCall();
		double[] y = new double[N];
		for (int n=0;n<N;n++) {
			for (int k=1;k<=nHarm;k++) {
				y[n]+= 2*amp/Math.PI * Math.pow(-1, k+1)
					   *Math.sin(2*Math.PI * freq * k*n
							   /(N-1)) / k;
			}
		}

		return y;
	}

}

public class FourierPanelFrame extends JFrame {
	private TraceV7 trace = new TraceV7(this);
	private Image icon = Utility.loadResourceImage("Fourier.png");
	private FourierPanel view = new FourierPanel();

	public FourierPanelFrame() {
		trace.constructorCall();
		add(view);
		setSize(720, 720);
		setIconImage(icon);
		setTitle("|FHNW|EIT|OOP|Fourier-Panel|");
		setLocationRelativeTo(null);
		setResizable(true);
		setVisible(true);
	}

	public static void main(String args[]) {
		TraceV7.mainCall();
		FourierPanelFrame frame = new FourierPanelFrame();
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(1);
			}
		});

	}
}