package gui.zad02_1;

public abstract class Figura
{
	static public final double PI = 3.14;
	double pole;
	double obwod;
	String kolor;
	
	public Figura(double pole, double obwod, String kolor)
	{
		this.pole = pole;
		this.obwod = obwod;
		this.kolor = kolor;
	}
}
