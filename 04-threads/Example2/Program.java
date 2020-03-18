class MyThread extends Thread {
    public void run() {
        System.out.println("Привет из побочного потока!");
    }
}
public class Program  {
    static MyThread t;
    
    public static void main(String[] args) {
        t = new MyThread(); //Создание потока
        t.start(); //Запуск потока
  
        System.out.println("Главный поток завершён...");
    }
}