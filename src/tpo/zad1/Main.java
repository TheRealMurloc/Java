/**
 *
 *  @author Skibiński-Kołtun Patryk S17203
 *
 */

package tpo.zad1;


public class Main {
  public static void main(String[] args) {
    String dirName = System.getProperty("user.home")+"/TPO1dir";
    String resultFileName = "TPO1res.txt";
    Futil.processDir(dirName, resultFileName);
  }
}
