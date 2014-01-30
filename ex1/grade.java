class student
{
	String name;
	int roll,mark1,mark2;
	float avg;
	char g;

	void calculate(String m1,String m2)
	{	
		mark1=Integer.parseInt(m1);
		mark2=Integer.parseInt(m2);
		avg=(mark1+mark2)/2;
		if(avg >=90)
			g='S';
		else if(avg>=80 && avg<90)
			g='A';
		else if(avg>=70 && avg<80)
			g='B';
		else if(avg>=65 && avg<70)
			g='C';
		else if(avg>=60 && avg<65)
			g='D';
		else if(avg>=50 && avg<60)
			g='E';
		else if(avg<50)
			g='U';
	}
		
	void display(String n,String r)
	{
		name=n;
		roll=Integer.parseInt(r);
		System.out.println("Student Name: "+name);
		System.out.println("Roll No.: "+roll);
		System.out.println("Marks in Sub1: "+mark1);
		System.out.println("Marks in Sub2: "+mark2);
		System.out.println("Average: "+avg);
		System.out.println("Grade: "+g);
	}
}

class grade
{
	public static void main(String args[])
	{
		student s=new student();
		s.calculate(args[2],args[3]);
		s.display(args[0],args[1]);
	}
}
 
