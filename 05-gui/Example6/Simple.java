import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Simple 
{
   public static void main (String [] args) {
      JFrame myWindow = new JFrame("Пробное окно");
      myWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      myWindow.setSize(500, 100);
   
      myWindow.setLayout(new FlowLayout());

      JLabel labName = new JLabel("Имя");
      JTextField tfName = new JTextField(15);
      JButton btnName = new JButton("Ввести");

      btnName.addActionListener(new ActionListener() {
      	public void actionPerformed(ActionEvent ae) {
            String name=tfName.getText();
      		JOptionPane.showMessageDialog(null,"Вас зовут "+name,"Привет",
               JOptionPane.INFORMATION_MESSAGE);
      	}
      });
       

      myWindow.add(labName);
      myWindow.add(tfName);
      myWindow.add(btnName);

      myWindow.setVisible(true);
   }
}