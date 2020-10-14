package nai.zad3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CzytaniePlikow 
{
	String path;
	String lang;
	String text;
	
	public CzytaniePlikow(String path, String lang)
	{
		this.path = path;
		this.lang = lang;
	}
	
	public CzytaniePlikow(String text)
	{
		this.text = text;
	}
	
	public double[] check()
	{
		double[] input = new double[26];
		for(int i = 0; i < text.length(); i++)
		{
			if(text.charAt(i) < 123 && text.charAt(i) > 96)
			{
				input[(text.charAt(i)-97)]++;
			}
			else
			{
				if(text.charAt(i) < 91 && text.charAt(i) > 64)
				{
					input[(text.charAt(i)-65)]++;
				}
			}
		}
		double vector = 0.0;
		for(int i = 0; i < input.length; i++)
		{
			vector += Math.pow(input[i], 2);
		}
		vector = Math.pow(vector, 0.5);
		for(int i = 0; i < input.length; i++)
		{
			input[i] = input[i]/vector;
		}
		return input;
	}
	
	public double[] count()
	{
		double[] input = new double[26];
        String line;
        int counter = 0;
		try(BufferedReader br = new BufferedReader(new FileReader(path)))
		{
			while((line = br.readLine()) != null)
			{
				for(int i = 0; i < line.length(); i++)
				{
					if(line.charAt(i) < 123 && line.charAt(i) > 96)
					{
						counter++;
						input[(line.charAt(i)-97)]++;
					}
					else
					{
						if(line.charAt(i) < 91 && line.charAt(i) > 64)
						{
							counter++;
							input[(line.charAt(i)-65)]++;
						}
					}
				}
			}
				
		} catch (IOException e) 
		{
			e.printStackTrace();
		}
		for(int i = 0; i < input.length; i++)
		{
			input[i] = input[i]/counter;
		}
		return input;
	}
}
