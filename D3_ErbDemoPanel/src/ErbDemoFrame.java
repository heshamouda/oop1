import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class ErbDemoPanel extends JPanel {
  private TraceV7 tr = new TraceV7(this);
  private SmartPerson smartPerson;
  

  public ErbDemoPanel() {
    super();
    tr.constructorCall();
    smartPerson = new SmartPerson("Hans-Heinrich");
    
    
  }

  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    tr.paintCall();
    smartPerson.anzeigen(g);
    
  }
}

class SmartPerson extends Person {
  private TraceV7 tr = new TraceV7(this);
  private int x = 5;
  private int y = 0;
  

  public SmartPerson(String name){
	super(name);
    tr.constructorCall();
    x = 7;
  }
  

  @Override
  public void anzeigen(Graphics g){ 
    tr.paintCall();
    g.drawString("Darf ich mich vorstellen: Ich heisse "+ name, 10, 200);
    g.drawString("Meine Martrikelnummer lautet "+ matrikelNummer, 10, 220);
    super.anzeigen(g);
  }
}

class Person extends Object {
  private TraceV7 tr = new TraceV7("Person", this);
  protected String name;
  protected int matrikelNummer = 16;


  public Person(String name) {
    super();
    tr.constructorCall();

    this.name = name;
  }
  

  public void anzeigen(Graphics g) {
    tr.paintCall();
    g.drawString("ich bin der Mama-Anzeiger ", 10, 260);
  }
}


public class ErbDemoFrame extends JFrame {
  private TraceV7 tr = new TraceV7(this);
  private ErbDemoPanel view = new ErbDemoPanel();

  public ErbDemoFrame() {
    tr.constructorCall();
    add(view);
    setSize(600, 600);
    setTitle("|FHNW|EIT|OOP|Erbdemo|");
    setResizable(true);
    setVisible(true);
    setLocationRelativeTo(null);
  }

  public static void main(String args[]) {
    TraceV7.mainCall();
    ErbDemoFrame frame = new ErbDemoFrame();
    frame.addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent e) {
        System.exit(1);
      }
    });
  }
}
