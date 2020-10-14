package utp.zad05.part2;

import java.io.IOException;
import java.util.function.Function;

public interface ThrowingFunction <U,T> extends Function<U,T>
{
	T applyThrowing(U u) throws IOException;
	
	default T apply(U u) 
	{
		return null;
	}
	

}
