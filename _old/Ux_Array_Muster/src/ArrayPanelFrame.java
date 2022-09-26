import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.lang.String;

class ArrayPanel extends JPanel implements ActionListener {
	private static final long serialVersionUID = 1L;
	private JTextArea data = new JTextArea();
	private JButton btMultiply = new JButton("Multiply");
	private JButton btAdd = new JButton("Add");
	private JButton btPascal = new JButton("Pascal's triangle");
	private JButton btRandomMatrices = new JButton("Random Matrices");
	private final int dimension = 3;
	private int[][] matrixA = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
	private int[][] matrixB = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
	private int[][] matrixResult = new int[dimension][dimension];

	public void init() {
		setLayout(null);

		data.setFont(new Font("monospaced", Font.BOLD, 16));
		add(data).setBounds(5, 5, 300, 300);
		add(btRandomMatrices).setBounds(5, 340, 200, 20);
		btRandomMatrices.addActionListener(this);
		add(btAdd).setBounds(5, 370, 200, 20);
		btAdd.addActionListener(this);
		add(btMultiply).setBounds(5, 400, 200, 20);
		btMultiply.addActionListener(this);
		add(btPascal).setBounds(5, 430, 200, 20);
		btPascal.addActionListener(this);

		showResult();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btPascal) {
			calcPascalTriangle();
		}
		if (e.getSource() == btRandomMatrices) {
			randomFillMatrix(matrixA);
			randomFillMatrix(matrixB);
			showResult();
		}
		if (e.getSource() == btAdd) {
			matrixResult = addMatrix(matrixA, matrixB);
			showResult();
		}
		if (e.getSource() == btMultiply) {
			matrixResult = multiplyMatrix(matrixA, matrixB);
			showResult();
		}

	}

	/**
	 * Füllt die übergebene Matrix mit zufälligen Zahlen im Bereich 0...9
	 * 
	 * @param matrix
	 */
	private void randomFillMatrix(int[][] matrix) {

		for (int row = 0; row < dimension; row++) {
			for (int col = 0; col < dimension; col++) {
				matrix[row][col] = (int) (Math.random() * 10.0);
			}
		}
	}

	/**
	 * Berechnet Addition zweier Matrizen
	 * 
	 * @param matrix1
	 * @param matrix2
	 * @return Summe beider Matrizen
	 */
	private int[][] addMatrix(int[][] matrix1, int[][] matrix2) {
		int[][] matrixC = new int[dimension][dimension];
		for (int row = 0; row < dimension; row++) {
			for (int col = 0; col < dimension; col++) {
				matrixC[row][col] = matrix1[row][col] + matrix2[row][col];
			}
		}
		return matrixC;
	}

	private int[][] multiplyMatrix(int[][] matrix1, int[][] matrix2) {
		int[][] matrixC = new int[dimension][dimension];
		int summe = 0;

		for (int row = 0; row < dimension; row++) {
			for (int col = 0; col < dimension; col++) {
				for (int j = 0; j < dimension; j++) {
					summe += matrix1[row][j] * matrix2[j][col];
				}
				matrixC[row][col] = summe;
				summe = 0;
			}
		}
		return matrixC;
	}

	private void showResult() {
		data.setText("");// löscht das TextArea
		data.append("Matrix A: ");
		for (int row = 0; row < dimension; row++) {
			for (int col = 0; col < dimension; col++) {
				data.append(String.format("%3d", matrixA[row][col]) + " ");
			}
			data.append("\r\n");
		}

		data.append("Matrix B: \r\n");
		for (int row = 0; row < dimension; row++) {
			for (int col = 0; col < dimension; col++) {
				data.append(String.format("%3d", matrixB[row][col]) + " ");
			}
			data.append("\r\n");
		}

		data.append("\r\n Result: \r\n");
		for (int row = 0; row < dimension; row++) {
			for (int col = 0; col < dimension; col++) {
				data.append(String.format("%3d", matrixResult[row][col]) + " ");
			}
			data.append("\r\n");
		}

	}

	/**
	 * <pre>
	 * Berechnung und Darstellug Pascalsches Dreieck 
	 * - 2D int array triangle mit 7 Zeilen anlegen 
	 * - TexArea löschen 
	 * - für row von 0 bis kleiner Länge von triangle
	 * 	- Spalte in triangle[row] mit Länge row+1 erzeugen 
	 *    - für col von 0 bis kleiner gleich row
	 *      - falls col gleich 0 oder coll gleich row:
	 *        - triangle Element auf eins setzen 
	 *      - sonst:
	 *        - triangle Element auf triangle[row - 1][col - 1] + triangle[row - 1][col] setzten 
	 *      - triangle Element anzeigen 
	 *    - Zeilenumbruch erzeugen
	 * </pre>
	 */
	private void calcPascalTriangle() {
		int[][] triangle = new int[7][];

		data.setText("");

		for (int row = 0; row < triangle.length; row++) {
			String spc = new String(new char[(14 - 2 * row)]).replace('\0', ' ');
			data.append(spc);

			triangle[row] = new int[row + 1];

			for (int col = 0; col <= row; col++) {
				if ((col == 0) || (col == row)) {
					triangle[row][col] = 1;
				} else {
					triangle[row][col] = triangle[row - 1][col - 1] + triangle[row - 1][col];
				}

				data.append(String.format("%3d", triangle[row][col]) + " ");// macht 3 Stellen aus jedem Feld so dass
																			// Einer untereinander stehen
			}
			data.append("\r\n");
		}
	}

}

public class ArrayPanelFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private static Image icon = Utility.loadResourceImage("apple.png");

	public static void main(String args[]) {

		ArrayPanelFrame frame = new ArrayPanelFrame();
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(1);
			}
		});
		ArrayPanel view = new ArrayPanel();
		view.init();
		/*
		 * view.addMouseMotionListener(new MouseMotionAdapter() { public void
		 * mouseMoved(MouseEvent e) { System.out.println("x: " + e.getX() + " y: " +
		 * e.getY()); } });
		 */
		frame.add(view);
		frame.setSize(400, 600);
		frame.setIconImage(icon);
		frame.setTitle("|FHNW|EIT|OOP|Array-Panel|");
		frame.setResizable(true);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
	}
}
