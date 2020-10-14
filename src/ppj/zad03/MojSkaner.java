package ppj.zad03;

import java.io.IOException;
import java.io.InputStream;

public class MojSkaner {

    InputStream inputStream;

    public MojSkaner(InputStream inputStream){
        this.inputStream = inputStream;
    }

    public String odczytajSlowo(){
        String slowo = "";
        try {
            int znak;
            while((znak = inputStream.read()) != ' ' && znak != -1){
                slowo += (char) znak;
            }
            return slowo;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public String odczytajLinie(){
        String slowo = "";
        try {
            int znak;
            while((znak = inputStream.read()) != 13 && znak != -1)
            {
                slowo += (char) znak;
            }
            return slowo;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public int odczytajLiczbeCalkowita(){

        String liczba = "";
        boolean czyLiczba = false;

        try {
            int znak;
            while((znak = inputStream.read()) != -1){
                if((znak > '0' && znak < '9') || znak == '-'){
                    liczba += (char)znak;
                    czyLiczba = true;
                }else if(czyLiczba){
                    break;
                }
            }
            return Integer.parseInt(liczba);
        } catch (IOException e) {
            e.printStackTrace();
            return Integer.MIN_VALUE;
        }

    }

    public int odczytajDodatniaLiczbeCalkowita() throws Exception{

        String liczba = "";
        boolean czyLiczba = false;

        try {
            int znak;
            while((znak = inputStream.read()) != -1){
                if((znak >= '0' && znak <= '9') || znak == '-'){
                    liczba += (char)znak;
                    czyLiczba = true;
                }else if(czyLiczba){
                    break;
                }
            }
            if(liczba.startsWith("-"))
                throw new Exception("Liczba nie jest dodatnia");
            else
                return Integer.parseInt(liczba);
        } catch (IOException e) {
            e.printStackTrace();
            return Integer.MIN_VALUE;
        }

    }
}

