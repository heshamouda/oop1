package Kapitel3;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class DrawExemple extends JFrame
		implements ActionListener {
		private JButton button;
		private JPanel panel;

	public static void main(String[] args) {
		DrawExemple frame = new DrawExemple();
		frame.setSize(400, 300);
		frame.createGUI();
		frame.setVisible(true);
		}
		private void createGUI() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		Container window = getContentPane();
		window.setLayout(new FlowLayout() );
		panel = new JPanel();
		panel.setPreferredSize(new Dimension(300, 200));
		panel.setBackground(Color.YELLOW);
		window.add(panel);
		button = new JButton("Drück mich");
		window.add(button);
		button.addActionListener(this);
		}
		public void actionPerformed(ActionEvent event) {
		Graphics paper = panel.getGraphics();
		paper.drawLine(0, 0, 100, 100);
		paper.drawLine(100, 100, +200, +50);
	}
}
