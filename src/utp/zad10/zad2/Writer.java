

package utp.zad10.zad2;

import java.util.concurrent.TimeUnit;

public class Writer implements Runnable 
{
	Author autor;
	public Writer(Author autor) 
	{
		this.autor = autor;
	}

	@Override
	public void run() 
	{
		try 
		{
			while(true)
			{
				String text = autor.bq.poll(10, TimeUnit.SECONDS); //Po 10 sekundach od momentu przerwania ciągu danych wątek kończy prace
				if(text == null)
				{
					System.out.println("Nie chce mi sie już czekać na wiadomość, wychodze :D");
					break;
				}
				else
					System.out.println(text);
			}
		} catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
	}
}
