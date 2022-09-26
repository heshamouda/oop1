import javax.swing.JFrame;

public class LandscapeApp {

	public static void main(String[] args) {
		JFrame frame = new JFrame("Landscape App");
		frame.setSize(800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		LandscapePanel panel = new LandscapePanel();
		panel.setDoubleBuffered(true);
		frame.add(panel);  //frame zu fügen

		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.setResizable(false);//setzen frame size konstant
		
		panel.init();
	}
}
