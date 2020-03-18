public class Fruits {
    static String[] list = new String[3];

    static {
      list[0]="Apple";
      list[1]="Orange";
      list[2]="Banana";
    }
    public static void main(String[] args) {
        for(int i=0;i<list.length;i++)
            System.out.println(list[i]);
    }
}