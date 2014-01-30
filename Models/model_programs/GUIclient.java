import java.io.*;
import java.awt.*;
import java.awt.event.*;
import java.net.*;

// no J all awt !
// Socket variables diff!
// br bw
// implements ActionListener and Runnable
// addItem from br
// create br bw	BR=ISR(IS) || BW=OSW(OS)
// thread(this) start()
// write in buffered writer clear text  field newLine flush

class GUIc extends Frame implements ActionListener,Runnable  
{
	List list;
	TextField t;
	Button send,exit;
	
	
	Socket sock1;
	

	BufferedReader br;
	BufferedWriter bw;
	
	public void run()
	{
		try
		{
			sock1.setSoTimeout(1);
		}
		catch(Exception excep)
		{
		}

		while(true)
		{
			try
			{
				list.addItem(br.readLine());
			}
			catch(Exception m)
			{
			}
		}
	}		
	
	GUIc()
	{
	
		list=new List();
		t=new TextField(25);
		send=new Button("SEND");
		exit=new Button("EXIT");
		
		send.addActionListener(this);
		exit.addActionListener(this);
		
		
		add(list,"Center");
		add(t,"South");
		add(send,"West");
		add(exit,"East");

		setVisible(true);
		
		
		try
		{
			sock1=new Socket("127.0.0.1",100);
			
			br=new BufferedReader(new InputStreamReader(sock1.getInputStream()));	
			bw=new BufferedWriter(new OutputStreamWriter(sock1.getOutputStream()));

			
			
	
			Thread th=new Thread(this);
			th.start();
		}
		catch(Exception ex)
		{}
	}
	public void actionPerformed(ActionEvent e)
	{
		String str=e.getActionCommand();
		if(str.equals("SEND"))
		{
			
			System.out.println("Hey i am clientr");
			try
			{
				bw.write(t.getText());t.setText("");
				bw.newLine();
				bw.flush();
			}
			catch(Exception eex)
			{
			}
		}
		else
		{
			System.exit(1);
		}
	}
}
class GUIclient
{
	public static void main(String args[])
	{
		GUIc g=new GUIc();
		g.pack();
		g.setVisible(true);
	}
	
}
				