import cmyutil.cmydate.MyDate;

public class MyDateClassFunctionality 
{
	public static void main(String[] args) 
	{
		java.io.PrintStream out = System.out;
		MyDate newdate = new MyDate();
		out.println("\n\tUsing Default Constructor MyDate()");
		out.println("\tSystem date and time = " + newdate);


		newdate = new MyDate(1990,02,06);
		out.println("\n\tUsing parameterized constructor MyDate(year,month,date) ");
		out.println("\tMyDate(1998,20,20) : "+newdate);


		newdate = new MyDate(2004,01,28,25,23,20);
		out.println("\n\tUsing parameterized constructor MyDate(y,m,d,hour,mins,sec)");
		out.println("\tMyDate(2004,01,29,12,23,20) : "+newdate);

		newdate = new MyDate("10/20/2009");
		out.println("\n\tUsing Parameterized constructor MyDate(String representing date )");
		out.println("\tMyDate(\"10/20/2009\"):  "+newdate);


		out.println("\n\tSetting date : -2\tmonth : 15\tyear :90");
		newdate.setYear(90);
		newdate.setDate(-2);
		newdate.setMonth(15);
		out.println("\tUpdated Date "+newdate);


		out.println("\n\tSetting time fields ");
		out.println("\tsetHours to 2");
		newdate.setHours(25);
		out.println("\n\tNew Date value: "+newdate);
		out.println("\tsetHours to -2");
		newdate.setHours(-2);
		out.println("\n\tNew Date Value: "+newdate);
		out.println("\n\tSetting minutes to 21");
		newdate.setMinutes(21);
		out.println("\tNew Date value: " +newdate);
		newdate.setMinutes(-1);
		out.println("\tNew Date value: " +newdate);
		
		MyDate date1 = new MyDate(2009,10,2);
		MyDate date2 = new MyDate(2009,11,2,23,10,11);

		out.println("\n\tDate 1: "+ date1);
		out.println("\n\tDate 2: "+ date2);
		
		out.println("\n\tDate1.equals(Date2) "+ date1.equals(date2));
		out.println("\n\tDate1.before(Date2) "+ date1.before(date2));
		out.println("\n\tDate1.after(Date2) " + date1.after(date2));
		out.println("\n\tDate1.compareTo(Date2) "+ date1.compareTo(date2));
	}
}

