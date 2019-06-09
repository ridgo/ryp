package CollectionHomework;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Maohomework {
    public static void main(String[] args) {
        Map<Integer,String> map=new HashMap<>();
        map.put(1896,"雅典");
        map.put(1900,"巴黎");
        map.put(1960,"罗马");
        map.put(1964,"东京");
        map.put(1968,"墨西哥");
        map.put(1972,"慕尼黑");
        map.put(1976,"蒙特利尔");
        map.put(1980,"莫斯科");
        map.put(1984,"洛杉矶");
        map.put(2004,"雅典");
        map.put(2008,"北京");
        map.put(2012,"伦敦");
        map.put(2016,"里约热内卢");
        map.put(2000,"悉尼");
        map.put(1940,"东京");
        map.put(2001,"北京");
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext())
        {
//             String str=sc.next();
//             Integer a=Integer.parseInt(str);
//             if(map.get(a)==null)
//             {
//                 System.out.println("该年没有举办运动会");
//             }
//            else System.out.println(map.get(a));
            String str=sc.next();
            print1(map,str);


        }

    }
    static <K,V>  void print1(Map<K,V> map,V st)
    {
        int i=0;
        Set<K> set=map.keySet();
        for(K as:set)
        {
//            V a=map.get(as);
//            System.out.println(as+"--------"+a);
            if(st.equals(map.get(as)))
            {
                System.out.println(as);
                i++;
            }
        }
        if(i==0)
            System.out.println("没有获得过世界杯");

    }
}
