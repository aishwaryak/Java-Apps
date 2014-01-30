import java.io.*;
import java.lang.Math.*;

class cosine
{
	public static void main(String [] args)
	{
		double res;
		res = Math.cos(60);
		System.out.println("Res : "+res);

		String s = "e-2";

		String [] a = s.split("-");

		for(int i=0;i<a.length;i++)
			System.out.println(a[i]);
	}
} 
