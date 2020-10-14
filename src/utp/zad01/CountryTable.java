package utp.zad01;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class CountryTable {
	BufferedReader reader;

	String[] columnNames;
	Object[][] data;

	public CountryTable(String countryFileName) throws Exception {
		reader = new BufferedReader(new FileReader(countryFileName));

		String line = reader.readLine();
		columnNames = line.split("\t");

		ArrayList<CountryData> arrayData = new ArrayList<>();

		while ((line = reader.readLine()) != null) {
			String[] parsedLine = line.split("\t");
			CountryData countryData = new CountryData(parsedLine[0], parsedLine[1], Integer.parseInt(parsedLine[2]));
			arrayData.add(countryData);
		}

		data = new Object[arrayData.size()][];

		for (int i = 0; i < data.length; i++) {
			CountryData tmp = arrayData.get(i);
			data[i] = new Object[] { tmp.name, tmp.capital, tmp.population * 1000 };
		}
	}

	public JTable create() throws Exception {
		JTable table = new JTable(data, columnNames);
		table.setDefaultRenderer(Object.class, new Renderer());
		return table;
	}
}
