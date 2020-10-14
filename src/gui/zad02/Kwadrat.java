package gui.zad02;

public class Kwadrat extends Figura
{
	int bok;
	
	public Kwadrat(int bok, String kolor)
	{
		super((bok * bok), (bok * 4), kolor);
		this.bok = bok;
	}
	@Override
	public String toString()
	{
		return "Kwadrat o boku: " + bok + ", Pole: " + super.pole + ", Obwód: " + super.obwod + ", Kolor: " + super.kolor;
	}
}
