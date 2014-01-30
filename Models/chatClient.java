import java.awt.event.*;
import java.awt.*;
import javax.swing.event.*;
import javax.swing.*;
import java.io.*;
import java.net.*;

class chatClient extends JFrame implements ActionListener
{
	JButton send,clear;
	JTextField msg;
	JLabel msg_l;
	JTextArea a1;
	JPanel p1,p2,p3;
	Socket s2;
	
	chatClient()
	{		
		setSize(200,400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		
		send=new JButton("Send");
		clear=new JButton("Clear");
		
		send.addActionListener(this);
		clear.addActionListener(this);
		
		msg=new JTextField("",10);
		msg_l=new JLabel("Message");
		
		a1=new JTextArea();

		p1=new JPanel(new GridLayout(1,2));
		p2=new JPanel(new GridLayout(1,2));
		p3=new JPanel();
	
		p1.add(msg_l);
		p1.add(msg);

		p2.add(send);
		p2.add(clear);

		p3.add(a1);

		add(p1,BorderLayout.NORTH);
		add(p3,BorderLayout.CENTER);
		add(p2,BorderLayout.SOUTH);

		pack();
	}
	
	public void actionPerformed(ActionEvent e)
	{
		if(e.getActionCommand().equals("Send"))
		{
			try{
			s2=new Socket("127.0.0.1",2233);
			DataInputStream d=new DataInputStream(s2.getInputStream());
			PrintStream p=new PrintStream(s2.getOutputStream());
			a1.append("\nClient:"+msg.getText());
			p.println(msg.getText());
			a1.append("\nServer:"+d.readLine());
			}
			catch(Exception ex)
			{
				System.out.println(ex);
			}
			finally
			{
				try{
				s2.close();
				}
				catch(Exception ex)
				{
					System.out.println(ex);
				}
			}
		}
		else if(e.getActionCommand().equals("Clear"))
		{
			msg.setText("");
		}
	}
	public static void main(String args[])
	{
		chatClient s=new chatClient();
	}
}
		

