import java.util.*;

public class Example2
{
  public static void main(String[] args) {
  	  List<String> colors =
      Arrays.asList("Red", "Orange", "Blue", "White", "Black", "Yellow");
      List<String> uppercaseColors = new ArrayList<String>();
      colors.forEach(color -> uppercaseColors.add(color.toUpperCase())); 
      System.out.println(uppercaseColors);
  }
}