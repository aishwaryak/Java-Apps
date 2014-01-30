import java.io.*;
import java.util.*;

class generic<T>
{
	int i,flag;
	int search(T a[],T b)
	{
		flag=1;
		for(i=0;i<a.length;i++)
		{
			if(a[i].equals(b))
			{
				flag=0;
			}
		}
		if(flag==1)
			return 0;
		else
			return 1;
	}
}	

class genericClass
{
	public static void main(String args[]) throws IOException
	{
		int ch,no,i;
		String st;
		DataInputStream d=new DataInputStream(System.in);

		while(true)
		{
			System.out.print("\nMENU :\n1)Int \n2)Char \n3)Float\n4)Exit\nEnter your choice:");
			ch = Integer.parseInt(d.readLine());
			switch(ch)
			{
				case 1:
					System.out.print("\nNumber of elements to be inserted:");
					no = Integer.parseInt(d.readLine());
					Integer a[]=new Integer[no];
					for(i=0;i<no;i++)
					{
						System.out.print("\nNumber:");
						a[i]=Integer.valueOf(d.readLine());
					}
					System.out.print("\nEnter the Element to be searched:");
					Integer element = Integer.valueOf(d.readLine());
	
				 	i=new generic<Integer>().search(a,element);
					
					if(i==0)
						System.out.println("\nNot found");
					else 
						System.out.println("\nFound");
					break;
			
				case 2:
					System.out.print("\nNumber of elements to be inserted:");
					no = Integer.parseInt(d.readLine());
					Character c[]=new Character[no];
					for(i=0;i<no;i++)
					{
						System.out.print("\nCharacter:");
						st = d.readLine();
						c[i] = st.charAt(0);
					}
					System.out.print("\nEnter the Element to be searched:");
					st = d.readLine();					
					Character e = st.charAt(0);

					i=new generic<Character>().search(c,e);
	
					if(i==0)
						System.out.println("\nNot found");
					else 
						System.out.println("\nFound");
					break;

				case 3:
					System.out.print("\nNumber of elements to be inserted:");
					no = Integer.parseInt(d.readLine());
					Float b[]=new Float[no];
					for(i=0;i<no;i++)
					{
						System.out.print("\nNumber:");
						b[i]=Float.valueOf(d.readLine());
					}
					System.out.print("\nEnter the Element to be searched:");
					Float el = Float.valueOf(d.readLine());

					i=new generic<Float>().search(b,el);
	
					if(i==0)
						System.out.println("\nNot found");
					else 
						System.out.println("\nFound");
					break;
				
				case 4:
					System.out.println("Program terminating!!");
					System.exit(0);
			}//switch
		}//while
	}//main
}

