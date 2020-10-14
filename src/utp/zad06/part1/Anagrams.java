/**
 *
 *  @author Skibiński-Kołtun Patryk S17203
 *
 */

package utp.zad06.part1;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Anagrams 
{
	List<String> allWords = new ArrayList<String>();
	List <List<String>> anagramy = new ArrayList<List<String>>();
	public Anagrams(String str) throws FileNotFoundException
	{
		 FileReader fr = new FileReader(str);
		 Scanner sc = new Scanner(fr);
		 while(sc.hasNext()) 
		 {
		    this.allWords.add(sc.next());
		 }
		 sc.close();
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
		 List<List<String>> listaList = new ArrayList<List<String>>();
	     List<String> slowaTmp = new ArrayList<String>();
	     slowaTmp.addAll(allWords);
	     
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
	     boolean needSort;
	     do
	     {
	    	 needSort = false;
		     for(int i = 0; i < listaList.size()-1; i++)
		     {
		    	 if(listaList.get(i).size() == listaList.get(i+1).size())
		    	 {
		    		for(int j = 0; j < listaList.get(i).size()-1; j++)
		    		{
		    			if(listaList.get(i).get(0).charAt(j) > listaList.get(i+1).get(0).charAt(j))
		    			{
		    				needSort = true;
				    		Collections.swap(listaList, i, i+1);
		    			}
		    		}
		    	 }
		    	 else
		    	 {
			    	 if(listaList.get(i).size() < listaList.get(i+1).size())
			    	 {
			    		needSort = true;
			    		Collections.swap(listaList, i, i+1);
			    	 }
		    	 }
		     }
	     }while(needSort);
	     this.anagramy = listaList;
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


