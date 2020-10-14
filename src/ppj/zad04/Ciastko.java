package ppj.zad04;

public class Ciastko {

	Dzem smak;
	double waga;
	
	public Ciastko(Dzem smak, double waga){
		this.smak = smak;
		this.waga = waga;
	}
	
	public void show(){
		System.out.println("Smak: " + smak.getSmak());
		System.out.println("Waga: " + waga);
	}
	
}
