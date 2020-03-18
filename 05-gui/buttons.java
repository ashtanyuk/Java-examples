import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.plaf.basic.*;
import javax.swing.border.*;
//import com.bruceeckel.swing.*;

class Buttons extends JApplet {
	JButton jb = new JButton("JButton");
	BasicArrowButton up = new BasicArrowButton(BasicArrowButton.NORTH),
			 down = new BasicArrowButton(BasicArrowButton.SOUTH),
			 right = new BasicArrowButton(BasicArrowButton.EAST),
			 left = new BasicArrowButton(BasicArrowButton.WEST);
	public void init() {
		Container cp = getContentPane();
		cp.setLayout(new FlowLayout());
		cp.add(jb);
		cp.add(new JToggleButton("JToggleButton"));
		cp.add(new JCheckBox("JCheckBox"));
		cp.add(new JRadioButton("JRadioButton"));
		JPanel jp = new JPanel();
		jp.setBorder(new TitledBorder("Directions"));
		jp.add(up);
		jp.add(down);
		jp.add(left);
		jp.add(right);
		cp.add(jp);
	}
	public static void main(String[] args) {
		Buttons but=new Buttons(), 350, 100);
	}
}


