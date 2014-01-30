import java.io.*;
import java.net.*;

class Server
{
	public static void main(String []args)
	{
		try
		{
			ServerSocket s = new ServerSocket(33333);
			Socket clientSocket = s.accept();

			InputStream in = clientSocket.getInputStream();
			OutputStream out = clientSocket.getOutputStream();

			DataInputStream din = new DataInputStream(in);
			PrintStream dout = new PrintStream(out);

			DataInputStream d = new DataInputStream(System.in);

			String str;

			while(true)
			{
				str = din.readLine();
				System.out.println("\nClient : "+str);
				if(str.equals("bye"))
					System.exit(0);
				System.out.print("Server : ");
				dout.println(d.readLine());
			}//while
		}//try
		catch(Exception ex)
		{
			System.out.println(ex);
		}//catch
	}//main
}//class

