import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.lang.String.*;
import java.lang.Math.*;

class CalculatorFirst
{
	public static void main(String []args)
	{
		CalculatorFrame f1 = new CalculatorFrame();
		f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f1.setVisible(true);
	}
}

class CalculatorFrame extends JFrame
{
	JMenuBar menuBar;

	public CalculatorFrame()
	{
		setTitle("Simple Calculator");
		setSize(300,200);
		
		menuBar = new JMenuBar();
		final ScientificCalculatorFrame f = new ScientificCalculatorFrame();
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
				simpleItem.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent event)
					{
						setVisible(true);
						f.setVisible(false);
						setJMenuBar(menuBar);
					}	
				});

				simpleItem.setSelected(true);

			JRadioButtonMenuItem scientificItem = new JRadioButtonMenuItem("Scientific");
				scientificItem.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent event)
					{
						setVisible(false);
						
						f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						f.setVisible(true);
						f.setJMenuBar(menuBar);
					}
					
				});
			
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
		
		CalculatorPanel calculatorPanel = new CalculatorPanel();
		add(calculatorPanel);

		pack();
	}
}

class CalculatorPanel extends JPanel
{
	JPanel buttonsPanel,p1,p2;
	JTextField text;
	JLabel label;

	String lastCommand = "=",str;
	double result = 0;
	boolean start = true;
	
	InsertAction insert = new InsertAction();
	CommandAction command = new CommandAction();

	public CalculatorPanel()
	{
		setLayout(new BorderLayout(40,40));
		Font displayFont = new Font("monspaced", Font.PLAIN, 20);

		p1 = new JPanel();
		text = new JTextField("",30);
		text.setHorizontalAlignment(JTextField.RIGHT);
		//text.setFont(displayFont);
		p1.add(text);
		
		add(p1,BorderLayout.NORTH);

		buttonsPanel = new JPanel(); 
		buttonsPanel.setLayout(new GridLayout(5,4,5,5));

		addButton("Bksp",command);
		addButton("CE",command);
		addButton("Clr",command);
		addButton(" ",command);

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
		p2.setLayout(new GridLayout(2,1));
		p2.add(new JSeparator(SwingConstants.HORIZONTAL));
		label = new JLabel("",JLabel.LEFT);
		label.setFont(new Font("monspaced",Font.PLAIN,20));
		p2.add(label);

		add(p2,BorderLayout.SOUTH);
		
		setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
	}//constructor

	private void addButton(String name,ActionListener listener)
	{
		JButton button = new JButton(name);
		buttonsPanel.add(button);
		button.addActionListener(listener);
		if(name.equals(" "))
			button.setEnabled(false);	
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

class ScientificCalculatorFrame extends JFrame
{	
	public ScientificCalculatorFrame()
	{
		setTitle("Scientific Calculator");
		setSize(650,450);

		ScientificCalculatorPanel scientificCalculatorPanel = new ScientificCalculatorPanel();
		add(scientificCalculatorPanel);

		//pack();
	}//constructor
}

class ScientificCalculatorPanel extends JPanel
{
	JPanel buttonsPanel,p1,p2,trigPanel,decBinPanel;
	JTextField text;
	JLabel label;
	JCheckBox inv,hyp;
	JRadioButton decimal,binary;
	ButtonGroup decBinGroup;
	
	JButton expbutton,tenpowerbutton,xybutton,x2button,recbutton,factbutton;
	JButton cosButton,sinButton,tanButton,lnbutton,logbutton,absbutton;
	JButton sevenbutton,eightbutton,ninebutton,divbutton,openbutton,button;
	JButton fourbutton,fivebutton,sixbutton,mulbutton,closebutton,bkspbutton;
	JButton onebutton,twobutton,threebutton,subbutton,percbutton,cebutton;
	JButton zerobutton,decpointbutton,resultbutton,addbutton,sqrtbutton,clrbutton;

	StackArray stack = new StackArray();

	String lastCommand = "=",str,value;
	double result = 0;
	boolean start = true;
	boolean trig = false;
	
	InsertAction insert = new InsertAction();
	CommandAction command = new CommandAction();
	InverseAction invAct = new InverseAction();
	HyperbolicAction hypAct = new HyperbolicAction();
	DecimalAction decAct = new DecimalAction();
	BinaryAction binAct = new BinaryAction();

	public ScientificCalculatorPanel()
	{
		setLayout(new BorderLayout(40,40));

		p1 = new JPanel();
		p1.setLayout(new GridLayout(3,0));
		
		text = new JTextField("",30);
		text.setHorizontalAlignment(JTextField.RIGHT);
		
		trigPanel = new JPanel();
		trigPanel.setLayout(new FlowLayout(FlowLayout.LEFT,5,5));
			inv = new JCheckBox("Inv");
			hyp = new JCheckBox("Hyp");
		trigPanel.add(inv);
		trigPanel.add(hyp);

		decBinPanel = new JPanel();
		decBinPanel.setLayout(new FlowLayout(FlowLayout.LEFT,5,5));
			decBinGroup = new ButtonGroup();
				decimal = new JRadioButton("Decimal");
				decimal.setSelected(true);
				binary = new JRadioButton("Binary");
			decBinGroup.add(decimal);
			decBinGroup.add(binary);
		decBinPanel.add(decimal);
		decBinPanel.add(binary);

		inv.addActionListener(invAct);
		hyp.addActionListener(hypAct);

		decimal.addActionListener(decAct);
		binary.addActionListener(binAct);

		p1.add(text);
		p1.add(trigPanel);
		p1.add(decBinPanel);
		
		add(p1,BorderLayout.NORTH);

		buttonsPanel = new JPanel(); 
		buttonsPanel.setLayout(new GridLayout(6,6,5,5));

		expbutton = new JButton("e^x");
		tenpowerbutton = new JButton("10^x");
		xybutton = new JButton("x^y");
		x2button = new JButton("x^2");
		recbutton = new JButton("1/x");
		factbutton = new JButton("x!");

		cosButton = new JButton("Cos");
		sinButton = new JButton("Sin");
		tanButton = new JButton("Tan");
		lnbutton = new JButton("Ln");
		logbutton = new JButton("Log");
		absbutton = new JButton("Abs");

		sevenbutton = new JButton("7");
		eightbutton = new JButton("8");
		ninebutton = new JButton("9");
		divbutton = new JButton("/");
		openbutton = new JButton("(");
		button = new JButton("");

		fourbutton = new JButton("4");
		fivebutton = new JButton("5");
		sixbutton = new JButton("6");
		mulbutton = new JButton("*");
		closebutton = new JButton(")");
		bkspbutton = new JButton("Bksp");

		onebutton = new JButton("1");
		twobutton = new JButton("2");
		threebutton = new JButton("3");
		subbutton = new JButton("-");
		percbutton = new JButton("%");
		cebutton = new JButton("CE");

		zerobutton = new JButton("0");
		decpointbutton = new JButton(".");
		resultbutton = new JButton("=");
		addbutton = new JButton("+");
		sqrtbutton = new JButton("Sqrt");
		clrbutton = new JButton("Clr");

		buttonsPanel.add(expbutton);
		buttonsPanel.add(tenpowerbutton);
		buttonsPanel.add(xybutton);
		buttonsPanel.add(x2button);
		buttonsPanel.add(recbutton);
		buttonsPanel.add(factbutton);

		buttonsPanel.add(cosButton);
		buttonsPanel.add(sinButton);
		buttonsPanel.add(tanButton);
		buttonsPanel.add(lnbutton);
		buttonsPanel.add(logbutton);
		buttonsPanel.add(absbutton);

		buttonsPanel.add(sevenbutton);
		buttonsPanel.add(eightbutton);
		buttonsPanel.add(ninebutton);
		buttonsPanel.add(divbutton);
		buttonsPanel.add(openbutton);
		buttonsPanel.add(button);

		buttonsPanel.add(fourbutton);
		buttonsPanel.add(fivebutton);
		buttonsPanel.add(sixbutton);
		buttonsPanel.add(mulbutton);
		buttonsPanel.add(closebutton);
		buttonsPanel.add(bkspbutton);

		buttonsPanel.add(onebutton);
		buttonsPanel.add(twobutton);
		buttonsPanel.add(threebutton);
		buttonsPanel.add(subbutton);
		buttonsPanel.add(percbutton);
		buttonsPanel.add(cebutton);
		
		buttonsPanel.add(zerobutton);		
		buttonsPanel.add(decpointbutton);		
		buttonsPanel.add(resultbutton);
		buttonsPanel.add(addbutton);
		buttonsPanel.add(sqrtbutton);
		buttonsPanel.add(clrbutton);

		expbutton.addActionListener(command);
		tenpowerbutton.addActionListener(command);
		xybutton.addActionListener(command);
		x2button.addActionListener(command);
		recbutton.addActionListener(command);
		factbutton.addActionListener(command);

		cosButton.addActionListener(command);
		sinButton.addActionListener(command);
		tanButton.addActionListener(command);
		lnbutton.addActionListener(command);
		logbutton.addActionListener(command);
		absbutton.addActionListener(command);

		sevenbutton.addActionListener(insert);
		eightbutton.addActionListener(insert);
		ninebutton.addActionListener(insert);
		divbutton.addActionListener(command);
		openbutton.addActionListener(command);
		button.addActionListener(command);

		fourbutton.addActionListener(insert);
		fivebutton.addActionListener(insert);
		sixbutton.addActionListener(insert);
		mulbutton.addActionListener(command);
		closebutton.addActionListener(command);
		bkspbutton.addActionListener(command);

		onebutton.addActionListener(insert);
		twobutton.addActionListener(insert);
		threebutton.addActionListener(insert);
		subbutton.addActionListener(command);
		percbutton.addActionListener(command);
		cebutton.addActionListener(command);

		zerobutton.addActionListener(insert);
		decpointbutton.addActionListener(insert);
		resultbutton.addActionListener(command);
		addbutton.addActionListener(command);
		sqrtbutton.addActionListener(command);
		clrbutton.addActionListener(command);
		
		button.setEnabled(false);

	//setting ToolTipTexts for buttons
		expbutton.setToolTipText("e to the power of the displayed value");
		tenpowerbutton.setToolTipText("10 to the power of the displayed value");
		xybutton.setToolTipText("Raise displayed value to the power of y");
		x2button.setToolTipText("Raise displayed value to the power of 2");
		recbutton.setToolTipText("Reciprocal");
		factbutton.setToolTipText("Factorial of displayed value");
		cosButton.setToolTipText("Cosine");
		sinButton.setToolTipText("Sine");
		tanButton.setToolTipText("Tangent");
		lnbutton.setToolTipText("Natural logarithm");
		logbutton.setToolTipText("Base 10 logarithm");	
		absbutton.setToolTipText("Absolute value");
		sqrtbutton.setToolTipText("Square Root");
		bkspbutton.setToolTipText("Remove rightmost character from displayed value");
		cebutton.setToolTipText("Clear displayed value");
		clrbutton.setToolTipText("Clear displayed value and any partial calculation");
		openbutton.setToolTipText("Start group of calculations");
		closebutton.setToolTipText("End group of calculations");
		percbutton.setToolTipText("Percentage");
		addbutton.setToolTipText("Add");
		subbutton.setToolTipText("Subtract");
		mulbutton.setToolTipText("Multiply");
		divbutton.setToolTipText("Divide");
		resultbutton.setToolTipText("Calculate result");

		add(buttonsPanel,BorderLayout.CENTER);

		p2 = new JPanel();
		p2.setLayout(new GridLayout(2,1,5,5));
		p2.add(new JSeparator(SwingConstants.HORIZONTAL));
		label = new JLabel("",JLabel.LEFT);
		p2.add(label);
		add(p2,BorderLayout.SOUTH);	
	
		setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
	}//constructor

	private class InsertAction implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
System.out.println("INSERT");
			str = event.getActionCommand();
			if(start)
			{
				text.setText("");
				if(!str.equals("0"))
					start = false;
			}
			
			text.setText(text.getText() + str);
			value = text.getText();
		}
	}//InsertAction

	private class CommandAction implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			String com = event.getActionCommand();
System.out.println("COMMAND");
			
			if(com.equals("Clr") || com.equals("CE"))
			{
				start = true;
				text.setText("");
				result = 0;
				//lastCommand = "=";
			}
			else if(com.equals("Bksp"))
			{
				String s = text.getText();
				String t = s.substring(0,s.length()-1);
				text.setText(t);				
			}
			else if(com.equals("e^x") || com.equals("10^x"))
			{
				start = false;
				if(com.equals("e^x"))
					text.setText("e");
				else if(com.equals("10^x"))
					text.setText("10");
				text.setText(text.getText() + "^");
				lastCommand = com;
			}
			else if(com.equals("x^y"))
			{
				start  = false;
				text.setText(text.getText() + "^");
				lastCommand = com;			
			}
			else if(com.equals("x^2"))
			{
				start = false;
				lastCommand = com;
			}
			else if(com.equals("1/x"))
			{
				start = false;
				text.setText("1/("+text.getText()+")");
				lastCommand = com;
			}
			else if(com.equals("x!"))
			{
				start = false;
				text.setText(text.getText()+"!");
				lastCommand = com;
			}
			else if(com.equals("Cos") || com.equals("InvCos") || com.equals("Cosh"))
			{
				start = false;
				trig = true;

				if(com.equals("Cos"))
					text.setText("cos");
				else if(com.equals("InvCos"))
					text.setText("Invcos");
				else if(com.equals("Cosh"))
					text.setText("cosh");
				//else if(com.equals("InvCosh"))
				//	text.setText("Invcosh");

				text.setText(text.getText() + " ");
				System.out.println("Text : "+text.getText());
	
				lastCommand = com;
				
			}
			else if(com.equals("Sin") || com.equals("InvSin") || com.equals("Sinh"))
			{
				start = false;
				trig = true;

				if(com.equals("Sin"))
					text.setText("sin");
				else if(com.equals("InvSin"))
					text.setText("Invsin");
				else if(com.equals("Sinh"))
					text.setText("sinh");
				//else if(com.equals("InvSinh"))
				//	text.setText("Invsinh");

				text.setText(text.getText() + " ");
				System.out.println("Text : "+text.getText());
	
				lastCommand = com;
			}
			else if(com.equals("Tan") || com.equals("InvTan") || com.equals("Tanh"))
			{
				start = false;
				trig = true;

				if(com.equals("Tan"))
					text.setText("tan");
				else if(com.equals("InvTan"))
					text.setText("Invtan");
				else if(com.equals("Tanh"))
					text.setText("tanh");
				//else if(com.equals("InvTanh"))
				//	text.setText("Invtanh");

				text.setText(text.getText() + " ");
				System.out.println("Text : "+text.getText());
	
				lastCommand = com;
			}
			else if(com.equals("Ln") || com.equals("Log"))
			{
				start = false;
				if(com.equals("Ln"))
					text.setText("ln ");
				else if(com.equals("Log"))
					text.setText("log ");
				lastCommand = com;	
			}
			else if(com.equals("Abs"))
			{
				start = false;
				text.setText("abs ");
				lastCommand = com;
			}
			else if(com.equals("Sqrt"))
			{
				start = false;
				text.setText("sqrt ");
				lastCommand = com;
			}
			else if(com.equals("%"))
			{
				start = false;
				text.setText(text.getText()+"%");
				lastCommand = com;
			}
			else
			{
				if(start)
				{
					if(com.equals("-") || com.equals("("))
					{
						text.setText(com);
						start = false;
					}
				}
				else
				{					
					if(com.equals("="))
					{
						System.out.println("com : =");
						if(trig)
						{
							String [] a = text.getText().split(" ");
							if(lastCommand.equals("Cos"))
								result = Math.cos(Math.toRadians(Double.parseDouble(a[1])));
							else if(lastCommand.equals("InvCos"))
								result = Math.toDegrees(Math.acos(Double.parseDouble(a[1])));
							else if(lastCommand.equals("Cosh"))
								result = Math.cosh(Double.parseDouble(a[1]));
							//else if(lastCommand.equals("InvCosh"))
							//	result = Math.acosh(Double.parseDouble(a[1]));

							else if(lastCommand.equals("Sin"))
								result = Math.sin(Math.toRadians(Double.parseDouble(a[1])));
							else if(lastCommand.equals("InvSin"))
								result = Math.toDegrees(Math.asin(Double.parseDouble(a[1])));
							else if(lastCommand.equals("Sinh"))
								result = Math.sinh(Double.parseDouble(a[1]));
							//else if(lastCommand.equals("InvSinh"))
							//	result = Math.asinh(Double.parseDouble(a[1]));

							else if(lastCommand.equals("Tan"))
								result = Math.tan(Math.toRadians(Double.parseDouble(a[1])));
							else if(lastCommand.equals("InvTan"))
								result = Math.toDegrees(Math.atan(Double.parseDouble(a[1])));
							else if(lastCommand.equals("Tanh"))
								result = Math.tanh(Double.parseDouble(a[1]));
							//else if(lastCommand.equals("InvTanh"))
							//	result = Math.atanh(Double.parseDouble(a[1]));


							text.setText(Double.toString(result));
						}
						else if(lastCommand.equals("e^x") || lastCommand.equals("10^x"))
						{
							System.out.println(text.getText());
							String [] a = text.getText().split("\\^");
							System.out.println("length : "+a.length);
							System.out.println("A[0] : "+a[0]);
							if(lastCommand.equals("e^x"))
								result = Math.exp(Double.parseDouble(a[1]));
							else if(lastCommand.equals("10^x"))
								result = Math.pow(10,Double.parseDouble(a[1]));
							text.setText(Double.toString(result));
						}
						else if(lastCommand.equals("x^y") || lastCommand.equals("x^2"))
						{
							String []a = text.getText().split("\\^");
							if(lastCommand.equals("x^y"))
								result = Math.pow(Double.parseDouble(a[0]),Double.parseDouble(a[1]));
							else if(lastCommand.equals("x^2"))
								result = Math.pow(Double.parseDouble(text.getText()),2);
							text.setText(Double.toString(result));
						}
						else if(lastCommand.equals("1/x"))
						{
							result = 1/Double.parseDouble(value);
							text.setText(Double.toString(result));
							value = text.getText();
						}
						else if(lastCommand.equals("x!"))
						{
							if(Double.parseDouble(value) == 0)
								result = 1;
							else
							{
								result = 1;
								double doubleValue = Double.parseDouble(value);

								for(int i=Integer.parseInt(value);i>=1;i--)
								{	
									result *= doubleValue;
									doubleValue--;
								} 
							}
							text.setText(Double.toString(result));
							value = text.getText();
						}
						else if(lastCommand.equals("Ln") || lastCommand.equals("Log"))
						{
							String []a = text.getText().split(" ");
							if(lastCommand.equals("Ln"))
								result = Math.log(Double.parseDouble(a[1]));
							else if(lastCommand.equals("Log"))
								result = Math.log10(Double.parseDouble(a[1]));
							text.setText(Double.toString(result));
						}
						else if(lastCommand.equals("Abs"))
						{
							String []a = text.getText().split(" ");
							result = Math.abs(Double.parseDouble(a[1]));
							text.setText(Double.toString(result));
						}
						else if(lastCommand.equals("Sqrt"))
						{
							String []a = text.getText().split(" ");
							result = Math.sqrt(Double.parseDouble(a[1]));
							text.setText(Double.toString(result));
						}
						else if(lastCommand.equals("%"))
						{
							result = Double.parseDouble(value) / 100;
							text.setText(Double.toString(result));
							value = text.getText();
						}							
						else
						{
							infixToPostfix(text.getText());
							stack.top_of_stack = 0;
						}
						trig = false;
						start = true;
					}
					else
						text.setText(text.getText() + com);
				}
			}//else
		}//actionPerformed
	}//CommandAction

	private class InverseAction implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			if(inv.isSelected() && !hyp.isSelected())
			{
				cosButton.setText("InvCos");
				sinButton.setText("InvSin");
				tanButton.setText("InvTan");
				
				cosButton.setToolTipText("Inverse Cosine");
				sinButton.setToolTipText("Inverse Sine");
				tanButton.setToolTipText("Inverse Tangent");	
			}
			else if(hyp.isSelected() && !inv.isSelected())
			{
				cosButton.setText("Cosh");
				sinButton.setText("Sinh");
				tanButton.setText("Tanh");
				
				cosButton.setToolTipText("Hyperbolic Cosine");
				sinButton.setToolTipText("Hyperbolic Sine");
				tanButton.setToolTipText("Hyperbolic Tangent");
			}
			else if(!inv.isSelected() && !hyp.isSelected())
			{
				cosButton.setText("Cos");
				sinButton.setText("Sin");
				tanButton.setText("Tan");
				
				cosButton.setToolTipText("Cosine");
				sinButton.setToolTipText("Sine");
				tanButton.setToolTipText("Tangent");
			}
			else if(inv.isSelected() && hyp.isSelected())
			{
				cosButton.setText("InvCosh");
				sinButton.setText("InvSinh");
				tanButton.setText("InvTanh");

				cosButton.setToolTipText("Hyperbolic Inverse Cosine");
				sinButton.setToolTipText("Hyperbolic Inverse Sine");
				tanButton.setToolTipText("Hyperbolic Inverse Tangent");
			}
		}
	}

	private class HyperbolicAction implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			if(hyp.isSelected() && !inv.isSelected())
			{
				cosButton.setText("Cosh");
				sinButton.setText("Sinh");
				tanButton.setText("Tanh");
				
				cosButton.setToolTipText("Hyperbolic Cosine");
				sinButton.setToolTipText("Hyperbolic Sine");
				tanButton.setToolTipText("Hyperbolic Tangent");
			}
			else if(inv.isSelected() && !hyp.isSelected())
			{
				cosButton.setText("InvCos");
				sinButton.setText("InvSin");
				tanButton.setText("InvTan");

				cosButton.setToolTipText("Inverse Cosine");
				sinButton.setToolTipText("Inverse Sine");
				tanButton.setToolTipText("Inverse Tangent");	
			}
			else if(inv.isSelected() && hyp.isSelected())
			{
				cosButton.setText("InvCosh");
				sinButton.setText("InvSinh");
				tanButton.setText("InvTanh");

				cosButton.setToolTipText("Hyperbolic Inverse Cosine");
				sinButton.setToolTipText("Hyperbolic Inverse Sine");
				tanButton.setToolTipText("Hyperbolic Inverse Tangent");
			}			
			else if(!hyp.isSelected() && !inv.isSelected())
			{
				cosButton.setText("Cos");
				sinButton.setText("Sin");
				tanButton.setText("Tan");

				cosButton.setToolTipText("Cosine");
				sinButton.setToolTipText("Sine");
				tanButton.setToolTipText("Tangent");
			}
		}
	}
	
	private class DecimalAction implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			
			expbutton.setEnabled(true);
			tenpowerbutton.setEnabled(true);
			xybutton.setEnabled(true);
			x2button.setEnabled(true);
			recbutton.setEnabled(true);
			factbutton.setEnabled(true);
			cosButton.setEnabled(true);
			sinButton.setEnabled(true);
			tanButton.setEnabled(true);
			lnbutton.setEnabled(true);
			logbutton.setEnabled(true);
			absbutton.setEnabled(true);
			percbutton.setEnabled(true);
			sqrtbutton.setEnabled(true);

			ninebutton.setEnabled(true);
			eightbutton.setEnabled(true);
			sevenbutton.setEnabled(true);
			sixbutton.setEnabled(true);
			fivebutton.setEnabled(true);
			fourbutton.setEnabled(true);
			threebutton.setEnabled(true);
			twobutton.setEnabled(true);

			inv.setEnabled(true);
			hyp.setEnabled(true);
		}
	}
		
	private class BinaryAction implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			expbutton.setEnabled(false);
			tenpowerbutton.setEnabled(false);
			xybutton.setEnabled(false);
			x2button.setEnabled(false);
			recbutton.setEnabled(false);
			factbutton.setEnabled(false);
			cosButton.setEnabled(false);
			sinButton.setEnabled(false);
			tanButton.setEnabled(false);
			lnbutton.setEnabled(false);
			logbutton.setEnabled(false);
			absbutton.setEnabled(false);
			percbutton.setEnabled(false);
			sqrtbutton.setEnabled(false);

			ninebutton.setEnabled(false);
			eightbutton.setEnabled(false);
			sevenbutton.setEnabled(false);
			sixbutton.setEnabled(false);
			fivebutton.setEnabled(false);
			fourbutton.setEnabled(false);
			threebutton.setEnabled(false);
			twobutton.setEnabled(false);

			inv.setEnabled(false);
			hyp.setEnabled(false);
		}
	}
 
	private void infixToPostfix(String expr)
	{
		String [] postfix_expr = new String[20];
		String a,b;
		Double result = 0.0;
				
		char []charexpr = new char[50];
		charexpr = expr.toCharArray();
		
		System.out.print(charexpr);
		int i=0,j=0,k=0;
	
		stack.top_of_stack = 0;
	    	a:
	    	{
			while(i<=charexpr.length)
			{
				if(charexpr[i] == '+')
				{
					if(stack.top_of_stack != 0)
					{
						while( stack.elements[stack.top_of_stack-1].equals("+") || stack.elements[stack.top_of_stack-1].equals("-") || stack.elements[stack.top_of_stack-1].equals("*") || stack.elements[stack.top_of_stack-1].equals("/") )
							postfix_expr[j++] = stack.pop();System.out.println("hello");
						stack.push("+");
					}
					else
						stack.push("+");
					k=0;
				}
				else if(charexpr[i] == '-')
				{ 
				 
					if(stack.top_of_stack != 0)
					{ 
						while( (stack.elements[stack.top_of_stack-1].equals("+") || stack.elements[stack.top_of_stack-1].equals("-") || stack.elements[stack.top_of_stack-1].equals("*") || stack.elements[stack.top_of_stack-1].equals("/")))
							postfix_expr[j++] = stack.pop();
						stack.push("-");
					}
					else 
						stack.push("-");
					k=0;
				}
				else if(charexpr[i] == '*')
				{ 
					if(stack.top_of_stack != 0)
					{
						while( stack.elements[stack.top_of_stack-1].equals("*") || stack.elements[stack.top_of_stack-1].equals("/") )
							postfix_expr[j++] = stack.pop();
						stack.push("*");
					}
					else
						stack.push("*");
					k=0;
				}
				else if(charexpr[i] == '/')
				{
					if(stack.top_of_stack != 0)
					{
						while( stack.elements[stack.top_of_stack-1].equals("*") || stack.elements[stack.top_of_stack-1].equals("/") )
							postfix_expr[j++] = stack.pop();
						stack.push("/");
					}
					else
						stack.push("/");						
					k=0;
				}
				else if(charexpr[i] == '(')
				{
					stack.push("(");
					k=0;
				}
				else if(charexpr[i] == ')')
				{
					while(!stack.elements[stack.top_of_stack -1].equals("("))
					{
							if(stack.top_of_stack == -1)
								break;
							postfix_expr[j++] = stack.pop();
					}
					if(stack.top_of_stack > 0)
						stack.top_of_stack--;
					k=0;
				}
				else
				{
					char []temp = new char[100];
					
					while(((((int)charexpr[i] >= 48 && (int)charexpr[i] <= 57)) || charexpr[i]=='.') && charexpr[i] != '+' && charexpr[i] != '-' && charexpr[i] != '*' && charexpr[i] != '/' && charexpr[i] != '(' && charexpr[i] != ')')
					{
						temp[k++]=charexpr[i++];
					
						if(i==charexpr.length)
							break;
					}
					String t = new String(temp);				
					postfix_expr[j++]=t;
					i-=1;
					
					if(i==charexpr.length)
						break;
				}
				i++;
				if(i==charexpr.length)
					break a;
			}//while
	    	}//a

		while(stack.top_of_stack != 0)
			postfix_expr[j++] = stack.pop();

		for(i=0;i<j;i++)
			System.out.println("----------: "+postfix_expr[i]);
	
	//evaluation of the postfix expression
		
		for(i=0;i<j;i++)
		{
			if(j == 1)
				result = Double.parseDouble(postfix_expr[i]);
			
			else if((int)postfix_expr[i].charAt(0) >= 48 && (int)postfix_expr[i].charAt(0) <= 57 )
				stack.push(postfix_expr[i]);

			else
			{
				b = stack.pop();
				a = stack.pop(); 
		
				if(postfix_expr[i].equals("+"))
					result = Double.parseDouble(a) + Double.parseDouble(b);
				else if(postfix_expr[i].equals("-"))
					result = Double.parseDouble(a) - Double.parseDouble(b);
				else if(postfix_expr[i].equals("*"))
					result = Double.parseDouble(a) * Double.parseDouble(b);
				
				else if(postfix_expr[i].equals("/"))
					result = Double.parseDouble(a) / Double.parseDouble(b);
		
				String res = Double.toString(result);
				stack.push(res);
			}			
				
		}///for		

		text.setText(Double.toString(result));		


	}//infixToPostfix
}

class StackArray
{
	int i,no;

	public int top_of_stack = 0;
	String []elements = new String[10];

	public void push(String val)
	{
		elements[top_of_stack] = val;
		System.out.println("top : " +top_of_stack+"\tPush : "+elements[top_of_stack]);
		top_of_stack ++;
	}
	
	public String pop()
	{	
		System.out.println("top: " +top_of_stack);
		top_of_stack--;
		return elements[top_of_stack];
		
	}
}

