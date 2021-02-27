import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.*;

import javax.swing.JButton;
import javax.swing.JPanel;

public class GridBagLayoutPanel extends JPanel {

	private JButton bt1 = new JButton("Button 1");
	private JButton bt2 = new JButton("Button 2");
	private JButton bt3 = new JButton("Button 3");
	private JButton bt4 = new JButton("Button 4");
	private JButton bt5 = new JButton("Button 5");

	public GridBagLayoutPanel() {
		setLayout(new GridBagLayout());
		setBorder(MyBorderFactory.createMyBorder("GridBagLayoutPanel"));
		int gridx = 0;
		int gridy = 0;
		int gridwidth = 1;
		int gridheight = 1;
		double weightx = 1.0;
		double weighty = 1.0;
		int anchor = GridBagConstraints.EAST;
		int fill = GridBagConstraints.VERTICAL;
		Insets insets = new Insets(5, 5, 5, 5);
		int ipadx = 50;
		int ipady = 20;
		
		//bt1.setPreferredSize(new Dimension(60,20));

		add(bt1, new GridBagConstraints(gridx, gridy, gridwidth, gridheight, weightx, weighty, anchor, fill, insets,
				ipadx, ipady));

//		add(bt1, new GridBagConstraints(0, 0, 1, 1, 1.0, 1.0, GridBagConstraints.EAST, GridBagConstraints.VERTICAL,
//				new Insets(5, 5, 5, 5), 50, 20));

		add(bt2, new GridBagConstraints(1, 0, 1, 1, 1.0, 1.0, GridBagConstraints.EAST, GridBagConstraints.NONE,
				new Insets(5, 5, 5, 5), 50, 20));

		add(bt3, new GridBagConstraints(0, 1, 1, 1, 1.0, 1.0, GridBagConstraints.WEST, GridBagConstraints.NONE,
				new Insets(5, 5, 5, 5), 50, 20));

		add(bt4, new GridBagConstraints(1, 1, 1, 1, 1.0, 1.0, GridBagConstraints.WEST, GridBagConstraints.NONE,
				new Insets(5, 5, 5, 5), 50, 20));

		add(bt5, new GridBagConstraints(0, 2, 2, 1, 1.0, 1.0, GridBagConstraints.CENTER, GridBagConstraints.NONE,
				new Insets(5, 5, 5, 5), 50, 20));
	}
}

//int gridx = 0;
//int gridy = 0;
//int gridwidth = 1;
//int gridheight = 1;
//double weightx = 1.0;
//double weighty = 1.0;
//int anchor = GridBagConstraints.LINE_END;
//int fill = GridBagConstraints.VERTICAL;
//Insets insets = new Insets(5, 5, 5, 5);
//int ipadx = 50;
//int ipady = 20;
//
//add(bt1, new GridBagConstraints(gridx, gridy, gridwidth, gridheight, weightx, weighty, anchor, fill, insets, ipadx,
//		ipady));
