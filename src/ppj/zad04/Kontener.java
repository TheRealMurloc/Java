package ppj.zad04;

public class Kontener {

	private Ciastko ladunek;
	private double masaLadunku;
	private int dniPrzydatnosci;

	public Kontener(double masaLadunku){
		this.setMasaLadunku(masaLadunku);
	}
	
	public void zaladuj(Ciastko ciastko){
		this.setLadunek(ciastko);
	}
	
	public void zaladuj(int dniPrzydatnosci){
		this.setDniPrzydatnosci(dniPrzydatnosci);
	}
	
	public boolean sprawdzPrzydatnosc(){
		if(getDniPrzydatnosci()>=0)
			return true;
		else
			return false;
	}
	
	@Override
	public String toString() {
		return String.valueOf(dniPrzydatnosci);
	}
	
	public int getDniPrzydatnosci() {
		return dniPrzydatnosci;
	}

	private void setDniPrzydatnosci(int dniPrzydatnosci) {
		this.dniPrzydatnosci = dniPrzydatnosci;
	}

	private double getMasaLadunku() {
		return masaLadunku;
	}

	private void setMasaLadunku(double masaLadunku) {
		this.masaLadunku = masaLadunku;
	}

	private Ciastko getLadunek() {
		return ladunek;
	}

	private void setLadunek(Ciastko ladunek) {
		this.ladunek = ladunek;
	}

}
