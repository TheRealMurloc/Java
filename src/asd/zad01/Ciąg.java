package asd.zad01;

import java.util.ArrayList;

public class Ciąg
{
	private Integer minInd;
	private Integer maxInd;
	private Integer maxDiff;
	Integer ciągSize;
	ArrayList<Integer> al = new ArrayList<Integer>();
	int comp = 0;
	
	public Ciąg()
	{
		ciągSize = 0;
	}
	
	public Ciąg(Integer a, Integer maxDiff)
	{
		this.maxDiff = maxDiff;
		al.add(a);
		maxInd = 0;
		minInd = 0;
		ciągSize = 1;
	}
	
	public boolean czyNalezy(Integer a)
	{
		comp++;
		if(a > al.get(maxInd))
		{
			comp++;
			if((a - al.get(minInd)) > maxDiff)
				return false;
			else
			{
				addIntMax(a);
				return true;
			}
		}
		comp++;
		if(a < al.get(minInd))
		{
			comp++;
			if((al.get(maxInd) - a) > maxDiff)
				return false;
			else
			{
				addIntMin(a);
				return true;
			}
		}
		addInt(a);
		return true;
	}
	
	public void addInt(Integer a)
	{
		al.add(a);
		ciągSize++;
	}
	public void addIntMax(Integer a)
	{
		al.add(a);
		maxInd = ciągSize;
		ciągSize++;
	}
	public void addIntMin(Integer a)
	{
		al.add(a);
		minInd = ciągSize;
		ciągSize++;
	}
	public String toString()
	{
		for(int i = 0; i < ciągSize; i++)
		{
			System.out.println(al.get(i));
		}
		return "";
	}
	
}
