import java.util.*;

public class Example1
{
  public static void main(String[] args) {
  	  List<String> colors =
      Arrays.asList("Red", "Orange", "Blue", "White", "Black", "Yellow");
   
    // опасный цикл
  	for(int i=0;i<colors.size();i++)
  		System.out.println(colors.get(i));

    // перебор коллекции
  	for(String color: colors) 
  		System.out.println(color);

    // перебор с лямбда-функцией
  	colors.forEach((String color) -> System.out.println(color));

    // перебор с лямбда-функцией
  	colors.forEach(System.out::println);
  }
  

}