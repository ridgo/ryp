package CollectionHomework;

import java.util.*;

public class Homework1 {
    public static void main(String[] args) {
//        List<String> list=new ArrayList<>();
//        list.add("hello");
//        list.add("world");
//        list.add("learn");
//        list.add("java");
//        list.add("hello");
//        list.remove("hello");
//        list.remove(0);
//        for(int i=0;i<list.size();i++)
//        {
//            System.out.println(list.get(i));
//        }
        //printList(list);
//        Set<String> set=new HashSet<>();
//        set.addAll(list);
//        System.out.println(set.size());
//        List<Worker> list=new ArrayList<>();
//        list.add(new Worker(18,"zhang3",3000));
//        list.add(new Worker(25,"li4",3500));
//        list.add(new Worker(22,"wang5",3200));
//        list.add(1,new Worker(22,"zhao6",3300));
//        list.remove(3);
//        //print(list);
//        for(Worker ker:list)
//        {
//            ker.work();
//        }
        Set<Worker> set=new HashSet<>();
        set.add(new Worker(18,"zhang1",3200));
        set.add(new Worker(18,"zhang1",3200));
        //set.add(0,new Worker(18,"zhang2",3200));
        System.out.println(set.size());


    }
    public static void print(List <Worker>con)
    {
        for(int i=0;i<con.size();i++)
        {
            Worker wo=con.get(i);
            System.out.println(wo);
        }
    }

    public static void printList(Collection con)
    {
        for(Object s:con)
        {
            String o=(String)s;
            System.out.println(o.toUpperCase());

        }
    }
}
