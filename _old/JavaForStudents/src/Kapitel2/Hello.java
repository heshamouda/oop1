package Kapitel2;
import java.awt.*;
import java.awt.event.*;
import java.io.InputStream;

import javax.swing.*;
import java.util.*;;

public class Hello extends JFrame {
	static Scanner s= new Scanner (System.in);
public static void main(String[] args) {
JOptionPane.showMessageDialog(null, "Hello wirld");
JOptionPane.showMessageDialog(null, "Hello World!");
JOptionPane.showMessageDialog(null, "Tell me your name");
String myName= s.nextLine();
JOptionPane.showMessageDialog(null, "Tell me your name");
JOptionPane.showMessageDialog(null, "Goodbye "+myName);
System.exit(0);
}
}
/*
 * create window with hello world
 * good bye message
 * ok
 */
