public class BinIntMul
{
    static int mul(int x,int y) {
        return x*y;
    }
    public static void main(String[] args) {
        int num1=0b100;
        int num2=0b101;
        System.out.println(Integer.toString(mul(num1,num2),2));
        System.out.println(Integer.toBinaryString(mul(num1,num2)));
    }
}