package ppj.zad04;

public class Magazyn {

	private Kontener[] kontenery = new Kontener[5];
	private int wsk = 0;
	
	// Zachęcam do znalezienia błędu. Prawidłowa odpowiedź zostanie zamieszczona
	// 24.12.2017
	public void przyjmijKontener(Kontener kontener){
		if(wsk>4)
			System.out.println("Brak miejsca");
		else{
			
			int tmp = 0;
			
			for(int i=wsk-1; i>0; i--)
				if(kontenery[i].getDniPrzydatnosci()<kontener.getDniPrzydatnosci())
					tmp = i;
			
			
			for(int i=wsk-1; i>tmp; i++)
				kontenery[i] = kontenery[i-1];
			
			kontenery[tmp] = kontener;
			
			
			wsk++;
			System.out.println("Kontener przyjęty");
		}
	}
	
	public void show(){
		System.out.println("==================");
		for(int i=0; i<wsk; i++)
			System.out.println(kontenery[i]);
		System.out.println("==================");
	}
	
	public Kontener wydajKontener(){
		if(wsk<1){
			System.out.println("Magazyn pusty");
			return null;
		}else{
			System.out.println("Kontener wydany");
			return kontenery[--wsk];
		}
	}
	
}
