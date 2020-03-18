import javax.swing.*;

public class Simple 
{
   public static void main (String [] args) {
      JFrame win1 = new JFrame("JFrame");
      win1.setSize(400, 300);
      win1.setLocation(10,10);

      JWindow win2 = new JWindow();
      win2.setSize(200,300);
      win2.setLocation(500,200);
      
      win1.setVisible(true);
      win2.setVisible(true);

   }
}