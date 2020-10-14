/**
 *
;[/=///;[=;/[=;[/= *  @author Skibiński-Kołtun Patryk S17203
 *
 */

package utp.zad05.part1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;


public class Main {
  public static void main(String[] args) 
  {
    Function <String, List<String>> flines = fl ->   
    {
    	 List<String> linie = new ArrayList<>();
	     String linia;
	     try 
	     { 
	    	 BufferedReader bufferedReader = new BufferedReader(new FileReader(fl)); 
	    	 while ((linia = bufferedReader.readLine()) != null ) 
	    	 {
	    		 linie.add(linia);
	    	 }
	     }
	     catch(IOException e) 
	     {
	    	 e.printStackTrace();
	     }
	     return linie;
    };
    Function<List<String>,String> join = j -> 
    {
		  String finalString = "";
		  for(String s: j) 
		  {
			  finalString+=(" "+s);
		  }
		  return finalString;
	  };
    
    Function <String, List<Integer>> collectInts = ints ->
    {
    	Pattern pattern = Pattern.compile("\\d+");
    	Matcher matcher = pattern.matcher(ints);
    	List<Integer> result = new ArrayList<>();
    	while(matcher.find())
    	{
    		result.add(Integer.parseInt(matcher.group()));
    	}
    	return result;
    };
    Function<List<Integer>, Integer> sum = s -> 
    {
		  int suma=0;
		  for(Integer i: s) 
		  {
			suma+=i;
		  }
		  return suma;
		  
	  };
    

    String fname = System.getProperty("user.home") + "/LamComFile.txt"; 
    InputConverter<String> fileConv = new InputConverter<>(fname);
    List<String> lines = fileConv.convertBy(flines);
    String text = fileConv.convertBy(flines, join);
    List<Integer> ints = fileConv.convertBy(flines, join, collectInts);
    Integer sumints = fileConv.convertBy(flines, join, collectInts, sum);

    System.out.println(lines);
    System.out.println(text);
    System.out.println(ints);
    System.out.println(sumints);

    List<String> arglist = Arrays.asList(args);
    InputConverter<List<String>> slistConv = new InputConverter<>(arglist);  
    sumints = slistConv.convertBy(join, collectInts, sum);
    System.out.println(sumints);

  }
}
