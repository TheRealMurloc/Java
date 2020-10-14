package gui.zad02_1;


public class Kolo extends Figura
{
    double r;

    public Kolo(double r, String kolor)
    {
        super(Figura.PI * r, 2 * Figura.PI * r, kolor);
        this.r = r;
    }

    @Override
    public String toString()
    {
        return "Koło o promieniu: " + r + ", Pole: " + super.pole + ", Obwód: " + super.obwod + ", Kolor: " + super.kolor;
    }

}
