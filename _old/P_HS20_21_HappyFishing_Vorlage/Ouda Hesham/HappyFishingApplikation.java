import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

public class HappyFishingApplikation extends JFrame {
	private static final long serialVersionUID = 1L;
	private Image icon = Utility.loadResourceImage("fisch.png");

	private SpielPanel view = new SpielPanel();

	public HappyFishingApplikation() {
		setTitle("Happy Fishing");
		setIconImage(icon);
		add(view);
		pack();
		setResizable(false);
		setVisible(true);
	}

	public static void main(String args[]) {
		HappyFishingApplikation frame = new HappyFishingApplikation();
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(1);
			}
		});
	}

}
