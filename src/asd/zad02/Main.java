package asd.zad02;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Main 
{

	public static void main(String[] args) 
	{
		//Tworzenie i wstawianie potrzebnych struktur dla programu
		int wielkosc = 0;
		boolean czyDrzewo;
		Node korzen = null;
		ArrayList<Node> dane = new ArrayList<Node>();
		Set<Node> nodes = new HashSet<Node>();
		int iloscNodes = 0;
		dane.add(new Node(0));
		BufferedReader br = null;
		//Wczytywanie z pliku wartosci
		try 
		{
			int read;
			boolean gotowyInd = false;
			int ind = 0;
			String str = "";
			int set;
			String setStr = "";
			br = new BufferedReader(new FileReader("test.txt"));
			wielkosc = Integer.parseInt(br.readLine());
			for(int i = 1; i < wielkosc+1; i++)
			{
				dane.add(new Node(i));
			}
			br.readLine();
			do
			{
				read = br.read();
				if(read != 10)
				{
						if(!gotowyInd)
						{
							if(read > 47 && read < 58)
								str += (char) read;	
							if(read == 58)
							{
								ind = Integer.parseInt(str);
								gotowyInd = true;
							}
						}
						else
						{
							if(read == 32 || read == -1 || read == 13)
							{
								if(setStr != "")
								{
									set = Integer.parseInt(setStr);
									dane.get(ind).setNexts(dane.get(set));
									setStr = "";	
								}
							}
							if(read > 47 && read < 58)
								setStr += (char) read;
						}
				}
				else
				{
					gotowyInd = false;
					str = "";
				}
				
			}while(read != -1);
				
		} catch (IOException e) 
		{
			e.printStackTrace();
		}
		
//------------------------------------------------------------------------------ Algorytm
		
		for(int i = 1; i < wielkosc+1; i++)		//sprawdzanie czy graf jest drzewem
		{
			for(int j = 0; j < dane.get(i).nexts.size(); j++)
			{
				nodes.add(dane.get(i).nexts.get(j));
				iloscNodes++;
			}
		}
		if((nodes.size())==(wielkosc-1) && nodes.size() == iloscNodes)
		{
			czyDrzewo = true;
			for(int i = 1; i < wielkosc+1; i++) //Ustalanie korzenia
			{
				if(!nodes.contains(dane.get(i)))
					korzen = dane.get(i);
			}
			
			for(int i = 0; i < korzen.nexts.size()+1; i++) //ustalenie wagi
			{
				korzen.recalculateWeights();
			}
		}
		else
		{
			czyDrzewo = false;
		}
		
		if(czyDrzewo == true)
		{
			int minInd = 0;
			int maxInd = 0;
			
			for(int i = 0; i < korzen.nexts.size(); i++)		//poszukiwanie najciezszego i najlzejszego poddrzewa
			{
				if(korzen.nexts.get(i).weight < korzen.nexts.get(minInd).weight)
				{
					minInd = i;
				}
				
				if(korzen.nexts.get(i).weight > korzen.nexts.get(maxInd).weight)
				{
					maxInd = i;
				}
			}
			
			System.out.println("JEST");
			System.out.println(korzen.nexts.get(maxInd).weight);
			System.out.println(korzen.nexts.get(minInd).weight);
		}
		else
		{
			System.out.println("NIE");
		}	
	}
}
