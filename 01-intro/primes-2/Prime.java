package Prime;

public class Prime
{
	public static boolean testPrime(int value) {
            boolean isprime=true;
		for(int i=2;i*i<=value;i++)
			if(value%i==0) {
				isprime=false;
				break;
			}
		return isprime;
	}
	public static int nextPrime(int begin) {
		while(!testPrime(++begin));
		return begin;
	}
	public static int nPrime(int begin,int num) {
		while(num>0) {
		  while(!testPrime(++begin));
		  num--;
		}
		return begin;
	}
}
