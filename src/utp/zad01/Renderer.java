package utp.zad01;

import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import java.awt.*;

public class Renderer implements TableCellRenderer {

	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {

		JLabel cell = new JLabel();

		if (column == 2 && (Integer) (value) > 20000000) {
			cell.setForeground(Color.RED);
		}
		cell.setText(value.toString());

		return cell;
	}
}