/**
 *
 *  @author Skibiński-Kołtun Patryk S17203
 *
 */

package utp.zad06.part2;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class CustomersPurchaseSortFind 
{
	List<Purchase> sale = new ArrayList<Purchase>();
	
	public void readFile(String str)
	{
		 FileReader fr = null;
		try {
			fr = new FileReader(str);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		 Scanner sc = new Scanner(fr);
		 while(sc.hasNextLine()) 
		 {
			String linia = sc.nextLine();
			String[] dane = linia.split(";");
			Purchase p = new Purchase(dane[0], dane[1], dane[2], Double.parseDouble(dane[3]), Double.parseDouble(dane[4]));
		    this.sale.add(p);
		 }
		 sc.close();
	}
	
	public void showSortedBy(String str)
	{
		if(str.equals("Nazwiska"))
		{
			boolean needSort;
			 do
		     {
		    	needSort = false;
		    	for(int i = 0; i < sale.size()-1; i++)
		    	{
		    		if(sale.get(i).nazwisko.charAt(0) == sale.get(i+1).nazwisko.charAt(0))
		    		{
			    		for(int j = 0; j < sale.get(i).nazwisko.length()-1 && j < sale.get(i+1).nazwisko.length()-1; j++)
		    			{
			    			if(sale.get(i).nazwisko.charAt(j) > sale.get(i+1).nazwisko.charAt(j))
				    		{
				    			needSort = true;
				    			Collections.swap(sale, i, i+1);
				    			break;
				    		}
		    			}
		    		}
			    	else
			    	{
			    		if(sale.get(i).nazwisko.charAt(0) > sale.get(i+1).nazwisko.charAt(0))
			    		{
			    			needSort = true;
			    			Collections.swap(sale, i, i+1);
			    		}
			    	}
		    	}
			     
		     }while(needSort);
			 System.out.println(str);
			 for(int i = 0; i < sale.size(); i++)
			 {
				 System.out.println(sale.get(i));
			 }
		}
		if(str.equals("Koszty"))
		{
			boolean needSort;
			 do
		     {
		    	needSort = false;
		    	for(int i = 0; i < sale.size()-1; i++)
		    	{
		    		if(sale.get(i).cena*sale.get(i).ilosc == sale.get(i+1).cena*sale.get(i+1).ilosc)
		    		{
		    			if(sale.get(i).nazwisko.charAt(0) > sale.get(i+1).nazwisko.charAt(0))
			    		{
			    			needSort = true;
			    			Collections.swap(sale, i, i+1);
			    		}
		    		}
		    		else
		    		{
			    		if(sale.get(i).cena*sale.get(i).ilosc < sale.get(i+1).cena*sale.get(i+1).ilosc)
			    		{
			    			needSort = true;
			    			Collections.swap(sale, i, i+1);
			    		}
		    		}
		    	}
			     
		     }while(needSort);
			 System.out.println(str);
			 for(int i = 0; i < sale.size(); i++)
			 {
				 System.out.println(sale.get(i) + " (koszt: " + sale.get(i).cena*sale.get(i).ilosc + ")");
			 }
		}
		
	}
	
	public void showPurchaseFor(String id)
	{
		System.out.println("Klient " + id);
		for(int i = 0; i < sale.size(); i++)
		{
			if(sale.get(i).id.equals(id))
			{
				System.out.println(sale.get(i));
			}
		}
	}
	
	
	
}
