package utp.zad11.part1;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Dzielenie implements Operacja
{

	@Override
	public BigDecimal oblicz(BigDecimal left, BigDecimal right) 
	{
		return left.divide(right, 7, RoundingMode.HALF_UP);
	}

}
