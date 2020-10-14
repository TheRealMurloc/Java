package ppj.zad07;

public class Main {

	public static void main(String[] args) {
		
		Telefon[] telefony = new Telefon[3];
		
		
		
		Telefon t1 = new Telefon();
		Komorka k1 = new Komorka();
		Smartfon s1 = new Smartfon();
		s1.dodajZnajomy("Jan", "Kowalski", "100");
		s1.dodajZnajomy("Janina", "Kowalska", "200");
		s1.dodajZnajomy("Jan3", "Kowalski3", "300");
		s1.dodajZnajomy("Jan4", "Kowalski4", "400");
		s1.dodajZnajomy("Jan5", "Kowalski5", "500");
		s1.dodajZnajomy("Jan6", "Kowalski6", "600");
		s1.dodajZnajomy("Jan7", "Kowalski7", "700");
		s1.dodajZnajomy("Jan8", "Kowalski8", "800");
		
		telefony[0] = t1;
		telefony[1] = k1;
		telefony[2] = s1;
		
		for(int i=0; i<3; i++)
			for(int j=0; j<10; j++)
				telefony[i].zadzwon(j+"00");
		
		for(int i=0; i<3; i++){
			System.out.println("==============");
			telefony[i].wyswietlHistoriePolaczen();
		}
		
	}

}
