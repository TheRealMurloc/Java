package gui.tut;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Okno extends JFrame implements ActionListener
{
	public Okno()
	{
		//Okno
		setSize(300, 200);
		setTitle("Moje okienko");
		//Button
		setLayout(null);
		JButton bPodajDate = new JButton("Podaj date");
		bPodajDate.setBounds(100, 50, 100, 20);
		add(bPodajDate);
		bPodajDate.addActionListener(this);
	}
	
	public static void main(String[] args) 
	{
		//Okno
		Okno okno = new Okno();
		okno.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		okno.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		System.out.println(new Date());
	}

}