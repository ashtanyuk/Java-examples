import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

class LamDemo
{
	public static void main(String[] args)
	{
		List<Integer> numbers=
       Arrays.asList(1,2,3,4,5,6,7,8,9,10);
		numbers.forEach(
       val->System.out.println(val));
    numbers.forEach(
       System.out::println);   
	}
}