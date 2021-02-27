import java.awt.Color;
import java.awt.Graphics;

public class Tree {
	
	public static final Color STEM_BROWN_1 = Color.decode("#8b3700");
	public static final Color STEM_BROWN_2 = Color.decode("#b30000");
	public static final Color STEM_BROWN_3 = Color.decode("#4d1a00");
    
	public static final Color FOLIAGE_GREEN_1 = Color.decode("#0c5000");
	public static final Color FOLIAGE_GREEN_2 = Color.decode("#408000");
	public static final Color FOLIAGE_GREEN_3 = Color.decode("#00b300");
	
	public int x, y;
	public Color foliageColor;
	public Color stemColor;
	
	//die Atribute werden in Konstruktor initialisiert
	public Tree(int x, int y, Color foliageColor, Color stemColor) {
		this.x = x;
		this.y = y;
		this.foliageColor = foliageColor;
		this.stemColor = stemColor;
	}


	public void drawTree( Graphics g) {
		// TODO drawTree implementieren
		
		g.setColor(Color.BLACK);
		g.fillRect(x - 11, y - 51, 22, 52);
		g.fillOval(x - 31, y - 101, 62, 62);
		g.fillOval(x - 31, y - 176, 62, 102);
		g.fillOval(x - 31, y - 201, 62, 102);

		g.setColor(stemColor);
		g.fillRect(x - 10, y - 50, 20, 50);
		g.setColor(foliageColor);
		g.fillOval(x - 30, y - 100, 60, 60);

		g.setColor(foliageColor);
		g.fillOval(x - 30, y - 175, 60, 100);

		g.setColor(foliageColor);
		g.fillOval(x - 30, y - 200, 60, 100);

	}
	
	

}
