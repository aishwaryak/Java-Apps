import java.io.*;
import java.util.*;

class PrimeThread extends Thread
{
	PipedReader pr1;
	PipedWriter pw1;

	PrimeThread(PipedReader pr1,PipedWriter pw1)
	{
		this.pr1 = pr1;
		this.pw1 = pw1;
	}
	
	public void run()
	{
		try
		{
		for(int no=2;no<=100;no++)
		{
			int flag=0,i;
			for(i=2;i<no;i++)
			{
				if(no%i  == 0)
				{
					flag = 1;
					break;
				}
			}
			if(flag == 0)
			{
				System.out.println("Prime : "+i);
				pw1.write(i);
				Thread.sleep(100);
			}
		}//for		
		pw1.close();
		}
		catch(Exception ex)
		{
			System.out.println(ex);
		}
	}
}//class

class SquareThread extends Thread
{
	PipedReader pr1,pr2;
	PipedWriter pw2;
	
	SquareThread(PipedReader pr2,PipedWriter pw2,PipedReader pr1)
	{
		this.pr2 = pr2;
		this.pw2 = pw2;
		this.pr1 = pr1;
	}

	public void run()
	{
		try
		{
		int n1;
		while((n1 = pr1.read()) != -1)
		{
			int sq = n1 * n1;
			System.out.println("Square : "+sq);
			pw2.write(sq);
		}//while
		pw2.close();
		}
		catch(Exception ex)
		{
			System.out.println(ex);
		}
	}
}//class

class PrimeSquare
{
	public static void main(String []args)
	{
		try
		{
		PipedWriter pw1 = new PipedWriter();
		PipedReader pr1 = new PipedReader(pw1);

		PipedWriter pw2 = new PipedWriter();
		PipedReader pr2 = new PipedReader(pw2);

		PrimeThread p = new PrimeThread(pr1,pw1);
		SquareThread s = new SquareThread(pr2,pw2,pr1);

		p.start();
		s.start();
		}
		catch(Exception ex)
		{
			System.out.println(ex);
		}
	}//main
}//class

