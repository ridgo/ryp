package Day2;

import java.io.File;
import java.util.Map;
import java.util.Scanner;

public class Interction {
    public static void main(String[] args) {
//        System.out.println(args.length);
//        for(String s:args)
//        {
//            System.out.println(s);
//        }
//
        Map<String,String> env=System.getenv();
        for(String name:env.keySet())
        {
            System.out.println(name);
        }

    }

}
