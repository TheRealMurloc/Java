package ppj.zad04;

public class Main {

	public static void main(String[] args) {
		
		Dzem dzem1 = new Dzem("Pomaranczowy", 1000);
		
		Ciastko ciastko = FabrykaCiastek.przygotuj(5);
		
		if(ciastko!=null)
			ciastko.show();
		
		Kontener kontener = new Kontener(10000);
		kontener.zaladuj(ciastko);
		kontener.zaladuj(-1);
		System.out.println(kontener.sprawdzPrzydatnosc());
		kontener.zaladuj(10);
		System.out.println(kontener.sprawdzPrzydatnosc());

		
		Kontener kontener2 = new Kontener(10000);
		kontener2.zaladuj(5);
		Kontener kontener3 = new Kontener(10000);
		kontener3.zaladuj(30);
		Kontener kontener4 = new Kontener(10000);
		kontener4.zaladuj(12);
		Kontener kontener5 = new Kontener(10000);
		kontener5.zaladuj(8);
		Kontener kontener6 = new Kontener(10000);
		kontener6.zaladuj(2);
		
//		Magazyn magazyn = new Magazyn();
//		
//		magazyn.wydajKontener();
//		
//		magazyn.przyjmijKontener(kontener);
//		magazyn.przyjmijKontener(kontener2);
//		magazyn.przyjmijKontener(kontener3);
//		magazyn.przyjmijKontener(kontener4);
//		magazyn.przyjmijKontener(kontener5);
//		magazyn.przyjmijKontener(kontener6);
//		
//		magazyn.wydajKontener();
//		magazyn.wydajKontener();
//		magazyn.wydajKontener();
//		magazyn.wydajKontener();
//		magazyn.wydajKontener();
//		magazyn.wydajKontener();
//		
		
		Magazyn magazyn2 = new Magazyn();
		
		magazyn2.show();
		magazyn2.przyjmijKontener(kontener);
		magazyn2.show();
		magazyn2.przyjmijKontener(kontener2);
		magazyn2.show();
		magazyn2.przyjmijKontener(kontener3);
		magazyn2.show();
		magazyn2.przyjmijKontener(kontener4);
		magazyn2.show();
		magazyn2.przyjmijKontener(kontener5);
		magazyn2.show();
		magazyn2.przyjmijKontener(kontener6);
		magazyn2.show();
	}

}
