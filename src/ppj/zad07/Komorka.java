package ppj.zad07;

public class Komorka extends Telefon {

	String[] tab = new String[10];
	
	public void zadzwon(String numer){
		super.zadzwon(numer);
		
		for(int i=8; i>=0; i--)
			tab[i+1] = tab[i];
		
		tab[0] = numer;
	}
	
	public void wyswietlHistoriePolaczen(){
		for(int i=0; i<10; i++){
			System.out.println(tab[i]);
		}
	}
	
	
}
