package StackPackage;

public class StackADT
{
	public int top_of_stack = -1;
	char []array = new char[20];

	public void push(char c)
	{
		top_of_stack++;
		array[top_of_stack] = c;					
	}

	public char pop()
	{
		char ch = array[top_of_stack];
		top_of_stack--;
		return ch;
	}
}//class

