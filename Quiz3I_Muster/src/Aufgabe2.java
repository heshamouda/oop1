
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

class TestPanel extends JPanel implements ActionListener {
	// ToDo:Im Konstruktor der Klasse soll noch Registrierung des ActionListeners
	// erfolgen. Hierzu den JButton() bei der Deklaration erzeugen. Ein Ballon
	// muss nicht erzeugt werden
	// 15
	private boolean start = false;
	private Ballon ballon;
	private JButton btStart = new JButton();

	public TestPanel() {
		btStart.addActionListener(this);

	}

	public void paintComponent(Graphics g) {
		g.drawString("Hier gibt es nichts zu sehen", 50, 250);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

}

class Ballon extends BildObjekt {

	public Ballon(int x, int y, Image bild) {
		super(x, y, bild);
	}

	public void update() {

	}
}

class BildObjekt {
	protected int x;
	protected int y;
	protected Image bild;

	public BildObjekt(int x, int y, Image bild) {

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