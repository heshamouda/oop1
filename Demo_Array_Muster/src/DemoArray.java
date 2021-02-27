import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

class ArrayPanelMuster extends JPanel {

	private Image[] bild = new Image[8];
	private int[] tabelle = new int[10];
	int[][] dim2Array = { { 1, 2 }, { 2, 3 }, { 3, 4 } };
	private int x = 0;

	public void init() {
		setLayout(null);
		for (int i = 0; i < 8; i++) {
			bild[i] = Utility.loadResourceImage("Image_" + (i + 1) + ".png"); // Achtung bei Indizierung!!
		}
		System.out.println(bild[2].getHeight(this)); // Zugriff auf Objektmethode eines Arrays

		//Beispiel mit Modulo Rechnung als "Ringbuffer"
//		int count = 0;
//		for (int i = 0; i < 100; i++) {
//			int index = count % 8;
//			bild[index] = Utility.loadResourceImage("Image_" + (index + 1) + ".png");
//			System.out.println(index);
//			count++;
//		}
		

		fuellen(tabelle);

		for (int i = 0; i < tabelle.length; i++) {
			System.out.println(tabelle[i]);
		}

		fuenfSetzen(x);
		System.out.println(x);

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 2; j++) {
				System.out.print(dim2Array[i][j] + "  ");
			}
			System.out.println();
		}

		double[] extract = getData()[0];

		System.out.println();

	}

	private void fuellen(int[] array) {
		for (int i = 0; i < array.length; i++) {
			array[i] = 42;
		}

	}

	private void fuenfSetzen(int x) {
		x = 5;
	}

	private double[][] getData() {
		double[][] retval = { { 1, 2, 3, 4 }, { 0.1, 0.2, 0.3, 0.4 }, { 2, 1, 5, 3 } };
		return retval;
	}

	@Override
	public void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		for (int i = 0; i < 8; i++) {
			g.drawImage(bild[i], 10 + i * 100, 200, null);
			g.setColor(Color.blue);
			g.fillPolygon(new int[] { 20, 70, 120 }, new int[] { 50, 10, 50 }, 3);
		}
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
		ArrayPanelMuster view = new ArrayPanelMuster();
		view.init();
		frame.setSize(1000, 800);
		frame.add(view);
		frame.setResizable(true);
		frame.setVisible(true);

	}

}
