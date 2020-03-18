class RunProg
{
  public static void main(String[] args)
  {
     Process p1,p2;
     String str=System.getProperty("os.name");
     System.out.println(str);
     try
     {
        Runtime rt=Runtime.getRuntime();
        System.out.println(rt.freeMemory()) ;
        p1=rt.exec("calc");
        p1.waitFor();
        System.out.println(rt.freeMemory()) ;
        p2=rt.exec("notepad");
        p2.waitFor();
        System.out.println(rt.freeMemory()) ;
    }
    catch(Exception e)
    {}
      
  }
}