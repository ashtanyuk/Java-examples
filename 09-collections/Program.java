class Box<T> 
{   
    private T t;           
    public void add(T t) 
	  {   
       this.t = t; 
    }
    public T get() 
	  { 
       return t;  
    }
    public <U> void inspect(U u)
    {
      System.out.println(
         "T: " + t.getClass().getName());
      System.out.println(
         "U: " + u.getClass().getName()); 
    }
}
public class Program
{
   public static void main(String[] args)
   {
      Box<String> sbox=new Box<String>();
      sbox.add("box");
      sbox.inspect<Integer>(5);
   }
}