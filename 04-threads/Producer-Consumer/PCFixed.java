class Q {
  int n;
  boolean valueSet = false;

  synchronized int get() {
    while(!valueSet)
      try {
        wait();
      } catch(InterruptedException e) {
        System.out.println("InterruptedException caught");
      }
      System.out.println("Получено: " + n);
      valueSet = false;
      notify();
      return n;
  }
  synchronized void put(int n) {
    while(valueSet)
      try {
        wait();
      } catch(InterruptedException e) {
        System.out.println("InterruptedException caught");
      }
      this.n = n;
      valueSet = true;
      System.out.println("Добавлено: " + n);
      notify();
  }
}

class Producer implements Runnable {
  Q q;

  Producer(Q q) {
    this.q = q;
    new Thread(this, "Producer").start();
  }

  public void run() {
    int i = 0;

    try {
      while(true) {
        Thread.sleep(1000);
        q.put(i++);
      }
    }
    catch(InterruptedException ex) {
      System.out.println("Прервано");
    }
  }
}

class Consumer implements Runnable {
  Q q;

  Consumer(Q q) {
    this.q = q;
    new Thread(this, "Consumer").start();
  }

  public void run() {
    try{
    while(true) {
      Thread.sleep(5000);
      q.get();
     }
    }
    catch(InterruptedException ex) {
      System.out.println("Прервано");
  }
}
}

class PCFixed {
  public static void main(String args[]) {
    Q q = new Q();
    new Producer(q);
    new Consumer(q);

    System.out.println("Press Control-C to stop.");
  }
}