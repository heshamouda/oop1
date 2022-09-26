
// Ich bestaetige, dass ich diese Pruefung selbstaendig geloest habe.
// Ich weiss, dass bei Zuwiederhandlung die Note 1 erteilt wird.
//
// Name:
// Vorname:
//

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TopView extends JPanel implements ActionListener, ItemListener {
	private JComboBox<String> cbLevel = new JComboBox<String>();
	private JComboBox<String> cbSex = new JComboBox<String>();
	private JButton btNeu = new JButton("Neues Spiel");
	private JButton btStart = new JButton("Start");
	private int level, sex;
	private SchokoSpielPanel schokoSpielPanel;

	/**
	 * <pre>
	 * - Haben Sie gebaut/erzeugt?
	 * - Haben Sie hinzugefügt?
	 * - Haben Sie Kabel eingesteckt?
	 * </pre>
	 */

	/**
	 * <pre>
	 * - Setzt das null - Layout.
	 * - Baut Benutzerschnittstelle gemäss Layout-Angaben.
	 * - Die Auswahlen (JComboBox) verfügen über die item 1 & 2 resp. Male & Female.
	 * - Registriert allfällige Listener.
	 * </pre>
	 */
	public TopView() {
		// 17
		setLayout(null);
		schokoSpielPanel = new SchokoSpielPanel();
		add(schokoSpielPanel).setBounds(0, 0, 1000, 600);
		add(new JLabel("Level")).setBounds(80, 610, 160, 25);
		cbLevel.addItem("1");
		cbLevel.addItem("2");
		add(cbLevel).setBounds(300, 610, 160, 25);
		add(new JLabel("Sex")).setBounds(560, 610, 160, 25);
		cbSex.addItem("Male");
		cbSex.addItem("Female");
		add(cbSex).setBounds(760, 610, 160, 25);
		add(btNeu).setBounds(80, 645, 380, 25);
		add(btStart).setBounds(540, 645, 380, 25);
		btNeu.addActionListener(this);
		btStart.addActionListener(this);
		cbLevel.addItemListener(this);
		cbSex.addItemListener(this);

	}

	/**
	 * <pre>
	 * - Falls e.getSource() gleich btNeu
	 *     - Methode neuesSpiel() des Spiel-Panels mit level und sex aufrufen.
	 * - Falls e.getSource() gleich btStart
	 *     - Methode start() des Spiel-Panels aufrufen.
	 * </pre>
	 */
	public void actionPerformed(ActionEvent e) {
		// 4
		if (e.getSource() == btNeu) {
			schokoSpielPanel.neuesSpiel(level, sex);
		}
		if (e.getSource() == btStart) {
			schokoSpielPanel.start();
		}

	}

	/**
	 * <pre>
	 * - Falls e.getSource() gleich cbLevel
	 *     - Attribut level gleich getSelectedIndex() von cbLevel setzen.
	 * - Falls e.getSource() gleich cbSex
	 *     - Attribut sex gleich getSelectedIndex() von cbSex setzen.
	 * </pre>
	 * 
	 * @param e
	 */
	public void itemStateChanged(ItemEvent e) {
		// 4
		if (e.getSource() == cbLevel) {
			level = cbLevel.getSelectedIndex();
		}
		if (e.getSource() == cbSex) {
			sex = cbSex.getSelectedIndex();
		}
		System.out.println(level);
	}

}
