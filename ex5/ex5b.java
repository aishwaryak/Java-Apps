import java.io.*;
import java.util.*;

class StackOverflowException extends Exception
{
	public String toString()
	{
		return "Stack Overflow Exception!!  Stack is full!!";
	}	
}

class StackUnderflowException extends Exception
{
	public String toString()
	{
		return "Stack Underflow Exception!!  Stack is empty!!";
	}	
}

interface StackADT
{
	void create() throws IOException;
	void push(String s);
	String pop();
	boolean isEmpty();
	boolean isFull();
	void display();
	String peek();
}

class StackArray implements StackADT
{
	int i,no;

	int top_of_stack;
	String []elements = new String[10];

	public void create() throws IOException 
	{
		top_of_stack =-1;
		DataInputStream d = new DataInputStream(System.in);
		System.out.print("\nEnter the no. of elements : ");
		no = Integer.parseInt(d.readLine());
		System.out.println("\nEnter the elements :");
		for(i=0;i<no;i++)
			push(d.readLine());

	}
	
	public void push(String s)
	{
		elements[++top_of_stack]=s;
	}
	
	public String pop()
	{
		return elements[top_of_stack--];
	}
	
	public boolean isEmpty()
	{
		if(top_of_stack == -1)
			return true;
		else 
			return false;
	}

	public boolean isFull()
	{
		if(top_of_stack == 9)
			return true;
		else 
			return false;
	}

	public void display()
	{
		System.out.println("\nSTACK:\n");
		System.out.print("-->");
		for(i=top_of_stack;i>=0;i--)
			System.out.print("\t|"+elements[i]+"|\n");
		System.out.println("\t---\n");
	}

	public String peek()
	{
		return elements[top_of_stack];
	}
}

class StackLinkedList implements StackADT
{
	int i,n;	

	int top_of_stack;
	String element;
	StackLinkedList next;

	public void create() throws IOException 
	{
		top_of_stack = -1;
		next = null;

		DataInputStream d = new DataInputStream(System.in);
		System.out.print("Enter the no. of elements : ");
		n = Integer.parseInt(d.readLine());
		System.out.println("\nEnter the elements :");
		for(i=0;i<n;i++)
			push(d.readLine());
	}
	
	public void push(String s)
	{
		top_of_stack++;
		StackLinkedList ptr = this;

		StackLinkedList tmp = new StackLinkedList();
		tmp.element = s;
		tmp.next = ptr.next;
		ptr.next = tmp;	
	}
	
	public String pop()
	{
		StackLinkedList ptr = this;
		String str = this.next.element;
		this.next = this.next.next;
		top_of_stack--;
		return str;
	}
	
	public boolean isEmpty()
	{
		if(top_of_stack == -1)
			return true;
		else 
			return false;
	}

	public boolean isFull()
	{
		if(top_of_stack == 9)
			return true;
		else 
			return false;
	}

	public void display()
	{
		System.out.println("\nSTACK:\n");
		StackLinkedList ptr = this;
		System.out.print("-->");
		while(ptr.next !=null)
		{
			ptr = ptr.next;
			System.out.print("\t|"+ptr.element+"|\n");	
		}
		System.out.println("---\n");
	}

	public String peek()
	{
		StackLinkedList ptr = this;
		return ptr.next.element;
	}
	
}

class ex5b
{
	public static void main(String args[]) throws IOException
	{
		DataInputStream d = new DataInputStream(System.in);
		StackADT arr=null;
		while(true)
		{
			System.out.println("\n\n\nMENU :");
			System.out.println("1.Stack as array\n2.Stack as linked list\n3.Exit\n");
			System.out.print("Enter your choice:");
			int choice = Integer.parseInt(d.readLine());
			int ch = 0;			
			
			
			switch(choice)
			{
				case 1:
					arr = new StackArray();
					break;

				case 2:
					arr = new StackLinkedList();					
					break;
	
				case 3:
					System.out.println("\nProgram terminating!!");
					System.exit(0);
					break;
			}//switch
			
			a:
			{
				do
				{
					System.out.println("\n\nOPTIONS :");
					System.out.println("1.Create a stack\n2.Push\n3.Pop\n4.Display\n5.Peek\n6.Go to main menu\n7.Exit\n");
					System.out.print("Enter your choice:");
					ch = Integer.parseInt(d.readLine());	
					
					switch(ch)
					{
						case 1:
							arr.create();
							arr.display();
							break;
					
						case 2:
							try
							{
								if(arr.isFull())
									throw new StackOverflowException();
								else
								{
									System.out.print("\nEnter the element you want to push onto the stack:");
									String str = d.readLine();
									arr.push(str);
									arr.display();
								}
							}
							catch(StackOverflowException e)
							{
								System.out.println(e);
							}
							break;
	
						case 3:
							try
							{
								if(arr.isEmpty())
									throw new StackUnderflowException();
								else
								{
									String str = arr.pop();
									System.out.println("\nElement popped out is : "+str);
									arr.display();
								}
							}
							catch(StackUnderflowException e)
							{
								System.out.println(e);
							}
							break;

						case 4:
							try
							{
								if(arr.isEmpty())
									throw new StackUnderflowException();
								else	
									arr.display();
							}
							catch(StackUnderflowException e)
							{
								System.out.println(e);
							}
							break;
	
						case 5:
							try
							{
								if(arr.isEmpty())
									throw new StackUnderflowException();
								else
								{
									String str = arr.peek();
									System.out.println("\nTop of the stack is : "+str);
									arr.display();
								}
							}
							catch(StackUnderflowException e)
							{
								System.out.println(e);
							}
							break;
	
						case 6:
							break a;
	
						case 7:
							System.out.println("\nProgram terminating!!");
							System.exit(0);
					}//switch
				}while(ch != 7);
			}//a
		}//while
	}//main				
}//class

