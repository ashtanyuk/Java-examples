public class IntegerToBinary 
{
   public static void convert(int n) {
     if (n == 0) 
     	return; 
     convert(n / 2); 
     System.out.print(n % 2);
}
public static void main(String[] args) {
   int N = Integer.parseInt(args[0]); 
   convert(N);
   System.out.println();
  } 
}