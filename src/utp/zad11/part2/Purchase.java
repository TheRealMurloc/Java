/**
 *
 *  @author Skibiński-Kołtun Patryk S17203
 *
 */

package utp.zad11.part2;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.beans.PropertyVetoException;
import java.beans.VetoableChangeListener;
import java.beans.VetoableChangeSupport;

public class Purchase 
{
	private String prod;
	private String data;
	private double price;
	private VetoableChangeSupport vsupp = new VetoableChangeSupport(this);
	private PropertyChangeSupport csupp = new PropertyChangeSupport(this);
	
	public Purchase(String prod, String data, double price) 
	{
		this.prod = prod;
		this.data = data;
		this.price = price;
	}

	public String getProd() 
	{
		return prod;
	}

	public void setProd(String prod) 
	{
		this.prod = prod;
	}

	public String getData() 
	{
		return data;
	}

	public void setData(String data) 
	{
		csupp.firePropertyChange("data", this.data, data);
		this.data = data;
	}

	public double getPrice() 
	{
		return price;
	}

	public void setPrice(double price) throws PropertyVetoException
	{
		vsupp.fireVetoableChange("price", this.price, price);
		this.price = price;
	}
	
	public void addPropertyChangeListener(PropertyChangeListener l)
	{
		csupp.addPropertyChangeListener(l);
	}
	
	public void addVetoableChangeListener(String str, VetoableChangeListener l)
	{
		vsupp.addVetoableChangeListener(str, l);
	}
	
	@Override
	public String toString()
	{
		return "Purchase [prod=" + getProd() + ", data=" + getData() + ", price=" + getPrice() + "]";
	}

	
	
}  
