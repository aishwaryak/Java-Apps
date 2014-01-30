import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class test
{
	public static void main(String []args)
	{
		ButtonFrame f = new ButtonFrame();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
}

class ButtonFrame extends JFrame
{
	JPanel p;
	public ButtonFrame()
	{
		setTitle("Button Test - Event Handling");
		setSize(300,200);
		
		p = new JPanel();
	//adding panel to frame
		add(p);

	//creating buttons	
		JButton yellowButton = new JButton("Yellow");
		JButton blueButton = new JButton("Blue");
		JButton redButton = new JButton("Red");

	//adding buttons to panel
		p.add(yellowButton);
		p.add(blueButton);
		p.add(redButton);
	
	//creating listener objects
		ColorAction yellowAction = new ColorAction(Color.YELLOW);
		ColorAction blueAction = new ColorAction(Color.BLUE);
		ColorAction redAction = new ColorAction(Color.RED);

	//registering listener objects with event sources (buttons)
		yellowButton.addActionListener(yellowAction);
		blueButton.addActionListener(blueAction);
		redButton.addActionListener(redAction);
	}//constructor

//inner class
	private class ColorAction implements ActionListener
	{
		Color bgcolor;

		public ColorAction(Color c)
		{
			bgcolor = c;
		}

		public void actionPerformed(ActionEvent event)
		{
			p.setBackground(bgcolor);
		}
	}	
}

