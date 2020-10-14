package skj.zad2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketException;
import java.util.Scanner;

public class Klient 
{
	boolean odebrano = false;
	Integer tcpPort;
	public static final int PORT = 9000;
	static InetAddress ip;
	
	public static void main(String[] args) throws Exception
	{
		ip = InetAddress.getLocalHost();
		Klient k = new Klient();
		k.startKlient(ip);
	}
	public void startNasluch(DatagramSocket datagramSocket)
	{
		Thread t = new Thread(new Nasluch(datagramSocket));
		t.start();
	}
	public void startKlient(InetAddress ip)
	{
		DatagramSocket datagramSocket = null;
		int port;
		try 
		{
			datagramSocket = new DatagramSocket(PORT);
			System.out.println("Utworzono socket " + datagramSocket);
			startNasluch(datagramSocket);
			System.out.println("Utworzono socket nasluchujacy ");
			String wiadomosc;
			byte[] buf = new byte[256];
			while(true)
			{
				while(!odebrano)
				{
					Scanner sc = new Scanner(System.in);
					System.out.print("Podaj numer portu na ktory chcesz wyslac pakiet UDP ");
					port = Integer.parseInt(sc.nextLine());	
					DatagramPacket packet = new DatagramPacket(buf, buf.length, ip, port);
					System.out.println("Utworzono pakiet");
					datagramSocket.send(packet);
					System.out.println("Wyslano pakiet");
					Thread.sleep(1000);
				}
				Scanner sc = new Scanner(System.in);
				System.out.print("Napisz co chcesz wyslac do serwera przez port TCP: ");
				wiadomosc = sc.nextLine();
				sc.close();
				
				Socket socket = new Socket(ip, tcpPort);
				System.out.println("Podlaczono do " + socket);
				
				PrintWriter printWriter = new PrintWriter(socket.getOutputStream());
				
				BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				printWriter.println(wiadomosc);
				System.out.println("Wyslano wiadomosc TCP");
				printWriter.flush();
				System.out.println("2");
				String wiadomoscOdSerwera;
				Thread.sleep(3000);
				if((wiadomoscOdSerwera = bufferedReader.readLine()) != null)
					System.out.println(wiadomoscOdSerwera);
				System.out.println("3");
				printWriter.close();
				System.out.println("4");
				socket.close();
				System.out.println("5");
				odebrano = false;
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
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	class Nasluch implements Runnable
	{
		DatagramSocket datagramSocket = null;
			
		public Nasluch(DatagramSocket datagramSocket)
		{
			this.datagramSocket = datagramSocket;
		}
		@Override
		public void run() 
		{
			byte[] buf = new byte[256];
			int packetLength;
			DatagramPacket packet = new DatagramPacket(buf, buf.length);
			while(true)
			{
				try 
				{
					datagramSocket.receive(packet);
					packetLength = packet.getLength();
					String message = new String(packet.getData(), 0, packetLength, "utf8");
					System.out.println("Otrzymano port TCP: " + message);
					tcpPort = Integer.parseInt(message);
					odebrano = true;

				} catch (IOException e) 
				{
					e.printStackTrace();
				}
			}
		}
		
	}

}
