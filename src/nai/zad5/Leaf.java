package nai.zad5;

import java.util.ArrayList;

public class Leaf
{
	char znak;
	int ilosc;
	String bit = "";
	ArrayList<Leaf> under = new ArrayList<Leaf>();
	
	public Leaf(char znak, int ilosc)
	{
		this.znak = znak;
		this.ilosc = ilosc;
	}
	
	public Leaf(int ilosc)
	{
		this.ilosc = ilosc;
		this.znak = '#';
	}
	
	
	public void updateBit(char x)
	{
		for(int i = 0; i < under.size(); i++)
		{
			under.get(i).bit += x;
			under.get(i).updateBit(x);
		}
	}
	
	
	@Override
	public String toString()
	{
		System.out.println("***");
		System.out.println(znak);
		System.out.println(ilosc);
		for(int i = 0; i < under.size(); i++)
		{
			System.out.println(under.get(i));
		}
		for(int i = bit.length()-1; i >= 0; i--)
		{
			System.out.print(bit.charAt(i));
		}
		return "";
	}
	
	
	public String toString2()
	{
		for(int i = 0; i < under.size(); i++)
		{
			System.out.println(under.get(i).znak + ": " + under.get(i).bit);
			under.get(i).toString2();
		}
		return "";
	}
}
