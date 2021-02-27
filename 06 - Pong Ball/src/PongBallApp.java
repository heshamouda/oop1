import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;

import util.ActivePanel;

public class PongBallApp {



	public static void main(String[] args) {
		JFrame frame = new JFrame("Pong Ball");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		final ActivePanel panel = new PongBallPanel();
		panel.setPreferredSize(new Dimension(800, 600));
		panel.setDoubleBuffered(true);
		frame.add(panel);

		frame.pack();
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);

		panel.onInit();
		panel.setFocusable(true);
		panel.requestFocus();
		
		JButton  startButton= new JButton("START");
		panel.setLayout(null);
		panel.add(startButton);
		startButton.setBounds(300, 250, 200, 100);
		
	}

}
