class classeg
{
	public static void main(String args[])
	{
		classeg cobj = new classeg();
		Class c = cobj.getClass();
		System.out.println(c.getName());
		System.out.println("\n\n");

		System.out.println(cobj.getClass());		
		System.out.println("\n\n");

		System.out.println(cobj.getClass().getName());
		System.out.println("\n\n");

		System.out.println(c);
		System.out.println("\n\n");

		System.out.println(c.getSuperclass());
		System.out.println("\n\n");

		System.out.println(c.getSuperclass().getClass());
		System.out.println("\n\n");
	}
}
