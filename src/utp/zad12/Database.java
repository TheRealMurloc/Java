package utp.zad12;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Database 
{

	private String url;
	private TravelData data;

	public Database(String url, TravelData data) 
	{
		this.url = url;
		this.data = data;
	}

	public void create() 
	{
		try 
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			try (Connection connection = getConnection();
					PreparedStatement statement = connection
							.prepareStatement("INSERT INTO offers VALUES(?, ?, ?, ?, ?, ?)")) {

				data.getOffers().forEach(offer -> {
					try 
					{
						statement.setString(1, offer.getCountry().toString());
						statement.setDate(2, new Date(offer.getDeparture().getTime()));
						statement.setDate(3, new Date(offer.getArrival().getTime()));
						statement.setString(4, offer.getPlace().toString());
						statement.setDouble(5, offer.getPrice());
						statement.setString(6, offer.getCurrency());
						statement.executeUpdate();
					} catch (SQLException e) 
					{
						e.printStackTrace();
					}
				});
			} catch (SQLException e1) 
			{
				e1.printStackTrace();
			}
		} catch (ClassNotFoundException e2) 
		{
			e2.printStackTrace();
		}
	}

	public Connection getConnection() throws SQLException 
	{
		return DriverManager.getConnection(url, "s17203", "oracle12");
	}

	public void showGui() 
	{

	}
}
