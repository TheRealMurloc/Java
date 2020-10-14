package ppj.zad05;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
	static String str="";
	public static void main(String[] args) {
		FileInputStream fis = null;
		
		try 
		{
			fis = new FileInputStream("C:\\Users\\Ppatryk27\\Desktop\\telFormat.txt");
			int x;
			while((x = fis.read()) != -1)
			{
				str+= (char)x;
				//System.out.print((char)x);
			}
		} catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		} catch (IOException e) 
		{
			e.printStackTrace();
		}
		
		Pattern p = Pattern.compile("[^a-zA-Z]");
		Matcher m = p.matcher(str);
		System.out.println(str);
		boolean b = m.find();
		System.out.println(b);

	}

}
