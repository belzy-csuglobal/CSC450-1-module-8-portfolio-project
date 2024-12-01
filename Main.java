class CountModel {
  static int count = 0;
  static int max = 20;
}

class CountThread extends Thread {
  private boolean countUp;

  public CountThread(boolean countUp) {
    this.countUp = countUp;
  }

  @Override
  public void run() {
    System.out.println("\nCount Thread " + ++Main.threadCount);

    if (countUp) 
      for (int i = 0; i <= CountModel.max; i++) 
        System.out.println("Count: " + ++CountModel.count);
    else 
      for (int i = 0; i <= CountModel.max; i++) 
        System.out.println("Count: " + --CountModel.count);
  }
}

public class Main {
  static int threadCount = 0;

  public static void main(String[] args) {
    try {
      CountThread thread1 = new CountThread(true);
      thread1.start();
      thread1.join();

      CountThread thread2 = new CountThread(false);
      thread2.start();
      thread2.join();
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }
}
