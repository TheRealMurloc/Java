package other.anagrams;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Anagrams 
{
	URL url = null;
	Scanner buff = null;
	List<String> allWords = new ArrayList<String>();
	List <List<String>> anagramy = new ArrayList<List<String>>();
	public Anagrams(String str)
	{
		try 
		{
			url = new URL(str);
		} catch (MalformedURLException e) 
		{
			e.printStackTrace();
		}
		try 
		{
			buff = new Scanner(url.openStream());
			int x = 0;
			String data;
			do
			{
				data = buff.nextLine();
				data.trim();
				allWords.add(data);
				System.out.println("dodalem " + x + " slowo");
				x++;
			} while(buff.hasNextLine() && data != null);
		} catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
	
	 public boolean czyAnagram(String a, String b)
	  {
		 boolean czyAnagram = true;
		 int znaczniki[] = new int[127];
	 	 if(a.length() != b.length())
	 	 {
	 		 return false;
	 	 }
	 	 else
	 	 {
	    	 for(int i = 0; i < a.length(); i++)
	    	 {
	    		 znaczniki[(int)a.charAt(i)]++;
	    		 znaczniki[(int)b.charAt(i)]--;
	    	 }
	     }
	 	 for(int i = 0; i < znaczniki.length; i++)
	 	 {
	 		 if(znaczniki[i] != 0)
	 		 {
	 			 czyAnagram = false;
	 		 }
	 	 }
	 	 return czyAnagram; 
	  }
	 
	 public List <List<String>> getSortedByAnQty()
	 {
		 System.out.println("zaczynam");
		 List<List<String>> listaList = new ArrayList<List<String>>();
	     List<String> slowaTmp = new ArrayList<String>();
	     slowaTmp.addAll(allWords);
	     int x = 0;
	     
	     while(!slowaTmp.isEmpty())
	     {
		     List<String> lista = new ArrayList<String>();
		     lista.add(slowaTmp.get(0));
	    	 slowaTmp.remove(0);
		     for(int i = 0; i < slowaTmp.size(); i++)
		     {	 
		    	 if(czyAnagram(lista.get(0), slowaTmp.get(i)))
		    	 {
		    		 lista.add(slowaTmp.get(i));
		    		 slowaTmp.remove(i);
		    		 i--;
		    	 }
		     }
		    listaList.add(lista);
	     }
	     this.anagramy = listaList;
	     System.out.println("Zrobiony anagram");
	     return listaList;
	 }
	 
	 public String getAnagramsFor(String word)
	 {
	    String wynik = word + ": ";
	    boolean exists = false;
	    for(int i = 0; i < anagramy.size(); i++)
	    {
	    	if(czyAnagram(word, anagramy.get(i).get(0)))
	    	{
	    		List<String> listaTmp = new ArrayList<String>();
	    		for(int j = 0; j < anagramy.get(i).size(); j++)
	    		{
	    			if(!anagramy.get(i).get(j).equals(word))
	    			{
	    				listaTmp.add(anagramy.get(i).get(j));
	    			}
	    			else
	    			{
	    				exists = true;
	    			}
	    		}
	    		wynik += listaTmp;
	    	}
	    	
	    }
	    if(exists)
	    {
	    	return wynik;
	    }
	    return word + ": null";
	 }
}  


