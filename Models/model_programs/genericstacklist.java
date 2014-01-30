import java.io.*;
import java.io.InputStreamReader;

public class node
{
	T ele;
	node next;
}

public class Stack<T> 
{

	private node N;
	private node top;
	int n;

	public Stack()
	{
		top=null;
		n=0;
	}
	public boolean isEmpty()
	{
		if(top==null) return true;
		else return false;
	}
	public T peek()
	{
		return node.ele;
	}
	public void push(T t)
	{
		node prevtop=top;
		top=new node();
		top.T=t;
		top.next=prevtop;
		n++;
	}
	public T pop()
	{
		
		T ret=top.ele;
		top=top.next;
		n--;
		return ret;
	}
	public void disp()
	{
		while(true)
		{
			if(top==null)
			break;
			System.out.println("_______________");
			System.out.println("|	top.ele	  |");
			top=top.next;
		}
	}
} 
public class genericstacklist
{

	public void menu()
	{
		System.out.println("\n *********MENU********\n1.Push\n2.Pop\n3.Display");
	}
	
	public static void main(String arg[])
	{
		DataInputStream d=new DataInputStream(System.in);
		int ch,i,j,k=0,choice;
		String a,b,c;
		char x,y,z='a';
		float m,n,l=4.5;
		System.out.println("\nMENU 1.Integer 2.char 3.string 4.float");
		ch=Integer.parseInt(d.readLine());
		switch(ch)
		{
		
			case 1:Stack<int> s=new Stack<int>();
			       menu();
				choice=Integer.ParseInt(d.readLine());
				switch(choice)
				{
					case 1:s.push(k++);
						break;
					case 2:i=s.pop();
						break;
					case 3:s.disp();
						break;
				}
			case 2:Stack<char> s=new Stack<char>();
			       menu();
				choice=Integer.ParseInt(d.readLine());
				switch(choice)
				{
					case 1:s.push(a++);
						break;
					case 2:y=s.pop();
						break;
					case 3:s.disp();
						break;
				}
			case 3:Stack<String> s=new Stack<String>();
			       menu();
				choice=Integer.ParseInt(d.readLine());
				switch(choice)
				{
					case 1:s.push("hahea");
						break;
					case 2:b=s.pop();
						break;
					case 3:s.disp();
						break;
				}
			case 4:Stack<float> s=new Stack<float>();
			       menu();
				choice=Integer.ParseInt(d.readLine());
				switch(choice)
				{
					case 1:s.push(l++);
						break;
					case 2:m=s.pop();
						break;
					case 3:s.disp();
						break;
				}
		}
	}
}
	