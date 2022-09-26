import java.awt.Dimension;

import javax.swing.JFrame;

public class BigButtonApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	 
		JFrame frame= new JFrame("Big Bad Button");   
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		BigButtonPanel panel= new BigButtonPanel();  
		panel.setPreferredSize(new Dimension(800,600));
		
		frame.add(panel); 
		
		frame.pack();
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		
		panel.init();
		
	}

}
