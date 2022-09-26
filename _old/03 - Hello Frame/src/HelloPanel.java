import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;
import utils.ImageHelper;

public class HelloPanel extends JPanel { //herit JPanel

	private static final long serialVersionUID = 1L;
	private final BufferedImage rakete = ImageHelper.loadImage("res/rocket-idle.png");
	

	@Override
	protected void paintComponent(Graphics g) {
		System.out.println("Panel wird gezeichnet (W, H)"+getWidth()+" "+getHeight());
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, getWidth(), getHeight());
		//Sterne zeichnen
		g.setColor(Color.white);
		for (int i = 0; i < 1000; i++) {
			int x= (int)(Math.random()*getWidth());
			int y=(int)(Math.random()*getHeight	());
			g.fillRect(x, y, 1, 1);
			
		}
		
		double cx= getWidth()/2 - 100/2; //in der Mitte setzen
		double cy=getHeight()/2 - 100/2;
		
		g.fillOval((int)cx, (int)cy, 100, 100);
		
		g.drawImage(rakete, 100,100, null);
		
		

		// TODO
		// Farbe auf weiss setzen
		// Gefüllten Kreis bei 300,200 mit Radius 100 zeichnen
		// Rakete in der Mitte des Bildschirms zeichnen
		// Tipp: verwenden Sie .getWidth() und .getHeight() von rakete
		
		// TODO Bonus
		// Bonus: 1000 sterne 1x1 px Zeichnen (im Hintergrund)
		
	}
}
