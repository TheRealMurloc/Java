package asd.zad02;

import java.util.ArrayList;

public class Node 
{
	int size;
	ArrayList<Node> nexts = new ArrayList<Node>();
	int weight;
	
	public Node(int size)
	{
		this.size = size;
	}
	
	public void setNexts(Node n)
	{
		nexts.add(n);
	}
	
	public int recalculateWeights()
	{
		int wynik = this.size;
		for(int i = 0; i < nexts.size(); i++)
		{
			wynik += nexts.get(i).recalculateWeights();
		}
		this.weight = wynik;
		return wynik;
	}
	
	@Override
	public String toString()
	{
		
		return "Node: " + size + " nexts: " + nexts + "\n";
	}
	
}
