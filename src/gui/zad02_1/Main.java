package gui.zad02_1;

import java.util.ArrayList;

public class Main 
{
	public static void main(String[] args)
	{
		ArrayList<Figura> lista = new ArrayList<Figura>();
		lista.add(new Kwadrat(10, "Czerwony"));
		System.out.println(lista);
	}

}
