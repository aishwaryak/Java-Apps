import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.String.*;
import java.lang.Math.*;

class ConversionFrame extends JFrame
{
	JMenuBar menuBar;
	JTextField t1,t2;
	float cel_val,fah_val,temp1,temp2;

	ConversionFrame()
	{
		setTitle("Temperature Conversion");
		setSize(200,100);
		menuBar = new JMenuBar();
		JMenu conv = new JMenu("Conversion");
		JMenuItem cel = new JMenuItem("Celsius");
		JMenuItem fah = new JMenuItem("Fahrenheit");
		conv.add(cel);
		conv.add(fah);
		menuBar.add(conv);
		setJMenuBar(menuBar);
		cel.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				t2.setText("");
				fah_val = Float.parseFloat(t1.getText());
				temp1 = (fah_val - 32)*5;
				cel_val = temp1/9;
				t2.setText(t2.getText() + cel_val);
			}
		});
		fah.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				t2.setText("");
				cel_val = Float.parseFloat(t1.getText());
				temp1 = 9*cel_val;
				temp2 = temp1/5;
				fah_val = temp2 + 32;
				t2.setText(t2.getText() + fah_val);
			}
		});

		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(1,2,5,5));
		t1 = new JTextField("",10);
		t2 = new JTextField("",10);
		panel.add(t1);
		panel.add(t2); 
		add(panel);
		pack();
	}
}
	
class tempConv
{
	public static void main(String []args)
	{
		ConversionFrame cf = new ConversionFrame();
		cf.setVisible(true);
		cf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
	}//main
}//class

