import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class TopViewPanel extends JPanel implements ActionListener {
	private SpielPanel spielPanel = new SpielPanel();
	private JButton btStartStop = new JButton("Stop");

	/**
	 * <pre>
	 * - spielPanel mit (0, 0, 1000, 600) platzieren
	 * - btstartStop mit (110, 630, 780, 20) platzieren
	 * - ActionListener und KeyListener gemäss Klasendiagramm registrieren
	 * </pre>
	 */
	public TopViewPanel() {
		setLayout(null);
		add(spielPanel).setBounds(0, 0, 1000, 600);
		add(btStartStop).setBounds(110, 630, 780, 20); 
		btStartStop.addActionListener(this);
		btStartStop.addKeyListener(spielPanel);
	}

	/**
	 * <pre>
	 * - falls ButtonText Stop
	 * 		- ButtonText auf Start setzen
	 * 		- setStop Methode von spielPanel mit wahr aufrufen
	 * - sonst
	 * 		- ButtonText auf Stop setzen
	 * 		- setStop Methode von spielPanel mit falsch aufrufen
	 * </pre>
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (btStartStop.getText().equals("Stop")) {
			btStartStop.setText("Start");
			spielPanel.setStop(true);
			
		} else {
			btStartStop.setText("Stop");
			spielPanel.setStop(false);
		}
	}
}