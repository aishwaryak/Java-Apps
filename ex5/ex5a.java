import java.io.*;
import java.util.*;

class InvalidYearException extends Exception
{
	public String toString()
	{
		return "Invalid year!!Enter a year > 2000";
	}	
}

class InvalidActorException extends Exception
{
	public String toString()
	{
		return "Invalid actor name!!";
	}	
}

class movie
{
	String movie_name,director_name;
	String []actor_name = new String[10];
	String []actress_name = new String[10];
	int year_of_release,no_of_days;
	int n1,n2;

	void getdata() throws IOException
	{
		DataInputStream d =new DataInputStream(System.in);
		System.out.print("\nEnter the movie name : ");
		movie_name = d.readLine();
		int j;
		System.out.println("\nEnter the no. of actors and actresses : ");
		n1=Integer.parseInt(d.readLine());
		n2=Integer.parseInt(d.readLine());
			
		for(j=0;j<n1;j++)
		{
			System.out.print("\nEnter the actor's name : ");
			actor_name[j] = d.readLine();
		}
			
		for(j=0;j<n2;j++)
		{
			System.out.print("\nEnter the actress's name : ");
			actress_name[j] = d.readLine();
		}
			
		System.out.print("\nEnter the director's name : ");
		director_name = d.readLine();
			
		System.out.print("\nEnter the year of release : ");
		year_of_release = Integer.parseInt(d.readLine());
			
		System.out.print("\nEnter the no. of days the movie ran : ");
		no_of_days = Integer.parseInt(d.readLine());
			
	}

	void display()
	{
		System.out.println("\n\nMovie name\t\t\tActors\t\tActresses\t\tDirector\tYear of release\tNo. of days\n");
		System.out.print("\n"+movie_name+"\t\t");
		for(int i=0;i<n1;i++)
			System.out.print("\t"+actor_name[i]);
		for(int i=0;i<2-n1;i++)
			System.out.printf("\t-\t");
		for(int i=0;i<n2;i++)
			System.out.print("\t"+actress_name[i]);
		for(int i=0;i<2-n2;i++)
			System.out.printf("\t-\t");
		System.out.print("\t"+director_name+"\t\t"+year_of_release+"\t\t"+no_of_days+"\n");
	}
}

class ex5a
{
	public static void main(String args[])throws IOException
	{
		
		DataInputStream d = new DataInputStream(System.in);
		movie []m = new movie[10];
		int i,j;

		System.out.print("\nEnter the number of movies : ");
		int n = Integer.parseInt(d.readLine());

		for(i=0;i<n;i++)
		{
			m[i] = new movie();
			m[i].getdata();
		}

		while(true)
		{
			System.out.println("\n\n\t\tMENU :");
			System.out.println("\n1.List of movies released in a particular year\n2.List of movies of a particular actor\n3.Movie Details\n4.Exit\n");
			System.out.print("\nEnter your choice : ");
			int choice = Integer.parseInt(d.readLine());
			
			switch(choice)
			{
				case 1:
					try
					{
						System.out.print("\nEnter the year : ");
						int year = Integer.parseInt(d.readLine());
						if(year < 2000)
						{
							InvalidYearException invyear = new InvalidYearException();
							throw invyear;
						}
						else
						{
							int count = 0;
							for(i=0;i<n;i++)
							{
								if(m[i].year_of_release == year)
								{
									System.out.println(m[i].movie_name);
									count++;
								}
							}
							if(count==0)
								System.out.println("\nNo movies released in the year "+year+" !!");
									 
						}
					}
					catch(InvalidYearException e)
					{
						System.out.println(e);
					}
					break;
				
				case 2:
					try
					{
						System.out.print("\nEnter the actor's name : ");
						String actor = d.readLine();
						if(actor.equals("x"))
						{
							InvalidActorException invactor = new InvalidActorException();
							throw invactor;
						}
						else
						{
							int count = 0;
							for(i=0;i<n;i++)
							{
								for(j=0;j<m[i].n1;j++)
								{
									if(actor.equals(m[i].actor_name[j]))
										System.out.println(m[i].movie_name);
									count++;
								}
							}
							if(count==0)
								System.out.println("\nNo movies available for the actor "+actor+" !!");
									 
						}
					}
					catch(InvalidActorException e)
					{
						System.out.println(e);
					}
					break;
				
				case 3:
					for(i=0;i<n;i++)
						m[i].display();
					break;
		
				case 4:
					System.out.println("\nProgram terminating !! ");
					System.exit(0);
					break;
			}//switch
		}//while
	}//main
}

