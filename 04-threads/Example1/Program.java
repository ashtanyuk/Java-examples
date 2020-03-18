class SomeThing implements Runnable  {
    //Этот метод будет выполняться в побочном потоке
    public void run() {
        System.out.println("Привет из побочного потока!");
    }
}
public class Program  {
    public static void main(String[] args)
    {
        Thread t = new Thread(new SomeThing());
        t.start();
        try {
           Thread.sleep(1000);
        }
        catch(InterruptedException ex) {
            
        }
        System.out.println("Главный поток завершён...");
    }
}