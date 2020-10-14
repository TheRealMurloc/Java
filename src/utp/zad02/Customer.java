package utp.zad02;


public class Customer 
{
	String imie;
	double gotowka;
	
	public Customer (String imie, int gotowka)
	{
		this.imie = imie;
		this.gotowka = gotowka;
	}
	
	public double getCash()
	{
		return gotowka;
	}
	public String getImie()
	{
		return imie;
	}
	public void get(Kwiat kwiat)
	{
		ShoppingCart.koszyk.add(kwiat);
	}
	
	public ShoppingCart getShoppingCart()
	{
		return ShoppingCart.sc;
	}
	
	public void pay()
	{
		for(int i = 0; i < ShoppingCart.koszyk.size(); i++)
		{
			PriceList pl = PriceList.getInstance();
			if(!pl.hm.containsKey(ShoppingCart.koszyk.get(i).nazwa))
			{
				ShoppingCart.koszyk.remove(i);
				i--;
			}
			else
			{
				if((pl.hm.get(ShoppingCart.koszyk.get(i).nazwa) * ShoppingCart.koszyk.get(i).ilosc)>gotowka)
				{
					ShoppingCart.koszyk.remove(i);
					i--;
				}
				else
				{
					gotowka -= pl.hm.get(ShoppingCart.koszyk.get(i).nazwa) * ShoppingCart.koszyk.get(i).ilosc;
				}
			}
		}
	}
	
	public void pack(Box box)
	{
		while(ShoppingCart.koszyk.size()!=0)
		{
			Box.pudelko.add(ShoppingCart.koszyk.get(0));
			ShoppingCart.koszyk.remove(0);
		}
	}
	

	
}
