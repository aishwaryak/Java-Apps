import java.io.*;

class Student
{
	String name;
	int ID;

	DataInputStream d = new DataInputStream(System.in);
	
	void getData() throws IOException
	{
		System.out.print("\nName : ");
		name = d.readLine();
		System.out.print("\nID : ");
		ID = Integer.parseInt(d.readLine());
	}
	 
}

class Marks extends Student
{
	float m1,m2,m3;

	DataInputStream d = new DataInputStream(System.in);

	void getData() throws IOException
	{
		super.getData();
		System.out.print("\nMark 1 : ");
		m1 = Float.parseFloat(d.readLine());
		System.out.print("\nMark 2 : ");
		m2 = Float.parseFloat(d.readLine());
		System.out.print("\nMark 3 : ");
		m3 = Float.parseFloat(d.readLine());
	}

	float getm1()
	{
		return m1;
	}

	float getm2()
	{
		return m2;
	}

	float getm3()
	{
		return m3;
	}
}

class Average
{
	public static void main(String []args) throws IOException
	{
		Marks []m = new Marks[10];
		float total1=0.0F, total2=0.0F ,total3=0.0F;
		float avg1,avg2,avg3;

		DataInputStream d = new DataInputStream(System.in);
		
		System.out.print("\nEnter the no. of students : ");
		int n = Integer.parseInt(d.readLine());
		
		for(int i=0;i<n;i++)
		{			
			m[i] = new Marks();
			m[i].getData();
			total1 += m[i].getm1();
			total2 += m[i].getm2();
			total3 += m[i].getm3();
		}
		avg1 = total1/n;
		avg2 = total2/n;
		avg3 = total3/n;

		System.out.println("\nAvg 1 : " +avg1+"\tAvg 2 : "+avg2+"\tAvg 3 : "+avg3+"\n");
	
	}//main
}

