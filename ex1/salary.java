class employee
{
	float basic,da,hra,pf,lic,sal;
	
	void calculate(String a)
	{
		basic=Float.parseFloat(a);
		da=basic*0.10F;
		hra=basic*0.04F;
		pf=basic*0.05F;
		lic=basic*0.05F;
		sal=basic+da+hra-pf-lic;
	}

	void display()
	{
		System.out.println("Basic: " +basic);
		System.out.println("DA: "+da);
		System.out.println("HRA: "+hra);
		System.out.println("PF: "+pf);
		System.out.println("LIC: "+lic);
		System.out.println("Salary of the employee: "+sal);
	}
}	

class salary
{
	public static void main(String args[])
	{
		employee emp=new employee();
		emp.calculate(args[0]);
		emp.display();
	}
}
