
// Ich bestaetige, dass ich diese Pruefung selbstaendig geloest habe.
// Ich weiss, dass bei Zuwiderhandlung die Note 1 erteilt wird.
//
// Name: Ouda
// Vorname: Hesham
//

public class GraphikObjekt {
	protected int x, y, vx, vy;
	public boolean sichtbar = true;

	public GraphikObjekt() {
	}

	/**
	 * <pre>
	 * - setzt entsprechende Attribute der Klasse
	 * </pre>
	 */
	public GraphikObjekt(int x, int y, int vx, int vy) {
		// 4
		this.x=x;
		this.y=y;
		this.vx=vx;
		this.vy=vy;

	}

	/**
	 * <pre>
	 * - erzeugt lokale double variable xDeviation gleich 75.0 + Zufallswert im Bereich +/- 5.0
	 * - erzeugt lokale double variable yDeviation gleich 90.0 + Zufallswert im Bereich +/- 90.0
	 * - erhoeht x um vx mal sinus(xdeviation) !Achtung! Umrechnung ins Bogenmass nicht vergessen!
	 * - erhoeht y um vy mal cosinus(ydeviation) !Achtung! Umrechnung ins Bogenmass nicht vergessen!
	 * </pre>
	 */
	public void update() {
		// 4
		double xDeviation=75.0+ ((Math.random()*-10)+5);
		double yDeviation=90.0+((Math.random()*-180)+90);
		x+=vx*Math.sin(Math.PI*2*xDeviation);
		y+=vy*Math.cos(Math.PI*2*yDeviation);
	}

}
