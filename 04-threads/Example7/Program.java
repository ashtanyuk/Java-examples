class DataManager implements Runnable {
  boolean ready=false;
  synchronized public void sendData() throws InterruptedException {
    //wait();
    while(!ready) {
      Thread.sleep(50);
      System.out.println("Waiting for data..");
    }
    System.out.println("Sending data...");
    ready=false;
  }
  synchronized public void prepareData() throws InterruptedException{
    System.out.println("Preparing data..");
    Thread.sleep(1000);
    ready=true;
    //notify();
  }
  public void run() {
    try
    {
      while(true) {
        if(Thread.currentThread().getName()=="prepare")
        {  prepareData();
          System.out.println("!");
        }
        else
          sendData();
      }
    }
    catch(InterruptedException ex) {}
  }
}

public class Program  {
    public static void main(String[] args)
    {
        DataManager manager=new DataManager();
        try {
          Thread t1 = new Thread(manager);
          Thread t2 = new Thread(manager);
          t1.setName("prepare");
          t2.setName("send");          
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