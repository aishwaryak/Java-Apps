import java.io.*;
import java.net.*;

class Client
{
	public static void main(String []args)
	{
		try
		{
			Socket s = new Socket("localhost",33333);
			
			InputStream in = s.getInputStream();
			OutputStream out = s.getOutputStream();

			DataInputStream din = new DataInputStream(in);
			PrintStream dout = new PrintStream(out);

			DataInputStream d = new DataInputStream(System.in);
			String str;
			
			while(true)
			{
				System.out.print("Client : ");
				str = d.readLine();
				dout.println(str);

				if(str.equals("bye"))
					System.exit(0);
			
				str = din.readLine();
				System.out.println("\nServer : "+str);
			}//while
		}//try
		catch(Exception ex)
		{
			System.out.println(ex);
		}//catch
	}//main
}//class

