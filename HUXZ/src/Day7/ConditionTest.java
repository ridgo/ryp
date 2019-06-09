package Day7;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionTest {
    public static void main(String[] args) {
//        List<String> list = new ArrayList<>();
//        List<String> list1 = Collections.synchronizedList(list);
        Mystask1 stack=new Mystask1();
//        stack.push("A");
//        stack.push("B");
//        stack.push("C");
//        stack.push("D");
//        stack.pop();
//        stack.pop();
//        stack.pop();
//        stack.pop();
        Runnable task1=new Runnable() {
            @Override
            public void run() {
                for(char c = 'A'; c<='Z'; c++)
                {
                    stack.push(c+" ");
                }
            }
        };
        Runnable task2=new Runnable() {
            @Override
            public void run() {
                for(int i=1;i<=26;i++)
                {
                    stack.pop();

                }
            }
        };
        new Thread(task1).start();
        new Thread(task2).start();


    }
}
class Mystask1
{
    String [] data={"","","","","",""};//代表一个有一定范围的物质；
    int index=0;
    Lock lock = new ReentrantLock();
    Condition full = lock.newCondition();
    Condition emply = lock.newCondition();

    public void push(String s)//入栈(生产者)
    {
        try {
            lock.lock();
            while (data.length == index) {
                try {
                    full.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.print("push" + "   ");
            data[index] = s;
            index++;
            print(data);
            emply.signalAll();
        }
        finally {
            lock.unlock();
        }

    }
    public void pop()//出栈（后进先出）（消费者）
    {
        try {
            lock.lock();
            while (index == 0) {
                try {
                    emply.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.print("pop" + "    ");
            index--;
            data[index] = "";
            print(data);
           full.signalAll();
        }
        finally {
            lock.unlock();
        }
    }
    public void print(String[] ss)
    {
        for(String s:ss)
        {
            System.out.print(s+" ");
        }
        System.out.println();
    }
}
