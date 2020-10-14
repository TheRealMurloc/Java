package nai.zad3;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTextField;

public class Okno extends JFrame
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1616928446113118193L;
	JList<String> list;
	DefaultListModel<String> listModel;
	String text;
	float n;
	static WarstwaPerceptronow warstwa1;
	static double[] dane;

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
		//Tworzenie warstwy perceptronow
		warstwa1 = new WarstwaPerceptronow();
		warstwa1.tworzeniePerceptrona("POL");
		warstwa1.tworzeniePerceptrona("ENG");
		warstwa1.tworzeniePerceptrona("GER");
		//Wartosc N
		Scanner scan = new Scanner(System.in);
		System.out.println("Podaj wartość uczenia N");
		n = Float.parseFloat(scan.nextLine());
		scan.close();
		//Wczytywanie danych treningowych
		ArrayList<CzytaniePlikow> lista = new ArrayList<CzytaniePlikow>();
		lista.add(new CzytaniePlikow("polish\\1.txt", "POL"));
		lista.add(new CzytaniePlikow("polish\\2.txt", "POL"));
		lista.add(new CzytaniePlikow("polish\\3.txt", "POL"));
		lista.add(new CzytaniePlikow("polish\\4.txt", "POL"));
		lista.add(new CzytaniePlikow("polish\\5.txt", "POL"));
		lista.add(new CzytaniePlikow("polish\\6.txt", "POL"));
		lista.add(new CzytaniePlikow("polish\\7.txt", "POL"));
		lista.add(new CzytaniePlikow("polish\\8.txt", "POL"));
		lista.add(new CzytaniePlikow("polish\\9.txt", "POL"));
		lista.add(new CzytaniePlikow("polish\\10.txt", "POL"));
		lista.add(new CzytaniePlikow("english\\1.txt", "ENG"));
		lista.add(new CzytaniePlikow("english\\2.txt", "ENG"));
		lista.add(new CzytaniePlikow("english\\3.txt", "ENG"));
		lista.add(new CzytaniePlikow("english\\4.txt", "ENG"));
		lista.add(new CzytaniePlikow("english\\5.txt", "ENG"));
		lista.add(new CzytaniePlikow("english\\6.txt", "ENG"));
		lista.add(new CzytaniePlikow("english\\7.txt", "ENG"));
		lista.add(new CzytaniePlikow("english\\8.txt", "ENG"));
		lista.add(new CzytaniePlikow("english\\9.txt", "ENG"));
		lista.add(new CzytaniePlikow("english\\10.txt", "ENG"));
		lista.add(new CzytaniePlikow("german\\1.txt", "GER"));
		lista.add(new CzytaniePlikow("german\\2.txt", "GER"));
		lista.add(new CzytaniePlikow("german\\3.txt", "GER"));
		lista.add(new CzytaniePlikow("german\\4.txt", "GER"));
		lista.add(new CzytaniePlikow("german\\5.txt", "GER"));
		lista.add(new CzytaniePlikow("german\\6.txt", "GER"));
		lista.add(new CzytaniePlikow("german\\7.txt", "GER"));
		lista.add(new CzytaniePlikow("german\\8.txt", "GER"));
		lista.add(new CzytaniePlikow("german\\9.txt", "GER"));
		lista.add(new CzytaniePlikow("german\\10.txt", "GER"));
		for(int i = 0; i < 1500; i++)
		{
			for(int j = 0; j < lista.size(); j++)
			{
				dane = lista.get(j).count();
				warstwa1.layer.get(0).training(dane, lista.get(j).lang, n);
				warstwa1.layer.get(1).training(dane, lista.get(j).lang, n);
				warstwa1.layer.get(2).training(dane, lista.get(j).lang, n);
			}
		}
		System.out.println("Trenowanie zakonczone");
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
				this.text = field.getText().toString();
				double[] input = new double[26];
				for(int i = 0; i < text.length(); i++)
				{
					if(text.charAt(i) < 123 && text.charAt(i) > 96)
					{
						input[(text.charAt(i)-97)]++;
					}
					else
					{
						if(text.charAt(i) < 91 && text.charAt(i) > 64)
						{
							input[(text.charAt(i)-65)]++;
						}
					}
				}
				double vector = 0.0;
				for(int i = 0; i < input.length; i++)
				{
					vector += Math.pow(input[i], 2);
				}
				vector = Math.pow(vector, 0.5);
				for(int i = 0; i < input.length; i++)
				{
					input[i] = input[i]/vector;
				}
				if(warstwa1.layer.get(0).calculateY(input) > warstwa1.layer.get(1).calculateY(input) && warstwa1.layer.get(0).calculateY(input) > warstwa1.layer.get(2).calculateY(input))
				{
					System.out.println("Polski");
				}
				if(warstwa1.layer.get(1).calculateY(input) > warstwa1.layer.get(0).calculateY(input) && warstwa1.layer.get(1).calculateY(input) > warstwa1.layer.get(2).calculateY(input))
				{
					System.out.println("Angielski");
				}
				if(warstwa1.layer.get(2).calculateY(input) > warstwa1.layer.get(0).calculateY(input) && warstwa1.layer.get(2).calculateY(input) > warstwa1.layer.get(1).calculateY(input))
				{
					System.out.println("Niemiecki");
				}
				

								
			}
		});
		panel.add(button);
		splitPane.setBottomComponent(panel);
		splitPane.setBorder(BorderFactory.createEmptyBorder(25, 20, 25, 20));
		return splitPane;
	}
	
}
