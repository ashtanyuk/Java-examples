import javax.swing.*;
import java.awt.*;

public class JFrameExample {
  public static void main(String[] args) {
    JFrame f=new JFrame("Test");
    f.setSize(400,150);
    Container content=f.getContentPane();
    content.setBackground(Color.white);
    content.setLayout(new FlowLayout());
    content.add(new JButton("1"));
    content.add(new JButton("2"));
    content.add(new JButton("3"));		
    f.addWindowListener(new ExitListener());
    f.setVisible(true);
  }
}


