package Day9;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;


public class SemaphoreTest
{
    public static void main(String[] args) {
        Semaphore s = new Semaphore(5);
        List<PhoneRoom> rooms = new ArrayList<>();
        rooms.add(new PhoneRoom("Room1"));
        rooms.add(new PhoneRoom("Room2"));
        rooms.add(new PhoneRoom("Room3"));
        rooms.add(new PhoneRoom("Room4"));
        rooms.add(new PhoneRoom("Room5"));
        class Task implements Runnable
        {
            public void run()
            {
                for(int i=0; i<rooms.size();i++)
                {
                    try {
                        s.acquire();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    PhoneRoom room = rooms.get(i);
                    if(room.getIsfree())
                    {
                        room.setIsfree(false);
                        System.out.println(Thread.currentThread().getName()+" entered " +room.getName());
                        try {
                            Thread.sleep(2000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println(Thread.currentThread().getName()+"existed"+room.getName());
                        room.setIsfree(true);
                        s.release();
                        return;
                    }
                }
            }
        }
        for(int i=1;i<=10;i++)
        {
            Runnable task = new Task();
            Thread t1 = new Thread(task);
            t1.start();
        }
    }
}
class PhoneRoom
{
    boolean isfree = true;
    String name;
    public PhoneRoom(String name)
    {
        this.name=name;
    }

    public boolean getIsfree() {
        return isfree;
    }

    public void setIsfree(boolean isfree) {
        this.isfree = isfree;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
