import java.io.*;
import myjava.myutil.MyDate;

class Parent
{
	String pName,pDOB;
	String []pHobby = new String[10];
	int no;

	Parent(String pName,String pDOB,String pHobby)
	{
		this.pName=pName;
		this.pDOB=pDOB;
		this.pHobby[0]=pHobby;
	}
	
	void getHobbies() throws IOException
	{
		DataInputStream d= new DataInputStream(System.in);
		int i=1;
		String ch;
		System.out.print("Enter hobby:");
		pHobby[i]=d.readLine();
		
		do
		{
			System.out.print("\nMore hobbies ? Y/N : " );
			ch=d.readLine();
			if(ch.equals("Y") || ch.equals("y"))
			{
				System.out.print("Enter hobby:");
				pHobby[++i]=d.readLine();
			}
		}while(ch.equals("Y") || ch.equals("y"));
		no=i;
	}

	void display()
	{
		int i;
		System.out.print("\n\n\n-----PARENT-----");
		System.out.println("\nParent Name: "+pName);
		System.out.println("Date of birth: "+pDOB);
		System.out.println("Hobbies:");
		for(i=0;i<=no;i++)
			System.out.println("\t"+pHobby[i]);
	}
}

class Child extends Parent
{
	int num;
	String name,DOB;
	String []hobby= new String[10];
 
	Child(String pName,String pDOB,String pHobby,String name,String DOB,String hobby) throws IOException
	{
		super(pName,pDOB,pHobby);

		DataInputStream d= new DataInputStream(System.in);
		System.out.print("\nMore hobbies of parent ? Y/N : ");
		String ch=d.readLine();
		if(ch.equals("Y") || ch.equals("y"))		
			super.getHobbies();

		this.name=name;
		this.DOB=DOB;
		this.hobby[0]=hobby;
	}

	void getHobbies() throws IOException
	{
		DataInputStream d= new DataInputStream(System.in);
		int i=1;
		String ch;
		System.out.print("Enter hobby:");
		hobby[i]=d.readLine();
		
		do
		{
			System.out.print("\nMore hobbies ? Y/N : " );
			ch=d.readLine();
			if(ch.equals("Y") || ch.equals("y"))
			{
				System.out.print("Enter hobby:");
				hobby[++i]=d.readLine();
			}
		}while(ch.equals("Y") || ch.equals("y"));
		num=i;
	}

	void display()
	{
		super.display();
		int i;
		System.out.print("\n\n\n-----CHILD-----");
		System.out.println("\nChild Name: "+name);
		System.out.println("Date of birth: "+DOB);
		System.out.println("Hobbies:");
		for(i=0;i<=num;i++)
			System.out.println("\t"+hobby[i]);
	}

	void ageDifference()
	{
		MyDate sysdate = new MyDate();
		int sysyear = sysdate.getYear();
	
		String[] parent_dob = null;
		parent_dob = pDOB.split("/");
		String[] child_dob = null;
		child_dob = DOB.split("/");

		System.out.println("\nAge of father : "+(sysyear - Integer.parseInt(parent_dob[2]))+" years");
		System.out.println("\nAge of child : "+(sysyear - Integer.parseInt(child_dob[2]))+" years");
		System.out.println("\nAge difference between father and child : "+(Integer.parseInt(child_dob[2]) - Integer.parseInt(parent_dob[2]))+" years");
	}

	void commonHobbies()
	{
		int i,j;
		for(i=0;i<=num;i++)
		{
			for(j=0;j<=no;j++)
			{
				if(hobby[i].equals(pHobby[j]))
					System.out.println("\t"+hobby[i]);
			}
		}
		System.out.println();
	}
}

class ex3a
{
	public static void main(String args[]) throws IOException
	{
		DataInputStream d= new DataInputStream(System.in);
		String ch;

		System.out.print("\nEnter the name of the parent:");
		String pn= d.readLine();
		System.out.print("Enter the parent's DOB:");
		String pd= d.readLine();
		System.out.print("Enter hobby:");
		String ph= d.readLine();

		System.out.print("\n\nEnter the name of the child:");
		String n=d.readLine();
		System.out.print("Enter the child's DOB:"); 
		String dob=d.readLine();
		System.out.print("Enter hobby:");
		String h=d.readLine();
		Child c= new Child(pn,pd,ph,n,dob,h);
		
		System.out.print("\nMore hobbies of child? Y/N : ");
		ch=d.readLine();
		if(ch.equals("Y") || ch.equals("y"))		
			c.getHobbies();
		c.display();

		c.ageDifference();

		System.out.println("\nCOMMON HOBBIES:");
		c.commonHobbies();
	
		System.out.println("\n");
	}
}

