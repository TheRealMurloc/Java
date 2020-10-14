package utp.zad12;

import java.util.Date;

public class Offer 
{
	String country;
	Date departure;
	Date arrival;
	Places place;
	Double price;
	String currency;
	
	public Offer(String country, Date departure, Date arrival, Places place, Double price,
			String currency) 
	{
		this.country = country;
		this.departure = departure;
		this.arrival = arrival;
		this.place = place;
		this.price = price;
		this.currency = currency;
	}

	public String getCountry() 
	{
		return country;
	}

	public Date getDeparture() 
	{
		return departure;
	}

	public Date getArrival() 
	{
		return arrival;
	}

	public Places getPlace() 
	{
		return place;
	}

	public Double getPrice() 
	{
		return price;
	}

	public String getCurrency() 
	{
		return currency;
	}
	
	
}
