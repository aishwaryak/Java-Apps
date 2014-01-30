import myjava.lisplist.Lisp;
import java.io.*;
import java.util.*;

class ex4b
{
	public static void main(String args[]) throws IOException
	{
		DataInputStream d = new DataInputStream(System.in);
		Lisp l = new Lisp();
		
		while(true)
		{
			System.out.println("\n\n\t\tMENU :");
			System.out.println("\n1.Create an ArrayList (insert a new element into the list)\n2.Display the list\n3.First element    (car)\n4.Remaining elements other than the first    (cdr)\n5.Add data as first element in the list   (cons)\n6.No. of elements in the list\n7.Returns the remaining elements except the first \'n\' elements    (nthcdr)\n8.Replace the first element    (setcar)\n9.Add list    (setcdr)\n10.nth element of a list    (nthlist)\n11.First and last element of the list\n12.cadr()\n13.Exit\n");
			System.out.print("Enter your choice : ");
			int choice = Integer.parseInt(d.readLine());
			int i;

			switch(choice)
			{
				case 1:
					System.out.print("\nEnter the element to be inserted : ");
					l.create(Integer.parseInt(d.readLine()));
					break;

				case 2:
					System.out.println("\nList :");		
					l.displist();
					break;

				case 3:
					System.out.println("\nFirst element : ["+l.car()+"]");
					break;

				case 4:
					ArrayList a1 = new ArrayList();
					a1 = l.cdr();
					System.out.println(a1);
					break;
	
				case 5:
					System.out.print("\nEnter the element to be added as the first element : ");
					l.cons(Integer.parseInt(d.readLine()));
					l.displist();
					break;

				case 6:
					System.out.println("\nSize of the list : "+l.length());
					break;

				case 7:
					System.out.print("\nEnter the value of n : ");
					a1 = l.nthcdr(Integer.parseInt(d.readLine()));
					System.out.println(a1);
					break;

				case 8:
					System.out.print("\nEnter the element you want to replace as the first element of the list : ");
					l.setcar(Integer.parseInt(d.readLine()));
					l.displist();
					break;

				case 9:
					ArrayList l1 = new ArrayList();
					System.out.print("\nEnter the number of elements you want to insert in the list : ");
					int n = Integer.parseInt(d.readLine());
					for(i=0;i<n;i++)
					{
						System.out.print("\nEnter the element : ");
						l1.add(Integer.parseInt(d.readLine()));
					}
					System.out.println("\nList:"+l1);
					l.setcdr(l1);
					l.displist();
					break;

				case 10:
					System.out.print("\nEnter the index : ");
					int index = Integer.parseInt(d.readLine());
					n = l.nthlist(index);
					if(index >= l.length())
						System.out.println("NULL");
					else
						System.out.println("\nElement : "+n);
					break;

				case 11:
					a1 = l.first_last();
					System.out.println(a1);
					break;

				case 12:
					a1 = l.cadr();
					System.out.println(a1);
					break;

				case 13:
					System.out.println("\nProgram terminating!!");
					System.exit(0);
					break;
			}//switch
		}//while
	}//main
}

