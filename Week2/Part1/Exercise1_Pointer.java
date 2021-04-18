package Week2.Part1;

import java.util.Scanner;

class Pointer
{
    private double x, y;

    public Pointer()
    {

    }

    public Pointer(double x, double y)
    {
        this.x = x;
        this.y = y;
    }

    public void input(Scanner scan)
    {
        System.out.print("x = ");
        x = scan.nextDouble();
        System.out.print("y = ");
        y = scan.nextDouble();
    }

    public void printInformation()
    {
        System.out.println("(" + x + "," + y + ")");
    }

    public double calculateDistance(Pointer other)
    {
        return Math.sqrt( Math.pow((x - other.x), 2) + Math.pow((y - other.y), 2));
    }

    public void output()
    {
        System.out.println("(" + x + "," + y + ")");
    }
}

public class Exercise1_Pointer 
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        Pointer p1 = new Pointer();
        Pointer p2 = new Pointer();

        System.out.println("Nhập tọa độ điểm thứ nhất:");
        p1.input(scan);
        System.out.println("Nhập tọa độ điểm thứ hai:");
        p2.input(scan);

        System.out.println("Tọa độ 2 điểm là: ");
        p1.output();
        p2.output();

        System.out.println("Khoảng cách của 2 điểm đó là: " + p1.calculateDistance(p2));
        scan.close();
    }
}
