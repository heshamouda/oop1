import java.awt.Color;
import java.awt.Font;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class BasicControlPanel extends JPanel implements ActionListener, ChangeListener {

	private JLabel lb;
	private JButton bt;
	private JSlider sld;
	private JTextField tf;
	private JComboBox<String> cb;
	private String[] colorList = { "Rot", "Gruen", "Gelb" };

	public BasicControlPanel() {
		super(null);
		setBorder(MyBorderFactory.createMyBorder(" Grundlegende Funktionen ... "));
		

		// JLabel
//		lb = new JLabel("<html>Leerzeile.<p/>Gummibärli", Utility.loadResourceIcon("Gummi_gelb.png"), JLabel.CENTER);
//		lb = new JLabel("<html><b>Gummibärli</b>", Utility.loadResourceIcon("Gummi_gelb.png"), JLabel.LEADING);

		lb = new JLabel("Gummibärli", Utility.loadResourceIcon("Gummi_gelb.png"), JLabel.CENTER);

		// undurchsichtig
//		lb.setOpaque(true);
//		lb.setBackground(Color.CYAN);

		lb.setVerticalTextPosition(JLabel.BOTTOM);
		lb.setHorizontalTextPosition(JLabel.CENTER);
		add(lb).setBounds(20, 20, 300, 210);

//		lb.setFont(new Font("Serif", Font.BOLD, 30));

		// JButton
		bt = new JButton("OK", Utility.loadResourceIcon("Gummi_rot.png"));
//		bt.setPressedIcon(Utility.loadResourceIcon("Gummi_gruen.png"));
//		bt.setDisabledIcon(Utility.loadResourceIcon("Gummi_transparent.png"));
		bt.setVerticalTextPosition(AbstractButton.BOTTOM);
		bt.setHorizontalTextPosition(AbstractButton.CENTER);
		bt.setEnabled(true);
		bt.addActionListener(this);
		add(bt).setBounds(300, 20,220, 210);

		// JSlider
		sld = new JSlider(JSlider.HORIZONTAL, 0, 30, 15);
		sld.addChangeListener(this);
		sld.setMajorTickSpacing(10);
		sld.setMinorTickSpacing(2);
		sld.setPaintTicks(true);
		sld.setPaintLabels(true);
		add(sld).setBounds(20, 250, 440, 50);

		// JTextField
		tf = new JTextField("JTextField");
		tf.setHorizontalAlignment(JTextField.CENTER);
		tf.addActionListener(this);
		add(tf).setBounds(20, 310, 440, 20);

		// JComboBox
		cb = new JComboBox<String>();

		for (int i = 0; i < colorList.length; ++i) {
			cb.addItem(colorList[i]);
		}
		cb.setSelectedItem("Gelb");
		cb.addActionListener(this);
		
		add(cb).setBounds(20, 350, 440, 20);

	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == bt) {
			System.out.println("bt");

		}
		if (e.getSource() == tf) {
			System.out.println("tf");
			System.out.println(tf.getText());
			//tf.setText("Ausgabe");
		}
		if (e.getSource() == cb) {
			System.out.println("cb");
			// --------------
			if (cb.getSelectedItem().equals("Gruen")) {
				lb.setIcon(Utility.loadResourceIcon("Gummi_gruen.png"));
			}
			if (cb.getSelectedItem().equals("Gelb")) {
				lb.setIcon(Utility.loadResourceIcon("Gummi_gelb.png"));
			}
			if (cb.getSelectedItem().equals("Rot")) {
				lb.setIcon(Utility.loadResourceIcon("Gummi_rot.png"));
			}

		}

		
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		if (e.getSource() == sld) {
			System.out.println("sld");
			System.out.println(sld.getValue());
	
			// setzt slider in Textfeld

		}
	}
	
	// -------------------------------------------

//	@Override
//	public void itemStateChanged(ItemEvent e) {
//		// TODO Auto-generated method stub
//		System.out.println(e.getItem());
//		System.out.println("itemchanged");
//
//	}
}
