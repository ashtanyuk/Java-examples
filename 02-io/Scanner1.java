import java.util.Scanner; // импортируем класс
public class Scanner1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int i = 2;
        System.out.print("Введите целое число: ");
        if(sc.hasNextInt()) { 
          i = sc.nextInt(); 
          System.out.println(i*2);
        } else {
          System.out.println("Вы ввели не целое число");
        }
    }
}