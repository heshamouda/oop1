import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;
import javax.swing.Timer;

import utils.ImageHelper;

public class LandscapePanel extends JPanel {
	
	int x=0;
	

	private static final long serialVersionUID = 1L;

	// Wolke, mit g.drawImage(x,y,w,h,null) zeichnen
	private final BufferedImage cloud = ImageHelper.loadImage("res/cloud.png");//importieren Wolke Bild

	// Black magic, Antialias
	private final static RenderingHints CONFIG = new RenderingHints(RenderingHints.KEY_ANTIALIASING,
			RenderingHints.VALUE_ANTIALIAS_ON);//schöne Kanten
	
	//final ist Konstant
	

	// Farben, welche Sie mit g.setColor verwenden kÃ¶nnen
	private static final Color BROWN = Color.decode("#8b3700");  //variable 
	private static final Color TREE_GREEN = Color.decode("#0c5000"); //varaible

	public void init() {
		// TODO Timer starten
		System.out.println("init wurde aufgerufen");
		   new Timer(16, new ActionListener() {
			      @Override
			      public void actionPerformed(ActionEvent e) {
			         // TODO x inkrementieren
			    	  x+=1;
			    	  x=x% getWidth();
//			    	  if (x> getWidth()) {
//						x=-200;
//					}

			         // Panel wird neu gezeichnet
			         repaint();

			         // Render Pipeline flushen (Performance)
			         Toolkit.getDefaultToolkit().sync();
			      }
			   }).start();
		
	}

	@Override
	protected void paintComponent(Graphics g) {//Graphics g ist ein Objekt als unser Kreide
		System.out.println("paintCompnent wurde aufgerufen");
		System.out.println("Dimensions: "+getWidth()+"px X "+getHeight()+"px");
		// Black Magic, Antialiasing
		((Graphics2D) g).setRenderingHints(CONFIG);

		// TODO zeichnen Sie!
		g.setColor(Color.cyan); //erst Hintergrund zeichnen
		g.fillRect(0,0,getWidth(),getHeight());
		
		g.setColor(Color.green);
		g.fillRect(0, getHeight()-200, getWidth(), 200);
		
		 
		
		g.setColor(Color.yellow);
		g.fillOval(100,100,50,50);
		g.drawImage(cloud,x, 100,200,100, null);
		
		int smallCloudx= (int) (x*0.5);
		g.drawImage(cloud,smallCloudx, 20,150,66, null);
		g.setColor(BROWN);
		g.fillRect(350,  350,  20,  150);
		
		g.setColor(TREE_GREEN);
		g.fillOval(320,150, 80, 250);
		
		g.setColor(BROWN);
		g.fillOval(500, 250, 100, 100);
		
		g.setColor(Color.white);
		g.fillRect(500, 300, 100, 100);
		
		g.setColor(BROWN);
		g.fillRect(540 , 350, 20, 50);
		
		
	}
}
