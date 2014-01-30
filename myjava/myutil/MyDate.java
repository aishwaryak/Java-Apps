package myjava.myutil;

import java.util.*;
import java.io.*;

/** This program is to develop a package containing a class MyDate similar to the class Date in java.util package. 
@author  <b>Keerthana</b>
@since 21/07/10
*/

public class MyDate
{	
	/** Day of the week */
	public int day;

	/** Date */
	public int date;
	
	/** Month */
	public int month;

	/** Year */
	public int year;

	/** Hours */
	public int hour;

	/** Minutes */
	public int min;

	/** Seconds */
	public int sec;

	/** Array containing the number of days in each month */
	public int []num = new int[12];
	
	
	/**Default constructor
	*/
	public MyDate()
	{
		Calendar c = Calendar.getInstance();
		day = c.get(Calendar.DAY_OF_WEEK);
		date = c.get(Calendar.DATE);
		month = c.get(Calendar.MONTH);
		year = c.get(Calendar.YEAR);
		hour = c.get(Calendar.HOUR_OF_DAY);
		min = c.get(Calendar.MINUTE);
		sec = c.get(Calendar.SECOND);	
	}

	/**Parameterised constructor
	@param year Year
	@param month Month
	@param date Date
	*/
	public MyDate(int year,int month,int date)
	{
		this.year = year + 1900;
		this.month = month;
		this.date = date;	
		hour=0;
		min=0;
		sec=0;
		adjustDate();
		adjustMonth();
		adjustYear();
		adjustDay();
	}
	
	/**Parameterised constructor
	@param year Year
	@param month Month
	@param date Date
	@param hour Hours
	@param min Minutes
	@param sec Seconds
	*/
	public MyDate(int year,int month,int date,int hour,int min,int sec)
	{
		this.year = year + 1900;
		this.month = month;
		this.date = date;		
		this.hour = hour;
		this.min = min;
		this.sec = sec;
		adjustTime();
		adjustDate();
		adjustMonth();
		adjustYear();
		adjustDay();
	}

	/**Function to get the day of week 
	@return Day
	*/
	public String getDay()
	{
		switch(day)
		{
			case 1:return "Sunday";
			case 2:return "Monday";
			case 3:return "Tuesday";
			case 4:return "Wednesday";
			case 5:return "Thursday";
			case 6:return "Friday";
			case 7:return "Saturday";
		}
		return "Invalid";
	}

	/**Function to get the date 
	@return Date
	*/
	public int getDate()
	{
		return date;
	}

	/**Function to get the month 
	@return Month
	*/
	public String getMonth()
	{
		switch(month)
		{
			case 0:return "January";
			case 1:return "February";
			case 2:return "March";
			case 3:return "April";
			case 4:return "May";
			case 5:return "June";
			case 6:return "July";
			case 7:return "August";
			case 8:return "September";
			case 9:return "October";
			case 10:return "November";
			case 11:return "December";
		}
		return "Invalid";
	}
		
	/**Function to get the year 
	@return Year
	*/
	public int getYear()
	{
		return year;
	}

	/**Function to get the full date 
	@return a string of the form : "date,month,year,day" 
 	*/
	public String getFullDate()
	{
		String fulldate=date+","+this.getMonth()+","+year+","+this.getDay();
		return fulldate;
	}

	/**Function to get the Hours 
	@return Hours
	*/
	public int getHours()
	{
		return hour;
	}

	/**Function to get the Minutes 
	@return Minutes
	*/
	public int getMinutes()
	{
		return min;
	}

	/**Function to get the Seconds 
	@return Seconds
	*/
	public int getSeconds()
	{
		return sec;	}

	/**Function to get the Time 
	@return a string in the form : "hours:minutes:seconds"
	*/
	public String getTime()
	{
		String t=hour+":"+min+":"+sec+" IST";
		return t;
	}
	
	/**Function to set the date
	@param date Date 
	*/
	public void setDate(int date)
	{
		this.date = date;
		hour = 0;
		min = 0 ;
		sec = 0;
		adjustDate();
		adjustMonth();
		adjustYear();
		adjustDay();
	}
	
	/**Function to set the month
	@param month Month
	*/
	public void setMonth(int month)
	{
		this.month = month;
		hour = 0;
		min = 0 ;
		sec = 0;
		adjustMonth();
		adjustYear();
		adjustDay();
	}

	
	/**Function to set the year
	@param year Year
	*/
	public void setYear(int year)
	{
		this.year = year+1900;
		hour = 0;
		min = 0 ;
		sec = 0;
		adjustYear();
		adjustDay();
	}

	
	/**Function to set the full date
	@param str string of the form : "year,month,date"
	*/
	public void setFullDate(String[] str)
	{
		String dat;
		year=Integer.parseInt(str[0])+1900;
		month=Integer.parseInt(str[1]);
		date=Integer.parseInt(str[2]);
		hour=0;
		min=0;
		sec=0;
		adjustDate();
		adjustMonth();
		adjustYear();
		adjustDay();
	}
	
	
	/**Function to set the time
	@param str string of the form : "hours:minutes:seconds"
	*/
	public void setTime(String[] str)
	{
		hour=Integer.parseInt(str[0]);
		min=Integer.parseInt(str[1]);
		sec=Integer.parseInt(str[2]);
		adjustTime();
		adjustDate();
		adjustMonth();
		adjustYear();
		adjustDay();
	}
	
	
	/**Function to set the Hours
	@param hour Hours
	*/
	public void setHours(int hour)
	{
		this.hour=hour;
		adjustTime();
		adjustDate();
		adjustMonth();
		adjustYear();
		adjustDay();
	}

	
	/**Function to set the Minutes
	@param min Minutes 
	*/
	public void setMinutes(int min)
	{
		this.min=min;
		adjustTime();
		adjustDate();
		adjustMonth();
		adjustYear();
		adjustDay();
	}
		
	
	/**Function to set the Seconds
	@param sec Seconds
	*/
	public void setSeconds(int sec)
	{
		this.sec=sec;
		adjustTime();
		adjustDate();
		adjustMonth();
		adjustYear();
		adjustDay();
	}

	
	/**Function to adjust the time
	*/
	void adjustTime()
	{
		if(sec < 0)
		{
			min--;
			sec = sec + 60;
		}
		if(min < 0)
		{
			hour--;
			min = min + 60;
		}
		if(hour < 0)
		{
			date--;
			hour = hour + 24;
		}	
		if(sec >= 60)
		{
			min += sec/60;
			sec %= 60;
		}
		if(min >= 60)
		{
			hour += min/60;
			min %= 60;
		}
		if(hour >= 24)
		{
			date += hour/24;
			hour %= 24;
		}
	}

	
	/**Function to set the Date
	*/
	void adjustDate()
	{
		num[0]=31;
		if((this.year%400 == 0) || (this.year%4==0 &&this.year%100 != 0))
			num[1]=29;
		else
			num[1]=28;
		num[2]=31;
		num[3]=30;
		num[4]=31;
		num[5]=30;
		num[6]=31;
		num[7]=31;
		num[8]=30;
		num[9]=31;
		num[10]=30;
		num[11]=31;
		
		while(date <= 0)
		{
			month--;
			adjustMonth();
			date = num[month] + date;
		}
		adjustMonth();
		while(date > num[month])
		{
			date -=num[month];
			month ++;
			adjustMonth();
		}
	}

	
	/**Function to set the month
	*/
	void adjustMonth()
	{
		while(month < 0)
		{
			year--;
			month += 12;
		}
		if(month >= 12)
		{
			year += month/12;
			month %= 12;
		}
	}
		
	
	/**Function to set the year
	*/
	void adjustYear()
	{
		if(year <= 0)
			year += 1900;
	}

	
	/**Function to set the day of week
	*/
	void adjustDay()
	{
		Calendar c = new GregorianCalendar(this.year,this.month,this.date);
		this.day = c.get(Calendar.DAY_OF_WEEK);
	}
		
	/**Function to check if two dates are equal
	@param d MyDate object
	@return true if the dates are equal else false
	*/
	public boolean equals(MyDate d)
	{
		if(this.year==d.year && this.month==d.month && this.date==d.date && this.day==day && this.hour==d.hour && this.min==d.min && this.sec==sec)
			return true; 
		return false;
	}

	/**Function to compare two dates
	@param d MyDate object
	@return -1 if Date1 is before Date2, 1 if Date1 is after Date2, 0 if they are equal 
	*/
	public int compareTo(MyDate d)
	{
		boolean b,a;
		b=before(d);
		a=after(d);

		if(b)
			return -1;
		if(a)
			return 1;
		return 0;
	}

	/**Function to check if a date occurs before another
	@param d MyDate object
	@return true if Date1 is before Date2, else false
	*/
	public boolean before(MyDate d)
	{
		if((year < d.year) || (year==d.year && month < d.month) || (year==d.year && month==d.month && date < d.date)|| (year==d.year && month==d.month && date==d.date && hour < d.hour) || (year==d.year && month==d.month && date==d.date && hour==d.hour && min < d.min) || (year==d.year && month==d.month && date==d.date && hour==d.hour && min==d.min && sec < d.sec))
			return true;
		return false;
	}

	/**Function to check if a date occurs after another
	@param d MyDate object
	@return true if Date1 is after Date2, else false
	*/
	public boolean after(MyDate d)
	{
		if(!equals(d) && !before(d))
			return true;
		return false;
	}
	
	/**Function to convert an object into a string
	@return a string of the form : "day month date hour:minutes:seconds IST year"
	*/	public String toString()
	{
		return getDay().substring(0,3) + " "  +getMonth().substring(0,3) + " " + getDate() + " " + getTime()+" "+getYear();
	}
}	

