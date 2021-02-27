package Kapitel2;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Greetings extends JFrame {
	private JTextField textField;
	public static void main(String[] args) {
		Greetings frame = new Greetings();
		frame.setSize(300,300);
		frame.createGUI();
		frame.setVisible(true);
	}
	
	private void createGUI() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		Container window = getContentPane();
		window.setLayout(new FlowLayout() );
		textField = new JTextField("Hello!");
		window.add(textField);
		}

}
