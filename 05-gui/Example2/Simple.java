import javax.swing.*;

public class Simple 
{
   public static void main (String [] args) {
      JFrame myWindow = new JFrame("Пробное окно");
      myWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      myWindow.setSize(400, 300);

      JLabel lab = new JLabel("Привет!");
      myWindow.add(lab);
      JLabel lab2 = new JLabel("С Новым годом!");
      myWindow.add(lab2);
      
      myWindow.setVisible(true);
   }
}