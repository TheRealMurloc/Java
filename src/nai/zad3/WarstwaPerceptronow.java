package nai.zad3;

import java.util.ArrayList;

public class WarstwaPerceptronow 
{
	ArrayList<Perceptron> layer = new ArrayList<Perceptron>();
	ArrayList<Double> outputs = new ArrayList<Double>();
	
	
	
	public void tworzeniePerceptrona(String lang)
	{
			ArrayList<Double> weights = new ArrayList<Double>();
			for(int j = 0; j < 26; j++)
			{
				weights.add((double)Math.random());
			}
			layer.add(new Perceptron(weights, (float)0.0, lang));
	}
}
