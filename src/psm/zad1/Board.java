package psm.zad1;

public class Board 
{
	Cell[][] tab;
	int height;
	int width;
	
	public Board(int y, int x)
	{
		tab = new Cell[y][x];
		for(int i = 0; i < y; i++)
		{
			for(int j = 0; j < x; j++)
			{
				tab[i][j] = new Cell();
			}
		}
		this.height = y;
		this.width = x;
	}
	
	public void calculateNeighbors()
	{
		int value = 0;
		for(int i = 0; i < height; i++)
		{
			for(int j = 0; j < width; j++)
			{
				value = 0;
				if(i != 0)
				{
					if(tab[i-1][j].isAlive())
						value++;
				}
				if(i != height-1)
				{
					if(tab[i+1][j].isAlive())
						value++;
				}
				if(j != 0)
				{
					if(tab[i][j-1].isAlive())
						value++;
				}
				if(j != width-1)
				{
					if(tab[i][j+1].isAlive())
						value++;
				}
				if(i != 0 && j != 0)
				{
					if(tab[i-1][j-1].isAlive())
						value++;
				}
				if(i != height-1 && j != 0)
				{
					if(tab[i+1][j-1].isAlive())
						value++;
				}
				if(i != 0 && j != width-1)
				{
					if(tab[i-1][j+1].isAlive())
						value++;
				}
				if(i != height-1 && j != width-1)
				{
					if(tab[i+1][j+1].isAlive())
						value++;
				}
				tab[i][j].setNeighbors(value);
			}
		}
	}
	
	@Override
	public String toString()
	{
		for(int i = 0; i < height; i++)
		{
			for(int j = 0; j < width; j++)
			{
				System.out.print(tab[i][j]);
			}
			System.out.println();
		}
		return "";
	}
}
