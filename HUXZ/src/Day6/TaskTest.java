package Day6;

import java.util.concurrent.CountDownLatch;

public class TaskTest {
    public static void main(String[] args)throws InterruptedException {
        CountDownLatch cdl = new CountDownLatch(2);

        Runnable task1=new Task1();
        Runnable task2=new Task2();
        Thread t1 = new Thread(task1, "线程1");
        Thread t2 = new Thread(task2,"线程2");
        Thread t3 = new TaskThread("线程3");
        t2.setDaemon(true);
        t1.setDaemon(true);
        t1.start();
        t2.start();
        t3.start();
        //t3.setDaemon(true);
        //t3.join();//仅仅时等待t2完了之后，不一定是t2完了之后立刻进行；
        //System.out.println(Thread.currentThread().getName());
        System.out.println("All Threads are over");
    }
}
class Task1 implements Runnable{
    public void run()
    {
        for(int i=1;i<=1000;i++)
        {
            System.out.println("###" + i);
            System.out.println(Thread.currentThread().getName());
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
class Task2 implements Runnable {
    public void run() {
        for (int i = 1; i <= 1000; i++) {
            System.out.println("&&&" + i);
            try
            {
                Thread.sleep(1000);
            }catch(InterruptedException e)
            {
                e.printStackTrace();
            }
        }
    }
}
class TaskThread extends Thread{
    public TaskThread(String ti)
    {
        super();
    }
    @Override
    public void run() {
        for(int i=1;i<=1000;i++)
        {
            System.out.println("@@@"+i);
        }
    }
}
