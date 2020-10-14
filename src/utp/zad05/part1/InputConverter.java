package utp.zad05.part1;

import java.util.function.Function;

public class InputConverter <T>
{
	T zmienna;
	
	public InputConverter(T x)
	{
		zmienna = x;
	}
	
	public <S> S convertBy(Function...fun)
	{
		Object obj = zmienna;
		for(Function f : fun)
		{
			obj = f.apply(obj);
		}
		return (S)obj;
	}
	
	
}
