package Prime;

public class Factorization
{
    public static void factorIt(int n) {
        for(int i=2;i*i<=n;i++) {
            if(n % i==0) {
                System.out.print(" "+i);
                n/=i;
            }
        }
        System.out.println();
    }
}