import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.UIManager;

public class WackApp {

	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		}

		JFrame frame = new JFrame("Wack-a-Pumpkin");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		final WackPanel panel = new WackPanel();
		panel.setPreferredSize(new Dimension(800, 600));
		panel.setDoubleBuffered(true);
		frame.add(panel);

		frame.pack();
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setIconImage(panel.image);

		panel.init();
		panel.setFocusable(true);
		panel.requestFocus();
	}

}
