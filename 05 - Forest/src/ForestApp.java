import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

import util.ActivePanel;

public class ForestApp {



	public static void main(String[] args) {
		JFrame frame = new JFrame("Forest");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		final ActivePanel panel = new ForestPanel();
		panel.setPreferredSize(new Dimension(800, 600));
		panel.setDoubleBuffered(true);
		frame.add(panel);

		frame.pack();
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);

		panel.onInit();
	}

}
