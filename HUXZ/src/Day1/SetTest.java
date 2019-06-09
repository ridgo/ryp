package Day1;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.function.Consumer;

public class SetTest {
    public static void main(String[] args) {
        Set<String> s=new HashSet<>();
        s.add("sk");
        s.add("ryp");
        s.add("xl");
        s.add("suz");
        s.add("lys");
        print1(s);
        System.out.println("----------------------------");
        print2(s);
        System.out.println("----------------------------");
        print3(s);
    }
    static <T> void print1(Collection <T> str)
    {
        Iterator<T> it=str.iterator();
        while(it.hasNext())
        {
            T t=it.next();
            System.out.println(t);
        }
    }
    static <T> void print2(Collection <T> s)
    {
        for(T t:s)
        {
            System.out.println(t);
        }
    }
    static <T> void print3(Collection <T> e)
    {
        e.forEach(new Consumer<T>() {//lamda表达式？？？？
            @Override
            public void accept(T t) {
                System.out.println(t);
            }
        });
    }
}
