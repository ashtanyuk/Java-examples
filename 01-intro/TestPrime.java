class Prime
{
    public static boolean isPrime(int number) {
        if(number==2)
            return true;
        for(int i=2;i<Math.sqrt(number)+1;i++)
            if(number%i==0)
                return false;
        return true;
    }
    public static int seqNumber(int number) {
        int i=2,n=0;
        if(isPrime(number)==false)
            return 0;
        else
            while(true) {
                if(isPrime(i)) {
                    n++;
                    if(i==number)
                       return n;
                }
                i++;
            }
    }
    public static int calcNumber(int n) {
        int i=0,number=2;
        while(true){
            if(isPrime(number))
                i++;
            if(i==n)
                return number;
            number++;
        }
    }
    public static int nextNumber(int number) {
        while(!isPrime(++number));
        return number;
    }
    public static void printSeq(int n) {
        int number=1;
        while(n>0) {
            while(!isPrime(++number));
            System.out.print(number+" ");
            n--;
        }
    }
}


public class TestPrime
{
    public static void main(String[] args) {
        int number=Integer.parseInt(args[0]);
        System.out.println("Is "+number+" a prime? "+Prime.isPrime(number));
        System.out.println("It's "+Prime.seqNumber(number)+" number in sequence");
        System.out.println("The 10001 prime number is "+Prime.calcNumber(10001));
        System.out.println("The next prime number is "+Prime.nextNumber(number));
        Prime.printSeq(10);
    }
}
