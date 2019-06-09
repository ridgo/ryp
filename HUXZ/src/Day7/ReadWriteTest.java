package Day7;

import java.util.ArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.function.Consumer;

public class ReadWriteTest {
    public static void main(String[] args) {
        Mylist1 mylist = new Mylist1();
        mylist.add("A");
        mylist.add("B");
        mylist.add("C");
        System.out.println(mylist.get(1));
        mylist.forEach(new Consumer() {
            @Override
            public void accept(Object o) {
                System.out.println(o);
            }
        });

    }
}
class Mylist1 extends ArrayList
{
    ReadWriteLock lock1 = new ReentrantReadWriteLock();
    Lock rlock = lock1.readLock();//读锁位共享锁（可以同时用）
    Lock wlock = lock1.writeLock();//写锁为互斥锁（有这个锁标记时别的县城不能访问）
    @Override
    public int size() {
        try {
            rlock.lock();
            return super.size();
        }
        finally {
            rlock.unlock();
        }
    }

    @Override
    public Object get(int index) {
        try{
            rlock.lock();
            return super.get(index);
        }
        finally {
            rlock.unlock();
        }
    }

    @Override
    public boolean remove(Object o) {
        try{
            rlock.lock();
            return super.remove(o);
        }finally {
            wlock.unlock();
        }

    }

    @Override
    public boolean add(Object o) {
        try{
            wlock.lock();
            return super.add(o);
        }finally {
            wlock.unlock();
        }
    }

    @Override
    public void forEach(Consumer action) {
        super.forEach(action);
    }
}