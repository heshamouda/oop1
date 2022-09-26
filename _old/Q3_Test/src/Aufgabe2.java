
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
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

class TestPanel extends JPanel  {
	// Hinweise in Anleitung und Code beachten
	
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