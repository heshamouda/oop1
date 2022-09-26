import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;

public class Utility {

	private static Container p = new Container();

	// public static Image loadImage(String strBild) {
	// MediaTracker tracker = new MediaTracker(p);
	// Image img = (new ImageIcon(strBild)).getImage();
	// tracker.addImage(img, 0);
	// try {
	// tracker.waitForID(0);
	// } catch (InterruptedException ex) {
	// System.out.println("Can not load image: " + strBild);
	// }
	// return img;
	// }

	public static Image loadResourceImage(String strBild) {
		MediaTracker tracker = new MediaTracker(p);
		Image img = (new ImageIcon(Utility.class.getResource("bilder/" + strBild))).getImage();
		tracker.addImage(img, 0);
		try {
			tracker.waitForID(0);
		} catch (InterruptedException ex) {
			System.out.println("Can not load image: " + strBild);
		}
		return img;
	}

	public static Image loadResourceImage(String strBild, int width, int height) {
		MediaTracker tracker = new MediaTracker(p);
		Image img = (new ImageIcon(Utility.class.getResource("bilder/" + strBild))).getImage();
		img = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
		tracker.addImage(img, 0);
		try {
			tracker.waitForID(0);
		} catch (InterruptedException ex) {
			System.out.println("Can not load image: " + strBild);
		}
		return img;
	}

	public static Cursor getInvisibleCursor() {
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Image image = new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB);
		return toolkit.createCustomCursor(image, new Point(0, 0), "img");
	}

	public static Cursor getDefaultCursor() {
		return Cursor.getDefaultCursor();
	}

	// public static Image rotateImage(Image image, double angle) {
	// int h = image.getHeight(null);
	// int w = image.getWidth(null);
	// double alphaCenter = Math.atan2(h / 2, w / 2);
	// int diag = (int) (Math.sqrt(w * w + h * h));
	// BufferedImage bufferedImage = new BufferedImage(diag, diag,
	// BufferedImage.TYPE_INT_ARGB);
	// Graphics2D g2d = (bufferedImage.createGraphics());
	// g2d.translate(-(diag / 2.0) * Math.cos(alphaCenter - angle) + w / 2.0,
	// -(diag / 2.0) * Math.sin(alphaCenter - angle) + h / 2.0);
	// g2d.rotate(-angle);
	// g2d.drawImage(image, 0, 0, null);
	// return bufferedImage;
	// }

	public static AudioClip loadAudioClip(String strAudioDatei) {
		AudioClip audioClip = null;
		audioClip = Applet.newAudioClip(Utility.class.getClassLoader().getResource("audio/" + strAudioDatei));
		return audioClip;
	}

}
