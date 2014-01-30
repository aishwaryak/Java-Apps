import java.io.*;
class GenericClass <T>
{
	int n;
	T[] Array;
	GenericClass(int n)
	{
		this.n=n;	
		Array=(T[])new Object[n];
	}
	void insert(T value,int pos)
	{
		Array[pos]=value;
	}
	void display()
	{
		for(int i=0;i<n;i++)	
			System.out.print(Array[i]+"\n");	
	}
	boolean search(T key)
	{
		
			for(int i=0;i<n;i++)
				if(Array[i].equals(key))
					return true;
	return false;
	}
};
class main
{
	public static void main(String a[]) throws IOException
	{
		int ch=1,n;
		DataInputStream d=new DataInputStream(System.in);
		while(ch==1)
		{
			System.out.print("1.Integer\n2.Float\n3.Char\n4.String\n5.Double\nEnter choice:");
			ch=Integer.parseInt(d.readLine());
			switch(ch)
			{	
				case 1:
				{
					GenericClass <Integer> I=new GenericClass<Integer>(5);
					for(int i=0;i<5;i++)
					{
						System.out.print("Enter element "+(i+1)+":");
						I.insert(Integer.parseInt(d.readLine()),i);
					}
					System.out.print("Enter search key:");
					if(I.search(Integer.parseInt(d.readLine())))
						System.out.print("Search key found!\n");
					else
						System.out.print("NOT FOUND\n");
					I.display();
				}
				break;
				case 2:
				{
					GenericClass <Float> F=new GenericClass<Float>(5);
					for(int i=0;i<5;i++)
					{
						System.out.print("Enter element "+(i+1)+":");
						F.insert(Float.parseFloat(d.readLine()),i);
					}
					System.out.print("Enter search key:");
					if(F.search(Float.parseFloat(d.readLine())))
						System.out.print("Search key found!\n");
					else
						System.out.print("NOT FOUND\n");
					F.display();
				}
				break;
				case 3:
				{
					GenericClass <Character> C=new GenericClass<Character>(5);
					for(int i=0;i<5;i++)
					{
						System.out.print("Enter element "+(i+1)+":");
						C.insert(new Character(d.readLine().charAt(0)),i);
					}
					System.out.print("Enter search key:");
					if(C.search(new Character(d.readLine().charAt(0))))
						System.out.print("Search key found!\n");
					else
						System.out.print("NOT FOUND\n");
					C.display();
				}
				break;
				case 4:
				{
					GenericClass <String> S=new GenericClass<String>(5);
					for(int i=0;i<5;i++)
					{
						System.out.print("Enter element "+(i+1)+":");
						S.insert(d.readLine(),i);
					}
					System.out.print("Enter search key:");
					if(S.search(d.readLine()))
						System.out.print("Search key found!\n");
					else
						System.out.print("NOT FOUND\n");
					S.display();
				}
				break;
				case 5:
				{
					GenericClass <Double> D=new GenericClass<Double>(5);
					for(int i=0;i<5;i++)
					{
						System.out.print("Enter element "+(i+1)+":");
						D.insert(Double.parseDouble(d.readLine()),i);
					}
					System.out.print("Enter search key:");
					if(D.search(Double.parseDouble(d.readLine())))
						System.out.print("Search key found!\n");
					else
						System.out.print("NOT FOUND\n");
					D.display();
				}
				break;
				
				
					 
			}
			System.out.print("To continue , press 1");
			ch=Integer.parseInt(d.readLine());
		}
	}
}

