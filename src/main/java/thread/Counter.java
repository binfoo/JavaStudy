package thread;

/**
 * Created by ZhangHongbin on 2017/7/20.
 */
public class Counter {
    long count = 0;

    public synchronized void add(long value) {
        this.count += value;
    }
}

class CounterThread extends Thread {
    protected Counter counter = null;

    public CounterThread(Counter counter) {
        this.counter = counter;
    }

    public void run() {
        for (int i = 0; i < 10; i++) {

            counter.add(i);
            System.out.println("Thread " + Thread.currentThread().getName() + ", count = " + counter.count);
        }
    }

}

class Example {

    public static void main(String[] args) {
//        Counter counter = new Counter();
//        Thread t1 = new CounterThread(counter);
//        Thread t2 = new CounterThread(counter);
//        t1.start();
//        t2.start();

        Counter counter1 = new Counter();
        Counter counter2 = new Counter();
        Thread t1 = new CounterThread(counter1);
        Thread t2 = new CounterThread(counter2);
        t1.start();
        t2.start();
    }


}
