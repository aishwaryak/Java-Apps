import myjava.myutil.*;
import java.io.*;

class datefunction
{

	public static void main(String args[])throws IOException
	{

		boolean r;
		int ch;
		DataInputStream d=new DataInputStream(System.in);

		while(true)
		{
			System.out.println("\n---------------MENU---------------");
			System.out.print("\n1.Using Default Constructor");
			System.out.print("\n2.Using Parameterized Constructor(year,month,date)");
			System.out.print("\n3.Using Parameterized Constructor(year,month,date,hours,minutes,seconds)");
			System.out.print("\n4.Using set and get functions");
			System.out.print("\n5.Using setFullDate(),setTime(),getFullDate(),getTime()");
			System.out.print("\n6.Comparing two dates");
			System.out.print("\n7.Exit\n");
			System.out.print("\nEnter your choice:");
			ch=Integer.parseInt(d.readLine());

			switch(ch)
			{
				case 1:
					System.out.println("\nDefault Constructor");
					MyDate d1=new MyDate();
					System.out.println(d1);
					break;
		
				case 2:
					System.out.println("\nParameterized constructor:year,month,date -parameters");
					System.out.println("\nEnter the year,month,date in integers:");
					MyDate d2=new MyDate(Integer.parseInt(d.readLine()),Integer.parseInt(d.readLine()),Integer.parseInt(d.readLine())); 						
					System.out.println("Date : "+d2);
					break;

				case 3:
					System.out.println("\nParameterized constructor:year,month,date,hours,minutes,seconds -parameters");
					System.out.println("\nEnter the year,month,date,hours,mins,secs in integers:");
					MyDate d3=new MyDate(Integer.parseInt(d.readLine()),Integer.parseInt(d.readLine()),Integer.parseInt(d.readLine()),Integer.parseInt(d.readLine()),Integer.parseInt(d.readLine()),Integer.parseInt(d.readLine()));
					System.out.println("Date : "+d3);
					break;

				case 4:
					System.out.println("\nSetting the date and time using setDate(),setMonth()...,setSeconds()");
					System.out.println("\nOutput using getDate(),getMonth,.....,getSeconds()");
					System.out.println("\nEnter the year,month,date,hours,minutes,seconds:");
					MyDate d4=new MyDate();
					int yr=Integer.parseInt(d.readLine());
					int mon=Integer.parseInt(d.readLine());
					int da=Integer.parseInt(d.readLine());
					int hr=Integer.parseInt(d.readLine());
					int mi=Integer.parseInt(d.readLine());
					int se=Integer.parseInt(d.readLine());
		
					d4.setYear(yr);
					d4.setMonth(mon);
					d4.setDate(da);		
					d4.setHours(hr);
					d4.setMinutes(mi);
					d4.setSeconds(se);

					System.out.println("Date : "+d4);
					System.out.println("Using get functions : "+d4.getDate()+","+d4.getMonth()+","+d4.getYear()+","+d4.getDay()+","+d4.getHours()+","+d4.getMinutes()+","+d4.getSeconds());
					break;	
				
				case 5:
					MyDate d5=new MyDate();
					System.out.println("\nSetting the date and time using setFullDate() and setTime()");
					System.out.println("\nOutput using getFullDate() and getTime()");
					System.out.print("Enter date in the format : \"year,month,date\":");
					String fulldate=d.readLine();
					String[] full=null;
					full=fulldate.split(",");
					d5.setFullDate(full);

					System.out.print("Enter time in the format : \"hours:min:sec\":");
					String fulltime=d.readLine();
					full=fulltime.split(":");
					d5.setTime(full);

					System.out.println("Date : "+d5);
					System.out.println("Using getFullDate() and getTime() : "+d5.getFullDate()+","+d5.getTime());
					break;

				case 6:
					System.out.println("\nEnter year,month,date,hours,minutes,seconds for Date 1:");
					MyDate d6=new MyDate(Integer.parseInt(d.readLine()),Integer.parseInt(d.readLine()),Integer.parseInt(d.readLine()),Integer.parseInt(d.readLine()),Integer.parseInt(d.readLine()),Integer.parseInt(d.readLine()));
		
					System.out.println("\nEnter year,month,date,hours,minutes,seconds for Date 2:");
					MyDate d7=new MyDate(Integer.parseInt(d.readLine()),Integer.parseInt(d.readLine()),Integer.parseInt(d.readLine()),Integer.parseInt(d.readLine()),Integer.parseInt(d.readLine()),Integer.parseInt(d.readLine()));
		
					System.out.print("\nDate 1:"+d6);
					System.out.print("\nDate 2:"+d7);


					System.out.println("\nUsing methods equals() and compareTo():");		
					if(d6.equals(d7)) 
						System.out.print("Date 1 and Date 2 are equal\n");
	
					if(d6.compareTo(d7)==1) 
						System.out.print("Date 1 greater than Date 2\n");
					else if(d6.compareTo(d7)==-1) 
						System.out.print("Date 2 greater than Date 1\n");
		
					System.out.println("\nUsing methods before() and after():");
					if(d6.before(d7)) 
						System.out.print("Date 1 is before Date 2\n");
					else if(d6.after(d7)) 
						System.out.print("Date 1 is after Date 2\n");

					break;

				case 7:
					System.out.println("Program terminating\n");
					System.exit(0);
			}//switch
		}//while
	}
}

