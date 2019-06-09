package Day4.Map;

import java.util.*;
import java.util.function.BiConsumer;

public class test {
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

//        System.out.println(map.get(2000));
//        System.out.println(map.size());
//        map.containsKey(1956);
//        map.containsValue("北京");
//        System.out.println(map.containsKey(1965));
        print4(map);
        List list=new ArrayList();



    }
    static <K,V>  void print1(Map<K,V> map)
    {
        Set<K> set=map.keySet();
        for(K as:set)
        {
            V a=map.get(as);
            System.out.println(as+"--------"+a);
        }
    }
    static <K,V> void print2(Map<K,V> map)
    {
        Collection<V> con=map.values();
        for(V co:con)
        {
            System.out.println(co);
        }
    }
    static <K,V> void print3(Map<K,V> map)
    {
        Set<Map.Entry<K,V>> eset=map.entrySet();
        for( Map.Entry<K,V>a:eset)
        {
            K k=a.getKey();
            V v=a.getValue();
            System.out.println(k+"------"+v);
        }
    }
    static<K,V> void print4(Map<K,V> map)
    {
        map.forEach(new BiConsumer<K, V>() {
            @Override
            public void accept(K k, V v) {
                System.out.println(k+"-----"+v);
            }
        });
    }

}
