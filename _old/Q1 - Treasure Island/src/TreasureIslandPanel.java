import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JPanel;

import utils.ImageHelper;

public class TreasureIslandPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	Image hintergrund = ImageHelper.loadImage("res/sealife.jpg");
	
	Lobster redLobster= new Lobster(100,100, Color.red); //instanzieren 
	Lobster greeLobster= new Lobster(400,300,Color.green);

	@Override
	protected void paintComponent(Graphics g) {
		g.drawImage(hintergrund, 0, 0, 800, 600, null);
		
		redLobster.draw(g);
		greeLobster.draw(g);
		
//		redLobster.x= 100;
//		redLobster.y=100;
//		redLobster.color= Color.red;
//		
//		greeLobster.x= 400;
//		greeLobster.y= 300;
//		greeLobster.color= Color.green;
//		
		}


public void init() {
	 addMouseMotionListener(new MouseMotionListener() {
		
		@Override
		public void mouseMoved(MouseEvent e) {
			// TODO Auto-generated method stub
			int x=e.getX();
			int y=getY();
			
			redLobster.x=x;
			greeLobster.y=y;
			
			repaint();
			
		}
		
		@Override
		public void mouseDragged(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
	});Listener(new MouseM
}