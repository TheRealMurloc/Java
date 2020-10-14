/**
 *
 *  @author Skibiński-Kołtun Patryk S17203
 *
 */

package tpo.zad3;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

public class Server implements Runnable
{
	public static void main(String[] args) 
	{
		new Server(25000);
	}
	
	ServerSocketChannel socket;
	Selector selector;
	ByteBuffer buf = ByteBuffer.allocate(1024);
	
	public Server(int port)
	{
		try 
		{
			socket = ServerSocketChannel.open();
			socket.bind(new InetSocketAddress(port));
			selector = Selector.open();
			socket.configureBlocking(false);
			socket.register(selector, SelectionKey.OP_ACCEPT);
			Thread t = new Thread(this);
			t.start();
			
		} catch (IOException e) 
		{
			e.printStackTrace();
		}
	}

	@Override
	public void run() 
	{
		System.out.println("Uruchomiono serwer *boop*");
		while(true)
		{
			try 
			{
				selector.select();
				Iterator<SelectionKey> keys = selector.selectedKeys().iterator();
				while(keys.hasNext())
				{
					SelectionKey key = keys.next();
					keys.remove();
					if(key.isAcceptable())
					{
						connAccept(key);
					}
					if(key.isReadable())
					{
						read(key);
					}
				}
				
			} catch (IOException e) 
			{
				e.printStackTrace();
			}
		}
		
	}
	private void connAccept(SelectionKey key)
	{
		try 
		{
			SocketChannel channel = socket.accept();
			channel.configureBlocking(false);
			channel.register(selector, SelectionKey.OP_READ);
			System.out.println("Nawiazano nowe polaczenie");
			
		} catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
	
	private void read(SelectionKey key)
	{
		SocketChannel sock = (SocketChannel)key.channel();
		try 
		{
			buf.clear();
			StringBuilder builder = new StringBuilder();
			while(sock.read(buf) != 0)
			{
				buf.flip();
				builder.append(new String(buf.array(), 0, buf.limit()));
			}
			broadcast(builder.toString());
			
		} catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
	
	private void broadcast(String msg)
	{
		ByteBuffer puff = ByteBuffer.wrap(msg.getBytes());
		for(SelectionKey k : selector.keys())
		{
			if(k.channel()instanceof SocketChannel && k.isValid())
			{
				SocketChannel sock = (SocketChannel)k.channel();
				try 
				{
					sock.write(puff);
					puff.flip();
				} catch (IOException e) 
				{
					e.printStackTrace();
				}
			}
		}
	}
}
