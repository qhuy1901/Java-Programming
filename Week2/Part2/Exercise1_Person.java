package Week2.Part2;

abstract class Person
{
    private String name;
    private int age;

    public Person()
    {

    }

    public Person(String name, int age)
    {
        this.name = name;
        this.age = age;
    }

    public int getAge() 
    {
        return age;
    }

    public String getName() 
    {
        return name;
    }

    public void setAge(int age) 
    {
        this.age = age;
    }

    public void setName(String name) 
    {
        this.name = name;
    }

    public abstract void show();
}

class Employee extends Person
{
    private float salary;

    public Employee()
    {

    }

    public Employee(String name, int age, float salary)
    {
        super(name, age);
        this.salary = salary;
    }

    public float getSalary() 
    {
        return salary;
    }

    public void setSalary(float salary) 
    {
        this.salary = salary;
    }

    public void raiseSalary()
    {
        salary += salary * 0.1;
    }

    public void raiseSalary(float salary)
    {
        this.salary += salary;
    }

    public void show()
    {
        System.out.println("Họ tên nhân viên: " + getName());
        System.out.println("Tuổi: " + getAge());
        System.out.println("Lương nhân viên: " + getSalary());
    }
}

public class Exercise1_Person 
{
    public static void main(String[] args)
    {

    }
}
