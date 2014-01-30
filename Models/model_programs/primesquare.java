import java.util.*;
import java.io.*;

class primethread extends Thread 
{
	private PipedReader pr;
	private PipedWriter pw;

	primethread(PipedReader pr, PipedWriter pw) 
	{
		this.pr = pr;
		this.pw = pw;
	}

	public void run() 
	{			
		try 
		{
		int i;
		for (i=1;i<100;i++)
		{
			int j;
			for (j=2; j<i; j++)
			{
				int n = i%j;
				if (n==0)
				{
					break;
				}
			}
			if(i == j)
			{
				pw.write(i);
				System.out.print("\npr -> "+i);
				Thread.sleep(10);
			} 
		}
		pw.close();
		}
		catch (Exception e) 
		{
		}
	}
}

class squarethread extends Thread 
{
	private PipedReader pr;
	private PipedWriter pw;
	private PipedReader ppr;

	squarethread(PipedReader pr, PipedWriter pw, PipedReader ppr) 
	{
		this.pr = pr;
		this.pw = pw;
		this.ppr = ppr;
	}

	public void run() 
	{			
		try 
		{
			int item;
			int sq;
			while((item = ppr.read()) != -1)
			{
				sq = item * item ;
				pw.write(sq);
				System.out.print("\nsq -> "+sq);
				Thread.sleep(20);
			}
		}
		catch (Exception e) 
		{
		}
	}
}

class primesquare
{
	public static void main(String[] args) throws Exception 
	{

	// PRIME
	PipedWriter pw1 = new PipedWriter();	
	PipedReader pr1 = new PipedReader(pw1);

	// SQUARE
	PipedWriter pw2 = new PipedWriter();
	PipedReader pr2 = new PipedReader(pw2);	
	
	primethread prime1 = new primethread(pr1, pw1);
	squarethread square1 = new squarethread(pr2, pw2, pr1);	

	prime1.start();
	square1.start();
	}
}
