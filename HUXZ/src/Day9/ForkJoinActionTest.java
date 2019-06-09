package Day9;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

public class ForkJoinActionTest {
    public static void main(String[] args) {
        int[] data = new int[5000000];
        Random random = new Random();
        for(int i = 0;i<data.length;i++)
        {
            data[i] = random.nextInt(5000000);
        }

        Mysort main = new Mysort(0,5000000,data);
        ForkJoinPool pool = new ForkJoinPool();
        pool.invoke(main);
        for(int i =0;i<500;i++)
        {
            if(i!=0&&i%10==0)
            {
                System.out.println();
            }
            System.out.print(data[i]+"  ");
        }


    }
}
class Mysort extends RecursiveAction
{
    int start;
    int end;
    int[] data;
    final static int THRESLOld = 1000;

    public Mysort(int start, int end, int[] data) {
        super();
        this.start = start;
        this.end = end;
        this.data = data;
    }


    @Override
    protected void compute() {
        int middle = (end+start)/2;
        if(start-end<=THRESLOld)
        {
            Arrays.sort(data,start,end);
        }
        else {
            Mysort task1 = new Mysort(start,middle,data);
            Mysort task2 = new Mysort(middle,end,data);
            invokeAll(task1,task2);
            merge(middle);

        }

     }
     void merge(int middle) {
        int x = 0;
        int y = 0;
        int[] a = Arrays.copyOfRange(data,start,middle);
        int[] b = Arrays.copyOfRange(data,middle,end);
        for(int i = start;i<end;i++)
        {
            if(x == a.length)data[i] = b[y++];
            else if(y == b.length)data[i] = a[x++];
            else if(a[x]>b[y])data[i] = b[y++];
            else data[i] = a[x++];
        }

    }
}

