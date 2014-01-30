import java.io.*;
import java.util.*;

class ThreeThreads extends Thread
{
	String name;
	
	ThreeThreads(String name)
	{
		this.name = name;
	}
	public void run()
	{
		try
		{
		if(name.equals("Numbers"))
		{
			for(int i=1;i<=100;i++)
				System.out.println("No : "+i+"\n");
			Thread.sleep(100);
		}
		if(name.equals("Reverse"))
		{
			for(int i=100;i>=1;i--)
				System.out.println("Rev : "+i+"\n");
			Thread.sleep(100);
		}
		if(name.equals("Odd"))
		{
			for(int i=1;i<=100;i++)
			{
				if(i%2 != 0)
					System.out.println("Odd : "+i+"\n");
			}
			Thread.sleep(100);
		}
		}
		catch(Exception ex)
		{
			System.out.println(ex);
		}
	}

	public static void main(String []args)
	{
		ThreeThreads t1 = new ThreeThreads("Numbers");
		t1.start();
		ThreeThreads t2 = new ThreeThreads("Reverse");
		t2.start();
		ThreeThreads t3 = new ThreeThreads("Odd");
		t3.start();
	}
}
