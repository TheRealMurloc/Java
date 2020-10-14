package nai.zad1;

public class Para implements Comparable<Para>
{
	String nazwa;
	double odleglosc;
	
	public Para(String nazwa, double odleglosc)
	{
		this.nazwa = nazwa;
		this.odleglosc = odleglosc;
	}
	
	public int compareTo(Para o) 
	{
		double distanceDiff = odleglosc - o.odleglosc;
		if(distanceDiff > 0)
		  return 1;
		if(distanceDiff < 0)
		  return -1;
		else
		  return 0;
	}
	
	@Override
	public String toString()
	{
		return nazwa + " odleglosc " + odleglosc;
	}

}
