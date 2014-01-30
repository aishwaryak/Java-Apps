import java.io.*;

class Rupee implements Serializable 
{
	float rValue;

	Rupee(float val)
	{
		rValue  = val;		
	}
	
	float getRupee()
	{
		return rValue;
	}
	
	float convertToDollar()
	{
		return rValue/50;
	}
}

class Dollar implements Serializable
{
	float dValue;

	Dollar(float val)
	{
		dValue = val;
	}
		
	float getDollar()
	{
		return dValue;
	}

	float convertToRupee()
	{
		return dValue*50;
	}
}

class CurrencyConvert
{
	public static void main(String []args)throws IOException
	{
		DataInputStream d = new DataInputStream(System.in);

		File f1 = new File("Rupee.txt");
		File f2 = new File("Dollar.txt");

		FileInputStream fin1 = new FileInputStream("Currency.txt");
		ObjectInputStream in1 = new ObjectInputStream(fin1);
		
		FileOutputStream fout2 = new FileOutputStream(f1);
		ObjectOutputStream out2 = new ObjectOutputStream(fout2);
		FileOutputStream fout3 = new FileOutputStream(f2);
		ObjectOutputStream out3 = new ObjectOutputStream(fout3);

		FileInputStream fin2 = new FileInputStream("Rupee.txt");
		ObjectInputStream in2 = new ObjectInputStream(fin2);
		FileInputStream fin3 = new FileInputStream("Dollar.txt");
		ObjectInputStream in3 = new ObjectInputStream(fin3);
		
		Object obj = new Object();

		Rupee r;
		Dollar dol;

		boolean val =true;
		System.out.println("\nContents of file \"Currency.txt\":");
		while(val)
		{
			try
			{
				obj =(Object)in1.readObject();
				if(obj instanceof Rupee)
				{
					r = (Rupee)obj;
					out2.writeObject(r);
					System.out.print("Rupee :");
					System.out.println(r.getRupee());
					dol = new Dollar(r.convertToDollar());
					out3.writeObject(dol);
				}
				else if(obj instanceof Dollar)
				{
					dol = (Dollar)obj;
					out3.writeObject(dol);
					System.out.print("Dollar :");
					System.out.println(dol.getDollar());
					r = new Rupee(dol.convertToRupee());
					out2.writeObject(r);
				}
			}//try
			catch(ClassNotFoundException e)
			{
				System.out.println(e);
				val = false;
			}
			catch(IOException e)
			{
				System.out.println("\nEnd of file");
				val = false;
			}
		}//while

		val = true;
		System.out.println("\nContents of file \"Rupee.txt\":");
		
		while(val)
		{
			try
			{
				r = (Rupee)in2.readObject();
				System.out.println(r.getRupee());
			}//try
			catch(ClassNotFoundException e)
			{
				System.out.println(e);
				val = false;
			}
			catch(IOException e)
			{
				System.out.println("\nEnd of file");
				val = false;
			}
		}//while

		val = true;
		System.out.println("\nContents of file \"Dollar.txt\":");
		
		while(val)
		{
			try
			{
				dol = (Dollar)in3.readObject();
				System.out.println(dol.getDollar());
			}//try
			catch(ClassNotFoundException e)
			{
				System.out.println(e);
				val = false;
			}
			catch(IOException e)
			{
				System.out.println("\nEnd of file");
				val = false;
			}
		}//while
	}//main
}//class

