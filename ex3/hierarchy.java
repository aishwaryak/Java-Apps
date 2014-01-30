import java.util.*;
import java.io.*;

class Employee
{
	String name;
	int id;
	float basic,da,hra,pf,bonus,salary;
	DataInputStream d= new DataInputStream(System.in);

	void getdata() throws IOException
	{
		System.out.print("\nEnter the name of the employee:");
		name = d.readLine();
		System.out.print("Enter the employee ID:");
		id=Integer.parseInt(d.readLine());
		System.out.print("Enter the basic pay:");
		basic=Float.parseFloat(d.readLine());
		System.out.print("Enter the bonus(if there is no bonus,enter 0.00) :");
		bonus=Float.parseFloat(d.readLine());
	}
	void cal_salary()
	{
		da=0.02F * basic;
		hra=0.05F * basic;
		pf=0.03F * basic;
		salary=basic+da+hra-pf+bonus;
	}
	void display()
	{
		System.out.println("\n\n--------EMPLOYEE DETAILS--------");
		System.out.println("\nEmployee name:"+name);
		System.out.println("Employee ID:"+id);
		System.out.println("Basic pay:"+basic);
		System.out.println("DA:"+da);
		System.out.println("HRA:"+hra);
		System.out.println("PF:"+pf);
		System.out.println("Bonus:"+bonus);
		System.out.println("Net Salary:"+salary);
	}
}

class Manager extends Employee
{	
	DataInputStream d= new DataInputStream(System.in);

	void getdata() throws IOException
	{
		System.out.print("\nEnter the name of the manager:");
		name = d.readLine();
		System.out.print("Enter the manager ID:");
		id=Integer.parseInt(d.readLine());
		System.out.print("Enter the basic pay:");
		basic=Float.parseFloat(d.readLine());
		System.out.print("Enter the bonus(if there is no bonus,enter 0.00) :");
		bonus=Float.parseFloat(d.readLine());
	}
	void cal_salary()
	{
		da=0.05F * basic;
		hra=0.07F * basic;
		pf=0.03F * basic;
		salary=basic+da+hra-pf+bonus;
	}
	void display()
	{
		System.out.println("\n\n---------MANAGER DETAILS--------");
		System.out.println("\nManager name:"+name);
		System.out.println("Manager ID:"+id);
		System.out.println("Basic pay:"+basic);
		System.out.println("DA:"+da);
		System.out.println("HRA:"+hra);
		System.out.println("PF:"+pf);
		System.out.println("Bonus:"+bonus);
		System.out.println("Net Salary:"+salary);
	}
}

class Secretary extends Employee
{
	DataInputStream d= new DataInputStream(System.in);

	void getdata() throws IOException
	{
		System.out.print("\nEnter the name of the secretary:");
		name = d.readLine();
		System.out.print("Enter the ID:");
		id=Integer.parseInt(d.readLine());
		System.out.print("Enter the basic pay:");
		basic=Float.parseFloat(d.readLine());
		System.out.print("Enter the bonus(if there is no bonus,enter 0.00) :");
		bonus=Float.parseFloat(d.readLine());
	}
	void cal_salary()
	{
		da=0.01F * basic;
		hra=0.03F * basic;
		pf=0.02F * basic;
		salary=basic+da+hra-pf+bonus;
	}
	void display()
	{
		System.out.println("\n\n--------SECRETARY DETAILS--------");
		System.out.println("\nSecretary name:"+name);
		System.out.println("ID:"+id);
		System.out.println("Basic pay:"+basic);
		System.out.println("DA:"+da);
		System.out.println("HRA:"+hra);
		System.out.println("PF:"+pf);
		System.out.println("Bonus:"+bonus);
		System.out.println("Net Salary:"+salary);
	}
}

class Programmer extends Employee
{
	DataInputStream d= new DataInputStream(System.in);

	void getdata() throws IOException
	{
		System.out.print("\nEnter the name of the programmer:");
		name = d.readLine();
		System.out.print("Enter ID:");
		id=Integer.parseInt(d.readLine());
		System.out.print("Enter the basic pay:");
		basic=Float.parseFloat(d.readLine());
		System.out.print("Enter the bonus(if there is no bonus,enter 0.00) :");
		bonus=Float.parseFloat(d.readLine());
	}
	void cal_salary()
	{
		da=0.05F * basic;
		hra=0.05F * basic;
		pf=0.04F * basic;
		salary=basic+da+hra-pf+bonus;
	}
	void display()
	{
		System.out.println("\n\n------PROGRAMMER DETAILS------");
		System.out.println("\nProgrammer name:"+name);
		System.out.println("ID:"+id);
		System.out.println("Basic pay:"+basic);
		System.out.println("DA:"+da);
		System.out.println("HRA:"+hra);
		System.out.println("PF:"+pf);
		System.out.println("Bonus:"+bonus);
		System.out.println("Net Salary:"+salary);
	}
}

class Executive_Officer extends Manager
{
	DataInputStream d= new DataInputStream(System.in);

	void getdata() throws IOException
	{
		System.out.print("\nEnter the name of the Executive Officer:");
		name = d.readLine();
		System.out.print("Enter the ID:");
		id=Integer.parseInt(d.readLine());
		System.out.print("Enter the basic pay:");
		basic=Float.parseFloat(d.readLine());
		System.out.print("Enter the bonus(if there is no bonus,enter 0.00) :");
		bonus=Float.parseFloat(d.readLine());
	}
	void cal_salary()
	{
		da=0.05F * basic;
		hra=0.07F * basic;
		pf=0.03F * basic;
		salary=basic+da+hra-pf+bonus;
	}
	void display()
	{
		System.out.println("\n\n-----EXECUTIVE OFFICER DETAILS----");
		System.out.println("Officer name:"+name);
		System.out.println("ID:"+id);
		System.out.println("Basic pay:"+basic);
		System.out.println("DA:"+da);
		System.out.println("HRA:"+hra);
		System.out.println("PF:"+pf);
		System.out.println("Bonus:"+bonus);
		System.out.println("Net Salary:"+salary);
	}
}

class hierarchy
{
	public static void main(String args[]) throws IOException
	{
		DataInputStream d= new DataInputStream(System.in);
		do
		{
			System.out.print("\n------MENU-------\n");
			System.out.println("1.Employee\n2.Manager\n3.Secretary\n4.Programmer\n5.Executive Officer\n6.Exit\n");
			System.out.print("Enter your choice: ");
			int ch=Integer.parseInt(d.readLine());
			switch(ch)
			{
				case 1:
					Employee e =new Employee();
					e.getdata();
					e.cal_salary();
					e.display();
					break;

				case 2:
					Manager m=new Manager();
					m.getdata();
					m.cal_salary();
					m.display();
					break;

				case 3:
					Secretary s= new Secretary();
					s.getdata();
					s.cal_salary();
					s.display();
					break;

				case 4:
					Programmer p= new Programmer();
					p.getdata();
					p.cal_salary();
					p.display();
					break;

				case 5:
					Executive_Officer ex= new Executive_Officer();
					ex.getdata();
					ex.cal_salary();
					ex.display();
					break;

				case 6:
					System.out.println("Program terminating!!\n"); 
					System.exit(0);
			}//switch
		}while(true);
	}//main
}	 		

