package nai.zad1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main 
{
	static int k;
	public static void main(String[] args) 
	{
		String line;
		String[] attributes = null;
		ArrayList<Iris> daneTreningowe = new ArrayList<Iris>();
		ArrayList<Iris> daneTestowe = new ArrayList<Iris>();
		PriorityQueue<Para> odleglosci = new PriorityQueue<Para>();
		
		// Wczytywanie danych treningowych z pliku i zapisywanie do ArrayListy
		String path = "src/nai/zad1/iris.data.normalized.txt";
		try(BufferedReader br = new BufferedReader(new FileReader(path)))
		{
			while((line = br.readLine()) != null)
			{
				ArrayList<Double> atrybuty = new ArrayList<Double>();
				attributes = line.split(",");
				for(int i = 0; i < attributes.length-1; i++)
				{
					atrybuty.add(Double.parseDouble(attributes[i]));
				}
				Iris iris = new Iris(attributes[attributes.length-1],atrybuty);
				daneTreningowe.add(iris);
			}
				
		} catch (IOException e) 
		{
			e.printStackTrace();
		}
		
		// Wczytywanie danych testowych z pliku i zapisywanie do ArrayListy
				String pathTest = "src/nai/zad1/iris.data.normalized.test.txt";
				try(BufferedReader br = new BufferedReader(new FileReader(pathTest)))
				{
					while((line = br.readLine()) != null)
					{
						ArrayList<Double> atrybuty = new ArrayList<Double>();
						attributes = line.split(",");
						for(int i = 0; i < attributes.length-1; i++)
						{
							atrybuty.add(Double.parseDouble(attributes[i]));
						}
						Iris iris = new Iris(attributes[attributes.length-1],atrybuty);
						daneTestowe.add(iris);
					}
						
				} catch (IOException e) 
				{
					e.printStackTrace();
				}
		
		// Podanie wartosci k
		Scanner scan = new Scanner(System.in);
        System.out.println("Podaj wartość K");
        k = Integer.parseInt(scan.nextLine());
        
		// Pomiar odleglości i zliczanie nazw
        int poprawnieZaklasyfikowane = 0;
        int irisSetosa = 0;
        int irisVersicolor = 0;
        int irisVirginica = 0;
        String nazwa;
        double odleglosc;
        for(int i = 0; i < daneTestowe.size(); i++)
        {
        	irisSetosa = 0;
            irisVersicolor = 0;
            irisVirginica = 0;
        	odleglosci.clear();
        	for(int j = 0; j < daneTreningowe.size(); j++)
        	{
        		odleglosc = daneTestowe.get(i).roznicaOdleglosci(daneTreningowe.get(j));
        		nazwa = daneTreningowe.get(j).nazwa;
        		Para para = new Para(nazwa, odleglosc);
        		odleglosci.add(para);
        	}
        	for(int l = 0; l < k; l++)
    		{
        		switch(odleglosci.poll().nazwa)
        		{
	        		case "Iris-setosa": 
	        			irisSetosa++; 
	                    break; 
	                case "Iris-versicolor": 
	                	irisVersicolor++;
	                    break; 
	                case "Iris-virginica": 
	                	irisVirginica++;
	                    break; 
        		}
    		}
        	
        	if ((irisSetosa > irisVersicolor) && (irisSetosa > irisVirginica))
        	{
        	    if(daneTestowe.get(i).nazwa.equals("Iris-setosa"))
        	    	poprawnieZaklasyfikowane++;
        	}
        	else
    	    {
			  if (irisVersicolor > irisVirginica)
			  {
				  if(daneTestowe.get(i).nazwa.equals("Iris-versicolor"))
					  poprawnieZaklasyfikowane++;
			  }
			  else
			  {
				  if(daneTestowe.get(i).nazwa.equals("Iris-virginica"))
					  poprawnieZaklasyfikowane++;
			  }
			}
        }
        System.out.println("Poprawnie zaklasyfikowanych zostało " + poprawnieZaklasyfikowane + " irysów");
		
		// Ręczne podawanie wartości
		boolean check = false;
		while(!check)
		{
	        System.out.println("Czy chcesz wprowadzic wektory atrybutu do zaklasyfikowania? (y/n)");
	        String czyRecznie = scan.nextLine();
	        if(czyRecznie.equals("y"))
	        {
	        	ArrayList<Double> atrybuty = new ArrayList<Double>();
	        	for(int i = 0; i < attributes.length-1; i++)
	        	{
	        		System.out.println("Wprowadz " + i + " atrybut");
	                atrybuty.add(Double.parseDouble(scan.nextLine()));
	        	}
				Iris iris = new Iris(atrybuty);
				System.out.println(iris);
				
				for(int j = 0; j < daneTreningowe.size(); j++)
	        	{
	        		odleglosc = iris.roznicaOdleglosci(daneTreningowe.get(j));
	        		nazwa = daneTreningowe.get(j).nazwa;
	        		Para para = new Para(nazwa, odleglosc);
	        		odleglosci.add(para);
	        	}
				irisSetosa = 0;
	            irisVersicolor = 0;
	            irisVirginica = 0;
	        	for(int l = 0; l < k; l++)
	    		{
	        		switch(odleglosci.poll().nazwa)
	        		{
		        		case "Iris-setosa": 
		        			irisSetosa++; 
		                    break; 
		                case "Iris-versicolor": 
		                	irisVersicolor++;
		                    break; 
		                case "Iris-virginica": 
		                	irisVirginica++;
		                    break; 
	        		}
	    		}
	        	System.out.println(irisSetosa);
	        	System.out.println(irisVersicolor);
	        	System.out.println(irisVirginica);
	        	
	        	if ((irisSetosa > irisVersicolor) && (irisSetosa > irisVirginica))
	        	{
	        	    System.out.println("Iris-setosa");
	        	}
	        	else
	    	    {
				  if (irisVersicolor > irisVirginica)
				  {
					  System.out.println("Iris-versicolor");
				  }
				  else
				  {
					  System.out.println("Iris-virginica");
				  }
				}
				
	        }
	        if(czyRecznie.equals("n"))
	        {
	        	check = true;
	        }
		}
        scan.close();
	}
}
