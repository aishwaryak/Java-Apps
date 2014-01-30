import java.io.*;
import java.util.Random;

class random
{
	public static void main(String []args)
	{
		Random r = new Random();

		int i = r.nextInt(10);
		float f = r.nextInt(1000) * 0.02F;
		float fl = r.nextFloat() * 100F;
		System.out.println(i+"\t"+f+"\t"+fl+"\n");
	}//main
}
