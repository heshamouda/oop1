
// Ich bestaetige, dass ich diese Pruefung selbstaendig geloest habe.
// Ich weiss, dass bei Zuwiderhandlung die Note 1 erteilt wird.
//
// Name:
// Vorname:
//
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class AufgabenPanel extends JPanel  {

	

}

// Muss nicht verändert werden!!
public class Aufgabe1 extends JFrame {

	private AufgabenPanel view = new AufgabenPanel();

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