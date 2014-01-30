import myjava.calculator.calculate;
import java.io.*;

class compute
{
	public static void main(String args[])
	{
		int r,ch;
		double n,n1,n2,res;

		ch=Integer.parseInt(args[0]);
		calculate c1=new calculate(Double.parseDouble(args[1]));
		n1=c1.getno();
		
		System.out.println("First no:"+n1);

		calculate c2=new calculate(Double.parseDouble(args[2]));
		n2=c2.getno();
		
		System.out.println("Second no:"+n2);
		
		switch(ch)
		{
			case 1:				res=c1.add(c2);
				System.out.println("Sum:"+res);
				break;

			case 2:
				res=c1.sub(c2);
				System.out.println("Difference:"+res);
				break;

			case 3:
				res=c1.mul(c2);
				System.out.println("Product:"+res);
				break;

			case 4:
				res=c1.div(c2);
				System.out.println("Quotient:"+res);
				break;

			case 5:
				res=c1.pow(c2);	
				System.out.println(n1+" ^ "+n2+" = "+res);
				break;

			case 6:
				res=c1.sqrt();
				System.out.println("Square root of "+n1+" : "+res);
				break;


			case 7:
				res=c1.mod(c2);
				System.out.println(n1+" % "+n2+" = "+res);
				break;

			default:
				System.out.println("Wrong option!!");
				break;
		}
	}
}
