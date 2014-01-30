class calc
{
	public static void main(String args[])
	{
		int opt=Integer.parseInt(args[0]);
		int a=Integer.parseInt(args[1]);
		int b=Integer.parseInt(args[2]);

		float c=Float.parseFloat(args[1]);
		float d=Float.parseFloat(args[2]);

		System.out.println("The numbers are: " +a +" and " +b);
		System.out.println("Option: " +opt);

		switch(opt)
		{
			case 1:
				System.out.println("Sum : " +(a+b));
				break;
			
			case 2:
				System.out.println("Difference : " +(a-b));
				break;

			case 3:
				System.out.println("Product : " +(a*b));
				break;

			case 4:
				System.out.println(a+"/" +b +":" +(c/d));
				break;

			case 5:
				double power=java.lang.Math.pow(a,b);
				System.out.println(a+ "^" +b +":" +power);
				break;

			default:
				System.out.println("Wrong Option!!");
				break;
		}
	}
}
