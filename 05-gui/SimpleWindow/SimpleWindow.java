import javax.swing.*;
import java.awt.FlowLayout; 
import java.awt.event.*;


public class SimpleWindow extends JFrame implements ActionListener
{
   SimpleWindow(){
     super("Пробное окно");
     setDefaultCloseOperation(EXIT_ON_CLOSE);
     setSize(250, 100);

     JPanel panel=new JPanel();
     JButton btnOne=new JButton("One");
     btnOne.setActionCommand("One");
     btnOne.addActionListener(this);
     JButton btnTwo=new JButton("Two");
     btnTwo.setActionCommand("Two");
     btnTwo.addActionListener(this);

     panel.setLayout(new FlowLayout());
     panel.add(btnOne);
     panel.add(btnTwo);
     setContentPane(panel);

  }
  public void actionPerformed(final ActionEvent e) {
      if (e.getActionCommand().equals("One")) 
      	JOptionPane.showMessageDialog(null, "One button pressed");
      else if(e.getActionCommand().equals("Two"))
      	JOptionPane.showMessageDialog(null, "One button pressed");
  }
	
}
