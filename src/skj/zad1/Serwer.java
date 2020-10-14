import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Serwer 
{
	static int liczbaGraczy = 0;
	static boolean aktywnaGra = false;
	static List<Integer> numery = new ArrayList<Integer>(); 
	ArrayList klientArraylist;
	static LinkedHashMap<Socket, String> mapaGraczy = new LinkedHashMap<Socket, String>();
	static LinkedHashMap<Socket, String> mapaGraczyTmp = new LinkedHashMap<Socket, String>();
	PrintWriter printWritter;
	public static void main(String[] args) 
	{
		Serwer s = new Serwer();
		s.startSerwer();	
	}
	
	public void startSerwer()
	{
		klientArraylist = new ArrayList();
		
		try 
		{
			ServerSocket serverSocket = new ServerSocket(5000);
			
			while(true)
			{
				Socket socket = serverSocket.accept();
				System.out.println("Slucham: " + serverSocket);
				printWritter = new PrintWriter(socket.getOutputStream());
				klientArraylist.add(printWritter);
				
				Thread t = new Thread(new SerwerKlient(socket));
				t.start();
			}
			
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	class SerwerKlient implements Runnable
	{
		Socket socket;
		BufferedReader bufferedReader;
		PrintWriter pw = null;
		
		public SerwerKlient(Socket socketKlient)
		{
			try
			{
				String imie;
				socket = socketKlient;
				bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				if((imie = bufferedReader.readLine()) != null)
				{
					mapaGraczy.put(socket, imie);
					System.out.println(imie + " Zostal polaczony. ");
					System.out.println("Lista graczy:");
					System.out.println(mapaGraczy.values());
					Iterator it = klientArraylist.iterator();
					while(it.hasNext())
					{
						pw = (PrintWriter) it.next();
						pw.println(imie + " dolaczyl do gry");
						pw.println("Lista graczy: " + mapaGraczy.values());
						pw.flush();
					}
				}
			} catch (Exception ex)
			{
				ex.printStackTrace();
			}
		}
		
		@Override
		public void run()
		{
			String str;
			
			try
			{
				while((str = bufferedReader.readLine()) != null)
				{
					if (!str.equalsIgnoreCase("q"))
					{
						if(str.endsWith(":gra"))
						{
							if(!aktywnaGra)
							{
								aktywnaGra = true;
								mapaGraczyTmp = (LinkedHashMap) mapaGraczy.clone();
								liczbaGraczy = mapaGraczy.size();
								String tmp[] = str.split(":");
								numery = new ArrayList<Integer>(); 
								numery.add(Integer.parseInt(tmp[1].trim()));
								mapaGraczyTmp.remove(socket);
								System.out.println("mapaGraczy aktualnie:");
								System.out.println(mapaGraczy);
								System.out.println("czekam na liczby od:");
								System.out.println(mapaGraczyTmp);
								System.out.println("Utworzono gre");
								
								if(mapaGraczyTmp.isEmpty())
								{
									Iterator it = klientArraylist.iterator();
									while(it.hasNext())
									{	
										pw = (PrintWriter) it.next();
										pw.println("Jestes sam w grze, nie uruchomie gry");
										pw.flush();
									}
									aktywnaGra = false;
									System.out.println("Zamknieto gre");
								}
							}
							else
							{
								if(mapaGraczyTmp.containsKey(socket))	
								{
									String tmp[] = str.split(":");
									numery.add(Integer.parseInt(tmp[1].trim()));
									mapaGraczyTmp.remove(socket);
									System.out.println("czekam na liczby od:");
									System.out.println(mapaGraczyTmp);
								}
								
								if(mapaGraczyTmp.isEmpty())
								{
									System.out.println("Dodaje numery graczy");
									int x = 0;
									int j = 0;
									for(int i = 0; i <= numery.size()-1; i++)
									{
										x += numery.get(i);
										TimeUnit.SECONDS.sleep(1);
										System.out.println("dodaje, teraz mam " + x + " przeskokow");
									}
									System.out.println("Losuje");
									while(x != 0)
									{
										j++;
										x--;
										TimeUnit.SECONDS.sleep(1);
										System.out.println("pozostalo przeskokow: " + x);
										if(j > liczbaGraczy)
										{	
											j=1;
										}
										System.out.println("teraz jestem na osobie : " + (String) mapaGraczy.values().toArray()[j-1]);
										
									}
									String wygrany = null;
									wygrany = (String) mapaGraczy.values().toArray()[j-1];
									System.out.println("Wygral: " + wygrany);
									System.out.println("Wysylam wiadomosc o wygranej");
									Iterator it = klientArraylist.iterator();
									while(it.hasNext())
									{	
										pw = (PrintWriter) it.next();
										pw.println("Wygral gracz: " + wygrany);
										pw.flush();
									}
									aktywnaGra = false;
								}
							}
						}
						else
						{
							System.out.println("Odebrano >> " + str);
							
							Iterator it = klientArraylist.iterator();
							while(it.hasNext())
							{
								pw = (PrintWriter) it.next();
								pw.println(str);
								pw.flush();
							}
						}
					}
					else
					{
						String x = mapaGraczy.get(socket);
						mapaGraczy.remove(socket);
						System.out.println("Odebrano >> " + str);
						System.out.println(x + " Rozlaczyl sie");
						Iterator it = klientArraylist.iterator();
						while(it.hasNext())
						{
							pw = (PrintWriter) it.next();
							pw.println(x + " Rozlaczyl sie");
							pw.println("Pozostali gracze: " + mapaGraczy.values());
							pw.flush();
						}
					}
				}
			} catch (Exception e)
			{
				
			}
		}
	}	
}

