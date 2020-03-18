import java.util.Scanner;
import java.util.Arrays;
import java.io.*;

public class Scanner3 
{
    public static void main(String[] args) throws FileNotFoundException
    {
        Scanner scanner = new Scanner(new File(args[0]));
        int [] data=new int[1];
        int i = 0;
        while(scanner.hasNextInt()){
        	data=Arrays.copyOf(data,data.length+1);
            data[i++] = scanner.nextInt();
        }
    }
}