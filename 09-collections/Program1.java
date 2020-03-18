class Pair<T extends Number> 
{   
    private T t1,t2;           
    public void add(T t1,T t2) 
	  {   
       this.t1 = t1;
       this.t2 = t2; 
    }
    public double getAvg() 
	  { 
       return (t1.doubleValue()+
               t2.doubleValue())/2.0;  
    }
    public boolean compTo(Pair<?> p)
    {
      return (getAvg()==p.getAvg());
    }
}
public class Program1
{
   public static void main(String[] args)
   {
      Pair<Integer> p1=new Pair<Integer>();
      p1.add(5,6);
      Pair<Double> p2=new Pair<Double>();
      p2.add(5.0,6.0);      
      System.out.println(p1.compTo(p2));
   }
}