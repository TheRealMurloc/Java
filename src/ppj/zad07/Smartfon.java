package ppj.zad07;

public class Smartfon extends Komorka{

	Osoba[] znajomi;
	
	public void dodajZnajomy(String imie, String nazwisko, String numer){
		
		Osoba osoba = new Osoba(imie, nazwisko, numer);
		
		if(znajomi == null){
			znajomi = new Osoba[1];
			znajomi[0] = osoba;
		}else{
			Osoba[] tmp = new Osoba[znajomi.length+1];
			for(int i=0; i<znajomi.length; i++)
				tmp[i] = znajomi[i];
			
			tmp[znajomi.length] = osoba;
		
			znajomi = tmp;	
		}
		
	}
	
	
	public void wyswietlHistoriePolaczen(){
		
		for(int i=0; i<tab.length; i++){
			boolean found = false;

			for(int j=0; j<znajomi.length; j++)
				if(tab[i].equals(znajomi[j].numer)){
					System.out.println(znajomi[j].imie + " " + znajomi[j].nazwisko + " " + znajomi[j].numer);
					found = true;
				}
			
			if(!found)
				System.out.println(tab[i]);
		}
		
	}
	
	
}
