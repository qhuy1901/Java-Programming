package Week2.GeneralInstruction;

class Account
{
    private long ID;
    private String name;
    private double amountOfMoney;

    public Account()
    {

    } 

    public Account(long ID, String name, double amountOfMoney)
    {
        this.ID = ID;
        this.name = name;
        this.amountOfMoney = amountOfMoney;
    } 

    public void print()
    {
        System.out.println("Số tài khoản: " + ID);
        System.out.println("Tên tài khoản: " + name);
        System.out.println("Số tiền trong tài khoản: " + amountOfMoney);
    }

    public boolean recharge(double rechargedMoney)
    {
        this.amountOfMoney += rechargedMoney;
        return true;
    }

    public boolean transfer(Account other , double transferredMoney)
    {
        other.amountOfMoney += transferredMoney;
        this.amountOfMoney -= transferredMoney;
        return true;
    }
}

public class Exercise1_Account
{
    public static void main(String[] args)
    {
        
    }
}
