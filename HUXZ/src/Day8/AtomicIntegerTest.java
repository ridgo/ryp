package Day8;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerTest {
    static int i=0;
    static AtomicInteger a = new AtomicInteger(0);
    static Integer b=Integer.valueOf(0);

    public static void main(String[] args)throws Exception {
        Thread[] th = new Thread[10];
        for(int k=0;k<th.length;k++)
        {
            th[k]=new Thread(new Runnable() {
                @Override
                public void run() {
                    for(int j=1;j<=10000;j++)
                    {
                        i++;
                        a.incrementAndGet();
                        synchronized (b)
                        {
                            b=Integer.valueOf(b.intValue()+1);
                        }
                    }
                }
            });
            th[k].start();
        }
        for(int k=0;k<th.length;k++)
        {
            th[k].join();
        }

        System.out.println(i);
        System.out.println(a);
        System.out.println(b);
    }

}
