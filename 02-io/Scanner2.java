import java.util.Scanner;
public class Scanner2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        for(int i=0; i < s.length(); i++) {
            if(s.charAt(i) == ' ') {
                System.out.println(i);
            }
        }
        System.out.print(s);
        System.out.println(s.length());
    }
}