import java.util.*;
import java.io.*;

class ex4a
{
	public static void main(String args[]) throws IOException
	{
		DataInputStream d = new DataInputStream(System.in);
		ArrayList a1 = new ArrayList();
		
		System.out.println("\nCreating the arraylist...");
		a1.add("algorithms");
		a1.add("pseudo-codes");
		a1.add("flow-charts");
		a1.add("programs");
		a1.add("code");
		a1.add("assembling");

		System.out.print("\nSize of the arraylist : "+a1.size());
		System.out.println("\nArray list:\t"+a1);

		while(true)
		{
			System.out.println("\n\n\n\t\tMENU :");
			System.out.println("\n1.Append\n2.Insert at a particular index\n3.Delete\n4.Replace\n5.Search\n6.Index of\n7.List of all strings starting with \'a\'\n8.Append the contents of another list at the end of the first\n9.Exit");
			System.out.print("\n\nEnter your choice : ");
			int choice = Integer.parseInt(d.readLine());
			
			switch(choice)
			{
				case 1:
					System.out.print("\nEnter the string to be appended : ");
					a1.add(d.readLine());
					System.out.println("Array List:\t"+a1);
					break;

				case 2:
					System.out.println("\nEnter the index and the string to be inserted at that position :");
					a1.add(Integer.parseInt(d.readLine()),d.readLine());
					System.out.println("Array List:\t"+a1);
					break;
	
				case 3:
					System.out.print("\nEnter the string to be deleted : ");
					a1.remove(d.readLine());
					System.out.println("Array List:\t"+a1);
					break;
	
				case 4:
					System.out.print("\nEnter the index and the new string that is to be placed in that position : ");
					a1.set(Integer.parseInt(d.readLine()),d.readLine());
					System.out.println("Array List:\t"+a1);
					break;

				case 5:
					System.out.print("\nEnter the element :");
					boolean r = a1.contains(d.readLine());
					if(r)
						System.out.println("Element found!!");
					else
						System.out.println("Element not found in the list!!");
					break;

				case 6:
					System.out.print("\nEnter the element for which the index is to be found : ");	
					System.out.println("\nIndex : "+a1.indexOf(d.readLine()));
					System.out.println("Array List:\t"+a1);
					break;

				case 7:
					String str;
					for(int i=0;i<a1.size();i++)
					{
						str = (String)a1.get(i);
						if(str.startsWith("a"))
							System.out.println("\n\t"+str);
					}					
					break;
			
				case 8:
					ArrayList a2 = new ArrayList();
					a2.add("C");
					a2.add("C++");
					a2.add("Java");
					a1.addAll(a2);
					System.out.println("Array List:\t"+a1);
					break;

				case 9:
					System.out.println("\nProgram terminating!!");
					System.exit(0);
			}//switch
		}//while
	}//main
}

