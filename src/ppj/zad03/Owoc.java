package ppj.zad03;


public
class Owoc {

    int iloscPestek;
    String barwa;

    Owoc(int iloscPestek, String barwa){
        this.iloscPestek = iloscPestek;
        this.barwa = barwa;
    }

    public void show(){
        System.out.println(
                this + " Ja owoc mam " + iloscPestek +
                        " i jestem barwy " + barwa
        );
    }

    public boolean compare(Owoc owoc){
        if(this != owoc){
            return this.iloscPestek == owoc.iloscPestek &&
                    this.barwa.equals(owoc.barwa);
        }
        return true;

    }

}

