class SomeThing implements Runnable  {
    //Этот метод будет выполняться в побочном потоке
    public void run() {
        try
        {
            for(int i=0;i<200;i++)
              System.out.println("Привет из побочного потока! -"+
                            Thread.currentThread());
              Thread.sleep(1);
        }
        catch(InterruptedException ex) {
            System.out.println("Break!");
        }    
    }
}
public class Program  {
    public static void main(String[] args)
    {
        try {
          Thread t1 = new Thread(new SomeThing());
          t1.setPriority(Thread.MAX_PRIORITY);
          Thread t2 = new Thread(new SomeThing());
          t2.setPriority(Thread.MIN_PRIORITY);
          t1.start();
          t2.start();

          t1.join();
          t2.join();
        }
        catch(InterruptedException ex) {
            System.out.println("Break!");
        }
        System.out.println("Главный поток завершён... "+
            Thread.currentThread());
    }
}