package nai.zad2;

import java.util.ArrayList;

public class Vector 
{
	ArrayList<Float> features = new ArrayList<Float>();
	String name;
	int nameInt;
	
	public Vector(String name, ArrayList<Float> features) 
	{
		if(name.equals("Iris-setosa"))
			this.nameInt = 0;
		else
			this.nameInt = 1;
		this.name = name;
		this.features = features;
	}
	
	public Vector(float theta, ArrayList<Float> weights, ArrayList<Float> features)
	{
		this.features = features;
		this.nameInt = this.wartoscY(theta, weights);
		if(this.nameInt == 0)
			this.name = "Iris-setosa";
		else
			this.name = "Iris-versicolor";
	}
	
	public int wartoscY(float theta, ArrayList<Float> weights)
	{
		float wynik = 0;
		for(int i = 0; i < features.size(); i++)
		{
			wynik += features.get(i) * weights.get(i);
		}
		wynik -= theta;
		if(wynik >= 0)
			return 1;
		else
			return 0;
	}
	
	public ArrayList<Float> updateWeights(int y, float n, ArrayList<Float> weights)
	{
		ArrayList<Float> neWeights = new ArrayList<Float>();
		float weight = 0;
		for(int i = 0; i < weights.size(); i++)
		{
			weight = weights.get(i);
			weight = weight + (n * (this.nameInt - y) * features.get(i));
			neWeights.add(weight);
		}
		return neWeights;
	}
	
	public float updateTheta(int y, float theta, float n)
	{
		theta = theta - (n * (this.nameInt - y));
		return theta;
	}
	
	
	
	
	@Override
	public String toString()
	{
		return "Nazwa " + name + " Liczba " + nameInt + " Atrybuty: " + features;
	}

}
