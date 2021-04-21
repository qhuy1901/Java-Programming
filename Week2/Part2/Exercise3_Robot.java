package Week2.Part2;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

abstract class Robot
{
    protected int M; // mass

    public Robot()
    {

    }

    public int getM() 
    {
        return M;
    }

    public void setM(int m)
    {
        M = m;
    }

    public abstract int calculateEnergy(int S);
    public abstract void input(Scanner scan);
    public abstract void output();
}

class Pedion extends Robot
{
    private int F; // flexibility

    public Pedion()
    {

    }

    public Pedion(int F)
    {
        M = 20;
        this.F = F;
    }

    public Pedion(Random ran)
    {
        F = 1 + ran.nextInt(5); // 1 <= f <= 5
    }

    @Override
    public int getM() 
    {
        return 20;
    }

    public int getF() 
    {
        return F;
    }

    public void setF(int f) 
    {
        F = f;
    }

    @Override
    public int calculateEnergy(int S) 
    {
        return M * S + (F + 1) * S / 2;
    }

    @Override
    public void input(Scanner scan) 
    {
        do {
            System.out.print("Nhập độ linh hoạt F (1 <= F <= 5): ");
            F = scan.nextInt(); 
        } while(F < 1 || F > 5);
    }

    @Override
    public void output() 
    {
        System.out.println("Loại robot: Pedion");
        System.out.println("Trọng lượng M = " + getM());
        System.out.println("Độ linh hoạt F = " + getF());
        System.out.println("Năng lượng tiêu thụ khi đi quãng đường 10 km = " + calculateEnergy(10));
    }
}

class Zattacker extends Robot
{
    private int P; // power

    public Zattacker()
    {

    }

    public Zattacker(int P)
    {
        this.P = P;
        M = 50;
    }

    public Zattacker(Random ran)
    {
        P = 20 + ran.nextInt(11); // 20 <= P <= 30
    }

    @Override
    public int getM() 
    {
        return 50;
    }

    public int getP() 
    {
        return P;
    }

    public void setP(int p) 
    {
        P = p;
    }

    @Override
    public int calculateEnergy(int S)
    {
        return M * S + P * P * S;
    }

    @Override
    public void input(Scanner scan) 
    {
        do {
            System.out.print("Nhập sức mạnh P (20 <= P <= 30): ");
            P = scan.nextInt(); 
        } while(P < 20 || P > 30);
    }

    public void output() 
    {
        System.out.println("Loại robot: Zattacker");
        System.out.println("Trọng lượng M = " + getM());
        System.out.println("Sức mạnh P = " + getP());
        System.out.println("Năng lượng tiêu thụ khi đi quãng đường 10 km = " + calculateEnergy(10));
    }
}

class Carrier extends Robot
{
    private int E; // shipping energy warehouse

    public Carrier()
    {

    }

    public Carrier(int E)
    {
        this.E = E;
        M = 30;
    }

    public Carrier(Random ran)
    {
        E = 50 + ran.nextInt(51); // 50 <= E <= 100
    }

    @Override
    public int getM()
    {
        return 30;
    }

    public void setE(int e) 
    {
        E = e;
    }

    public int getE() 
    {
        return E;
    }

    @Override
    public int calculateEnergy(int S) 
    {
        return M * S + 4 * E * S;
    }

    @Override
    public void input(Scanner scan) 
    {
        do {
            System.out.print("Nhập kho năng lượng vận chuyển E (50 <= E <= 100): ");
            E = scan.nextInt(); 
        } while(E < 50 || E > 100);
    }

    public void output() 
    {
        System.out.println("Loại robot: Carrier");
        System.out.println("Trọng lượng M = " + getM());
        System.out.println("Kho năng lượng vận chuyển E = " + getE());
        System.out.println("Năng lượng tiêu thụ khi đi quãng đường 10 km = " + calculateEnergy(10));
    }
}

public class Exercise3_Robot
{
    public static void inputRobotList(ArrayList<Robot> robotList)
    {
        Random ran = new Random();
        Scanner scan = new Scanner(System.in);

        System.out.print("Nhập số lượng robot Pedion:\n>> ");
        int numberOfPedion= scan.nextInt();
        System.out.print("Nhập số lượng robot Zattacker:\n>> ");
        int numberOfZattacker = scan.nextInt();
        System.out.print("Nhập số lượng robot Carrier:\n>> ");
        int numberOfCarrier = scan.nextInt();
        
        for(int i = 0; i < numberOfPedion; i++)
        {
            Pedion Pedion = new Pedion(ran);
            robotList.add(Pedion);
        }

        for(int i = 0; i < numberOfZattacker; i++)
        {
            Zattacker Zattacker = new Zattacker(ran);
            robotList.add(Zattacker);
        }

        for(int i = 0; i < numberOfCarrier; i++)
        {
            Carrier Carrier = new Carrier(ran);
            robotList.add(Carrier);
        }

        scan.close();
    }

    public static void outputRobotList(ArrayList<Robot> robotList)
    {
        for(int i = 0; i < robotList.size(); i++)
        {
            System.out.println("\nThông tin robot thứ " + (i + 1));
            robotList.get(i).output();
        }
    }

    public static void main(String[] args)
    {
        
        ArrayList<Robot> robotList = new ArrayList<Robot>();
        inputRobotList(robotList);
        outputRobotList(robotList);
        
        int totalEnergyOfPedion = 0, totalEnergyOfZattacker = 0, totalEnergyOfCarrier = 0;
        for(int i = 0; i < robotList.size(); i++)
        {
            if(robotList.get(i).getClass().equals(Pedion.class))
                totalEnergyOfPedion += robotList.get(i).calculateEnergy(10);
            else if(robotList.get(i).getClass().equals(Zattacker.class))
                totalEnergyOfZattacker += robotList.get(i).calculateEnergy(10);
            else 
                totalEnergyOfCarrier += robotList.get(i).calculateEnergy(10);
        }

        System.out.print("\nLoại robot tiêu thụ năng lượng nhiều nhất trong đoàn là: ");
        if (totalEnergyOfPedion >= totalEnergyOfCarrier && totalEnergyOfPedion >= totalEnergyOfZattacker)
            System.out.print("Pedion.");
        else if (totalEnergyOfZattacker >= totalEnergyOfPedion && totalEnergyOfZattacker >= totalEnergyOfCarrier)
            System.out.print("Zattacker.");
        else 
            System.out.print("Carrier.");
    }   
}