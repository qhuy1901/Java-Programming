package Week2.GeneralInstruction;

abstract class Book
{
    private long id; 
    private String name;
    private double unitPrice;
    private int number; // số lượng
    private String publisher; //nxb

    public Book()
    {

    }

    public Book(long id, String name, double unitPrice, int number, String publisher)
    {
        this.id = id;
        this.name = name;
        this.unitPrice = unitPrice;
        this.number = number;
        this.publisher = publisher;
    }

    public void printBookInformation()
    {
        System.out.println("Mã sách: " + id);
        System.out.println("Tên sách: " + name);
        System.out.println("Đơn sách: " + unitPrice);
        System.out.println("Số lượng: " + number);
        System.out.println("Nhà xuất bản: " + publisher);
    }

    public double getUnitPrice()
    {
        return unitPrice;
    }

    public int getNumber()
    {
        return number;
    }

    public abstract double intoMoney(); //Thành tiền
}

class Novel extends Book
{
    private boolean status;

    public Novel()
    {

    }

    public Novel(long id, String name, double unitPrice, int number, String publisher, boolean status)
    {
        super(id, name, unitPrice, number, publisher);
        this.status = status;
    }

    public void printBookInformation()
    {
        super.printBookInformation();
        if(status == true)
            System.out.println("Trang thái: sách mới.");
        else
            System.out.println("Trang thái: sách cũ.");
    }

    public double intoMoney()
    {
        if(status == true)
            return getNumber() * getUnitPrice();
        else
            return getNumber() * getUnitPrice() * 0.2;
    }
}

class DetectiveBook extends Book
{
    private float tax;

    public DetectiveBook()
    {

    }

    public DetectiveBook(long id, String name, double unitPrice, int number, String publisher, float tax)
    {
        super(id, name, unitPrice, number, publisher);
        this.tax = tax;
    }

    public void printBookInformation()
    {
        super.printBookInformation();
        System.out.println("Thuế: " + tax);
    }

    public double intoMoney()
    {
        return getUnitPrice() * getNumber() * tax;
    }
}


public class Exercise2_Book 
{
    public static void main(String[] args)
    {

    }
}
