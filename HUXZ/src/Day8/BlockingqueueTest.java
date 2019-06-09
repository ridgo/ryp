package Day8;

import javax.management.relation.RoleUnresolved;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BlockingqueueTest {
    public static void main(String[] args) {
        BlockingQueue<String> s1 = new ArrayBlockingQueue<>(6);
        Runnable s4 = new Runnable() {
            @Override
            public void run() {
                for(int i = 1;i <= 100;i++)
                {
                    try
                    {
                        s1.put("A"+ i);
                        for(String s:s1)
                        {
                            System.out.print(s+" ");
                        }
                        System.out.println();
                    }catch(InterruptedException e)
                    {
                        e.printStackTrace();
                    }
                }
            }
        };
        Runnable s5 = new Runnable() {
            @Override
            public void run() {
                for(int i=1;i<=100;i++)
                {
                    try
                    {
                        s1.take();
                        for(String s:s1)
                        {
                            System.out.print(s+" ");
                        }
                        System.out.println();
                    }catch(InterruptedException e)
                    {
                        e.printStackTrace();
                    }
                }
            }
        };
        ExecutorService ee = Executors.newFixedThreadPool(2);
        ee.submit(s4);
        ee.submit(s5);
        ee.shutdown();
    }
}
