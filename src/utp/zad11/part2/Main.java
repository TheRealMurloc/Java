/**
 *
 *  @author Skibiński-Kołtun Patryk S17203
 *
 */

package utp.zad11.part2;

import java.beans.PropertyChangeListener;
import java.beans.PropertyVetoException;
import java.beans.VetoableChangeListener;

public class Main {
  public static void main(String[] args) {

    Purchase purch = new Purchase("komputer", "nie ma promocji", 3000.00);
    System.out.println(purch);

    PropertyChangeListener zmiennik = e -> System.out.println("Change value of: " + e.getPropertyName() + " from: " + e.getOldValue() + " to: " + e.getNewValue());
    VetoableChangeListener vetoSluchacz = e -> {
    	if((double) e.getNewValue() < 1000)
    		throw new PropertyVetoException("Price change to: " + e.getNewValue() + " not allowed", e);
    };
    purch.addPropertyChangeListener(zmiennik);
    purch.addVetoableChangeListener("price", vetoSluchacz);
    

    try {
      purch.setData("w promocji");
      purch.setPrice(2000.00);
      System.out.println(purch);

      purch.setPrice(500.00);

    } catch (PropertyVetoException exc) {
      System.out.println(exc.getMessage());
    }
    System.out.println(purch);

  }
}
