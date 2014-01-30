import java.io.*;
import java.net.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

class ClientFrame extends JFrame
{
	JPanel p1,p2;
	JTextArea textArea;
	JTextField text;
	JButton b1;
	
	ClientFrame()
	{	
		p1 = new JPanel();
		p2 = new JPanel();
		textArea = new JTextArea();
		text = new JTextField("",30);
		b1 = new JButton("SEND");
	
		setSize(600,400);
		setTitle("CLIENT");
		setLayout(new BorderLayout());
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		textArea.setColumns(50);
		textArea.setRows(30);
		textArea.setEditable(false);
		text.requestFocus();
	
		p1.add(textArea);
		p2.setLayout(new GridLayout(1,2));
		p2.add(text);
		p2.add(b1);
	
		add(p1,BorderLayout.CENTER);
		add(p2,BorderLayout.SOUTH);
	}
}
			
class Client extends Thread
{
	String str,s1;
	InputStream in;
	OutputStream out;
	DataInputStream din;
	PrintStream dout;
	ClientFrame fr;

	Client()
	{
		try
		{
		fr = new ClientFrame(); 
		Socket s = new Socket("localhost",33310);
		
		in = s.getInputStream();
		out = s.getOutputStream();

		din = new DataInputStream(in);
		dout = new PrintStream(out);

		fr.b1.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent event)	
			{
				try
				{
					str = "\nClient : "+fr.text.getText();
					fr.textArea.append(str);
					dout.println(str);
					fr.text.setText("");							
				}
				catch(Exception ex)
				{
					System.out.println(ex);
				}
			}
		});
	/*	fr.text.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent event)	
			{
				try
				{
					str = "\nClient : "+fr.text.getText();
					fr.textArea.append(str);
					dout.println(str);
					fr.text.setText("");							
				}
				catch(Exception ex)
				{
					System.out.println(ex);
				}
			}
		});
*/
		new Thread(this,"Receive").start();
		}
		catch(Exception ex)
		{
			System.out.println(ex);
		}
	}

	public void run()
	{
		try
		{	
			while(true)
			{
				String x;
		
				while((x=din.readLine())!=null)
				{
					fr.textArea.append("\n"+x);
					Thread.sleep(10);
				}
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	public static void main(String []args)
	{
		Client cli = new Client();
	}//main
}//class

