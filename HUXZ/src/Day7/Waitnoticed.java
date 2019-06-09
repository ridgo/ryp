package Day7;

import javax.management.relation.RoleUnresolved;
import javax.swing.*;

public class Waitnoticed {
    public static void main(String[] args) throws Exception {
        Object o = new Object();
        Runnable task1=new Runnable() {
            @Override
            public void run() {
                synchronized (o)
                {
                    for(char c='A';c <= 'Z';c++)
                    {
                        o.notifyAll();
                        System.out.println(c);
                        try
                        {
                            if(c!='Z')o.wait();
                        }catch(InterruptedException e)
                        {
                            e.printStackTrace();
                        }

                    }
                }
            }
        };
        Runnable task2=new Runnable() {
            @Override
            public void run() {
                synchronized (o){
                    for(int i=1;i<=52;i++)
                    {
                        o.notifyAll();
                        System.out.println(i);
                        if(i%2==0)
                        {
                            try
                            {
                                if(i!=52)o.wait();
                            }catch(InterruptedException e)
                            {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
        };
        new Thread(task1).start();
        new Thread(task2).start();
    }
}
