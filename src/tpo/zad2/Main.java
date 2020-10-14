/**
 *
 *  @author Skibiński-Kołtun Patryk S17203
 *
 */

package tpo.zad2;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
	  
	String kraj;
	String miasto;
	String waluta;
	Scanner scan = new Scanner(System.in);
	System.out.println("Podaj kraj po angielsku:");
	kraj = scan.nextLine();
	System.out.println("Podaj miasto po angielsku:");
	miasto = scan.nextLine();
	System.out.println("Podaj skrót waluty z duzych liter:");
	waluta = scan.nextLine();
	scan.close();
		  
    Service s = new Service(kraj);
    String weatherJson = s.getWeather(miasto);
    Double rate1 = s.getRateFor(waluta);
    Double rate2 = s.getNBPRate();
    
    System.out.println("Pogoda: (Json)");
    System.out.println(weatherJson);
    System.out.println("Kurs Waluty " + s.currencyCode + " do " + waluta + " :");
    System.out.println(rate1);
    System.out.println("Kurs złotego wobec " + s.currencyCode + " :");
    System.out.println(rate2);

    // Niestety nie umiem zrobic tego w GUI :c, ale zrobilem prowizorycznie w konsoli :D
  }
}
