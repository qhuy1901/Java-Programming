package Week2.Part1;
import java.util.Scanner;

class Student
{
    private int id;
    private String name;
    private float theoreticalScore, practiceScore;

    public Student()
    {
        id = 0;
        name = "";
        theoreticalScore = practiceScore = 0;
    }

    public Student(int id, String name, float theoreticalScore, float practiceScore)
    {
        this.id = id;
        this.name = name;
        this.theoreticalScore = theoreticalScore;
        this.practiceScore = practiceScore;
    }

    public Student input(Scanner scan)
    {
        System.out.print("Nhập mã sinh viên: ");
        id = scan.nextInt();
        System.out.print("Nhập tên sinh viên: ");
        scan.nextLine();
        name = scan.nextLine();
        System.out.print("Nhập điểm lý thuyết: ");
        theoreticalScore = scan.nextFloat();
        System.out.print("Nhập điểm thực hành: ");
        practiceScore = scan.nextFloat();
        return this;
    }

    public int getId()
    {
        return id;
    }

    public String getName()
    {
        return name;
    }

    public float getTheoreticalScore()
    {
        return theoreticalScore;
    }

    public float getPracticeScore()
    {
        return practiceScore;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setTheoreticalScore(float theoreticalScore)
    {
        this.theoreticalScore = theoreticalScore;
    }

    public void setPracticeScore(float practiceScore)
    {
        this.practiceScore = practiceScore;
    }

    public void ToString()
    {
        System.out.println(id + "\t" + name + "\t" + theoreticalScore + "\t\t" + practiceScore + "\t\t" +  average());
    }

    public float average()
    {
        return (theoreticalScore + practiceScore) / 2;
    }
}

public class Exercise3_Student
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        Student[] student = new Student[3];
        for(int i = 0; i < student.length; i++)
        {
            student[i] = new Student();
            System.out.println("\nNhập thông tin sinh viên thứ " + (i + 1));
            student[i].input(scan);
        }
        System.out.println("\n\t\tID \tName \tTheoretical Score \tPractice Score \tAverage Score");
        for(int i = 0; i < 3; i++)
        {
            System.out.print("Student " + (i + 1) + "\t");
            student[i].ToString();
        }
    }
}