import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class ButtonTest
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
	JButton yellowButton,blueButton,redButton;
	ButtonPanel p;

	public ButtonFrame()
	{
		setTitle("Button Test - Event Handling");
		setSize(300,200);
		
		ButtonPanel p = new ButtonPanel();
		add(p); //adding panel to frame	
	}
}

class ButtonPanel extends JPanel
{
	public ButtonPanel()
	{
		JButton yellowButton = new JButton("Yellow");
		JButton blueButton = new JButton("Blue");
		JButton redButton = new JButton("Red");

	//adding buttons to panel
		add(yellowButton);
		add(blueButton);
		add(redButton);
	
	//creating listener objects
		ColorAction yellowAction = new ColorAction(Color.YELLOW);
		ColorAction blueAction = new ColorAction(Color.BLUE);
		ColorAction redAction = new ColorAction(Color.RED);

	//registering listener objects with event sources (buttons)
		yellowButton.addActionListener(yellowAction);
		blueButton.addActionListener(blueAction);
		redButton.addActionListener(redAction);
	}

//inner class
	private class ColorAction implements ActionListener
	{
		public ColorAction(Color c)
		{
			bgcolor = c;
		}

		public void actionPerformed(ActionEvent event)
		{
			setBackground(bgcolor);
		}
		private Color bgcolor;
	}		
}

