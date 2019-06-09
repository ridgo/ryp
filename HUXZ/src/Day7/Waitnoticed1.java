package Day7;

public class Waitnoticed1 {
    public static void main(String[] args) {
        Mystack stack=new Mystack();
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
class Mystack
{
    String [] data={"","","","","",""};//代表一个有一定范围的物质；
    int index=0;
    public synchronized void push(String s)//入栈(生产者)
    {
        while(data.length==index)
        {
            try
            {
                this.wait();
            }catch(InterruptedException e)
            {
                e.printStackTrace();
            }
        }
        System.out.print("push"+"   ");
        data[index]=s;
        index++;
        print(data);
        this.notifyAll();

    }
    public synchronized void pop()//出栈（后进先出）（消费者）
    {
        while(index==0)
        {
            try
            {
                this.wait();
            }catch(InterruptedException e)
            {
                e.printStackTrace();
            }
        }
        System.out.print("pop"+"    ");
        index--;
        data[index]="";
        print(data);
        this.notifyAll();
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
