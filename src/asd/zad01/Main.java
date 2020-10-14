package asd.zad01;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main 
{
	public static void main(String[] args) 
	{
		Integer size = null;
		Integer maxDiff = null;
		Integer startInd = null;
		Integer endInd = null;
		int comp = 0;
		Cionk wynik = new Cionk();
		ArrayList<Integer> dane = new ArrayList<Integer>();
		
		BufferedReader br = null;
		String line;
		
		try 
		{
			br = new BufferedReader(new FileReader("test.txt"));
			size = Integer.parseInt(br.readLine());
			maxDiff = Integer.parseInt(br.readLine());
			br.readLine();
			while((line = br.readLine()) != null)
				dane.add(Integer.parseInt(line));
				
		} catch (IOException e) 
		{
			e.printStackTrace();
		}
		
		
		
		for(int i = 0; i < (size-wynik.cionkSize); i++)
		{
			Cionk test = new Cionk(dane.get(i), maxDiff);
			for(int j = i+1 ; j < size && test.czyNalezy(dane.get(j)) ; j++);
			comp += test.comp;
			if(test.cionkSize > wynik.cionkSize)
			{
				wynik = test;
				startInd = i;
				endInd = i+wynik.cionkSize-1;
			}
		}
		System.out.println(startInd);
		System.out.println(endInd);
		System.out.println();
		System.out.println(wynik);
		System.out.println("Ilosc porownan: " + comp);
		
		
		
		
		
	}

}
