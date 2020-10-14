package other.anagrams;

import java.util.List;
import java.util.function.Function;

public class Main 
{

	public static void main(String[] args) 
	{
		Anagrams an = new Anagrams("http://wiki.puzzlers.org/pub/wordlists/unixdict.txt");
		
			an.anagramy
				.stream()
				.filter(s -> ((CharSequence) s).length() > 1)
				.close();
		
		
		
		
		for(List<String> wlist : an.getSortedByAnQty()) 
		{
			wlist
				.stream()
				.filter(s -> s.length() > 1)
				.close();
			System.out.println(wlist);
			
		}
	
	}

}
