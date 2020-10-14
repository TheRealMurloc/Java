package utp.zad02;

public abstract class Kwiat 
{	
	String nazwa;
	String kolor;
	int ilosc;
	public Kwiat (String nazwa, String kolor,int ilosc) 
	{
		this.nazwa = nazwa;
		this.kolor = kolor;
		this.ilosc = ilosc;
	}
	
	public String toString()
	{
		double cena = -1.0;
		PriceList pl = PriceList.getInstance();
		if(pl.hm.containsKey(nazwa))
		{
			cena = pl.hm.get(nazwa);
		}
		
		return nazwa + ", Kolor: " + kolor + " ilosc: " + ilosc + " cena: " + cena +"\n";
	}
}
