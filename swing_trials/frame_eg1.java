import java.io.*;
import javax.swing.*;
import java.awt.*;

class frame_eg1
{
	public static void main(String args[])
	{
		JFrame f1 = new JFrame("FRAME 1");
		f1.setTitle("Frame 1");  //to set the title 
		f1.setSize(300,200);
		f1.setLocation(120,100);
		//f1.setBounds(200,200,300,200); //can be used in place of setSize() and setLocation()
		//f1.setLocationByPlatform(true);
		f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//f1.setUndecorated(true); //by default , it is set to false
		//f1.show(); //deprecated function
		//f1.setResizable(false);  //by default, the frame can be resizable
		f1.setVisible(true);
		//f1.pack(); //sets the frame to the smallest size that can accomodate all the components
	}
}

