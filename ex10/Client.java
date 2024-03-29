import java.io.*;
import java.net.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Client
{
	public static void main(String []args)
	{
		ClientFrame f = new ClientFrame();
		f.setSize(600,400);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}//main
}//class

class ClientFrame extends JFrame
{

	JPanel p1,p2,p3;
	JLabel l1,l2,l3;
	JTextField t1,t2,t3;
	JButton b1,b2;
	JFrame f;

	InputStream in = null;
	OutputStream out = null;
	DataInputStream din;
	PrintStream dout;
	Socket socket;

	SendAddressListener addrListener = new SendAddressListener();
	SendMessageListener mssgListener = new SendMessageListener();

	ClientFrame()
	{
			
		l1 = new JLabel("Server IP Address : ");
		l2 = new JLabel("Message : ");
		l3 = new JLabel("Message's echo from server : ");
		
		t1 = new JTextField("",15);
		t2 = new JTextField("",15);
		t3 = new JTextField("",15);
					
		b1 = new JButton("Send Server IP Address");
		b2 = new JButton("Send Message");
				
		p1 = new JPanel();
		p1.add(l1);
		p1.add(t1);
		p1.add(b1);
		
		p2 = new JPanel();
		p2.add(l2);
		p2.add(t2);
		p2.add(b2);
		
		p3 = new JPanel();
		p3.add(l3);
		p3.add(t3);	
		
				
		setLayout(new GridLayout(3,1,1,1));
		add(p1);
		add(p2);
		add(p3);
				
		b1.addActionListener(addrListener);
		b2.addActionListener(mssgListener);
	
	}//constructor	
	
	
	private class SendAddressListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			try
			{
				String str = t1.getText();
				if(str.equals("localhost"))
				{
					socket = new Socket(str,34370);	

					in = socket.getInputStream();
					din = new DataInputStream(in);

					out = socket.getOutputStream();
					dout = new PrintStream(out);
				}
				else
				{
					
				}
			}
			catch(UnknownHostException e)
			{	
				System.out.println(e);
			}
			catch(IOException e)
			{
				System.out.println(e);
			}
		}
	}
			
	private class SendMessageListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			try
			{
				dout.println(t2.getText());
				t3.setText(din.readLine());
				if(t2.getText().equals("end"))
				{
					dout.println(t2.getText());
					dout.flush();
					dout.close();
					din.close();
					System.exit(0);
				}
			}
			catch(IOException e)
			{
				System.out.println(e);
			}
		}
	}					
}//class

