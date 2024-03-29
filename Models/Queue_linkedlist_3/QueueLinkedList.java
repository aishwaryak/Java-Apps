import java.io.*;

interface QueueADT
{
	public void enqueue(String s);
	public String dequeue();
	public void display();
}

class QueueLinkedList implements QueueADT
{
	String element;
	int front=-1,rear=-1;
	QueueLinkedList next,ptr;

	public void enqueue(String s)
	{
		ptr = this;
		while(ptr.next != null)
			ptr = ptr.next;
		QueueLinkedList tmp = new QueueLinkedList();
		tmp.element = s;
		tmp.next = ptr.next;
		ptr.next = tmp;
		if(front == -1)
			front++;
		rear++;
	}

	public String dequeue()
	{
		ptr = this;
		String s = this.next.element;
		this.next = this.next.next;
		front++;
		return s;
	}

	public void display()
	{
		ptr = this;
		while(ptr.next != null)
		{
			ptr = ptr.next;
			System.out.println(ptr.element);
		}
	}

	public static void main(String []args) throws IOException
	{
		QueueLinkedList q = new QueueLinkedList();
		DataInputStream d = new DataInputStream(System.in);

		while(true)
		{
			System.out.print("\nMENU :\n1.Enqueue\n2.Dequeue\n3.Display\n4.Exit\nEnter your choice : ");
			int ch = Integer.parseInt(d.readLine());
			
			switch(ch)
			{
				case 1:
					System.out.print("\nEnter the element : ");
					q.enqueue(d.readLine());
					break;

				case 2:
					if((q.front == - 1 && q.rear == -1) || (q.front == q.rear + 1))
						System.out.println("\nQueue is empty\n");
					else
					{
						String str = q.dequeue();
						System.out.println("\nElement de-queued : "+str);
					}
					break;

				case 3:
					if((q.front == - 1 && q.rear == -1) || (q.front == q.rear + 1))
						System.out.println("\nQueue is empty\n");
					else
						q.display();
					break;

				case 4:
					System.out.println("\nProgram terminating!!\n");
					System.exit(0);				
			}//switch
		}//while		
	}//main
}//class

