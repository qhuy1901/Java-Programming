package Week2.Part1;

import java.util.Arrays;
import java.util.Scanner;

class Car
{
    private String ownerName, carType;
    private int value;
    private int cylinderCapacity; // dung tích xi lanh

    public Car()
    {

    }

    public Car(String ownerName, String carType, int value, int cylinderCapacity)
    {
        this.ownerName = ownerName;
        this.carType = carType;
        this.value = value;
        this.cylinderCapacity = cylinderCapacity;
    }

    public String getOwnerName() 
    {
        return ownerName;
    }

    public String getCarType() 
    {
        return carType;
    }
    
    public int getValue() 
    {
        return value;
    }

    public int getCylinderCapacity() 
    {
        return cylinderCapacity;
    }

    public void setOwnerName(String ownerName) 
    {
        this.ownerName = ownerName;
    }

    public void setCarType(String carType)
    {
        this.carType = carType;
    }

    public void setValue(int value)
    {
        this.value = value;
    }

    public void setCylinderCapacity(int cylinderCapacity) 
    {
        this.cylinderCapacity = cylinderCapacity;
    }

    public void input(Scanner scan)
    {
        System.out.print("Nhập tên chủ xe: ");
        ownerName = scan.nextLine();
        if(!ownerName.equals(""))
        {
            System.out.print("Nhập loại xe: ");
            carType = scan.next();
            System.out.print("Nhập giá trị xe: ");
            value = scan.nextInt();
            System.out.print("Nhập dung tích xi lanh: ");
            cylinderCapacity = scan.nextInt();
            scan.nextLine();
        }
    }

    public double calculateTax()
    {
        if(cylinderCapacity < 100)
            return value * 0.01;
        else if(cylinderCapacity > 175)
            return value * 0.05;
        else 
            return value * 0.03;  
    }

    public void output()
    {
        System.out.println("Tên chủ xe: " + ownerName);
        System.out.println("Loại xe: " + carType);
        System.out.println("Trị giá xe: " + value);
        System.out.println("Dung tích xylanh: " + cylinderCapacity);
        System.out.println("Mức thuế phải đóng sau khi mua xe: " + calculateTax());
    }
}

public class Exercise4_Car 
{
    
    public static Car[] inputCarList(Car[] carList)
    {
        Scanner scan = new Scanner(System.in);
        for(int i = 0; ; i++)
        {
            Car car = new Car();
            System.out.println("\nNhập thông tin xe thứ " + (i + 1) + ": ");
            car.input(scan);
            if(car.getOwnerName().equals(""))
                break;
            carList = Arrays.copyOf(carList, carList.length + 1);
            carList[carList.length - 1] = car;
        }
        return carList;
    }

    public static void outputCarList(Car[] carList)
    {
        int i = 1;
        for(Car car: carList)
        {
            System.out.println("\nThông tin xe thứ " + i + ": ");
            car.output();   
        }
    }
    
    public static void calculateTax(Car[] carList)
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("\nTính thuê phải đóng của chủ xe: ");
        System.out.print("Nhập tên chủ xe: ");
        String ownerName = scan.nextLine();
        System.out.print("Nhập loại xe: ");
        String carType = scan.nextLine();
        boolean isFound = false;
        for(Car car: carList)
        {
            if(car.getOwnerName().equals(ownerName) && car.getCarType().equals(carType))
            {
                isFound = true;
                System.out.println(">> Thuê phải đóng là " + car.calculateTax());
            }
        }
        if(!isFound)
            System.out.println("Không tìm thấy xe có tên chủ xe là " + ownerName + " và loại xe là " + carType);
        scan.close();
    }
    public static void main(String[] args)
    {
        Car carList[] = new Car[0];
        carList = inputCarList(carList);
        outputCarList(carList);
        calculateTax(carList);
    }
}