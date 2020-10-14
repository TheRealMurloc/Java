package utp.zad03.part1;
import java.util.*;
import java.util.function.*;


public class ListCreator <T>
{
	List<T> l1 = new ArrayList<>();
	
	static public <S> ListCreator<S> collectFrom(List<S> dest)
	{
		ListCreator<S> listCreator = new ListCreator<>();
		listCreator.l1.addAll(dest);
		return listCreator;
	}
	
	ListCreator<T> when(Predicate<T> p)
	{
		l1.removeIf(t -> !p.test(t));
		return this;
	}
	
	<U> List<U> mapEvery(Function <T, U> f)
	{
		List <U> l2 = new ArrayList<>();
		for(T i : l1)
		{
			U przelicznik = f.apply(i);
			l2.add(przelicznik);
		}
		return l2;
		
	}
}
