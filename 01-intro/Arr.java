import java.util.Random;

public class Arr
{
	static int[] arr;
	static Random rand=new Random();
	public static void main(String[] args) {
		arr=new int[Integer.parseInt(args[0])];
		int sum=0;
		for(int i=0;i<arr.length;i++) {
			arr[i]=rand.nextInt()%100;
			sum+=arr[i];
		}
		System.out.println("len="+arr.length+" sum="+sum);
	}
}