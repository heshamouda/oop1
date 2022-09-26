import javax.swing.JFrame;
import javax.swing.JPanel;

public class TreasureIslandApp {

	public static void main(String[] args) {
		JFrame frame = new JFrame("Treasure Island");
		frame.setSize(800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel treasurePanel = new TreasureIslandPanel();
		frame.add(treasurePanel);
		
		treasurePanel.init();

		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

}
