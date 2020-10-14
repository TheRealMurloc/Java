import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Klient 
{
	public static final int PORT = 5000;
	public static final String IP = "127.0.0.1";
	
	BufferedReader bufferedReader;
	String imie;
	
	public static void main(String[] args) 
	{
		Klient k = new Klient();
		k.startKlient();

	}
	
	public void startKlient()
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("Podaj imie, a nastepnie sie przywitaj: ");
		imie = sc.nextLine();
		 
		 try
		 {
			Socket socket = new Socket(IP, PORT);
			System.out.println("Podlaczono do " + socket);
			
			PrintWriter printWriter = new PrintWriter(socket.getOutputStream());
			bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			printWriter.println(imie);
			Thread t = new Thread(new Odbiorca());
			t.start();
			
			while(true)
			{
				System.out.print(">> ");
				String str = sc.nextLine();
				if (!str.equalsIgnoreCase("q"))
				{
					if(str.endsWith(":gra"))
					{
						System.out.println("Jestes teraz w trybie gry, zostales rozlaczony z czatem na czas trwania rozgrywki");
						printWriter.println(imie + ": " + str);
						printWriter.flush();
					}
					else
					{
					printWriter.println(imie + ": " + str);
					printWriter.flush();
					}
				}
				else
				{		
					printWriter.println(str);
					printWriter.flush();
					printWriter.close();
					sc.close();
					socket.close();
				}
			}
			
		 } catch (Exception e)
		 {
			 
		 }
		 
	}
	
	public class Odbiorca implements Runnable
	{
		@Override
		public void run()
		{
			String wiadomosc;
			try
			{
				while((wiadomosc = bufferedReader.readLine()) != null)
				{
					String subString[] = wiadomosc.split(":");
					if(!subString[0].equals(imie))
					{
						System.out.println(wiadomosc);
						System.out.println(">> ");
					}
				}
			} catch (Exception e)
			{
				System.out.println("Polaczenie zakonczone");
			}
		}
	}
}


