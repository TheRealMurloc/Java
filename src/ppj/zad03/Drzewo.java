package ppj.zad03;


public
class Drzewo {

    String nazwa;
    Owoc owoce[];

    private Drzewo(String nazwa){
        this.nazwa = nazwa;
        owoce = null;
    }

    public void makeWiosna(){
        owoce = new Owoc[10];

        for(int i=0; i<owoce.length; i++)
            owoce[i] = new Owoc( 1, "pomaranczowy");
    }

    public Owoc getOwoc() throws Exception{

        if(owoce == null)
            throw new Exception("Too sooooon Studencie");

        for(int i=0; i<owoce.length; i++){
            if(owoce[i] != null){
                Owoc tmp = owoce[i];
                owoce[i] = null;
                return tmp;
            }
        }
        return null;
    }

    private static Drzewo diz;

    public static Drzewo makeDrzewo(String nazwa){
        if(nazwa.equals("dobra i zla")){
            if(diz == null)
                diz = new Drzewo(nazwa);
            return diz;
        }else
            return new Drzewo(nazwa);
    }
}


