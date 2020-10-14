package skj.zad2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Serwer 
{
	Map<InetAddress, ArrayList<Integer>> mapa = new HashMap<InetAddress, ArrayList<Integer>>();
	public static void main(String[] args) throws Exception
	{
		InetAddress ip = InetAddress.getLocalHost();
		Serwer n = new Serwer();
		n.startNasluch(11000, ip);
		n.startNasluch(12000, ip);
		n.startNasluch(13000, ip);
	}
	
	public void startNasluch(int port, InetAddress ip)
	{
		Thread t = new Thread(new Nasluch(port, ip));
		t.start();
	}
	
	class Nasluch implements Runnable
	{
		int port;
		InetAddress ip;
			
		public Nasluch(int port, InetAddress ip)
		{
			this.port = port;
			this.ip = ip;
		}
		
		
		@Override
		public void run() 
		{
			ArrayList<Integer> test = new ArrayList<Integer>();
			test.add(11000);
			test.add(12000);
			test.add(13000);
			Integer tcpPort = (int)(Math.random() * 45000) + 10000;
			try 
			{
				System.out.println("Otwieram port " + port);
				DatagramSocket datagramSocket = new DatagramSocket(port, ip);
				byte[] buf = new byte[256];
				DatagramPacket packet = new DatagramPacket(buf, buf.length);
				while(true)
				{
					datagramSocket.receive(packet);
					System.out.println("Odebralem pakiet na porcie " + port + " od " + packet.getAddress());
					if(mapa.containsKey(packet.getAddress()))
					{
						if(port == 13000)
						{
							mapa.get(packet.getAddress()).add(port);
							System.out.println("Sprawdzam");
							if(mapa.get(packet.getAddress()).equals(test))
							{
								mapa.get(packet.getAddress()).clear();
								System.out.println("Otwieram tcp");
								System.out.println(tcpPort);
								byte[] tcpInfo = new byte[256];
								tcpInfo = tcpPort.toString().getBytes();
								System.out.println(packet.getAddress());
								System.out.println(packet.getPort());
								DatagramPacket infoPacket = new DatagramPacket(tcpInfo, tcpInfo.length, packet.getAddress(), packet.getPort());
								System.out.println("Utworzono pakiet");
								datagramSocket.send(infoPacket);
								System.out.println("Wyslalem pakiet info tcp");
								
								ServerSocket serverSocket = new ServerSocket(tcpPort);
								Socket socket = serverSocket.accept();
								System.out.println("Slucham: " + serverSocket);
								PrintWriter printWriter = new PrintWriter(socket.getOutputStream());
								
								BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
								String secretMessage;
								Thread.sleep(1000);
								if((secretMessage = bufferedReader.readLine()) != null)
								{
									System.out.println(secretMessage);
								}
								printWriter.println("Otrzymano wiadomosc - Serwer");
								System.out.println("Wyslano wiadomosc TCP");
							}
							else
							{
								mapa.get(packet.getAddress()).clear();
							}
						}
						else
						{
							mapa.get(packet.getAddress()).add(port);
						}
					}
					else
					{
						ArrayList<Integer> porty = new ArrayList<Integer>();
						porty.add(port);
						mapa.put(packet.getAddress(), porty);
					}			
				}
			
			} 
			catch (SocketException e) 
			{
				e.printStackTrace();
			}
			catch (IOException e) 
			{
				e.printStackTrace();
			} 
			catch (InterruptedException e) 
			{
				e.printStackTrace();
			}
		}
		
	}

}
