import java.awt.Color;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

public class UhrApplikation extends JFrame {
	private static final long serialVersionUID = 1L;
	private Image icon = Utility.loadResourceImage("heart.png");
	private UhrPanel view = new UhrPanel();

	public UhrApplikation() {
		setSize(410, 175);
		add(view);
		setIconImage(icon);
		setTitle("|FHNW|EIT|OOP|7 - Segment - Uhr|");
		setForeground(Color.red);
		//setBackground(new Color(40, 40, 40));
		setBackground(Color.black);
		setResizable(false);
		setVisible(true);
		setLocationRelativeTo(null);
	}
 
	public static void main(String[] args) {
		new UhrApplikation().addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}
}
