package gui.tut2;

import java.awt.*;
import javax.swing.*;

public 
	class MyJPanel extends JPanel 
	{
	
	public MyJPanel(LayoutManager mgr, Color color)
	{
		this.setBackground(color);
		if(mgr != null)
			this.setLayout(mgr);	
	}

}
