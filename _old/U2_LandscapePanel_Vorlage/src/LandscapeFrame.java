import java.awt.*;
import java.awt.event.*;
import java.awt.geom.AffineTransform;
import javax.swing.*;

class LandscapePanel extends JPanel {
	private static final long serialVersionUID = 1L;

	public void init() {

	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);

	}

	// Black Magic ;-) ...
	private AffineTransform at = new AffineTransform();
	private boolean sizeSet = false;

	public void scaleGraphics(Graphics g, double scale) {
		if (!sizeSet) {
			getTopLevelAncestor().setSize(new Dimension((int) (scale * 400), (int) (scale * 300)));
			sizeSet = true;
			getTopLevelAncestor().revalidate();
			at.setToIdentity();
			at.scale(scale, scale);
		}
		((Graphics2D) g).setTransform(at);
	}
}

public class LandscapeFrame extends JFrame {
	static final long serialVersionUID = 1L;
	LandscapePanel view = new LandscapePanel();

	public LandscapeFrame() {
		setTitle("LandscapeFrame");
		add(view);
		setSize(800, 800);
		view.addMouseMotionListener(new MouseMotionAdapter() {
			public void mouseMoved(MouseEvent e) {
				System.out.println("x: " + e.getX() + " y: " + e.getY());
			}
		});
		view.init();
	}

	public static void main(String args[]) {
		LandscapeFrame frame = new LandscapeFrame();
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(1);
			}
		});
		frame.setResizable(true);
		frame.setVisible(true);
	}
}
