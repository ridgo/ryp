package CollectionHomework;

public class Worker {
    private int age;
    private String name;
    private int salary;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public Worker(int age, String name, int salary) {
        this.age = age;
        this.name = name;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Worker{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }
    public void work()
    {
        System.out.println(name+"work");
    }
    public boolean equals(Object wo)
    {
        if(this==wo)return true;
        if(wo!=null&&wo.getClass()==Worker.class)
        {
            Worker wo1=(Worker)wo;
            if(this.getName().equals(wo1.name))
            {
                return true;
            }
        }
        return false;
    }
    public int hashCode()
    {
        return 0;

    }
}
