package Week2.Part1;
import java.util.Scanner;

class Rectangle
{
    private double length, width;

    public Rectangle()
    {

    }

    public Rectangle(double length, double width)
    {
        this.length = length;
        this.width = width;
    }

    public void Input()
    {
        Scanner scan = new Scanner(System.in);
        System.out.print("Nhập chiều dài: ");
        length = scan.nextDouble();
        System.out.print("Nhập chiều rộng: ");
        width = scan.nextDouble();
        scan.close();
    }

    public void setLength(double length)
    {
        this.length = length;
    }

    public void setWidth(double width)
    {
        this.width = width;
    }

    public double getLength()
    {
        return length;
    }

    public double getWidth()
    {
        return width;
    }

    public double calculateArea()
    {
        return length * width;
    }

    public double calculatePerimeter()
    {
        return 2 * (length + width);
    }

    public void ToString()
    {
        System.out.println("Chiều dài hình chữ nhật: " + length);
        System.out.println("Chiều rộng hình chữ nhật: " + width);
        System.out.println("Chu vi hình chữ nhật: " + calculatePerimeter());
        System.out.println("Diện tích hình chữ nhật: " + calculateArea());
    }
}

public class Exercise2_Rectangle 
{
    public static void main(String[] args)
    {
        Rectangle myRectangle = new Rectangle();
        myRectangle.Input();
        myRectangle.ToString();
    } 
}
