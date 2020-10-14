package utp.zad12;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

public class TravelData 
{
	static 
	{
		Dictionary.initialize();
	}
	List<Offer> offers = new ArrayList<>();

	public TravelData(File dataDir) 
	{
		File file[] = dataDir.listFiles();
		for(File i : file)
		{
			try (Scanner sc = new Scanner(i))
			{
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); 
				while(sc.hasNextLine())
				{
					String str = sc.nextLine();
					String dane[] = str.split("\t");
					String locale = dane[0];
					locale = locale.replaceAll("_", "-");
					Locale localeObj = Locale.forLanguageTag(locale);
					String country = dane[1];
					country = translateCountry(country, localeObj, Locale.ENGLISH);
					Date departure = sdf.parse(dane[2]);
					Date arrival = sdf.parse(dane[3]);
					Places place = Places.valueOf(Dictionary.get(localeObj.getLanguage()).translateToEnglish(dane[4]).toUpperCase());	
					Double price = (Double)NumberFormat.getNumberInstance(localeObj).parse(dane[5]);
					String currency = dane[6];
					offers.add(new Offer(country, departure, arrival, place, price, currency));
				}
			} catch (FileNotFoundException | ParseException e) 
			{
				e.printStackTrace();
			}
		}
	}

	public List<String> getOffersDescriptionsList(String locale, String dateFormat) 
	{
		List<String> description = new ArrayList<>();
		Locale localeObj = Locale.forLanguageTag(locale.replaceAll("_", "-"));
		SimpleDateFormat sdf = new SimpleDateFormat(dateFormat); 
		for(Offer i : offers)
		{
			StringBuilder sb = new StringBuilder();
			sb.append(translateCountry(i.getCountry(), Locale.ENGLISH, localeObj));
			sb.append(' ');
			sb.append(sdf.format(i.getDeparture()));
			sb.append(' ');
			sb.append(sdf.format(i.getArrival()));
			sb.append(' ');
			ResourceBundle.getBundle("lang", localeObj).getString(i.getPlace().toString());
			sb.append(' ');
			sb.append(NumberFormat.getNumberInstance(localeObj).format(i.getPrice()));
			sb.append(' ');
			sb.append(i.getCurrency());	
			description.add(sb.toString());
		}
		return description;
	}
	
	public String translateCountry(String country, Locale locale, Locale translation)
	{
		for(Locale loc : Locale.getAvailableLocales())
		{
			if(loc.getDisplayCountry(locale).equals(country))
			{
				return loc.getDisplayCountry(translation);
			}
		}
		return null;
	}
	
	public List<Offer> getOffers()
	{
		return offers;
	}

}
