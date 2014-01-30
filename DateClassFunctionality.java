import java.util.*;
import java.io.*;

class DateClassFunctionality
{
	public static void main(String args[])throws IOException
	{
		DataInputStream d = new DataInputStream(System.in);
		Date d1 = new Date();
		Date d2 = new Date();
		while(true)
		{
			System.out.println("\n------MENU-----\n");
			System.out.println("1.Default constructor\n2.Parameterized Constructor(yyyy/mm/dd)\n3.Parameterized Constructor(yyyy/mm/dd,hr:mn:sc)\n4.Parameterized Constructor(using a string)\n5.Date using get functions\n6.Setting the date and time\n7.Comparing two dates\n8.Exit\n");
			System.out.print("Enter your choice:");
			int ch=Integer.parseInt(d.readLine());
		
			switch(ch)
			{
				case 1:
					System.out.println("\nUsing Default Constructor:");
					System.out.println(d1);
					break;
				
				case 2:
					System.out.println("\nUsing Parameterized Constructor(year,month,date):\n");
					System.out.println("\nEnter the year,month and date:");
					d2 = new Date(Integer.parseInt(d.readLine()),Integer.parseInt(d.readLine()),Integer.parseInt(d.readLine()));
					System.out.println(d2);
					break;
	
				case 3:
					System.out.println("\nUsing Parameterized Constructor(year,month,date,hours,mins,secs):\n");
					System.out.println("\nEnter the year(yy),month,date,hours,mins,secs:");
					d2 = new Date(Integer.parseInt(d.readLine()),Integer.parseInt(d.readLine()),Integer.parseInt(d.readLine()),Integer.parseInt(d.readLine()),Integer.parseInt(d.readLine()),Integer.parseInt(d.readLine()));
					System.out.println(d2);
					break;
			
				case 4:
					System.out.println("\nUsing Parameterised Constructor(using a string):\n");
					System.out.print("\nEnter the date in the form (\"mm/dd/yyyy\"):");
					d2 = new Date(d.readLine());
					System.out.println(d2);
					break;
			
				case 5:
					System.out.println("\nUsing getYear(),getMonth(),getDate(),getDay(),getHours(),getMinutes(),getSeconds():\n");
					System.out.println("\nDate:"+d1);
					System.out.println("\nYear: "+d1.getYear()+ "\tMonth: "+d1.getMonth()+"\tDate: "+d1.getDate());
					System.out.println("\nTime: "+d1.getHours()+":"+d1.getMinutes()+":"+d1.getSeconds());
					break;
			

				case 6:
					System.out.println("\nSet date,month,year,hours,minutes and seconds:\n");
					System.out.println("Date: "+d2);

					System.out.println("Enter new year:");
					d2.setYear(Integer.parseInt(d.readLine()));
					System.out.println("Enter new month:");
					d2.setMonth(Integer.parseInt(d.readLine()));
					System.out.println("Enter new date:");
					d2.setDate(Integer.parseInt(d.readLine()));
					System.out.println(d2);

					System.out.println("Enter new time(hr,mn,sc):");
					d2.setHours(Integer.parseInt(d.readLine()));
					d2.setMinutes(Integer.parseInt(d.readLine()));
					d2.setSeconds(Integer.parseInt(d.readLine()));
					System.out.println(d2);
					break;

				case 7:
					System.out.println("\nEnter year,month,date,hours,minutes,seconds for Date 1:");
					Date d3 = new Date(Integer.parseInt(d.readLine()),Integer.parseInt(d.readLine()),Integer.parseInt(d.readLine()),Integer.parseInt(d.readLine()),Integer.parseInt(d.readLine()),Integer.parseInt(d.readLine()));
					
					System.out.println("\nEnter year,month,date,hours,minutes,seconds for Date 2:");
					Date d4 = new Date(Integer.parseInt(d.readLine()),Integer.parseInt(d.readLine()),Integer.parseInt(d.readLine()),Integer.parseInt(d.readLine()),Integer.parseInt(d.readLine()),Integer.parseInt(d.readLine()));

					System.out.print("\nDate 1:");
					System.out.println(d3);
					System.out.print("\nDate 2:");
					System.out.println(d4);
	
					System.out.println("\nUsing compareTo():");
					int r=d3.compareTo(d4);
					if(r==1)
						System.out.println("\nDate 1 is greater than Date 2");
					else if(r==-1)
						System.out.println("\nDate 2 is greater than Date 1");
					else if(r==0)
						System.out.println("\nDate 1 and Date 2 are equal");
					
					System.out.println("\nUsing before() and after():");
					if(d3.before(d4))
						System.out.println("Date 1 is before Date 2");
					else if(d3.after(d4))
						System.out.println("Date 1 is after Date 2");
					else
						System.out.println("Date 1 and Date 2 are equal");
					break;
		
				case 8:
					System.out.println("\nProgram terminating!!\n");
					System.exit(0);
			}//switch
			
		}//while
	}
}
