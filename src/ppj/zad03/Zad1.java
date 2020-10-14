package ppj.zad03;

import java.io.IOException;
import java.io.InputStream;

public class Zad1 {

    public static void main(String[] args) {

        InputStream strumienWe = System.in;


        try {
            System.out.println((char)strumienWe.read());
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}

