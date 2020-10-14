package ppj.zad02;

public class Main
{
    public static void main(String[] args)
    {
		/*
		MethodCurrier mc = new MethodCurrier();
		mc.setValue(5);
		mc.setValue(3.14f);
		mc.setValue('a');
		mc.setValue((byte)10);
		Liczba liczba = new Liczba();
		liczba.przypiszWartosc(2);
		mc.setValue(liczba);
		*/
        Osoba Patryk = new Osoba("Patryk","Skibinski-Koltun",1997);
//		Patryk.imie = "Patryk";
//		Patryk.nazwisko = "Skibinski-Koltun";
//		Patryk.rokUrodzenia = 1997;
        Patryk.show();
        Cplx l1 = new Cplx(1, 2);
        Cplx l2 = new Cplx(0.3, 1.2);
        Cplx l3 = new Cplx(1., 2.3);

        l1.show();
        l2.show();
        l3.show();

        l1.add(l2);
        l2.mul(l3);
        l3.sub(l1);

        l1.show();
        l2.show();
        l3.show();
    }
}
