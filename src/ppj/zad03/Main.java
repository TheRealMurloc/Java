package ppj.zad03;


public class Main {

    public static void main(String[] args) {
/*
		Owoc owoc = new Owoc(1, "fioletowa");
		owoc.show();
		Owoc owoc1 = new Owoc(1, "fioletowa");
		System.out.println(owoc.compare(owoc1));
*/
/*
		Drzewo brzoskwiniowiec = new Drzewo("brzoskwiniowiec");
		brzoskwiniowiec.makeWiosna();
//		Owoc tmp = brzoskwiniowiec.getOwoc();
//		while(tmp != null){
//			tmp.show();
//			tmp = brzoskwiniowiec.getOwoc();
//		}

		Owoc tmp;
		while( (tmp = brzoskwiniowiec.getOwoc()) != null)
			tmp.show();
*/
        Drzewo diz = Drzewo.makeDrzewo("dobra i zla");
        System.out.println(diz);
        diz = Drzewo.makeDrzewo("dobra i zla");
        System.out.println(diz);

        Drzewo brzoskwiniowiec = Drzewo.makeDrzewo("brzoskwiniowiec");
        //brzoskwiniowiec.makeWiosna();
        Owoc tmp;
        try {
            while( (tmp = brzoskwiniowiec.getOwoc()) != null)
                tmp.show();
        } catch (Exception e) {
            e.printStackTrace();
        }


        Drzewo ddiz = Drzewo.makeDrzewo("dobra i zla");
        System.out.println(ddiz);

    }

}

