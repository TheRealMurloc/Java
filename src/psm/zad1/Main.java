package psm.zad1;

import java.util.concurrent.TimeUnit;

public class Main implements Runnable
{

	public static void main(String[] args) 
	{
		
		Main x = new Main();
		x.run();
		
	}

	@Override
	public void run() 
	{
		Board board = new Board(10, 50);
		board.tab[4][24].setAlive(true);
		board.tab[5][25].setAlive(true);
		board.tab[6][23].setAlive(true);
		board.tab[6][24].setAlive(true);
		board.tab[6][25].setAlive(true);

		
		while(true)
		{
			try 
			{
				TimeUnit.SECONDS.sleep(5);
			} catch (InterruptedException e) 
			{
				e.printStackTrace();
			}
			System.out.println(board);
			board.calculateNeighbors();
			for(int i = 0; i < 10; i++)
			{
				for(int j = 0; j < 50; j++)
				{
					if(board.tab[i][j].isAlive())
					{
						if(board.tab[i][j].getNeighbors() < 2 || board.tab[i][j].getNeighbors() > 3)
						{
							board.tab[i][j].setAlive(false);
						}
					}
					if(!board.tab[i][j].isAlive())
					{
						if(board.tab[i][j].getNeighbors() == 3)
						{
							board.tab[i][j].setAlive(true);
						}
					}
				}
			}
		}
	}

}
