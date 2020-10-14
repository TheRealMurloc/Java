package utp.zad11.part1;

import java.math.BigDecimal;

public class Mnozenie implements Operacja
{

	@Override
	public BigDecimal oblicz(BigDecimal left, BigDecimal right) 
	{
		return left.multiply(right);
	}

}
