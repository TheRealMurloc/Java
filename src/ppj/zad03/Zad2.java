package ppj.zad03;

import java.io.IOException;
import java.io.InputStream;

public class Zad2 {

    public static void main(String[] args) {

        InputStream strumienWe = System.in;


        try {
            int znak;
            while((znak = strumienWe.read()) != 13 && znak != -1){
                System.out.println((char)znak + " - " + znak);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}

