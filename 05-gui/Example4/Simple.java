import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Simple 
{
   public static void main (String [] args) {
      JFrame myWindow = new JFrame("Пробное окно");
      myWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      myWindow.setSize(400, 300);
   
      myWindow.setLayout(new FlowLayout());

      JButton btn1 = new JButton("Привет!");
      JButton btn2 = new JButton("Пока!");

      btn1.addActionListener(new ActionListener() {
      	public void actionPerformed(ActionEvent ae) {
      		JOptionPane.showMessageDialog(null,"Привет","Нажато",JOptionPane.WARNING_MESSAGE);
      	}
      });
      btn2.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent ae) {
            myWindow.setSize(100,100);
         }
      });      

      myWindow.add(btn1);
      myWindow.add(btn2);
      
      myWindow.setVisible(true);
   }
}