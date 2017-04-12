/**
 * Created by rohanrampuria on 1/12/17.
 *
 *
 * How to use Runnable and synchronized
 */


class Counter{

    int count;

    public synchronized void increment(){
        count = count +1;
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class ThreadExample {


    public static void main(String [] args){
        Counter c = new Counter();

        Thread t1 = new Thread(new Runnable(){
            public void run(){
                for(int i=0;i<1000000;i++){
                    c.increment();
                }
            }
        });
        Thread t2 = new Thread(new Runnable(){
            public void run(){
                for(int i=0;i<1000000;i++){
                    c.increment();
                }
            }
        });
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.print(""+c.count);
    }
}
