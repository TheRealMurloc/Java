package ppj.zad05;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Fain {
	static StringBuilder sb = new StringBuilder("");

	public static void main(String[] args) {
		FileInputStream fis = null;
		int x =0;
		try {

			fis = new FileInputStream("C:\\Users\\Ppatryk27\\Desktop\\serverLog.txt");
			int tmp;
			while ((tmp = fis.read()) != -1) {
				sb.append((char) tmp);

			}
			System.out.print(sb);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	
	
	
//	String tab1[] = new String[100];
//	String tab2[] = new String[100];
//	String tab3[] = new String[100];
//	
//	Pattern p6 = Pattern.compile("\\d{2}.\\d.\\d.\\d{3}");
//	Matcher m6 = p6.matcher(sb);
//	while(m6.find())
//	{
//		tab1[x] = m6.group();
//		x++;
//		if(x == 100)
//			break;
//	}
//
//
//	x = 0;
//	Pattern p7 = Pattern.compile("\\d{2}/\\d{2}/\\d{4}");
//	Matcher m7 = p7.matcher(sb);
//	while(m7.find())
//	{
//		tab2[x] = m7.group();
//		x++;
//		if(x == 100)
//			break;
//	}
//	x = 0;
//	Pattern p8 = Pattern.compile(">.*[.]");
//	Matcher m8 = p8.matcher(sb);
//	while(m8.find())
//	{
//		tab3[x] = m8.group();
//		x++;
//		if(x == 100)
//			break;
//	}
//		
	}
	

}