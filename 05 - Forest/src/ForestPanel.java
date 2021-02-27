import java.awt.Color;
import java.awt.Graphics;

import util.ActivePanel;

public class ForestPanel extends ActivePanel {

	private static final long serialVersionUID = 1L;

	
	private  static final Color STEM_BROWN_1 = Color.decode("#8b3700");
	private  static final Color STEM_BROWN_2 = Color.decode("#b30000");
	private  static final Color STEM_BROWN_3 = Color.decode("#4d1a00");
    
	private  static final Color FOLIAGE_GREEN_1 = Color.decode("#0c5000");
	private  static final Color FOLIAGE_GREEN_2 = Color.decode("#408000");
	private  static final Color FOLIAGE_GREEN_3 = Color.decode("#00b300");

	private static final Color GRASS_GREEN = Color.decode("#99ff33");

	@Override
	public void onInit() {
		// TODO was passiert, wenn das Frame startet?
		repaint();
	}
	
	
	public Color randomColor(Color...colors ) {
		int n= colors.length;
		int idx = (int) (n* Math.random());
		return colors[idx];		
	}
	
	public Color randomFoliage() {
		int n = (int) (Math.random() * 3);
		Color color;
		if (n == 0) {
			color = FOLIAGE_GREEN_1;
		} else if (n == 1) {
			color = FOLIAGE_GREEN_2;
		} else {
			color = FOLIAGE_GREEN_3;
		}
		return color;
		
	}
	
	public  Color randomStem() {		
		int k = (int) (Math.random() * 3);
		Color color;
		if (k == 0) {
			color = STEM_BROWN_1;
		} else if (k == 1) {
			color = STEM_BROWN_2;
		} else {
			color = STEM_BROWN_3;
		}
		return color;		
	}
	
	public void drawTree( int x, int y,Color foliageColor,Color stemColor ,Graphics g) {
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
	

	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		// TODO drawTree aufrufen
		g.setColor(Color.cyan);
		g.fillRect(0, 0, getWidth(), getHeight());
		g.setColor(GRASS_GREEN);
		g.fillRect(0, getHeight() / 2, getWidth(), getHeight() / 2);

		for (int h = 0; h < 10; h++) {
			int yOffset = 10 * h; // andern die horizontal axe
			for (int i = 0; i < 10; i++) {
				int x = (int) (Math.random() * getWidth());

				int y = getHeight() / 2 + yOffset;
//				Color foliageColor= randomFoliage();
//				Color stemColor= randomStem();
				Color foliageColor= randomColor(FOLIAGE_GREEN_1,FOLIAGE_GREEN_2,FOLIAGE_GREEN_3);
 				Color stemColor= randomColor(STEM_BROWN_1,STEM_BROWN_2,STEM_BROWN_3);
				
				drawTree(x, y,foliageColor,stemColor, g);
			}

		}

	}

}
