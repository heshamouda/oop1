import java.awt.Color;
import java.awt.Frame;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

public class SchokoSpielApplikation extends JFrame {
	private static final long serialVersionUID = 1L;
	private Image icon = Utility.loadResourceImage("monster.png");
	private TopView view = new TopView();

	public void init() {
		setTitle("Schoko Spiel");
		setIconImage(icon);
		view.setBackground(new Color(157, 32, 27));
		add(view);
	}

	public static void main(String args[]) {
		SchokoSpielApplikation frame = new SchokoSpielApplikation();
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(1);
			}
		});
		frame.init();
		frame.setSize(1000, 710);
		frame.setResizable(false);
		frame.setVisible(true);
		frame.setFont(frame.getFont().deriveFont(20.0f));
	}
}
