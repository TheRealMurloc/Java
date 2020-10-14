package ppj.zad02;

public class MethodCurrier
{
    public void setValue(int wrt)
    {
        System.out.println(wrt);
        System.out.println("integer");
    }
    public void setValue(float wrt)
    {
        System.out.println(wrt);
        System.out.println("float");
    }
    public void setValue(Liczba wrt)
    {
        wrt.wyswietlWartosc();
        wrt.przypiszWartosc(10);
        wrt.wyswietlWartosc();
    }
}
