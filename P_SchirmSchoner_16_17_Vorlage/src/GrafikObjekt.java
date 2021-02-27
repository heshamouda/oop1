import java.awt.Graphics;

public class GrafikObjekt {
	// 2
	public static double XSCALAR = 1.0, YSCALAR = 1.0;
	protected int x, y;

	public GrafikObjekt() {
	}

	/**
	 * <pre>
	 * - Entsprechende Attribute gleich entsprechende Argumente mal zugehörigen Skalar setzen.
	 * </pre>
	 * 
	 * @param x
	 * @param y
	 */
	public GrafikObjekt(int x, int y) {
		// 2
		this.x =(int)( x * XSCALAR);
		this.y = (int)( y * YSCALAR);
		
	}

	public void anzeigen(Graphics g) {
	}
}
