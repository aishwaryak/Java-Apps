import java.util.*;
import java.io.*;

class PrimeThread extends Thread
{
	private PipedReader pr1;
	private PipedWriter pw1;

	private int flag = 0;

	PrimeThread(PipedReader pr1,PipedWriter pw1)
	{
		this.pr1 = pr1;
		this.pw1 = pw1;
	}//constructor

	public void run()
	{
		try
		{
			for(int no=2;no<=10000;no++)
			{
				flag = 0;
				for(int i=2;i<no;i++)
				{
					if((no%i)==0)
					{
						flag = 1;
						break;
					}
				}
				if(flag == 0)
				{
					System.out.println("Prime Number : " + no);
					pw1.write(no);
				}//if
			}//for
			pw1.close();
		}//try
		catch(IOException e)
		{
			System.out.println("Prime\t" +e);
		}//catch
	}//run
}

class FibonacciThread extends Thread
{
	private PipedReader pr2;
	private PipedWriter pw2;

	FibonacciThread(PipedReader pr2,PipedWriter pw2)
	{
		this.pr2 = pr2;
		this.pw2 = pw2;
	}//constructor
	
	public void run()
	{
		try
		{
			int n1 = 0;
			int n2 = 1;
			int n3 = 1;
			while(n3 <= 10000)
			{
				
				System.out.println("Fibonacci Number : " +n3);
				pw2.write(n3);
				n1 = n2;
				n2 = n3;
				n3 = n1 + n2;
				
			}
			pw2.close();			
		}//try
		catch(IOException e)
		{
			System.out.println("Fibonnaci\t"+e);
		}
	}//run
}

class ex9
{
	public static void main(String []args)
	{
		ArrayList l1 = new ArrayList();
		ArrayList l2 = new ArrayList();
		ArrayList l3 = new ArrayList();
		int n1,n2;
		
		try
		{
			PipedWriter pw1 = new PipedWriter();
			PipedReader pr1 = new PipedReader(pw1);
				PrimeThread p = new PrimeThread(pr1,pw1);

			PipedWriter pw2 = new PipedWriter();	
			PipedReader pr2 = new PipedReader(pw2);
				FibonacciThread f = new FibonacciThread(pr2,pw2);

			p.start();
			f.start();
		
			while(p.isAlive() && f.isAlive());
		
			//pw1.close();
			//pw2.close();
		
			while((n1 = pr1.read()) != -1)
				l1.add(new Integer(n1));
			pr1.close();

			while((n2 = pr2.read()) != -1)
				l2.add(new Integer(n2));
			//pr1.close();
			pr2.close();

	System.out.println("\n\nL1 size : " +l1.size());
	System.out.println("L2 size : " +l2.size());
			for(int i=0;i<l2.size();i++)
			{ 
				if(l1.contains(l2.get(i)))
					l3.add(l2.get(i));
			}//for
		
			System.out.println("\n\nNumbers that are both prime and fibonnaci :\n" +l3+"\n");
		}//try
		catch(IOException e)
		{
			System.out.println("Main class\t"+e);
		}//catch
		
	}//main
}//class

