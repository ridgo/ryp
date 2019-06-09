package Day3;

import java.util.Collection;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;

public class HashSet {

    public static void main(String[] args) {
        Set<Student> a=new java.util.HashSet<>();
        Student s1=new Student("xll",20);
        Student s3=new Student("ryp",24);
        Student s4=new Student("sk",26);
        Student s5=new Student("lys",27);
        Student s6=new Student("zdj",21);
        Student s7=new Student("ryp",24);

        a.add(s1);
        a.add(s3);
        a.add(s4);
        a.add(s5);
        a.add(s6);
        a.add(s7);
        print(a);

    }
    static void print(Collection con)
    {
        Iterator it=con.iterator();
        while(it.hasNext())
        {
            System.out.println(it.next());
        }
    }
}
class Student
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return age == student.age &&
                Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}
