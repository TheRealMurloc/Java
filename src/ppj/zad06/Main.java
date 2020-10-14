package ppj.zad06;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void zDnia(ArrayList<Wiadomosc> wiadomosci,int dzien){
        for(Wiadomosc a:wiadomosci)
            if(a.getDzien()==dzien)
            System.out.println(a);
    }
    public static void zMiesiaca(ArrayList<Wiadomosc> wiadomosci,int miesiac){
        for(Wiadomosc a:wiadomosci)
            if(a.getMiesiac()==miesiac)
            System.out.println(a);
    }
    public static void zIP(ArrayList<Wiadomosc> wiadomosci,String ip){
        for(Wiadomosc a:wiadomosci)
            if(a.getIp().equals(ip))
            System.out.println(a);
    }
       
    public static void main(String[] args) {
        File plik=new File("C:\\Users\\Ppatryk27\\Desktop\\serverLog.txt");
        ArrayList<Wiadomosc> wiadomosci=new ArrayList<Wiadomosc>();
        try {
            Scanner czyt=new Scanner(plik);
            
            Pattern pattern =Pattern.compile("\\d{2,3}\\s{2}(\\d{1,2}).(\\d{2}).(\\d{4})\\s(\\d.\\d{2}.\\d{2}\\s\\w{2})\\s.\\s(\\w{4}|[(].*[)])\\s([(].*[)])[>]\\s(.*)");
            Matcher m;
            while(czyt.hasNextLine()){
                m=pattern.matcher(czyt.nextLine());
                System.out.println(m.find());
                wiadomosci.add(new Wiadomosc(Integer.parseInt(m.group(1)),Integer.parseInt(m.group(2)),Integer.parseInt(m.group(3)),m.group(4),m.group(5),m.group(6),m.group(7)));
            }
            czyt.close();
        } catch (FileNotFoundException e) {
        System.out.println("Nie ma pliku");
        }
        

        for(int i = 0; i < 418; i++)
        	System.out.println(wiadomosci.get(i));
        System.out.println(wiadomosci.size());
        System.out.println("Z DNIA");
        zDnia(wiadomosci,11);
        System.out.println("==========================");
        System.out.println("Z MIESIACA");
        zMiesiaca(wiadomosci,7);
        System.out.println("==========================");
        System.out.println("Z IP");
        zIP(wiadomosci,"10.0.2.143");
    }
}