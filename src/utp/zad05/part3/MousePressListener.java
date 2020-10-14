package utp.zad05.part3;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public interface MousePressListener extends MouseListener 
{
	default void mouseEntered(MouseEvent e){} 
	default void mouseExited(MouseEvent e){}
	default void mousePressed(MouseEvent e){}
	default void mouseReleased(MouseEvent e){} 
	

}