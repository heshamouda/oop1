
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

class TestPanel extends JPanel implements ActionListener {
	// ToDo: Im Konstruktor der Klasse soll noch Registrierung des ActionListeners
	// erfolgen. Hierzu ein JTextField() bei der Deklaration erzeugen. Ein Vogel
	// muss nicht erzeugt werden!
	// 15 (mit Schnittstelle)eigentlich 16
	private int count;
	private Vogel spatz;
	private JTextField tfName = new JTextField();
	

	public TestPanel() {
		tfName.addActionListener(this);

	}

	public void paintComponent(Graphics g) {
		g.drawString("Hier gibt es nichts zu sehen", 50, 250);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

}

class Vogel extends Flugkoerper {

	public Vogel(int x, int y, int vx, int vy) {
		super(x, y, vx, vy);
	}

	public void fliegen() {

	}
}

class Flugkoerper {
	protected int x;
	protected int y;
	protected int vx;
	protected int vy;

	public Flugkoerper(int x, int y, int vx, int vy) {

	}

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