package Day9;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class TestCirBarrir {
    public static void main(String[] args) {
        CyclicBarrier cb = new CyclicBarrier(3);
        class Travel extends Thread
        {
            String name;
            String city;
            int time;

            public Travel(String name, String city, int time) {
                this.name = name;
                this.city = city;
                this.time = time;
            }
            public void run()
            {
                System.out.println(name+"从"+city+"出发");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(name+"到达北京");
                try {
                    cb.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
                System.out.println(name+"开始爬长城");

            }
        }
        Thread t1 = new Travel("hxz","天津",2000);
        Thread t2 = new Travel("langb","黑龙江",5000);
        Thread t3 = new Travel("xl","西藏",10000);
        t1.start();
        t2.start();
        t3.start();
    }
}
