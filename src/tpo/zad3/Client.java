/**
 *
 *  @author Skibiński-Kołtun Patryk S17203
 *
 */

package tpo.zad3;

import java.awt.Dimension;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

public class Client extends JFrame implements Runnable 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5441472020081114115L;

	public static void main(String[] args) 
	{
		new Client(new InetSocketAddress("127.0.0.1", 25000));
	}
	
	JList<String> list;
	DefaultListModel<String> listModel;
	SocketChannel socket;
	Selector selector;
	ByteBuffer buf = ByteBuffer.allocate(1024);
	String nick = null;

	public Client(InetSocketAddress s)
	{
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle(nick);
		setResizable(false);
		JSplitPane splitPane = setupSplitPane();
		add(splitPane);
		setMinimumSize(new Dimension(550, 540));
		pack();
		setVisible(true);
		try 
		{
			socket = SocketChannel.open(s);
			selector = Selector.open();
			socket.configureBlocking(false);
			socket.register(selector, socket.validOps());
			Thread t = new Thread(this);
			t.start();
		} catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
	
	private JSplitPane setupSplitPane() 
	{
		JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
		splitPane.setDividerSize(0);
		splitPane.setDividerLocation(450);
		splitPane.setTopComponent(setupList());
		JTextField field = new JTextField();
		field.addFocusListener(new FocusListener() 
		{

            @Override
            public void focusLost(FocusEvent e) 
            {
                if(field.getText().isEmpty() && nick == null) 
                {
                    field.setText("Podaj swoje imie");
                }
            }

            @Override
            public void focusGained(FocusEvent e) 
            {
                if(field.getText().equals("Podaj swoje imie")) 
                {
                    field.setText("");
                }
            }
        });
		field.setText("Podaj swoje imie");
		field.setPreferredSize(new Dimension(512, 30));
		JPanel panel = new JPanel();
		panel.add(field);
		JButton button = new JButton("Wyślij");
		button.addActionListener(a -> {
			if(!field.getText().isEmpty())
			{
				if(nick == null)
				{
					this.nick = field.getText().toString();
					setTitle(nick);
					field.setText(null);
				}
				else
				{
					try 
					{
						String msg = nick + ": " + field.getText();
						socket.write(ByteBuffer.wrap(msg.getBytes()));
						field.setText(null);
					} catch (IOException e) 
					{
						e.printStackTrace();
					}
				}
			}
		});
		panel.add(button);
		splitPane.setBottomComponent(panel);
		splitPane.setBorder(BorderFactory.createEmptyBorder(25, 20, 25, 20));
		return splitPane;
	}
	
	private JScrollPane setupList() 
	{
		listModel = new DefaultListModel<>();
		list = new JList<>(listModel);
		list.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		return new JScrollPane(list);
	}
	
	@Override
	public void run() 
	{
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
			listModel.addElement(builder.toString());
			
		} catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
	
	

}
