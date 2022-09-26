import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class BallonPanel extends JPanel implements ActionListener,SimpleTimerListener {
	private TraceV7 trace = new TraceV7(this);
	private JButton btWachsen = new JButton("Wachsen");
	private JButton btSchrumpfen = new JButton("Schrumpfen");
	private Ballon meinBallon = new Ballon(200, 70, 50);
	private Ballon deinBallon = new Ballon(250,60,50);
	
	

	private SimpleTimer updateTimer;

	public BallonPanel() {
		trace.constructorCall();
		setLayout(null);
		add(btWachsen).setBounds(20, 525, 250, 20);
		btWachsen.addActionListener(this);
		add(btSchrumpfen).setBounds(300, 525, 250, 20);
		btSchrumpfen.addActionListener(this);
		
		updateTimer = new SimpleTimer(50, this);
		updateTimer.start();

		System.out.println("Objekt meinBallon: " + meinBallon);

		
		

	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		meinBallon.anzeigen(g);
		deinBallon.anzeigen(g);
		

	}

	public void actionPerformed(ActionEvent e) {
		trace.eventCall();

		if (e.getSource() == btWachsen) {
			meinBallon.groesseVeraendern(+5);
		} else {
			meinBallon.groesseVeraendern(-5);
		}
		repaint();
	}

	@Override
	public void timerAction() {
		// TODO Auto-generated method stub
		if(meinBallon.getYValue() < (getHeight() - 50) ){
			meinBallon.update();
		}
		
		
		repaint();
		
	}

	

}

public class BallonPanelFrame extends JFrame {
	private TraceV7 tr = new TraceV7(this);
	private BallonPanel view;

	public BallonPanelFrame() {
		tr.constructorCall();
		view = new BallonPanel();
		add(view);
		setSize(600, 600);
		setTitle("|FHNW|EIT|OOP|Ballon-Panel|");
		setResizable(true);
		setVisible(true);
		setLocationRelativeTo(null);
	}

	public static void main(String args[]) {
		TraceV7.mainCall();
		BallonPanelFrame frame = new BallonPanelFrame();
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(1);
			}
		});
	}
}
