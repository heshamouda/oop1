
// Ich bestaetige, dass ich diese Pruefung selbstaendig geloest habe.
// Ich weiss, dass bei Zuwiderhandlung die Note 1 erteilt wird.
//
// Name:
// Vorname:
//
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

class TestPanel extends JPanel {
	// ToDo: Im Konstruktor der Klasse soll noch Registrierung des ActionListeners
	// erfolgen. Hierzu ein JTextField() bei der Deklaration erzeugen.Ein Vogel
	// muss nicht erzeugt werden!
	// 15

	public void paintComponent(Graphics g) {
		g.drawString("Hier gibt es nichts zu sehen", 50, 250);
	}

}

class Vogel {

}

class Flugkoerper {

}

// muss nicht verändert werden
public class Aufgabe2 extends JFrame {

	private TestPanel view = new TestPanel();

	public Aufgabe2() {

		add(view);
		setSize(520, 520);

		setTitle("|FHNW|EIT|OOP|Aufgabe2|");
		setLocationRelativeTo(null);
		setResizable(true);
		setVisible(true);
	}

	public static void main(String args[]) {

		Aufgabe2 frame = new Aufgabe2();
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(1);
			}
		});

	}
}