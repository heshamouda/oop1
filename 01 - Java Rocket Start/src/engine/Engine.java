package engine;

import lib.Rocket;

/**
 * 
 * TODO alle Methoden ausimplementieren.
 *
 */

public class Engine {
	private static double degToRad(double deg) {
		double max= 2*Math.PI;
		double oneDeg= max/360;
		return deg*oneDeg;
	}

	public static void gas(Rocket rocket) {
		rocket.setGasOutletLevel(10); // int
		//set the rotation between 10 and -10
//		double max= 2* Math.PI;
//		double oneDeg= max/360;
		double rnd=10* (Math.random()*2-1);
		double rot=degToRad(rnd) +rocket.getRotation();
		rocket.setRotation(rot);
	}

	public static void turnLeft(Rocket rocket) {
		// Rakete nach links drehen um 5°
	
		double rot= rocket.getRotation()- degToRad(5);
		rocket.setRotation(rot);
		rocket.setGasOutletLevel(10); 
	}

	public static void turnRight(Rocket rocket) {
		
		double rot= rocket.getRotation()+degToRad(5);
		rocket.setRotation(rot);
		rocket.setGasOutletLevel(10); 
	}

}
