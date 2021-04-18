package Week2.Part2;

import java.util.Scanner;

abstract class Car
{
    protected double amountOfGasoline, numberOfGoods; // lượng xăng, lượng hàng hóa

    public Car()
    {

    }

    public Car(double amountOfGasoline, double numberOfGoods)
    {
        this.numberOfGoods = numberOfGoods;
        this.amountOfGasoline = amountOfGasoline;
    }

    public double getNumberOfGoods() 
    {
        return numberOfGoods;
    }

    public double getAmountOfGasoline() 
    {
        return amountOfGasoline;
    }

    public void setNumberOfGoods(double numberOfGoods) 
    {
        this.numberOfGoods = numberOfGoods;
    }

    public void setAmountOfGasoline(double amountOfGasoline) 
    {
        this.amountOfGasoline = amountOfGasoline;
    }
    
    public void input(Scanner scan)
    {
        System.out.print("Nhập lượng hàng hiện tại: ");
        numberOfGoods = scan.nextDouble();
        System.out.print("Nhập lượng xăng hiện tại: ");
        amountOfGasoline = scan.nextDouble();
    }

    public void refuel(double amountOfGasoline )
    {
        setAmountOfGasoline(this.amountOfGasoline + amountOfGasoline);
    }

    public boolean isOutOfGas()
    {
        return (amountOfGasoline == 0) ? true : false;
    }

    public void addGoods(double numberOfGoods)
    {
        setNumberOfGoods(this.numberOfGoods + numberOfGoods);
    }

    public void reduceGoods(double numberOfGoods)
    {
        setNumberOfGoods(this.numberOfGoods + numberOfGoods);
    }

    public abstract void run(double roadLength);
}

class Motorcycle extends Car // xe máy
{
    public Motorcycle()
    {

    }

    public void run(double roadLength)
    {
        double wastedGasoline = (roadLength * 2) / 100 + (numberOfGoods * 0.1) / 10; // lượng xăng hao phí
        if(wastedGasoline > amountOfGasoline)
            System.out.print("Xe không đủ xăng để chạy quãng đường " + roadLength + " km.");
        else
            setAmountOfGasoline(amountOfGasoline - wastedGasoline);
    }
}

class Truck extends Car
{
    public Truck()
    {

    }

    public void run(double roadLength)
    {
        double wastedGasoline = (roadLength * 20) / 100 + (numberOfGoods * 1) / 100;
        if(wastedGasoline > amountOfGasoline)
            System.out.println("Xe không đủ xăng để chạy quãng đường " + roadLength + " km.");
        else
            setAmountOfGasoline(amountOfGasoline - wastedGasoline);
    }

}

public class Exercise4_Car 
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        System.out.print("Chọn 1 để tạo xe máy, 2 để tạo xe tải\n>> ");
        int selection = scan.nextInt();
        Car car;
        if(selection == 1)
        {
            car = new Motorcycle();
            car.input(scan);
        }
        else
        {
            car = new Truck();
            car.input(scan);
        }

        while(true)
        {
            System.out.print("\nChọn các lựa chọn sau:"
            + "\n1. Thêm một lượng hàng lên xe."
            + "\n2. Bớt một lượng hàng xuống xe."
            + "\n3. Đổ một lượng xăng vào xe."
            + "\n4. Cho xe chạy một đoạn đường."
            + "\n5. Kiểm tra xem xe đã hết xăng chưa."
            + "\n6. Cho biết lượng xăng còn trong xe."
            + "\n7. Thoát.\n>> ");
            int option = scan.nextInt();
            switch(option)
            {
                case 1:
                    System.out.print("Nhập lượng hàng sẽ thêm lên xe: ");
                    int numberOfGoodsThem = scan.nextInt();
                    car.addGoods(numberOfGoodsThem);
                    break;
                case 2:
                    System.out.print("Nhập lượng hàng sẽ bớt xuống xe: ");
                    int numberOfGoodsXuong = scan.nextInt();
                    car.reduceGoods(numberOfGoodsXuong);
                    break;
                case 3:
                    System.out.print("Nhập lượng xăng đổ vào xe: ");
                    int amountOfGasoline = scan.nextInt();
                    car.refuel(amountOfGasoline);
                    break;
                case 4:
                    System.out.print("Nhập chiều dài đoạn đường xe chạy: ");
                    int roadLength = scan.nextInt();
                    car.run(roadLength);
                    break;
                case 5:
                    if(car.isOutOfGas())
                        System.out.println("Xe đã hết xăng!");
                    else 
                        System.out.println("Xe chưa hết xăng.");
                    break;
                case 6:
                    System.out.println("Lượng xăng còn trong xe là " + car.getAmountOfGasoline() + " lít.");
                    break;
                case 7:
                    System.out.println("Chương trình kết thúc...");
                    return;
            }
        }
    } 
}
