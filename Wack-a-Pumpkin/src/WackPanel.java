import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.JButton;
import javax.swing.JPanel;

import utils.ImageHelper;

public class WackPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	BufferedImage image = ImageHelper.loadImage("res/pumpkin.png");

	int pumpkinX, pumpkinY;
	long startTime, endTime;
	int smacked = 0;
	boolean started = false;
	int highscore = 100;

	void spawn() {
		// TODO
		int x = (int) (Math.random() * 4); // ein int x zufällig zwischen 0 und 4 wählen
		int y = (int) (Math.random() * getHeight() - 200); // ein int y zufällig zwischen 0 und getHeight() - 200
															// wählen

		pumpkinX = x * 200 + 50;
		pumpkinY = y;
	}

	void smack(int corridor) {
		int pumpkinCorridor = pumpkinX / 200;
		if (pumpkinCorridor == corridor) {
			smacked++;
			spawn();
		}
	}

	int getTime() {
		// TODO
		// Zeit in Sekunden als int zurückgeben
		int zeit = 0;
		// startTime ist in Millisekunden
		int startTime = zeit / 1000;
		// endTime ist in Millisekunden
		int endTime = zeit / 1000;
		return 9999;
	}

	void corridorButtonPressed(int corridor) {
		if (!started) {
			smacked = 0;
			started = true;
			startTime = System.currentTimeMillis();
		} else {
			smack(corridor);
		}

		if (smacked >= 20) {
			started = false;
			endTime = System.currentTimeMillis();
			if (getTime() < highscore) {
				highscore = getTime();
			}
		}

		repaint();
	}

	void init() {
		spawn();
		setLayout(null);

		for (int i = 0; i < 4; i++) {
			final int corridor = i;
			int x = i * 200;
			int y = getHeight() - 100;
			int w = 200;
			int h = 100;

			// TODO
			// 1. JButton "SMACK" erstellen
			JButton button = new JButton("SMACK");
			// 2. mit add() dem Panel hinzufügen
			add(button);
			button.setBounds(x, y, w, h);

			button.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {

					corridorButtonPressed(corridor);
					repaint();

				}
			});

		}
	}

	void drawWelcomeScreen(Graphics g) {
		// TODO
		// weissen Text zeichnen: "Press any Button"
		g.drawString("Press any Button", getWidth() / 4, getHeight() / 2);
		// ungefähr in der Bildschirmmitte
	}

	void drawGameScreen(Graphics g) {
		// TODO
		// 1. pumpkin zeichnen
		// an der Stelle, pumpkinX, pumpkinY
		// mit Breite 100 und Höhe 100

		g.drawImage(image, pumpkinX, pumpkinX, 100, 100, null);
		// 2. Text Zeichnen oben rechts am Bildschirm
		// mit Anzahl "smacked" pumpkins (Variable smacked)
		g.setColor(Color.WHITE);
		g.drawString("smacked" + smacked, getWidth() / 2 + 50, 50);

	}

	void drawHighscoreScreen(Graphics g) {
		// TODO
		// Highscore Screen zeichnen
		// g.drawString für Text verwenden
		// weisse Farbe verwenden
		// 1. Zeile: "Seconds: 10", getTime() verwenden um Sekunden zu bekommen
		g.setColor(Color.WHITE);
		g.drawString("Seconds: 10" + getTime(), getWidth() / 4, getHeight() / 2);
		// 2. Zeile: "Highscore: 9", Variable highscore verwenden
		g.drawString("Highscore: 9" + highscore, getWidth() / 4, getHeight() / 2 + 50);
		// 3. Zeile: "Press any Button to restart"
		g.drawString("Press any Button to restart", getWidth() / 4, getHeight() / 2 + 100);
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setFont(new Font("monospace", Font.PLAIN, 50));

		// TODO zeichne schwarzen Hintergrund
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, getWidth(), getHeight());
		// TODO zeichne weisses Hintergrundpannel unten für die vier Knöpfe, 100px
		// hoch
		// TODO zeichne schwarzen Hintergrund
		g.setColor(Color.WHITE);
		g.fillRect(0, getHeight() - 100, getWidth(), 100);

		if (started) {
			drawGameScreen(g);
		} else if (smacked > 0) {
			drawHighscoreScreen(g);
		} else {
			drawWelcomeScreen(g);
		}

	}
}
