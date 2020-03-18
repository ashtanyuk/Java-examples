class SomeThing implements Runnable  {

    synchronized void print() {
           try {
                System.out.print("[");
                Thread.sleep(5);
                System.out.print(Thread.currentThread().getName());
                System.out.println("]");            
        }
        catch(InterruptedException ex) {
            System.out.println("Break!");
        }            
    }
    //Этот метод будет выполняться в побочном потоке
    public void run() {
        try {
            for(int i=0;i<100;i++) {
                Thread.sleep(100);
               print();
            }
        }
        catch(InterruptedException ex) {
            System.out.println("Break!");
        }  
    }
}
public class Program  {
    static SomeThing sth;
    public static void main(String[] args)
    {
        sth=new SomeThing();
        try {
          Thread t1 = new Thread(sth);
          Thread t2 = new Thread(sth);
          t1.start();
          t2.start();
          t1.join();
          t2.join();
        }
        catch(InterruptedException ex) {
            System.out.println("Break!");
        }
        System.out.println("Главный поток завершён...");
    }
}