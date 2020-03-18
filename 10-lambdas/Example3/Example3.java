import java.util.*;

public class Example3
{
  public static void main(String[] args) {
  	  List<String> colors =
      Arrays.asList("Red", "Orange", "Blue", "White", "Black", "Yellow");
      List<String> uppercaseColors = new ArrayList<String>();


      colors.stream()
            .map(color -> color.toUpperCase())
            .forEach(color -> System.out.print(color + " "));

      System.out.println();
  }
}