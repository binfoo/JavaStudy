package thread;

/**
 * Created by ZhangHongbin on 2017/7/21.
 */
public class ThreadLocalExample {

    public static class MyRunnable implements Runnable{
        private ThreadLocal<Integer> myThreadLocal = new ThreadLocal<Integer>();

        @Override
        public void run() {

            myThreadLocal.set( (int) (Math.random() * 100D) );
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
            }
            System.out.println(myThreadLocal.get());


        }
    }


    public static void main(String[] args) {

        MyRunnable myRunnable = new MyRunnable();
        Thread t1 = new Thread(myRunnable);
        Thread t2 = new Thread(myRunnable);
        try {
            t1.start();
            t2.start();
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }


}
