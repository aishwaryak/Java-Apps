package myjava.lisplist;

import java.util.*;
import java.io.*;

public class Lisp
{
	public ArrayList al = new ArrayList();

	public void create(int e)
	{
		al.add(e);
	}

	public void displist()
	{
		System.out.println(al);
	}

	public int car()
	{
		return (Integer)al.get(0);
	}
	
	public ArrayList cdr()
	{
		ArrayList a1 = new ArrayList();

		for(int i=1;i<al.size();i++)
			a1.add(i-1,al.get(i));
		return a1;
	} 
		
	public void cons(int e)
	{
		al.add(0,e);
	}

	public int length()
	{
		return al.size();
	}

	public ArrayList nthcdr(int n)
	{
		ArrayList a1 = new ArrayList();
		ArrayList a2 = new ArrayList();
		a1 = al;
		a2 = al;
		for(int i=1;i<=n;i++)
		{
			a1 = cdr();
			al = a1;
		}
		al = a2;
		return a1;
	}

	public void setcar(int e)
	{
		al.set(0,e);
	}

	public void setcdr(ArrayList l1)
	{
		for(int i=al.size()-1;i>=1;i--)
			al.remove(al.get(i));
		al.addAll(l1);
	}
		
	public int nthlist(int n)
	{
		return (Integer)al.get(n);
	}

	public ArrayList first_last()
	{
		ArrayList a1 = new ArrayList();
		a1.add(0,al.get(0));
		a1.add(1,al.get(al.size()-1));
		return a1;
	}
	
	public ArrayList cadr()
	{
		ArrayList a1 = new ArrayList();
		ArrayList a2 = new ArrayList();
		a1 = cdr();
		a2.add(0,a1.get(0));
		return a2;
	}
				
}

