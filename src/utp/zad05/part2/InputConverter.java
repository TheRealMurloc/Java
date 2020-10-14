package utp.zad05.part2;

import java.io.IOException;
import java.util.function.Function;

public class InputConverter <T>
{
	T zmienna;
	
	public InputConverter(T x)
	{
		this.zmienna = x;
	}
	
	public <S> S convertBy(ThrowingFunction...fun) throws IOException
	{
		Object obj = zmienna;
		for(ThrowingFunction f : fun)
		{
			obj = f.applyThrowing(obj);
		}
		return (S)obj;
	}
	
	
}
