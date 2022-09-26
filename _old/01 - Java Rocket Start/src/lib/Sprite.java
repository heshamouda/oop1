package lib;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Sprite {

	private final String fileName;
	private int x = 0, y = 0;
	private double rot = 0;

	private final BufferedImage image;
	private final Region region;

	public Sprite(String fileName, Region region) throws IOException {
		this.fileName = fileName;
		this.region = region;

		final String path = String.format("./res/%s", fileName);
		BufferedImage tmp;

		try {
			tmp = ImageIO.read(new File(path));
		} catch (IOException e) {
			e.printStackTrace();
			throw e;
		}

		if (region != null) {
			this.image = tmp.getSubimage(region.x, region.y, region.width, region.height);
		} else {
			this.image = tmp;
		}
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getHeight() {
		return image.getHeight();
	}

	public int getWidth() {
		return image.getWidth();
	}

	public BufferedImage getImage() {
		return image;
	}

	public double getRot() {
		return rot;
	}

	public void setRot(double rot) {
		this.rot = rot;
	}

	public void draw(Graphics2D g) {
		g.rotate(rot, x + getWidth() / 2, y + 2 * getHeight() / 3);
		g.drawImage(image, x, y, null);
		g.rotate(-rot, x + getWidth() / 2, y + 2 * getHeight() / 3);
	}

}
