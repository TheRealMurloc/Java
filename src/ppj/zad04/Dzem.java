package ppj.zad04;

public class Dzem {

	private String smak;
	private double waga;
	
	public Dzem(String smak, double waga){
		this.setSmak(smak);
		this.setWaga(waga);
	}
	
	@Override
	public String toString() {
		return getSmak() + " " + getWaga();
	}

	String getSmak() {
		return smak;
	}

	void setSmak(String smak) {
		this.smak = smak;
	}

	double getWaga() {
		return waga;
	}

	void setWaga(double waga) {
		if(waga>0)
			this.waga = waga;
	}
	
}
