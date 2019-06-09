package Day7;


import java.util.concurrent.*;

public class ThreadPool1 {
    public static void main(String[] args) throws Exception{
        //ExecutorService es=Executors.newFixedThreadPool(2);
        ExecutorService es= Executors.newCachedThreadPool();
        Runnable t1=new Runnable() {
            @Override
            public void run() {
                for(int i=1;i<=100;i++)
                {
                    System.out.println("### "+i);
                }
            }
        };
        Runnable t2=new Runnable() {
            @Override
            public void run() {
                for(int i=1;i<=100;i++)
                {
                    System.out.println("*** "+i);
                }
            }
        };
        Runnable t3=new Runnable() {
            @Override
            public void run() {
                for(int i=1;i<=100;i++)
                {
                    System.out.println("&&& "+i);
                }
            }
        };
        Callable<Integer> s1=new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                System.out.println("s1 are working");
                int result=0;
                for(int i=1;i<=100;i+=2)
                {
                    result+=i;
                    Thread.sleep(110);
                }
                System.out.println("s1 end working");
                return result;
            }
        };
        Callable<Integer> s2=new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                System.out.println("s2 are working");
                int result=0;
                for(int i=2;i<=100;i+=2)
                {
                    result+=i;
                    Thread.sleep(110);
                }
                System.out.println("s2 end working");
                return result;
            }
        };
//        es.submit(t1);
//        es.submit(t2);
//        es.submit(t3);
        Future<Integer> d1=es.submit(s1);
        Future<Integer> d2=es.submit(s2);
        System.out.println("main do anything");
        int result=d1.get()+d2.get();
        System.out.println(result);
        es.shutdown();

    }
}
