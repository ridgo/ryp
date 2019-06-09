package Day9;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class ForkJoinTest {
    public static void main(String[] args) {
        System.out.println(Runtime.getRuntime().availableProcessors());
        ForkJoinPool pool = new ForkJoinPool();
        AddTask main = new AddTask(1,100000);
        long result =  pool.invoke(main);
        System.out.println(result);
    }
}
class AddTask extends RecursiveTask<Long>
{
    int start;
    int end;
    static final int THRESHOLD = 5000;

    public AddTask(int start,int end) {
        super();
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {
        //如果俩个数的差小于阈值，则计算；
        if((end-start)<=THRESHOLD)
        {
            long result = 0;
            for(int i = start;i<=end;i++)
            {
                result+=i;
            }
            return result;
        }
        //否则再次把任务分配开
        else
        {
            int middle = (end+start)/2;
            AddTask task1 = new AddTask(start,middle);
            AddTask task2 = new AddTask(middle+1,end);
            this.invokeAll(task1,task2);
            long r1 = task1.compute();
            long r2 = task2.compute();
            return r1+r2;
        }
    }
}
