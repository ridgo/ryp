package Day10;

import java.io.File;

public class TestIOFile {


    public static void main(String[] args) throws Exception{
        File file = new File("ryp");
        System.out.println(file.getName());
        System.out.println(file.getParent());
        System.out.println(file.getAbsolutePath());
        File newFile = new File(System.currentTimeMillis()+"");
        //newFile.createNewFile();
        newFile.mkdir();
    }
}
