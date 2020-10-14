package ppj.zad02;

public class Cplx {
    private double rzeczywista;
    private double urojona;

    public Cplx(double rzeczywista, double urojona)
    {
        this.rzeczywista = rzeczywista;
        this.urojona = urojona;
    }
    public void add(Cplx liczba){
        rzeczywista+=liczba.rzeczywista;
        urojona+=liczba.urojona;
    }

    public void sub(Cplx liczba){
        rzeczywista-=liczba.rzeczywista;
        urojona-=liczba.urojona;
    }

    public void mul(Cplx liczba){
        rzeczywista=rzeczywista*liczba.rzeczywista-urojona*liczba.urojona;
        urojona=rzeczywista*liczba.urojona-urojona*liczba.rzeczywista;
    }

    public void inc(){
        rzeczywista++;
    }

    public void show(){
        System.out.println(rzeczywista+" + "+urojona+"i");
    }






}
