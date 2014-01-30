import java.io.*;

class three extends Thread 
{
	String name;
	int i=1,j=100,k=0;
	
	three(String name)
	{
		this.name = name;
	}
	public void run()
	{	
	 	if(name.equals("display"))
		{
			while(i<=100)
			{
				System.out.println("Display:"+i++);	
			}
		}
		else if(name.equals("reverse"))
		{
			while(j>=1)
			{	System.out.println("Reverse:"+j);
				j=j-1;
			}
		}
		else if(name.equals("odd"))
		{
			while(k<100)
			{
				if(k%2!=0)
					System.out.println("Odd:"+k);
				k++;
			}
		}
	}
}

class threeThreads 
{
	public static void main(String args[])
	{
		three t1 = new three("display");
		t1.start();
		three t2 = new three("reverse");
		t2.start();
		three t3 = new three("odd");
		t3.start();
	}
}		
		
