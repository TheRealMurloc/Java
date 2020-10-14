package utp.zad02;

import java.util.HashMap;

public class PriceList 
{
	static PriceList pl = new PriceList();
	HashMap<String, Double> hm = new HashMap<>();
	private PriceList(){}
	
	public static PriceList getInstance()
	{
		return pl;
	}

	public void put(String string, double d) 
	{
		hm.put(string, d);	
	}

	
	
}
