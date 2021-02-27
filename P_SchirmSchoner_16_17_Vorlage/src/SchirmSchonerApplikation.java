
// Name: 
// Vorname:

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class SchirmSchonerApplikation extends JFrame {
	private static final long serialVersionUID = 1L;
	private static final int VOLLBILD = 0, TEILBILD = 1;
	private int mode = TEILBILD;
	// private int mode = VOLLBILD;

	private TopView topView;

	public SchirmSchonerApplikation() {
		getContentPane().setLayout(new BorderLayout());
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setIconImage(Utility.loadResourceImage("UhrIcon.png"));
		int w = screenSize.width;
		int h = screenSize.height;

		switch (mode) {
		case TEILBILD:
			topView = new TopView(2 * w / 3, 2 * h / 3);
			getContentPane().add(topView);
			setSize(2 * w / 3, 2 * h / 3 + 50);
			setLocation(w / 2 - w / 3, h / 2 - h / 3);
			setUndecorated(false);
			break;
		case VOLLBILD:
			topView = new TopView(w, h);
			getContentPane().add(topView);
			setSize(w, h);
			setLocation(0, 0);
			setUndecorated(true);
			break;
		}

	}

	public void setAllFonts(Component[] comps, Font font) {
		for (int i = 0; i < comps.length; i++) {
			comps[i].setFont(font);
			if (comps[i] instanceof Container) {
				setAllFonts(((Container) comps[i]).getComponents(), font);
			}
		}
	}
	
	public void init() {
	}

	public static void main(String args[]) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				SchirmSchonerApplikation frame = new SchirmSchonerApplikation();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setTitle("SchirmSchonerApplikation");
				frame.setResizable(false);
				frame.setVisible(true);
				synchronized (frame.getTreeLock()) {
					frame.setAllFonts(frame.getComponents(), frame.getFont().deriveFont(30.0f));
				}
			}
		});
	}
}
