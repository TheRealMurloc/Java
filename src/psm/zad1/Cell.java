package psm.zad1;

public class Cell 
{
	private boolean alive;
	private int neighbors;
	
	public Cell()
	{
		alive = false;
		neighbors = 0;
	}
	
	public void setNeighbors(int n)
	{
		neighbors = n;
	}
	
	public boolean isAlive()
	{
		return alive;
	}
	
	public void setAlive(boolean alive)
	{
		this.alive = alive;
	}
	
	public int getNeighbors()
	{
		return neighbors;
	}
	
	@Override
	public String toString()
	{
		if(alive)
			return "O";
		else
			return "-";
	}
}
