/**
 *
 *  @author Skibiński-Kołtun Patryk S17203
 *
 */

package tpo.zad2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Currency;
import java.util.Locale;
import com.google.gson.JsonParser;

public class Service 
{
	String kraj;
	String currencyCode;

	public Service(String kraj) 
	{
		this.kraj = kraj;
		this.currencyCode = getCurrencyCode(kraj);
	}

	public String getWeather(String city) 
	{
		return getTextFromHttp("http://api.openweathermap.org/data/2.5/weather?q=" + city
				+ "&APPID=c791ff2c8a30a717787df1b2510df068");
	}

	public Double getNBPRate() 
	{
		if(this.kraj.equals("Poland"))
			return 1d;
		String response = getTextFromHttp("http://api.nbp.pl/api/exchangerates/rates/A/" + this.currencyCode + "/");
		if(response == null)
			response = getTextFromHttp("http://api.nbp.pl/api/exchangerates/rates/B/" + this.currencyCode + "/");
		if(response == null)
			return null;
		else
			return new JsonParser().parse(response).getAsJsonObject().get("rates").getAsJsonArray().get(0).getAsJsonObject().get("mid").getAsDouble();
	}

	public Double getRateFor(String currency) 
	{
		String response = getTextFromHttp("https://api.exchangeratesapi.io/latest?base=" + currency + "&symbols=" + this.currencyCode);
		return new JsonParser().parse(response).getAsJsonObject().get("rates").getAsJsonObject().get(this.currencyCode).getAsDouble();
	}
	
	private String getCurrencyCode(String kraj) 
	{
		for (String iso : Locale.getISOCountries()) 
		{
			Locale locale = new Locale("", iso);
			if (locale.getDisplayCountry(Locale.ENGLISH).equals(kraj))
				return Currency.getInstance(locale).getCurrencyCode();
		}
		return null;
	}
	
	private String getTextFromHttp(String urlString)
	{
		URL url;
		try 
		{
			url = new URL(urlString);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));

			StringBuilder sb = new StringBuilder();
			while (true) 
			{
				String line = reader.readLine();
				if (line == null)
					break;
				else
					sb.append(line);

			}
			return sb.toString();
		} catch (Exception e) {
			return null;
		}
	}
}
