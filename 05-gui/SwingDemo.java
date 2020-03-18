import java.io.*;
import java.lang.*;
import java.text.*;
import java.util.*;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;



public class SwingDemo extends JPanel implements ActionListener{

  public void actionPerformed(final ActionEvent e) {
       
        if (e.getActionCommand().equals("BUTTON_1")) {
	        JOptionPane.showMessageDialog(this,"Message 1","Info",JOptionPane.INFORMATION_MESSAGE);
		    
        }
        else if (e.getActionCommand().equals("BUTTON_2")) {
	        JOptionPane.showMessageDialog(this,"Message 2","Info",JOptionPane.INFORMATION_MESSAGE);
        }
        
    }

   public static void setMotifLookAndFeel() {
    try {
      UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
    } catch(Exception e) {
      System.out.println("Error setting Motif LAF: " + e);
    }
  }

 public static void setNativeLookAndFeel() {
    try {
      UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
    } catch(Exception e) {
      System.out.println("Error setting native LAF: " + e);
    }
  }
 public static void setJavaLookAndFeel() {
    try {
      UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
    } catch(Exception e) {
      System.out.println("Error setting Java LAF: " + e);
    }
  }

  public static void main( String[] args ) throws IOException   {	      
    SwingDemo.setJavaLookAndFeel();       
    JFrame frame = new JFrame( "SwingDemo" );
    SwingDemo sd=new SwingDemo();

    final JButton button1=new JButton("button-1");
    button1.setActionCommand("BUTTON_1");
    button1.addActionListener(sd);
    
    final JButton button2=new JButton("button-2");
    button2.setActionCommand("BUTTON_2");
    button2.addActionListener(sd);    
    
    final JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.add(button1);
        buttonPanel.add(button2);        
	
    JPanel mpanel=new JPanel(new BorderLayout());
    mpanel.add(buttonPanel, BorderLayout.CENTER);
	    
    JTabbedPane tabPane;
    tabPane=new JTabbedPane();
    tabPane.add(buttonPanel,"1");
    tabPane.add(mpanel,"2");
    
    frame.getContentPane().add( tabPane);
    
    frame.setSize( 640, 480 );
    frame.setVisible( true );
    frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
  }
} 
