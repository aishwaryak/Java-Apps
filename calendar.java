import java.util.*;

class calendar
{
	public static void main(String args[])
	{
		GregorianCalendar c=new GregorianCalendar();
		int dat=c.get(Calendar.DAY_OF_MONTH);
		System.out.println(dat);
		dat=c.get(Calendar.DAY_OF_WEEK);
		System.out.println(dat);

		Date da=new Date("12/09/09");
		System.out.println(da);

		da=new Date("09/09/21");
		System.out.println(da);
	}
}
