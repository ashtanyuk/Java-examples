import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

class SumDemo
{
	public static int sum(
     List<Integer> numbers,
     Predicate<Integer> p)
	{
		int total=0;
		for(int n:numbers) {
			if(p.test(n)) {
              total+=n;
			}
		}
		return total;
	}
	public static void strTest(String str)
	{
		    Predicate<String> i  = (s)-> s.length() > 5;
            System.out.println(i.test(str));
	}
  public static boolean my(Integer val)
  {
     return val*val>10;
  }
	public static void main(String[] args)
	{
		List<Integer> numbers=Arrays.asList(1,2,3,4,5,6,7,8,9,10);
		System.out.println(
      sum(numbers,SumDemo::my));
		System.out.println(sum(numbers,n->n%2==0));
		System.out.println(sum(numbers,n->n>=3));
		strTest("Hello");
		strTest("world!");
	}
}