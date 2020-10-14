/**
 *
 *  @author Skibiński-Kołtun Patryk S17203
 *
 */

package utp.zad04.part1;

import java.util.ArrayList;
import java.util.List;

public class ListCreator <T>
{ // Uwaga: klasa musi być sparametrtyzowana
	
	List<T> l1 = new ArrayList<>();
	
	static <T> ListCreator<T> collectFrom(List<T> list)
	{
		ListCreator<T> listCreator = new ListCreator<>();
		listCreator.l1.addAll(list);
		return listCreator;
	}
	
	ListCreator<T> when(Selector<T> sel)
	{
		List <T> l2 = new ArrayList<>();
		for(T i : l1)
		{
			if(sel.select(i))
				l2.add(i);
		}
		return ListCreator.collectFrom(l2);	
	}
	
	<U> List<U> mapEvery(Mapper <T, U> f)
	{
		List <U> l3 = new ArrayList<>();
		for(T i : l1)
		{
			l3.add(f.map(i));
		}
		return l3;
		
	}
}  
