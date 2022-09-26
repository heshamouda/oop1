import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;

import utils.ImageHelper;

public class Lobster {
	int x;
	int y;
	Color color;
	
	
	public Lobster(int x, int y, Color color) {
		super();
		this.x = x;
		this.y = y;
		this.color = color;
	}


	void draw (Graphics kreide ) {
		// TODO Auto-generated method stub
		kreide.setColor(color);
		kreide.fillRect(x+0,y+0, 50, 50);
		kreide.fillRect(x+250,y+0,50,50);
		kreide.fillRect(x+50,y+50,200,100);
		kreide.fillRect(x+25,y+150,25,50);
		kreide.fillRect(x+250,y+150,25,50);
		
		kreide.fillRect(x+100,y+0,25,50);
		kreide.fillRect(x+200,y+0,25,50);
		
		
		
		kreide.setColor(Color.black);
		kreide.fillOval(x+110,y+10,10,10);
		kreide.fillOval(x+210,y+10,10,10);
             
	}

}
