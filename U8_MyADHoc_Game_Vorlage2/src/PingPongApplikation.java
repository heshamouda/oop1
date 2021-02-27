import java.awt.Color;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

public class PingPongApplikation extends JFrame {
	private Image icon = Utility.loadResourceImage("ball.png");
	private TopViewPanel view;

	public PingPongApplikation() {

		view = new TopViewPanel();
		setTitle("Ping-Pong-Game");
		setIconImage(icon);
		view.setBackground(new Color(224, 224, 224));
		add(view);
		setSize(1000, 700);
		setResizable(false);
		setVisible(true);
		setLocationRelativeTo(null);
	}

	public static void main(String args[]) {
		PingPongApplikation frame = new PingPongApplikation();
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(1);
			}
		});
	}
}
