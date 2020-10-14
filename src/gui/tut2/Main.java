package gui.tut2;

import java.awt.*;
import javax.swing.*;

public 
	class Main{
	public static void main(String[] args) {

		javax.swing.SwingUtilities.invokeLater(
			new Runnable(){
				public void run(){
					createAndShowGUI();
				}
			}
		);
	}
	
	public Main(){
		
	}
	
	public static void createAndShowGUI(){
		JFrame jf = new JFrame("test");
		jf.setPreferredSize(new Dimension(700, 300));
		jf.setLayout(new BorderLayout());

//		JTextArea textArea = new JTextArea("JTextArea1", 5, 20);
//		jf.add(textArea, BorderLayout.EAST);
//		textArea.setEditable(false);
//		JTextArea textArea1 = new JTextArea("JTextArea2", 5, 20);
//		jf.add(textArea1, BorderLayout.WEST);
//		textArea.setEditable(false);
//		JTextArea textArea2 = new JTextArea("JTextArea3", 5, 20);
//		jf.add(textArea2, BorderLayout.PAGE_END);
//		textArea.setEditable(false);
		JPanel jp1 = new MyJPanel( 
				new GridLayout(3, 1), Color.YELLOW
			);
			for(int i=1; i<=6; i++)
			{
				JTextField JTF = new JTextField("JTextField" + i);
				jp1.add(JTF);
				JTF.setEditable(false);
			}	
			jf.add(jp1, BorderLayout.NORTH);
			
			JPanel jp2 = new MyJPanel( 
					new GridLayout(1, 2), Color.YELLOW
				);	
			JTextArea textArea = new JTextArea("JTextArea1", 5, 20);
			jf.add(textArea, BorderLayout.WEST);
			textArea.setEditable(false);
			jf.add(jp2);		
			
		JPanel jp3 = new MyJPanel( 
			new GridLayout(3, 3), Color.YELLOW
		);
		for(int i=1; i<=20; i++)
		{
			JButton jb = new JButton(""+i);
			jp3.add(jb);
		}	
		jp2.add(jp3, BorderLayout.WEST);
		
		
		
		
		
		
		
		
		
		jf.pack();
		jf.setVisible(true);
	}
}


