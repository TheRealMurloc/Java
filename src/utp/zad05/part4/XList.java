package utp.zad05.part4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class XList <T>
{
	List list = new ArrayList<>();
	
	public XList(T arg0, T...args)
	{
		for(T i : args)
		{
			this.list.add(i);
		}
	}
	
	public XList(T[] tab)
	{
		for(int i = 0; i < tab.length; i++)
		{
			this.list.add(tab[i]);
		}
	}
	
	static public XList of(int arg0, int...args)
	{
		return new XList<>(arg0, args);
	}
	
	static public XList of(Integer [] tab)
	{
		return new XList<>(tab);
	}
	
	static public XList charsOf(String str)
	{
		char[] tab = str.toCharArray();
		return new XList<>(tab);
	}
	
	static public XList tokensOf(String str)
	{
		String[] tab = str.split(" ");
		return new XList<>(tab);
	}
	
	static public XList tokensOf(String str, String reg)
	{
		String[] tab = str.split(reg);
		return new XList<>(tab);
	}
	
	public XList union(T kol)
	{
		this.list.addAll((Collection) kol);
		return new XList<>(this.list);
	}
	
	public List union(XList l)
	{
		this.list.addAll(l.list);
		return this.list;
	}
	
	public XList union(Collection kol)
	{
		this.list.addAll(kol);
		return new XList<>(this);
	}
	
	public XList<XList<T>> union(Integer [] tab)
	{
		for(int i : tab)
		{
			this.list.add(i);
		}	
		return new XList<>(this);
	}
	
	public String toString()
	{
		return list.toString();
	}
	
	
	
}
