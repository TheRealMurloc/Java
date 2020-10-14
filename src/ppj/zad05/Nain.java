package ppj.zad05;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Nain {

	public static void Main(String[] args) {
		int iloscSlow = 0;
		int iloscDat = 0;
		int iloscLat= 0;
		int iloscSlowNaDuzaLitere = 0;
		int iloscKropek = 0;
		
		String s = "Jan III Sobieski herbu Janina (ur. 17 sierpnia 1629 w Olesku, zm. 17 czerwca 1696 w Wilanowie) � kr�l Polski i wielki ksi��� litewski od 1674, hetman wielki koronny od 1668, hetman polny koronny od 1666, marsza�ek wielki koronny od 1665, chor��y wielki koronny od 1656.";
		System.out.println(s);
		String wyrazenie = "\\w*\\s";

		Pattern p = Pattern.compile(wyrazenie);
		Matcher m = p.matcher(s);
		while (m.find()) {
			iloscSlow++;
			
		}
		System.out.println("Ilosc slow: " +iloscSlow);
		
		String wyrazenie1 = "\\d{2}\\s\\w*\\s\\d{4}";
		Pattern p1 = Pattern.compile(wyrazenie1);
		Matcher m1 = p1.matcher(s);
		while (m1.find()) {
			iloscDat++;
		}
		System.out.println("Ilosc dat: " +iloscDat);
		
		String wyrazenie2 = "\\d{4}";
		Pattern p2 = Pattern.compile(wyrazenie2);
		Matcher m2 = p2.matcher(s);
		while (m2.find()) {
			iloscLat++;
		}
		System.out.println("Ilosc lat: " +iloscLat);
		
		String wyrazenie3 = "\\p{Upper}\\p{Lower}";
		Pattern p3 = Pattern.compile(wyrazenie3);
		Matcher m3 = p3.matcher(s);
		while (m3.find()) {
			iloscSlowNaDuzaLitere++;
		}
		System.out.println("Ilosc slow na duza litere: " +iloscSlowNaDuzaLitere);
		
		String wyrazenie4 = "[.]";
		Pattern p4 = Pattern.compile(wyrazenie4);
		Matcher m4 = p4.matcher(s);
		while (m4.find()) {
			iloscKropek++;
		}
		System.out.println("Ilosc kropek: " +iloscKropek);
	}
}