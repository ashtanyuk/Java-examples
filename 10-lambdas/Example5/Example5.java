import java.util.*;

public class Example5
{
  public static void main(String[] args) {
  	  List<String> colors =
      Arrays.asList("Red", "Orange", "Blue", "White", "Black", "Yellow");
      List<String> uppercaseColors = new ArrayList<String>();

      long count= 
         colors.stream() 
               .filter(color -> color.startsWith("B"))
               .count();
      System.out.println(count);
  }
}