public class GreetHW
{
    String text="Hello, world!";
    void Print() {
        System.out.println(text);
    } 
    public static void main(String[] args) {
        GreetHW greet=new GreetHW();
        greet.Print();
    }
}