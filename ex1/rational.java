/** This program is to create a rational number class and use Javadoc comments for implementation.
    @author <b>Keerthana</b>
    @since 15/07/10
*/


public class rational
{
	/** Numerator*/
	public int num;
	/** Denominator */
	public int den;
	
	
	/**Default constructor
	@param nothing
	*/
	public rational()
	{
		num=5;
		den=7;
	}
	

	/**Parameterised constructor
	@param n Numerator
	@param d Denominator
	*/
	public rational(String n,String d)
	{
		num=Integer.parseInt(n);
		if(Integer.parseInt(d)!=0)
			den=Integer.parseInt(d);
		else
			System.out.println("Undefined as denominator is zero!!!");
	}
	

	/**Copy constructor
	@param r Object of class rational
	*/
	public rational(rational r)
	{
		num=r.num;
		den=r.den;
	}
	

	/**Function to display a rational number 
	@param nothing
	@return nothing
	*/
	public void display()
	{
		System.out.println(num+"/"+den);
	}
	

	/**Function to reduce a given rational number
	@param nothing
	@return nothing
	*/
	public void reduce()
	{
		int n1=num,d1=den;
		int r,gcd;
		while(n1!=0)
		{
			r=d1%n1;
			d1=n1;
			n1=r;
		}
		gcd=d1;
		num=num/gcd;
		den=den/gcd;
	}

	/**Function to add two rational numbers
	@param r Second rational number
	@return Sum of the numbers
	*/
	public rational add(rational r)
	{
		rational res=new rational();
		res.num=(num*r.den + den*r.num);
		res.den=den*r.den;
		return res;
	}
}

class number
{
	public static void main(String args[])
	{
		rational r1= new rational(args[0],args[1]);
		System.out.println("Initialising a rational number using constructor:");
		r1.reduce();
		System.out.print("Number 1:");
		r1.display();

		System.out.println();
		rational r2=new rational();
		System.out.println("Initialising a rational number using default constructor:");
		System.out.print("Number 2:");
		r2.display();

		System.out.println();
		rational r3=new rational(r2);
		System.out.println("Initialising a rational number using copy constructor:");
		System.out.print("Number 3:");
		r3.display();

		System.out.println();
		System.out.println("Addition of two rational numbers:"); 
		rational r4=new rational();
		r4=r1.add(r3);
		r4.reduce();
		System.out.print("Sum of number 1 and number 3:"); 
		r4.display();
		System.out.println();
	}
}
	
