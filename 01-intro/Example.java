class Security
{
    private int value;
    private Security(int v) {
        value=v;
    }
    int getVal() {
        return value;
    }
    public static Security Instance(int v)
    {
        return new Security(v);
    }
}

public class Example
{
    public static void main(String[] args) {
        Security s= Security.Instance(12);
    }
}
