package nai.zad2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main 
{
	static float theta = 0;
	static float n;
	static int maxE;
	static ArrayList<Float> weights = new ArrayList<Float>();
	public static void main(String[] args) 
	{
		ArrayList<Vector> trainingVectors = new ArrayList<Vector>();
		ArrayList<Vector> testVectors = new ArrayList<Vector>();
		
		//Wartosc N
		Scanner scan = new Scanner(System.in);
        System.out.println("Podaj wartość uczenia N");
        n = Float.parseFloat(scan.nextLine());
        System.out.println("Podaj maksymalny dopuszczalny błąd iteracyjny");
        maxE = Integer.parseInt(scan.nextLine());

        
        //Wczytywanie danych treningowych
        String line;
        String[] attributes;
        String pathTraining = "src/nai/zad2/perceptron.data.txt";
		try(BufferedReader br = new BufferedReader(new FileReader(pathTraining)))
		{
			while((line = br.readLine()) != null)
			{
				ArrayList<Float> atrybuty = new ArrayList<Float>();
				attributes = line.split(",");
				for(int i = 0; i < attributes.length-1; i++)
				{
					atrybuty.add(Float.parseFloat(attributes[i]));
				}
				Vector vector = new Vector(attributes[attributes.length-1],atrybuty);
				trainingVectors.add(vector);
			}
				
		} catch (IOException e) 
		{
			e.printStackTrace();
		}
		
		//Inicjowanie wag
		for(int i = 0; i < trainingVectors.get(0).features.size(); i++)
		{
			weights.add((float)(Math.random() * 10) - 4);
		}
		
		
		int errors = 0;
		int gen = 1;
		//Poczatkowe sprawdzenie błedów + wypisanie wag
		System.out.println("Generacja " + gen);
		errors = 0;
		int y = 0;
		for(int i = 0; i < trainingVectors.size(); i++)
		{
			y = trainingVectors.get(i).wartoscY(theta, weights);
			if(y != trainingVectors.get(i).nameInt)
				errors++;
		}
		System.out.println("Błąd iteracji dla " + trainingVectors.size() + " danych: " + errors);
		for(int i = 0; i < weights.size(); i++)
		{
			System.out.println(weights.get(i));
		}
		
		do
		{
			gen++;
			//Trenowanie regułą DELTA
			y = 0;
			for(int i = 0; i < trainingVectors.size(); i++)
			{
				y = trainingVectors.get(i).wartoscY(theta, weights);
				weights = trainingVectors.get(i).updateWeights(y, n, weights);
				theta = trainingVectors.get(i).updateTheta(y, theta, n);
			}
			
			
			//Sprawdzenie bledow
			System.out.println("Generacja " + gen);
			errors = 0;
			y = 0;
			for(int i = 0; i < trainingVectors.size(); i++)
			{
				y = trainingVectors.get(i).wartoscY(theta, weights);
				if(y != trainingVectors.get(i).nameInt)
					errors++;
			}
			System.out.println("Błąd iteracji dla " + trainingVectors.size() + " danych: " + errors);
			
			for(int i = 0; i < weights.size(); i++)
			{
				System.out.println(weights.get(i));
			}
		}while(errors > maxE);
		
		
		//Wczytywanie danych testowych	
		 String pathTest = "src/nai/zad2/perceptron.data.test.txt";
		 int kwiat = 1;
			try(BufferedReader br = new BufferedReader(new FileReader(pathTest)))
			{
				while((line = br.readLine()) != null)
				{
					ArrayList<Float> atrybuty = new ArrayList<Float>();
					attributes = line.split(",");
					for(int i = 0; i < attributes.length-1; i++)
					{
						atrybuty.add(Float.parseFloat(attributes[i]));
					}
					Vector vector = new Vector(theta, weights, atrybuty);
					System.out.println("Kwiat o numerze " + kwiat + " zaklasyfikowany do " + vector.name);
					testVectors.add(vector);
					kwiat++;
				}
					
			} catch (IOException e) 
			{
				e.printStackTrace();
			}
			
		//Dodawanie wlasnych danych testowych
			
		String odp = "";
		while(!odp.equals("n"))
		{
			System.out.println("Czy chcesz wpisac wlasne wektory do zaklasyfikowania? (y/n)");
	        odp = scan.nextLine();
	        if(odp.equals("y"))
	        {
	        	ArrayList<Float> atrybuty = new ArrayList<Float>();
	        	float x;
	        	for(int i = 1; i < weights.size()+1; i++)
	        	{
	        		System.out.println("Podaj argument " + i);
	        		x = Float.parseFloat(scan.nextLine());
	        		atrybuty.add(x);
	        	}
	        	Vector vector = new Vector(theta, weights, atrybuty);
				System.out.println("Kwiat zaklasyfikowany do " + vector.name); 	
	        }
		}
        scan.close();
		
		
		
		
		
		
		
		
		
		
		
	}
}
