package utp.zad02;

import java.util.ArrayList;

public class ShoppingCart 
{
	static ShoppingCart sc = new ShoppingCart();
	static ArrayList<Kwiat> koszyk = new ArrayList<Kwiat>();
	
	public String toString()
	{
		if(koszyk.size()==0)
		{
			return "-- Pusto";
		}
		String wKoszyku = "W koszyku \n";
		for(int i = 0; i < koszyk.size(); i++)
		{
			wKoszyku+=koszyk.get(i).toString();
		}
		return wKoszyku;
	}
	
	
	
	
	
	
	
}
