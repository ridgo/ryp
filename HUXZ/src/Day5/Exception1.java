package Day5;

import java.io.FileNotFoundException;
import java.io.IOException;



public class Exception1 {
    public static void main(String[] args) throws java.lang.Exception,XLException{
        ma(3);
    }
    public static void ma(int i){
        try {
            System.out.println("ma");
            System.out.println("ma1");
            mb(i);
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        System.out.println("ma2");
    };
    public static void mb(int i)throws IOException,XLException{
        System.out.println("b1");
        mc(i);
        System.out.println("b2");
    }
    public static void mc(int i)throws IOException{
        System.out.println("c1");
        if(i==1)throw new IOException();
        if(i==2)throw new XLException("我是自己定义的");
        if(i==3)throw new NullPointerException("空指针");
        System.out.println("c2");
    }
}
class XLException  extends RuntimeException
{
    public XLException(){}
    public XLException(String message){
        super(message);
    }


}
