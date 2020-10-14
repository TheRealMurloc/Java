package utp.zad07;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;

public class ProgLang 
{
	LinkedHashMap<String, List<String>> langsMap = new LinkedHashMap<String, List<String>>();
	LinkedHashMap<String, List<String>> progsMap = new LinkedHashMap<String, List<String>>();
	public ProgLang(String str)
	{
		 FileReader fr = null;
			try 
			{
				fr = new FileReader(str);
			} catch (FileNotFoundException e) 
			{
				e.printStackTrace();
			}
			 Scanner sc = new Scanner(fr);
			 while(sc.hasNextLine()) 
			 {
				String linia = sc.nextLine();
				String[] dane = linia.split("\t");
				String tmp = dane[0];
				
				List<String> programisci = new ArrayList<String>();
				for(int i = 1; i < dane.length; i++)
				{
					if(!programisci.contains(dane[i]))
						programisci.add(dane[i]);
				}
				langsMap.put(tmp, programisci);
				//2
				for(int i = 1; i < dane.length; i++)
				{
					if(progsMap.containsKey(dane[i]))
					{
						if(!progsMap.get(dane[i]).contains(tmp))
						{
							progsMap.get(dane[i]).add(tmp);
						}
					}
					else
					{
						List<String> jezyki = new ArrayList<>();
						jezyki.add(tmp);
						progsMap.put(dane[i], jezyki);
					}
				}	
			 }
			 sc.close();
	}
	
	public Map getLangsMap()
	{
		return langsMap;
	}
	
	public Map getProgsMap()
	{
		return progsMap;
	}
	
	public Map<String, List<String>> getLangsMapSortedByNumOfProgs()
	{
		Map<String, List<String>> treeMap = new TreeMap<String, List<String>>(langsMap);
		List<Entry<String, List<String>>> list = new LinkedList<>(treeMap.entrySet());
		list.sort(new Comparator<Entry<String, List<String>>>() 
		{
			public int compare(Entry<String, List<String>> o1, Entry<String, List<String>> o2) 
			{
				return Integer.compare(o2.getValue().size(), o1.getValue().size());
			}
		});
		Map<String, List<String>> wynik = new LinkedHashMap<>();

		for (Entry<String, List<String>> e : list) 
		{
			wynik.put(e.getKey(), e.getValue());
		}

		return wynik;
	}
	
	public Map<String, List<String>> getProgsMapSortedByNumOfLangs()
	{
		Map<String, List<String>> treeMap = new TreeMap<String, List<String>>(progsMap);

		List<Entry<String, List<String>>> list = new LinkedList<>(treeMap.entrySet());
		list.sort(new Comparator<Entry<String, List<String>>>() 
		{
			public int compare(Entry<String, List<String>> o1, Entry<String, List<String>> o2) 
			{
				return Integer.compare(o2.getValue().size(), o1.getValue().size());
			}
		});
		Map<String, List<String>> wynik = new LinkedHashMap<>();

		for (Entry<String, List<String>> e : list) 
		{
			wynik.put(e.getKey(), e.getValue());
		}

		return wynik;
	}
	
	public Map<String, List<String>> getProgsMapForNumOfLangsGreaterThan(int i)
	{
		Map<String, List<String>> wynik = new LinkedHashMap<>();
		
			for (Entry<String, List<String>> entry : progsMap.entrySet()) 
			{
				if (entry.getValue().size() > i) 
				{
					String key = entry.getKey();
					wynik.put(key, entry.getValue());
				}
			}
		
		return wynik;
	}
	
	
	
}
