/**
 *
 *  @author Skibiński-Kołtun Patryk S17203
 *
 */

package utp.zad06.part2;


public class Purchase 
{
	String id;
	String nazwisko;
	String nazwa;
	double cena;
	double ilosc;
	
	public Purchase(String id, String nazwisko, String nazwa, double cena, double ilosc)
	{
		this.id = id;
		this.nazwisko = nazwisko;
		this.nazwa = nazwa;
		this.cena = cena;
		this.ilosc = ilosc;
	}
	
	public String toString()
	{
		return id + ";" + nazwisko + ";" + nazwa + ";" + String.valueOf(cena) + ";" + String.valueOf(ilosc);
	}
	
	
}
