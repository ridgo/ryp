package Day1;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class Test {

    public static void main(String[] args) {
        List<Student> list= Arrays.asList(new Student("xl",20),
                new Student("ryp",20),
                new Student("suz",18),
                new Student("sk",21)
        );
        Comparator<Student> c1= new Comparator<Student>() {

            @Override
            public int compare(Student o1, Student o2) {
                return o1.age-o2.age;
            }
        };
        Comparator<Student> c2=new Comparator<Student>(){
            @Override
            public int compare(Student o1, Student o2) {
                return o1.name.compareTo(o2.name);
            }
        };

        Collections.sort(list,c1);
        //Collections.sort(list,c2);
//
//        String[] s={"a","ab","aaa","dasda"};
//        Arrays.sort(s);
        for(Student o:list)
        {
            System.out.println(o);
        }

    }
}
class Student implements Comparable<Student>
{
    String name;
    int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public int compareTo(Student o1) {
        return this.name.compareTo(o1.name);
    }
}
