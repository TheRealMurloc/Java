package utp.zad04.part2;

import java.util.NoSuchElementException;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Maybe <T>
{
	private T zmienna = null;
	private Maybe(T x)
	{
		this.zmienna = x;
	}
	
	private Maybe()
	{
	}
	
	static <T> Maybe<T> of(T x)
	{
		Maybe<T> maybe = new Maybe<>(x);
		return maybe;
	}
	
	public void ifPresent(Consumer <T> cons)
	{
		if(zmienna != null)
			cons.accept(zmienna);
	}
	
	public <U> Maybe <U> map(Function <T, U> func)
	{
		if(zmienna != null)
		{
			U tmp = func.apply(zmienna);
			return new Maybe<>(tmp);
		}
		return new Maybe<>();
	}
	
	
	public T get() throws NoSuchElementException
	{
		if(zmienna == null)
			throw new NoSuchElementException("maybe is empty");
		return zmienna;
	}
	
	public boolean isPresent()
	{
		if(zmienna != null)
		{
			return true;
		}
		return false;
	}
	
	public T orElse(T defVal)
	{
		if(zmienna == null)
			return defVal;
		return zmienna;
	}
	
	public Maybe <T> filter(Predicate <T> pred)
	{
		if(pred.test(zmienna) || zmienna == null)
			return this;
		return new Maybe<>();
		
	}
	
	public String toString()
	{
		if(zmienna == null)
			return "Maybe is empty";
		return "Maybe has value "+zmienna;
	}
}
