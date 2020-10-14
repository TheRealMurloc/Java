package nai.zad1;

import java.util.ArrayList;

public class Iris 
{
	ArrayList<Double> features = new ArrayList<Double>();
	String nazwa;

	public Iris(String nazwa, ArrayList<Double> features) 
	{
		this.features = features;
		this.nazwa = nazwa;
	}
	
	public Iris(ArrayList<Double> features) 
	{
		this.features = features;
		this.nazwa = null;
	}
	
	public double roznicaOdleglosci(Iris x)
	{
		double wynik = 0;
		for(int i = 0; i < features.size(); i++)
		{
			wynik += Math.pow(this.features.get(i) - x.features.get(i), 2);
		}
		return Math.sqrt(wynik);
	}
	
	@Override
	public String toString()
	{
		return "Nazwa " + nazwa + " Atrybuty: " + features;
	}
}
