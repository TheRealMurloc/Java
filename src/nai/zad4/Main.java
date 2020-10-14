package nai.zad4;

import java.util.ArrayList;
import java.util.Scanner;

public class Main 
{

	public static void main(String[] args) 
	{
		/*
		ArrayList<Point> points = new ArrayList<Point>();
		ArrayList<Centroid> centroids = new ArrayList<Centroid>();
		points.add(new Point(1,2));
		points.add(new Point(1,4));
		points.add(new Point(1,7));
		points.add(new Point(3,5));
		points.add(new Point(3,7));
		points.add(new Point(5,1));
		points.add(new Point(4,3));
		points.add(new Point(5,4));
		int n;
		Scanner scan = new Scanner(System.in);
		System.out.println("Podaj liczbe k");
		n = scan.nextInt();
		scan.close();
		//tworzenie centroidow
		for(int i = 0; i < n; i++)
		{
			centroids.add(new Centroid());
		}
		
		int min = 0;
		ArrayList<Centroid> oldCentroids = new ArrayList<Centroid>();
		boolean same = true;
		outerLoop:
		while(true)
		{
			//Dla kazdego punktu znajdujemy centroid i przypisujemy
			for(int i = 0; i < points.size(); i++)
			{
				min = 0;
				for(int j = 1; j < centroids.size(); j++)
				{
					if(points.get(i).calculateDistance(centroids.get(min)) > points.get(i).calculateDistance(centroids.get(j)))
					{
						min = j;
					}
				}
				centroids.get(min).points.add(points.get(i));
			}
			//old
			for(int i = 0; i < centroids.size(); i++)
			{
				oldCentroids.add(centroids.get(i));
			}
			//wyliczamy nowy centroid
			for(int i = 0; i < centroids.size(); i++)
			{
				centroids.get(i).calculateNewCentroid();
			}
			same = true;
			for(int i = 0; i < centroids.size(); i++)
			{
				if(centroids.get(i).points.size() != oldCentroids.get(i).points.size())
				{
					same = false;
				}
				else
				{
					for(int j = 0; j < centroids.get(i).points.size(); j++)
					{
						if(centroids.get(i).points.get(j).x != oldCentroids.get(i).points.get(j).x || centroids.get(i).points.get(j).y != oldCentroids.get(i).points.get(j).y)
						{
							same = false;
						}
					}
				}
				
			}
			if(same)
				break outerLoop;
			oldCentroids.clear();
		}
		for(int i = 0; i < centroids.size(); i++)
		{
			System.out.println("Centroid o wartosciach x: " + centroids.get(i).x + " y: " + centroids.get(i).y + " posiada punkty: ");
			for(int j = 0; j < centroids.get(i).points.size(); j++)
			{
				System.out.println(centroids.get(i).points.get(j).x + " " + centroids.get(i).points.get(j).y);
				System.out.println("odległość: " + centroids.get(i).points.get(j).calculateDistance(centroids.get(i)));
			}
		}
			*/
	}

}
