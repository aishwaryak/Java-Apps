class numbers
{
	int a,b;
	
	void get(int x,int y)
	{
		a=x;
		b=y;
	}
	
	void add()
	{
		int c=a+b;
		System.out.println("Sum of " +a+" and "+b+ " is : "+c);
	}
}

class sum
{
	public static void main(String args[])
	{
		numbers num = new numbers();
		num.get(10,15);
		num.add();
	}
}
