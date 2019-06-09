package Day1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ListTest1 {
    public static void main(String[] args) {
        List<String> list= Arrays.asList("一","四","三","八","十","七");
        Comparator<String> c1=Comparator.naturalOrder();
        Comparator<String> c2=c1.reversed();
        Comparator<String> c3=new Comparator<String>() {
            List<String> list=Arrays.asList("一","二","三","四","五","六","七","八","九","十","十一","十二","十三","十四","十五");
            @Override
            public int compare(String o1, String o2) {
                return list.indexOf(o1)-list.indexOf(o2);
            }
        };
        list.sort(c1);
        for(String p:list)
        {
            System.out.println(p);
        }
    }
}
