enum Season
{
  WINTER(1), 
  SPRING(2), 
  SUMMER(3), 
  AUTUMN(4);
  final int number;
  Season(int number)
  {
     this.number=number;
  }

  public int get() 
  {
     return number;
  }
}

public class EnumDemo
{
   public static void main(String[] args)
   {
      Season now=Season.SUMMER;
      System.out.println(now.get());
      System.out.println(now.ordinal());
      for(Season s:Season.values())
      {
         System.out.println(
              s.name()+":"+s.get());
      }
   }
}