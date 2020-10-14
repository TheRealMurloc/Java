package utp.zad12;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;

public class Dictionary 
{
	Map<String, String> aToB = new HashMap<>();
	Map<String, String> bToA = new HashMap<>();
	
	public void addNewWord(String inA, String inB)
	{
		aToB.put(inA, inB);
		bToA.put(inB, inA);
	}
	
	public String translateFromEnglish(String inA)
	{
		return aToB.get(inA);
	}
	
	public String translateToEnglish(String inB)
	{
		return bToA.get(inB);
	}
	
	static Map<String, Dictionary> dictionaries = new HashMap<>();
	
	public static Dictionary get(String language)
	{
		return dictionaries.get(language);
	}
	
	public static void initialize()
	{
		initializeLanguage("pl");
		initializeLanguage("en");
	}
	
	private static void initializeLanguage(String language)
	{
		ResourceBundle pl = ResourceBundle.getBundle("lang", new Locale(language));
		Enumeration<String> minutaCiszyDlaEnumeratorow = pl.getKeys();
		Dictionary dpl = new Dictionary();
		while(minutaCiszyDlaEnumeratorow.hasMoreElements())
		{
			String key = minutaCiszyDlaEnumeratorow.nextElement();
			String translation = pl.getString(key);
			dpl.addNewWord(key, translation);
		}
		dictionaries.put(language, dpl);
	}
	
}
