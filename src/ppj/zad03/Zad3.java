package ppj.zad03;

import java.io.FileInputStream;

public class Zad3 {

    public static void main(String[] args) {

        try {
            FileInputStream fis = new FileInputStream("C:\\Users\\Ppatryk27\\Desktop\\text.txt");
            MojSkaner ms = new MojSkaner(fis);

            System.out.println(ms.odczytajDodatniaLiczbeCalkowita());
        } catch (Exception e) {
            e.printStackTrace();
        }






    }

}

