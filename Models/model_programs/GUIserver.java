import java.io.*;
import java.awt.*;
import java.awt.event.*;
import java.net.*;


// no J all awt !
// Socket variables diff! ServerSocket 
// br bw
// implements ActionListener and Runnable
// addItem from br
// create server socket then socket=server.accept()
// create br bw	BR=ISR(IS) || BW=OSW(OS)
// thread(this) start()
// write in buffered writer clear text  field newLine flush

class GUIserver extends Frame implements ActionListener,Runnable
{
	List list;
	TextField t;
	Button send,exit;
	
	
	ServerSocket serv;
	Socket sock;
	

	BufferedReader br;
	BufferedWriter bw;
	
	public void run()
	{

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
	
	GUIserver()
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
			serv=new ServerSocket(100);
			sock=serv.accept();
			System.out.println("accepted connection!");
			br=new BufferedReader(new InputStreamReader(sock.getInputStream()));	
			bw=new BufferedWriter(new OutputStreamWriter(sock.getOutputStream()));

			bw.write("HELLO CLIENT ");
			bw.newLine();
			bw.flush();
	
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
			System.out.println("Hey i am server");
			try
			{
				bw.write(t.getText());
				bw.newLine();
				bw.flush();
				t.setText("");
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
	public static void main(String args[])
	{
		GUIserver g=new GUIserver();
		g.setSize(400,400);
		g.pack();
		g.setVisible(true);
		g.setResizable(true);
	}
	
}
				