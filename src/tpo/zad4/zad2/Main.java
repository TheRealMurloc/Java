package tpo.zad4.zad2;

import java.awt.Dimension;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.Hashtable;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
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

public class Main extends JFrame
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3039942522705769789L;
	private static final String SUBSCRIBER_NAME = "sub1"; 

	public static void main(String[] args) throws NamingException, JMSException 
	{
		new Main();
	}
	
	JList<String> list;
	DefaultListModel<String> listModel;
	String nick = null;
	MessageProducer producer;
	Session session;
	
	public Main() throws NamingException, JMSException
	{
		setupSplitPane();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		JSplitPane splitPane = setupSplitPane();
		add(splitPane);
		setMinimumSize(new Dimension(550, 540));
		pack();
		setVisible(true);
		
		Hashtable<String, String> properties = new Hashtable<>();
		properties.put(Context.INITIAL_CONTEXT_FACTORY, "org.exolab.jms.jndi.InitialContextFactory");
		properties.put(Context.PROVIDER_URL, "tcp://localhost:3035/");
		Context context = new InitialContext(properties);
		
		Topic topic = (Topic) context.lookup("topic1");
		Connection con = ((ConnectionFactory) context.lookup("ConnectionFactory")).createConnection();
		con.start();
		session = con.createSession(false, Session.AUTO_ACKNOWLEDGE);
		MessageConsumer consumer = session.createDurableSubscriber(topic, SUBSCRIBER_NAME);
		producer = session.createProducer(topic);
		consumer.setMessageListener(message ->
		{
			TextMessage tm = (TextMessage) message;
			try 
			{
				listModel.addElement(tm.getText());
			} catch (JMSException e) 
			{
				e.printStackTrace();
			}
		});
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
					String msg = nick + ": " + field.getText();
					try 
					{
						TextMessage message = session.createTextMessage();
						message.setText(msg);
						producer.send(message);
					} catch (JMSException e1) 
					{
						e1.printStackTrace();
					}
					field.setText(null);
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
}
