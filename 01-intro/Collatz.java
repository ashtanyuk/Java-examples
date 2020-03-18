public class Collatz 
{
  public static void collatz(int n) {
    System.out.print(n + " ");
    if (n == 1) return;
    else if (n % 2 == 0) collatz(n / 2);
    else collatz(3*n + 1);
  }
  public static void main(String[] args) {
    int N = Integer.parseInt(args[0]);
    collatz(N);
    System.out.println();
  }
}