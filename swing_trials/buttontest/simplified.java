import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class simplified
{
	public static void main(String []args)
	{
		ButtonFrame f = new ButtonFrame();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);

		f.makeButton("Yellow",Color.YELLOW);
		f.makeButton("Blue",Color.BLUE);
		f.makeButton("Red",Color.RED);
	}
}

class ButtonFrame extends JFrame
{
	JPanel p;
	public ButtonFrame()
	{
		setTitle("Simplified Code");
		setSize(300,200);
		
		p = new JPanel();
		add(p);
	}
	
	public void makeButton(String name,Color bgcolor)
	{
		JButton button = new JButton(name);
		p.add(button);
		ColorAction action = new ColorAction(bgcolor);
		button.addActionListener(action);
	}

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

