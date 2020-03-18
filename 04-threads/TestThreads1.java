class TestThreads1 extends Thread
{
    String name;
    TestThreads1(String name)
    {
      this.name=name;
    }
    public void run()
    {
      //try
      //{
       for(int i=0;i<100;i++) {
          //Thread.sleep(10);
          System.out.println("Thread:"+name);
       }
      //}
      //catch(InterruptedException ex)
      //{}
    }
    public static void main(String[] args) throws InterruptedException
    {
        TestThreads1 t1,t2;
        System.out.println("Hello from father");
        t1=new TestThreads1("t1");
        t2=new TestThreads1("t2");
        t1.setPriority(1);
        t2.setPriority(10);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        
        for(int i=0;i<10;i++)  {
          //Thread.sleep(10);
          System.out.println("Thread-father");
        }
        System.out.println("Thread-father-ex i");
        
    }  
      
}
