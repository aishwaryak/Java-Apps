import java.io.*;
import java.net.*;

class Server
{
	public static void main(String []args)
	{
		try
		{
			ServerSocket s = new ServerSocket(34370);
			int clientID = 1;

			while(true)
			{
				try
				{
					Socket clientSocket = s.accept();
					ServiceThread st = new ServiceThread(clientSocket,clientID);
					clientID++;
					st.start();
				}
				catch(IOException e)
				{
					System.out.println(e);
				}
			}//while		
		}
		catch(IOException e)
		{
			System.out.println(e);
		}
	}//main
}//class

class ServiceThread extends Thread
{
	Socket clientSocket;
	int clientID;

	ServiceThread(Socket clientSocket,int clientID)
	{
		this.clientSocket = clientSocket;
		this.clientID = clientID;
	}
	public void run()
	{
		try
		{
			boolean input = true;
 
			System.out.println("Request sent by client "+clientID+" accepted!");
			System.out.println("Client's IP address : "+clientSocket.getInetAddress().getHostName());

			
			InputStream in = clientSocket.getInputStream();
			OutputStream out = clientSocket.getOutputStream();

			DataInputStream din = new DataInputStream(in);
			PrintStream dout = new PrintStream(out);
			
			while(input)
			{
				String str = din.readLine();
				System.out.println("Client : "+str);
				
				if(str.equals("end"))
				{
					input = false;
					din.close();
					dout.close();
					dout.flush();
				}
				else
				{
					dout.println(str);
					dout.flush();
				}
			}//while								
		}
		catch(IOException e)
		{
			System.out.println(e);
		}
	}//run
}//class

