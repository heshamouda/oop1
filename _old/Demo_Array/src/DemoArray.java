import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

class ArrayPanel extends JPanel {

	// 1. 8 Bilder vom Typ Image anlegen
	
	private int[] tabelle = new int[10];
	int[][] dim2Array = { { 1, 2 }, { 2, 3 }, { 3, 4 } };
	private int x = 1;

	public void init() {
		setLayout(null);
		// 2. Image Objekte mit Utility.LoadResourceImage laden und Modulo Rechnung
		

		

		// 3. --> Methode tabelle füllen erstellen
		//fuellen(tabelle);

		// 4. Tabelle anzeigen
		

		// 5. Methode fuenfSetzen
		//fuenfSetzen(x);
		//System.out.println(x);

		// 6. 2dim Array darstellen
		

		// Zeile aus Matrix extrahieren
		

		System.out.println(); //für breakpoint

	}

	// 3. Methode zum füllen von array
	

	// 5. Methode fuenfSetzen
	

	private double[][] getData() {
		double[][] retval = { { 1, 2, 3, 4 }, { 0.1, 0.2, 0.3, 0.4 }, { 2, 1, 5, 3 } };
		return retval;
	}

	@Override
	public void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		for (int i = 0; i < 8; i++) {
			//g.drawImage(bild[i], 10 + i * 100, 200, null);
		}
		g.setColor(Color.blue);
		// g.fillPolygon(new int[] {20,70,120},new int[] {50,10,50} , 3);
	}
}

public class DemoArray extends JFrame {

	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		DemoArray frame = new DemoArray();
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(1);
			}
		});
		ArrayPanel view = new ArrayPanel();
		view.init();
		frame.setSize(1000, 800);
		frame.add(view);
		frame.setResizable(true);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);

	}

}
