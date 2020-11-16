package other.matcher;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

	public static void main(String[] args) {
		String str = "12-Sty-2011";
		Pattern p = Pattern.compile("\\d\\d-\\D{3}-\\d{4}");
		Matcher m = p.matcher(str);
		System.out.println(str);
		boolean b = m.find();
		System.out.println(b);
	}
}
