import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Ballon {
	private TraceV7 trace = new TraceV7(this);
	private int x, y, d;
	private Image bild;
	

	public Ballon(int x, int y, int d) {
		trace.constructorCall();
		this.x = x;
		this.y = y;
		this.d = d;
		

		bild = Utility.loadResourceImage("Image_1.png");
		System.out.println("Objekt " + this + " hat die Attribute: " + "x=" + x + ", y=" + y + ", d=" + d);
	}

	public void anzeigen(Graphics g) {
		trace.methodeCall();
		g.drawImage(bild, x - d / 2, y - d / 2, d, d, null);
	}

	public void groesseVeraendern(int v) {
		trace.methodeCall();
		d += v;
	}
	
	public void update() {
		y +=5;
	}
	
	public int getYValue() {
		return y;
	}
	

	

}
