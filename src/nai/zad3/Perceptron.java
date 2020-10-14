package nai.zad3;

import java.util.ArrayList;

public class Perceptron 
{
	String lang;
	ArrayList<Double> weights = new ArrayList<Double>();
	float theta;
	double net;
	double y;
	
	public Perceptron(ArrayList<Double> weights, float theta, String lang)
	{
		this.weights = weights;
		this.theta = theta;
		this.lang = lang;
	}
	
	public double calculateY(double[] input)
	{
		double output = 0;
		for(int i = 0; i < input.length; i++)
		{
			output += input[i] * weights.get(i);
		}
		output -= theta;
		net = output;
		return unipolarFunction();
	}
	
	public double unipolarFunction()
	{
		double function = 1/(1+Math.pow(Math.E, -net));
		this.y = function;
		return function;
	}
	
	public void training(double[] tab, String lang, float n)
	{
		double err = calculateErrors(lang);
		ArrayList<Double> newWeights = new ArrayList<Double>();
		for(int i = 0; i < weights.size(); i++)
		{
			newWeights.add((weights.get(i)+(n * err * tab[i])));
		}
		this.weights = newWeights;
		this.y = calculateY(tab);
	}
	
	public double calculateErrors(String lang)
	{
		int d;
		if(this.lang.equals(lang))
		{
			d = 1;
		}
		else
		{
			d = 0;
		}
		double err = (d-y)*y*(1-y);
		return err;
	}
}
