import java.io.*;
import java.lang.String.*;
import StackPackage.StackADT;

class balancingParan
{
	public static void main(String []args) throws IOException
	{
		DataInputStream d = new DataInputStream(System.in);
		StackADT s = new StackADT();

		System.out.print("\nEnter the expression : ");
		String expr = d.readLine();
		char []char_expr = expr.toCharArray();
		System.out.println(char_expr);
		char top;

		for(int i=0;i < expr.length();i++)
		{
			switch(char_expr[i])
			{
				case '(':
				case '{':
				case '[':
					s.push(char_expr[i]);
					break;

				case ')':
					top = s.pop();
					if(top != '(')
					{
						System.out.println("\nUnbalanced paranthesis\n");
						System.exit(0);
					}
					break;

				case '}':
					top = s.pop();
					if(top != '{')
					{
						System.out.println("\nUnbalanced paranthesis\n");
						System.exit(0);
					}
					break;

				case ']':
					top = s.pop();
					if(top != '[')
					{
						System.out.println("\nUnbalanced paranthesis\n");
						System.exit(0);
					}
					break;			
			}//switch
		}//for
		if(s.top_of_stack == -1)
			System.out.println("\nBalanced expression\n");
		else
			System.out.println("\nUnbalanced paranthesis\n");
	}//main
}//class

