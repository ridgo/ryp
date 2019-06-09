package CollectionHomework;

import Day1.Test;

public  class TestThread extends Thread{
    String data;
    public TestThread(String data)
    {
        this.data = data;
    }

    public void run()
    {
        synchronized (data)
        {
            for(int i = 1;i<101;i++)
            {
                try {
                    Thread.sleep((long) (Math.random()*1000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(data);
            }
        }
    }
    public static void main(String[] args) {
        Thread t1 = new TestThread("hello");
        Thread t2 = new TestThread("world");
        t1.start();
        t2.start();

    }



}
