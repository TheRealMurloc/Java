package ppj.zad07;

import java.awt.Color;

public class Telefon {

	String interfejsKomunikacyjny;
	Color color;
	
	public void zadzwon(String numer){
		System.out.println(numer);
	}
	
	public void wyswietlHistoriePolaczen(){
		System.out.println("brak historii");
	}
	
}
