import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.lang.String.*;

class SimpleCalculator
{
	public static void main(String []args)
	{
		SimpleCalculatorFrame f1 = new SimpleCalculatorFrame();
		f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f1.setVisible(true);
	}
}

class SimpleCalculatorFrame extends JFrame
{
	JMenuBar menuBar;
	public SimpleCalculatorFrame()
	{
		setTitle("Simple Calculator");
		setSize(300,200);
		
		menuBar = new JMenuBar();
		//final ScientificCalculatorFrame f = new ScientificCalculatorFrame();
		JMenu calculatorMenu = new JMenu("Calculator");
			JMenuItem quitItem = new JMenuItem("Quit");
				quitItem.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent event)
					{
						System.exit(0);
					}
				});
			calculatorMenu.add(quitItem);

		JMenu viewMenu = new JMenu("View");
			ButtonGroup group = new ButtonGroup();
			JRadioButtonMenuItem simpleItem = new JRadioButtonMenuItem("Simple");
			/*	simpleItem.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent event)
					{
						setVisible(true);
						f.setVisible(false);
						setJMenuBar(menuBar);
					}	
				});
			*/
				simpleItem.setSelected(true);

			JRadioButtonMenuItem scientificItem = new JRadioButtonMenuItem("Scientfic");
			/*	scientificItem.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent event)
					{
						setVisible(false);
						
						f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						f.setVisible(true);
						f.setJMenuBar(menuBar);
					}
					
				});
			*/
			group.add(simpleItem);
			group.add(scientificItem);
			viewMenu.add(simpleItem);
			viewMenu.add(scientificItem);

		JMenu helpMenu = new JMenu("Help");
			JMenuItem helpItem = new JMenuItem("Help");	
			JMenuItem aboutItem = new JMenuItem("About");
			helpMenu.add(helpItem);
			helpMenu.addSeparator();
			helpMenu.add(aboutItem);

		menuBar.add(calculatorMenu);
		menuBar.add(viewMenu);
		menuBar.add(helpMenu);

		setJMenuBar(menuBar);
		
		SimpleCalculatorPanel calculatorPanel = new SimpleCalculatorPanel();
		add(calculatorPanel);

		pack();
	}
}

class SimpleCalculatorPanel extends JPanel
{
	JPanel buttonsPanel,p1,p2;
	JTextField text;
	JStatusBar statusBar;

	String lastCommand = "=",str;
	double result = 0;
	boolean start = true;
	
	InsertAction insert = new InsertAction();
	CommandAction command = new CommandAction();

	public SimpleCalculatorPanel()
	{
		setLayout(new BorderLayout(40,40));

		p1 = new JPanel();
		text = new JTextField("",30);
		text.setHorizontalAlignment(JTextField.RIGHT);
		p1.add(text);
		
		add(p1,BorderLayout.NORTH);

		buttonsPanel = new JPanel(); 
		buttonsPanel.setLayout(new GridLayout(5,4,5,5));

		addButton("Bksp",command);
		addButton("CE",command);
		addButton("Clr",command);
		addButton("+/-",command);

		addButton("7",insert);
		addButton("8",insert);
		addButton("9",insert);
		addButton("/",command);
		
		addButton("4",insert);
		addButton("5",insert);
		addButton("6",insert);
		addButton("*",command);
		
		addButton("1",insert);
		addButton("2",insert);
		addButton("3",insert);
		addButton("-",command);
		
		addButton("0",insert);
		addButton(".",insert);
		addButton("=",command);
		addButton("+",command);

		add(buttonsPanel,BorderLayout.CENTER);

		p2 = new JPanel();
		p2.setLayout(new GridLayout(2,1,5,5));
		p2.add(new JSeparator(SwingConstants.HORIZONTAL));
		statusBar = new JStatusBar();
		p2.add(statusBar);
		add(p2,BorderLayout.SOUTH);
	}//constructor

	private void addButton(String name,ActionListener listener)
	{
		JButton button = new JButton(name);
		buttonsPanel.add(button);
		button.addActionListener(listener);	
	}

	private class InsertAction implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			str = event.getActionCommand();
			if(start)
			{
				text.setText("");
				if(!str.equals("0"))
					start = false;
			}
			
			text.setText(text.getText() + str);
		}
	}//InsertAction

	private class CommandAction implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			String com = event.getActionCommand();

			if(com.equals("Clr") || com.equals("CE"))
			{
				start = true;
				text.setText("");
				result = 0;
				lastCommand = "=";
			}
			else if(com.equals("Bksp"))
			{
				String s = text.getText();
				String t = s.substring(0,s.length()-1);
				text.setText(t);				
			}
			else
			{
				if(start)
				{
					if(com.equals("-"))
					{
						text.setText(com);
						start = false;
					}
					else
						lastCommand = com;
				}
				else
				{
					calculate(Double.parseDouble(text.getText()));
					lastCommand = com;
					start = true;
				}
			}//else
		}//actionPerformed
	}//CommandAction

	public void calculate(double x)
	{
		if(lastCommand.equals("+")) result += x;
		else if(lastCommand.equals("-")) result -=x;
		else if(lastCommand.equals("*")) result *=x;
		else if(lastCommand.equals("/")) result /=x;
		else if(lastCommand.equals("=")) result =x;
		else if(lastCommand.equals("+/-"));

		text.setText(""+result);
	}//calculate	
}

