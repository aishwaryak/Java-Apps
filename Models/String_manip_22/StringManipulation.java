import java.io.*;
import java.util.*;

class StringManipulation
{
	public static void main(String []args) throws IOException
	{
		DataInputStream d = new DataInputStream(System.in);
		String str1,str2;
		int i,j,k=0,flag=0;

		while(true)
		{
			System.out.print("\nMENU :\n1.Length of a string\n2.Concatenate two strings\n3.Compare two strings\n4.Search for a substring in a string\n5.Exit\nEnter your choice : ");
			int ch = Integer.parseInt(d.readLine());

			switch(ch)
			{
				case 1:
					System.out.print("\nEnter the string : ");
					str1 = d.readLine();
					char []array = str1.toCharArray();
					System.out.println("Length : "+ array.length);
					break;
				
				case 2:
					System.out.print("\nEnter the first string : ");
					str1 = d.readLine();
					System.out.print("\nEnter the second string : ");
					str2 = d.readLine();
					char []a1 = str1.toCharArray();
					char []a2 = str2.toCharArray();
					char []a3 = new char[40];

					for(i=0;i<a1.length;i++)
						a3[i] = a1[i];

					for(j=a1.length;j<(a1.length+a2.length);j++)
						a3[j] = a2[k++];

					String str3 = new String(a3);
					System.out.println("\nString after concatenation : "+str3);
					break;

				case 3:
					System.out.print("\nEnter the first string : ");
					str1 = d.readLine();
					System.out.print("\nEnter the second string : ");
					str2 = d.readLine();
					a1 = str1.toCharArray();
					a2 = str2.toCharArray();
				
					if(a1.length != a2.length)
						System.out.println("\nUnequal strings!!");
					else
					{
						flag = 0;
						for(i=0;i<a1.length;i++)
						{
							if(a1[i] != a2[i])
							{
								flag = 1;
								break;
							}
						}
						if(flag == 1)
							System.out.println("\nUnequal strings!!");
						else
							System.out.println("\nEqual strings!!\n");
					}
					break;
			
				case 4:
					System.out.print("\nEnter the string : ");
					str1 = d.readLine();
					System.out.print("\nEnter the sub-string : ");
					str2 = d.readLine();
					a1 = str1.toCharArray();
					a2 = str2.toCharArray();
					
					int f = 0;
					flag = 0;
					i = 0;
					a:
					while(i<a1.length)
					{
						if(a1[i] == a2[0])
						{
							f = 1;
							i++;
							j=1;
							while(j<a2.length)
							{
								if(a1[i] == a2[j])
								{
									i++;
									j++;
								}
								else
								{
									flag = 1;
									break a;
								}
							}
						}
						else
							i++;
					}
					if(f == 0)
						System.out.println("\nSubstring not found!!\n");
					else
					{
						if(flag == 0)
							System.out.println("\nSubstring found!!\n");
						else 
							System.out.println("\nSubstring not found!!\n");
					}
					break;
			
				case 5:
					System.out.println("\nProgram terminating!!\n");
					System.exit(0);
			}//switch
		}//switch
	}//main
}//class

