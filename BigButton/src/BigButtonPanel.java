import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class BigButtonPanel extends JPanel{
	boolean pressed;

	public void init() {
		setLayout(null);
		JButton button= new JButton("BIG BAD BUTTON");
		add(button);
	 
		button.setBounds(getWidth()/2- 200,getHeight()/2- 100,400, 200); 
		
		
 
		

	button.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			 
			pressed= !pressed;
			repaint();
			
			
		}
	});
 
	
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		 if (pressed) {
			g.setColor(Color.BLACK);
			g.fillRect(0, 0, getWidth(), getHeight());
			
		} else {
			g.setColor(Color.WHITE);
			g.fillRect(0, 0, getWidth(), getHeight());
			
		}
	}
	
}
