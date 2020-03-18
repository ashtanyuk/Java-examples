package primes;

public class Prime
{
	public static boolean isPrime(int number)
	{
		boolean status=true;
		for ( int j = 2 ; j*j <= number ; j++ )
        {
            if ( number%j == 0 )
            {
               status = false;
               break;
            }
        }
        return number>1?status:false;
	}
}