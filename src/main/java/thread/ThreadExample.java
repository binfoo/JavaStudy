package thread;

/**
 * Created by ZhangHongbin on 2017/7/20.
 */
public class ThreadExample {

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {

            System.out.println(Thread.currentThread().getName());

            new Thread("" + i) {
                public void run() {
                    System.out.println("Thread: " + Thread.currentThread().getName() + " running");

                }
            }.start();

        }
    }

}
