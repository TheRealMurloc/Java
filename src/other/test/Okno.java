package other.test;

import java.awt.Dimension;
import java.io.IOException;
import java.nio.ByteBuffer;

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

public class Okno extends JFrame
{
	JList<String> list;
	DefaultListModel<String> listModel;
	String dane;

	public Okno()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Sprawdzanie języka");
		setResizable(false);
		JSplitPane splitPane = setupSplitPane();
		add(splitPane);
		setMinimumSize(new Dimension(300, 50));
		pack();
		setVisible(true);
	}
	
	private JSplitPane setupSplitPane() 
	{
		JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
		splitPane.setDividerSize(0);
		splitPane.setDividerLocation(450);
		JTextField field = new JTextField();
		field.setPreferredSize(new Dimension(250, 30));
		JPanel panel = new JPanel();
		panel.add(field);
		JButton button = new JButton("Check");
		button.addActionListener(a -> {
			if(!field.getText().isEmpty())
			{
				this.dane = field.getText().toString();
			}
		});
		panel.add(button);
		splitPane.setBottomComponent(panel);
		splitPane.setBorder(BorderFactory.createEmptyBorder(25, 20, 25, 20));
		return splitPane;
	}
}
