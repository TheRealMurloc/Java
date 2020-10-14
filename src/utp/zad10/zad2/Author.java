

package utp.zad10.zad2;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class Author implements Runnable 
{
	String dane[];
	BlockingQueue<String> bq = new ArrayBlockingQueue<String>(1);
	public Author(String[] args) 
	{
		dane = args;
	}

	@Override
	public void run() 
	{
		for(String i : dane)
		{
			try 
			{
				bq.put(i);
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) 
			{
				e.printStackTrace();
			}
		}
		
	}
}  
