/**
 *
 *  @author Skibiński-Kołtun Patryk S17203
 *
 */

package utp.zad11.part1;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class Calc 
{
	private Map<String, Operacja> zdefiniowaneOperacje = new HashMap<>();
	public Calc()
	{
		zdefiniowaneOperacje.put("+", new Dodawanie());
		zdefiniowaneOperacje.put("-", new Odejmowanie());
		zdefiniowaneOperacje.put("*", new Mnozenie());
		zdefiniowaneOperacje.put("/", new Dzielenie());
	}
	
	public String doCalc(String str)
	{
		try
		{
			String tab[] = str.split("\\s+");
			String op = tab[1];
			BigDecimal left = new BigDecimal(tab[0]);
			BigDecimal right = new BigDecimal(tab[2]);
			Operacja opr = zdefiniowaneOperacje.get(op);
			BigDecimal wynik = opr.oblicz(left, right);
			return wynik.toString();
		}
		catch (Exception e)
		{
			return "Invalid command to calc";
		}
	}
}  
