package cmyutil.cmydate;
import java.util.Calendar;
import java.util.IllegalFormatException;

public class MyDate
{
	private int month;
	private int date;
	private int dayofweek;
	private int year;
	private int hour;
	private int minutes;
	private int seconds;
	private static String months[];
	private static String days[];
	private static int numberofdays[];
	static
	{
		months=new String[12];
		months[0] = new String("January");
		months[1] = new String("February");
		months[2] = new String("March");
		months[3] = new String("April");
		months[4] = new String("May");
		months[5] = new String("June");
		months[6] = new String("July");
		months[7] = new String("August");
		months[8] = new String("September");
		months[9] = new String("October");
		months[10] = new String("November");
		months[11] = new String("December");
		
		days = new String[7];
		days[0] = new String("Sunday");
		days[1] = new String("Monday");
		days[2] = new String("Tuesday");
		days[3] = new String("Wednesday");
		days[4] = new String("Thursday");
		days[5] = new String("Friday");
		days[6] = new String("Saturday");
		
		numberofdays = new int[12];
		numberofdays[0] = 31;
		numberofdays[1] = 28;
		numberofdays[2] = 31;
		numberofdays[3] = 30;
		numberofdays[4] = 31;
		numberofdays[5] = 30;
		numberofdays[6] = 31;
		numberofdays[7] = 31;
		numberofdays[8] = 30;
		numberofdays[9] = 31;
		numberofdays[10] = 30;
		numberofdays[11] = 31;
	};
	
	
	public MyDate()
	{
		initializeToSystemDateAndTime();
	}
	
	public MyDate(int year,int month,int date)
	{
		this(year,month,date,0,0,0);
	}
	
	public MyDate(int year,int month,int date,int hour,int min,int sec)
	{
		this.date = date;
		this.month = month+1;
		this.year = 1900+year;
		this.hour = hour;
		this.minutes = min;
		this.seconds = sec;
		correctTime();
		correctDate();
		correctMonth();
		correctYear();
		correctDay();
	}
		
	public MyDate(String date)
	{
		try{
			String parts[] = date.split("/");
			if(parts.length != 3)
				initializeToSystemDateAndTime();
			else
			{
				this.date = Integer.parseInt(parts[1].trim());
				this.month = Integer.parseInt(parts[0].trim());
				if(Integer.parseInt(parts[2]) <30)
					this.year = Integer.parseInt(parts[2].trim())+2000;
				else if(Integer.parseInt(parts[2]) <100)
					this.year = Integer.parseInt(parts[2].trim())+1900;
				else
					this.year = Integer.parseInt(parts[2].trim());
				hour = 0;
				minutes =0 ;
				seconds = 0;
				correctDate();
				correctMonth();
				correctYear();
				correctDay();
			}
		}
		catch(Exception e)
		{
			initializeToSystemDateAndTime();
		}
	}
	
	private void initializeToSystemDateAndTime()
	{
		Calendar temp = Calendar.getInstance();
		date = temp.get(Calendar.DAY_OF_MONTH);
		month = temp.get(Calendar.MONTH) + 1;
		year = temp.get(Calendar.YEAR);
		dayofweek = temp.get(Calendar.DAY_OF_WEEK);
		hour = temp.get(Calendar.HOUR_OF_DAY);
		minutes = temp.get(Calendar.MINUTE);
		seconds = temp.get(Calendar.SECOND);	
	}
	
	public String getDay()
	{
		return days[dayofweek-1];
	}
	
	public int getDate()
	{
		return date;
	}
	
	public void setDate(int date)
	{
		this.date = date;
		hour = 0;
		minutes =0 ;
		seconds = 0;
		correctDate();
		correctMonth();
		correctYear();
		correctDay();
	}
	
	public String getMonth()
	{
		return months[month -1 ];
	}
	
	public void setMonth(int month)
	{
		this.month = month;
		if(month>=0 && month<=11)
			this.month++;
		hour = 0;
		minutes =0 ;
		seconds = 0;
		correctMonth();
		correctYear();		
		correctDay();
	}
	
	public int getYear()
	{
		return year;
	}
	
	public void setYear(int year)
	{
		this.year = year+1900;
		hour =minutes =seconds = 0;		
		correctYear();
		correctDay();
	}
	
	public String getFullDate()
	{
		StringBuffer fulldate = new StringBuffer();
		if(date < 10)
			fulldate.append("0");
		fulldate.append(date+", ");
		fulldate.append(months[month-1]+", ");
		fulldate.append(year +", ");
		fulldate.append(days[dayofweek-1]);
		return new String(fulldate);
	}
	
	public void setFullDate(String fulldate)
	{
		String parts[] = fulldate.split(",");
		int i;
		if(parts.length!=4)
			initializeToSystemDateAndTime();
		else
		{
			date = Integer.parseInt(parts[0].trim());
			parts[1] = parts[1].trim();
			for(i=0;i<months.length;i++)
				if(months[i].equalsIgnoreCase(parts[1]))
					break;
			if(i == months.length)
				initializeToSystemDateAndTime();
			else
			{
				month = i+1;
				year = Integer.parseInt(parts[2].trim());
				hour = 0;
				minutes =0 ;
				seconds = 0;			
				correctDate();
				correctMonth();
				correctYear();
				correctDay();
			}
		}
	}

	public void setHours(int h)
	{
		hour = h;
		correctTime();
		correctDate();
		correctMonth();
		correctYear();
		correctDay();		
	}
	
	public int getHours()
	{
		return hour;
	}
	
	public void setMinutes(int m)
	{
		minutes = m;
		correctTime();
		correctDate();
		correctMonth();
		correctYear();
		correctDay();		
	}
	
	public int getMinutes()
	{
		return minutes;
	}
	
	public void setSeconds(int s)
	{
		seconds = s;
		correctTime();
		correctDate();
		correctMonth();
		correctYear();
		correctDay();
	}
	
	public int getSeconds()
	{
		return seconds;
	}
	
	public void setTime(String time)
	{
		String parts[] = time.split(":");
		if(parts.length != 3)
			initializeToSystemDateAndTime();
		else
		{
			hour = Integer.parseInt(parts[0].trim());
			minutes = Integer.parseInt(parts[1].trim());
			parts = parts[2].trim().split(" ");
			if(parts.length != 2)
				initializeToSystemDateAndTime();
			else
			{		
				seconds = Integer.parseInt(parts[0].trim());
				if(parts[1].trim().equals("pm") || parts[1].trim().equals("PM"))
						hour += 12;
				correctTime();
				correctDate();
				correctMonth();
				correctYear();
				correctDay();
			}
		}
	}
	
	public String getTime()
	{
		StringBuffer time = new StringBuffer();
		int temp=hour;
		boolean pm = false;
		if(temp >= 13)
		{
			temp-=12;
			pm = true;
		}
		if(temp < 10)
			time.append("0");
		time.append(temp+" : ");
		if(minutes < 10)
			time.append("0");
		time.append(minutes+" : ");
		if(seconds < 10)
			time.append("0");
		time.append(seconds+" ");
		if(pm)
			time.append("PM");
		else
			time.append("AM");
		return new String(time);
	}
	
	private void correctTime()
	{
		while(seconds < 0)
		{
			minutes--;
			seconds = 60 + seconds;
		}
		while(minutes < 0)
		{
			hour--;
			minutes = 60 + minutes;
		}			
		while(hour < 0)
		{
			date--;
			hour = 24 + hour;
		}
		if(seconds >= 60)
		{
			minutes+= seconds/60;
			seconds %=60;
		}
		if(minutes >= 60)
		{
			hour += minutes/60;
			minutes %= 60;
		}
		if(hour >=24)
		{
			date+= hour/24;
			hour %=24;
		}
	}
	
	private void correctDay()
	{
		Calendar temp = Calendar.getInstance();
		temp.set(year,month-1,date);
		dayofweek = temp.get(Calendar.DAY_OF_WEEK);
	}
	
	private void correctDate()
	{
		while(date <= 0)
		{
			month--;
			correctMonth();
			date = numberofdays[month-1] + date + 1;
		}
		correctMonth();
		while(date > numberofdays[month-1])
		{
			date -=numberofdays[month-1];
			month ++;
			correctMonth();
		}
	}
	
	private void correctMonth()
	{
		while(month <= 0)
		{
			year--;
			month += 12;
		}	
		if(month > 12)
		{
			year += month/12;
			month%= 12;
		}
	}
	
	private void correctYear()
	{
		if(year <= 0)
			year+=1900;
	}

	public boolean equals(MyDate date)
	{
		if(month == date.month && this.date == date.date && dayofweek == date.dayofweek && year == date.year && hour == date.hour && minutes == date.minutes && seconds == date.seconds)
			return true;
		return false;
	}
	
	public boolean before(MyDate date)
	{
		if(equals(date))
			return false;
		if(year > date.year)
			return false;
		else if(month > date.month && year == date.year)
			return false;
		else if(this.date > date.date && month == date.month && year == date.year)
			return false;
		else if(hour > date.hour && this.date == date.date && month == date.month && year == date.year)
			return false;
		else if(minutes > date.minutes && hour == date.hour && this.date == date.date && month == date.month && year == date.year)
			return false;
		else if(seconds > date.seconds && minutes == date.minutes && hour == date.hour && this.date == date.date && month == date.month && year == date.year)
			return false;
		return true;
	}
	
	public boolean after(MyDate date)
	{
		if(!before(date) && !equals(date))
			return true;
		return false;
	}
	
	public int compareTo(MyDate date)
	{
		boolean bef= before(date);
		boolean aft = after(date);
		if(bef)
			return -1;
		if(aft)
			return 1;		
		return 0;
	}

	public String toString()
	{
		return getDay().substring(0,3) + " "  +getMonth().substring(0,3) + " " + getDate() + " " + getTime()+" "+getYear();
	}
}

