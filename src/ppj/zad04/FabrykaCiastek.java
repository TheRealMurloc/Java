package ppj.zad04;

public class FabrykaCiastek {

	private static Ciastko[] produkowaneCiastka = new Ciastko[5];
	
	public static Ciastko przygotuj(int rodzajCiastka){
		
		try{
			if(produkowaneCiastka[rodzajCiastka-1]==null)
				produkowaneCiastka[rodzajCiastka-1] = upieczCiastko(rodzajCiastka);
			return produkowaneCiastka[rodzajCiastka-1];
		}catch(Exception ex){
			return null;
		}
		
	}
	
	private static Ciastko upieczCiastko(int rodzajCiastka){
		switch(rodzajCiastka){
			case 1: return new Ciastko(new Dzem("Dżemowy", 1000), 100);
			case 2: return new Ciastko(new Dzem("Czekolada", 2000), 80);
			case 3: return new Ciastko(new Dzem("Wiśniowy", 3000), 70);
			case 4: return new Ciastko(new Dzem("Pomarańczowy", 4000), 50);
			case 5: return new Ciastko(new Dzem("Truskawkowy", 5000), 85);
			default: return null;
		}
	}
	
}
