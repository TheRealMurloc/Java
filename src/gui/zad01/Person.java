package gui.zad01;

public class Person 
{
	String imie;
	int wiek;
	
	public Person(String imie, int wiek)
	{
		this.imie = imie;
		this.wiek = wiek;
	}
	
	public void sayHelloTo(Person p)
	{
		String imie = p.imie;
		System.out.println("Hello " + imie + "!");
	}
	@Override
	public String toString()
	{
		return this.imie;
	}
}
