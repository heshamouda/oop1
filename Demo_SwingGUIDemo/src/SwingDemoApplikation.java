import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class SwingDemoApplikation extends JFrame {

	

	
	private int width = 800, height = 600;
	private BasicControlPanel view = new BasicControlPanel();
//	 private BasicLayoutPanel view = new BasicLayoutPanel();
//	 private GridBagLayoutPanel view = new GridBagLayoutPanel();



	public void init() {
		setLayout(new BorderLayout());
		add(view, BorderLayout.CENTER);

		setSize(width, height);
		setResizable(false);
		setLocationRelativeTo(null);

	}

	public static void main(String args[]) {
		SwingUtilities.invokeLater(new Runnable() {

			public void run() {

				SwingDemoApplikation frame = new SwingDemoApplikation();

				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setTitle("GUIDemoFramework");
				frame.init();
				frame.setVisible(true);
			}
		});
	}

}
