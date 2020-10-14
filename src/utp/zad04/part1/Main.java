/**
 *
 *  @author Skibiński-Kołtun Patryk S17203
 *
 */

package utp.zad04.part1;



import java.util.*;

public class Main {
  public Main() {
    List<Integer> src1 = Arrays.asList(1, 7, 9, 11, 12);
    System.out.println(test1(src1));

    List<String> src2 = Arrays.asList("a", "zzzz", "vvvvvvv" );
    System.out.println(test2(src2));
  }

  public List<Integer> test1(List<Integer> src) {
    Selector<Integer> sel = new Selector<Integer>()
    {
    	public boolean select(Integer i)
    	{
    		return i < 10;
    	}
    };
    Mapper<Integer, Integer> map = new Mapper<Integer, Integer>()
    	{
    		public Integer map(Integer i)
    		{
    			return i + 10;
    		}
    	};
    return ListCreator.collectFrom(src).when(sel).mapEvery(map);
  }

  public List<Integer> test2(List<String> src) {
	  Selector<String> sel = new Selector<String>()
	    {
	    	public boolean select(String i)
	    	{
	    		return i.length() > 3;
	    	}
	    };
	    Mapper<String, Integer> map = new Mapper<String, Integer>()
    	{
    		public Integer map(String i)
    		{
    			return i.length() + 10;
    		}
    	};
    return ListCreator.collectFrom(src).when(sel).mapEvery(map);
  }

  public static void main(String[] args) {
    new Main();
  }
}
