package nai.zad5;

import java.util.ArrayList;
import java.util.Scanner;

public class Main 
{

	public static void main(String[] args) 
	{
		String n = new String();
		Scanner scan = new Scanner(System.in);
		System.out.println("Podaj ciąg znaków");
		n = scan.nextLine();
		scan.close();
		int tab[] = new int[26];
		for(int i = 0; i < n.length(); i++)
		{
			if(n.charAt(i) != 32)
				tab[n.charAt(i)-97]++;
		}
		
		ArrayList<Leaf> lista = new ArrayList<Leaf>();
		for(int i = 0; i < tab.length; i++)
		{
			if(tab[i] != 0)
			{
				lista.add(new Leaf((char) (i+97), tab[i]));
			}
		}
		ArrayList<Leaf> min = new ArrayList<Leaf>();
		while(lista.size() != 1)
		{
			//wybieranie najmniejszego liscia
			
			//1 przejscie w poszukiwaniu min
			int minLeaf = 0;
			for(int i = 1; i < lista.size(); i++)
			{
				if(lista.get(i-1).ilosc > lista.get(i).ilosc)
				{
					minLeaf = i;
				}
			}
			min.add(lista.get(minLeaf));
			lista.remove(minLeaf);
	
			//2 przejscie w poszukiwaniu min
			minLeaf = 0;
			for(int i = 1; i < lista.size(); i++)
			{
				if(lista.get(i-1).ilosc > lista.get(i).ilosc)
				{
					minLeaf = i;
				}
			}
			min.add(lista.get(minLeaf));
			lista.remove(minLeaf);
			
			
			
			lista.add(new Leaf(min.get(0).ilosc + min.get(1).ilosc));
			lista.get(lista.size()-1).under.add(min.get(0));
			lista.get(lista.size()-1).under.add(min.get(1));
			lista.get(lista.size()-1).under.get(0).bit += "0";
			lista.get(lista.size()-1).under.get(0).updateBit('0');
			lista.get(lista.size()-1).under.get(1).bit += "1";
			lista.get(lista.size()-1).under.get(1).updateBit('1');
		
			min.clear();
		}
		
		System.out.println(lista.get(0).toString2());
	}
}
