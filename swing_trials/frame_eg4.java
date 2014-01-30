import java.io.*;
import javax.swing.*;
import java.awt.*;

class frame_eg4
{
	public static void main(String args[])
	{
		FrameWithText f = new FrameWithText();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
}

class FrameWithText extends JFrame
{
	public FrameWithText()
	{
		setTitle("Frame With Text");
		setSize(300,200);
		setLocation(200,200);
		
		MyPanel p = new MyPanel();
		add(p);
	}
}

class MyPanel extends JPanel
{
	public void paintComponent(Graphics g)
	{
		g.drawString("Example of frame with text",100,100);
	}
}

