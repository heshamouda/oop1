import javax.swing.JFrame;

public class HelloApp extends JFrame {

	public static void main(String[] args) {
		JFrame frame = new JFrame("Welcome to Space");// frame ist  Instanz von JFrame,mit new wir erstellen ein Objekt/Instanz
		//Methoden von JFrame
		frame.setSize(800, 600); //method to set window's size
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(new HelloPanel()); //Ein objekt erstellt (Instanz von der Klasse HelloPanel
 
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
}
