package Day7;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Safe {
    public static void main(String[] args) throws Exception{
        Mylist list=new Mylist();
        Thread t1=new Thread(new Runnable() {
            @Override
            public void run() {
                list.add("C");
            }
        });
        Thread t2=new Thread(new Runnable() {
            @Override
            public void run() {
                //同一个list对象;
                list.add("D");

            }
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        list.print();

    }
}
class Mylist{
    String[] date={"A","B","","","",""};
    int index =2;
    Lock lock=new ReentrantLock();
    public  void add(String s)
    {
        try {
            lock.lock();
            date[index] = s;
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            index++;
        }
        finally {
            lock.unlock();
        }
    }
    public void print()
    {
        for(int i=0;i<date.length;i++)
        {
            System.out.println(date[i]);
        }
    }
}