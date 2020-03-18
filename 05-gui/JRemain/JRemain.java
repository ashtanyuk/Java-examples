import java.io.*;
import java.lang.*;
import java.text.*;
import java.util.*;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

import java.util.Calendar;
import java.util.Date;



public class JRemain extends JPanel implements ActionListener{
  
   public static int getDiffSeconds(Date firstDate) {
	Date secondDate = Calendar.getInstance().getTime();
	long millesecDifference = secondDate.getTime() - firstDate.getTime();
	long secondsDifference = millesecDifference / 1000;
	long minutesDifference = secondsDifference / 60;
	long hoursDifference = minutesDifference / 60;
	long daysDifference = hoursDifference / 24;
	return (int)Math.abs(secondsDifference);
   }

   public void actionPerformed(final ActionEvent e) {

        if (e.getActionCommand().equals("Start")) {
	  int diff_sec=JRemain.getDiffSeconds(firstDate);
	  pb.setValue(diff_sec);
          timer.start();
	  //JOptionPane.showMessageDialog(this,"","Info",JOptionPane.INFORMATION_MESSAGE);
		    
        }
        else if (e.getActionCommand().equals("Stop")) {
          timer.stop();
	  //JOptionPane.showMessageDialog(this,"","Info",JOptionPane.INFORMATION_MESSAGE);
        }
	else if (e.getActionCommand().equals("Clear")) {
          timer.stop();
	  pb.setValue(0);
	  //JOptionPane.showMessageDialog(this,"","Info",JOptionPane.INFORMATION_MESSAGE);
        }
        
    }


  public static JProgressBar pb;
  javax.swing.Timer timer=new javax.swing.Timer(100,timerFun());
  public Date firstDate;
  int init_diff_sec;
  int R=0,G=64,B=0;
  JLabel text1,text2,text3;

  public Action timerFun() {
	  return new AbstractAction() {
		  public void actionPerformed (ActionEvent e) {
			int diff_sec=JRemain.getDiffSeconds(firstDate);
      			if(pb.getValue() >= pb.getMinimum()) {
				 float d=(init_diff_sec-diff_sec)/(float)init_diff_sec;
				 //if(d>=0 && d<0.6)        { R=0;   G=64;  B=0; }
				 //else if(d>=0.6 && d<0.9) { R=255; G=255; B=0; }
				 //else                     { R=255; G=0;   B=0; }
                                 
				 if(d>=0 && d<0.6)        { R=(int)((d*255)/0.6); G=64+(int)((d*191)/0.6); B=0; }
				 else if(d>=0.6 && d<0.9) { R=255; G=255-(int)(((d-0.6)*255)/0.3); B=0; }
				 else                     { R=255; G=0; B=0; }
			         Color c=new Color(R,G,B);	 
	     			 pb.setValue(diff_sec);
				 pb.setForeground(c);
				 Calendar cal=Calendar.getInstance();
                                 //text1.setText(""+cal.get(Calendar.HOUR_OF_DAY)+":"+cal.get(Calendar.MINUTE));
				 //text3.setText(""+(int)(100-d*100)+"%");

      			} else {
	      			 timer.stop();
				 
                        }
                   }
	  };
  }

  public static void main( String[] args ) throws IOException   {	      
    Look.setJavaLookAndFeel();       
    JFrame frame = new JFrame( "JRemain" );
    JRemain app=new JRemain();

    final JButton button1=new JButton("Start");
    button1.setActionCommand("Start");
    button1.addActionListener(app);
    
    final JButton button2=new JButton("Stop");
    button2.setActionCommand("Stop");
    button2.addActionListener(app);    

    final JButton button3=new JButton("Clear");
    button3.setActionCommand("Clear");
    button3.addActionListener(app);  

    app.text1=new JLabel("");
    app.text2=new JLabel("");
    app.text3=new JLabel("");

    int year=Integer.parseInt(args[0])-1900;
    int mon=Integer.parseInt(args[1])-1;
    int day=Integer.parseInt(args[2]);
    int hour=Integer.parseInt(args[3]);
    int min=Integer.parseInt(args[4]);
   
    app.firstDate = new Date(year, mon, day,hour,min,0);
    int diff_sec=app.getDiffSeconds(app.firstDate);
    app.init_diff_sec=diff_sec;
    System.out.println("Sec: "+diff_sec);
    //app.text2.setText(""+hour+":"+min);

    Calendar cal=Calendar.getInstance();
    //app.text1.setText(""+cal.get(Calendar.HOUR_OF_DAY)+":"+cal.get(Calendar.MINUTE));
    

    pb=new JProgressBar(JProgressBar.HORIZONTAL,0,diff_sec) {
	    public Dimension getPreferredSize() {
		    return new Dimension(400,super.getPreferredSize().height*2);
	    }
    };
    
    pb.setStringPainted(true);

    final JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        buttonPanel.add(button1);
        buttonPanel.add(button2);
        buttonPanel.add(button3); 	
	buttonPanel.add(pb);
    
    //final JPanel infoPanel=new JPanel(new FlowLayout(FlowLayout.LEFT));
       // infoPanel.add(app.text1);
       // infoPanel.add(app.text2);
      //  infoPanel.add(app.text3);

    final JPanel mainPanel=new JPanel(new GridLayout(1,1));
        mainPanel.add(buttonPanel);
	//mainPanel.add(infoPanel);

    JPanel mpanel=new JPanel(new BorderLayout());
    mpanel.add(mainPanel);
	    
    frame.getContentPane().add(mpanel);   
    frame.setSize( 640, 90 );
    frame.setVisible( true );
    frame.setResizable(false);
    frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
  }
} 
