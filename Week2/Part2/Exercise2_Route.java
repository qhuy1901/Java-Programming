package Week2.Part2;

import java.util.Scanner;
import java.util.ArrayList;

abstract class Route // tuyến đường
{
    private int id;
    private String driverName;
    private int numberPlate; // số xe
    private int cargoVolume; // Khối lượng hàng hóa
    private int revenue ;

    public Route()
    {

    }

    public Route(int id, String driverName, int numberPlate, int cargoVolume, int revenue)
    {
        this.id = id;
        this.driverName = driverName;
        this.numberPlate = numberPlate;
        this.cargoVolume = cargoVolume;
        this.revenue = revenue;
    }

    public void setId(int id) 
    {
        this.id = id;
    }

    public void setdriverName(String driverName) 
    {
        this.driverName = driverName;
    }

    public void setnumberPlate(int numberPlate) 
    {
        this.numberPlate = numberPlate;
    }

    public void setcargoVolume(int cargoVolume) 
    {
        this.cargoVolume = cargoVolume;
    }

    public void setrevenue(int revenue) 
    {
        this.revenue = revenue;
    }

    public int getId() 
    {
        return id;
    }

    public String getdriverName() 
    {
        return driverName;
    }

    public int getnumberPlate() 
    {
        return numberPlate;
    }

    public int getcargoVolume() 
    {
        return cargoVolume;
    }

    public int getrevenue() 
    {
        return revenue;
    }

    public void input(Scanner scan)
    {
        System.out.print("Nhập mã số chuyến: ");
        id = scan.nextInt();
        System.out.print("Nhập họ tên tài xế: ");
        scan.nextLine();
        driverName = scan.nextLine();;
        System.out.print("Nhập số xe: ");
        numberPlate = scan.nextInt();
        System.out.print("Nhập khối lượng hàng hóa: ");
        cargoVolume = scan.nextInt();
        System.out.print("Nhập doanh thu: ");
        revenue = scan.nextInt();
    }

    public void output()
    {
        System.out.println("Mã số chuyến: " + id);
        System.out.println("Họ tên tài xế: " + driverName);
        System.out.println("Số xe: " + numberPlate);
        System.out.println("Khối lượng hàng hóa: " + cargoVolume);
        System.out.println("Doanh thu: " + revenue);
    }
}

class UrbanRoute extends Route
{
    private int travelDistance; // Quãng đường đi

    public UrbanRoute()
    {

    }

    public UrbanRoute(int id, String driverName, int numberPlate, int cargoVolume, int revenue, int travelDistance)
    {
        super(id, driverName, numberPlate, cargoVolume, revenue);
        this.travelDistance = travelDistance;
    }

    public int gettravelDistance() {
        return travelDistance;
    }

    public void settravelDistance(int travelDistance) {
        this.travelDistance = travelDistance;
    }

    public void input(Scanner scan)
    {
        super.input(scan);
        System.out.print("Nhập quãng đường đi: ");
        travelDistance = scan.nextInt();
    }

    public void output()
    {
        super.output();
        System.out.println("Quãng đường đi: " + travelDistance);
    }

}

class SuburbanRoute extends Route
{
    private String destination; // nơi đến
    private int numberShippingDays; // Số ngày vận chuyển

    public SuburbanRoute()
    {

    }

    public SuburbanRoute(int id, String driverName, int numberPlate, int cargoVolume, int revenue, String destination, int numberShippingDays)
    {
        super(id, driverName,numberPlate, cargoVolume,revenue);
        this.destination = destination;
        this.numberShippingDays = numberShippingDays;
    }

    public String getdestination() 
    {
        return destination;
    }

    public int getnumberShippingDays() 
    {
        return numberShippingDays;
    }

    public void setdestination(String destination) 
    {
        this.destination = destination;
    }

    public void setnumberShippingDays(int numberShippingDays) 
    {
        this.numberShippingDays = numberShippingDays;
    }

    public void input(Scanner scan)
    {
        super.input(scan);
        System.out.print("Nhập nơi đến: " );
        scan.nextLine();
        destination = scan.nextLine();
        System.out.print("Nhập số ngày vận chuyển: ");
        numberShippingDays = scan.nextInt();
    }

    public void output()
    {
        super.output();
        System.out.println("Nơi đến: " + destination);
        System.out.println("Số ngày vận chuyển " + numberShippingDays);
    }

}

public class Exercise2_Route 
{
    public static void inputRouteList(ArrayList<Route> routes, int numberOfRoutes, Scanner scan)
    {
        for(int i = 0; i < numberOfRoutes; i++)
        {
            System.out.print("\nChọn 1 để nhập chuyến xe nội thành, 2 để nhập chuyến xe ngoại thành:\n>> ");
            int option = scan.nextInt();
            if(option == 1)
            {
                UrbanRoute route = new UrbanRoute();
                route.input(scan);
                routes.add(route);
            }
            else
            {
                SuburbanRoute route = new SuburbanRoute();
                route.input(scan);
                routes.add(route);
            }
        }
    }

    public static void outputRouteList(ArrayList<Route> routes)
    {
        for(int i = 0; i < routes.size(); i++)
        {
            System.out.println("\nThông tin chuyến xe thứ " + (i + 1));
            routes.get(i).output(); 
        }
    }

    public static boolean isValidNumberOfRoutes(int numberOfRoutes)
    {
        if(numberOfRoutes <= 0 || numberOfRoutes > 20)
            return false;
        return true;
    }

    public static int findHighestRevenue(ArrayList<Route> routes)
    {
        int highestRevenue = routes.get(0).getrevenue();
        for(Route route: routes)
        {
            if(route.getrevenue() > highestRevenue)
                highestRevenue = route.getrevenue();
        }
        return highestRevenue;
    }

    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        ArrayList<Route> routes = new ArrayList<Route>();
        int numberOfRoutes;
        do {
            System.out.print("Nhập số lượng chuyến xe (không quá 20 chuyến):\n>> ");
            numberOfRoutes = scan.nextInt();
        } while(!isValidNumberOfRoutes(numberOfRoutes));
        inputRouteList(routes, numberOfRoutes, scan);
        outputRouteList(routes);

        int totalUrbanRouteRevenue = 0, totalSuburbanRouteRevenue = 0;
        for(Route route : routes)
        {
            if(route.getClass().equals(SuburbanRoute.class))
                totalSuburbanRouteRevenue += route.getrevenue();
            else
                totalUrbanRouteRevenue += route.getrevenue();
        }
        System.out.println("\nTổng doanh thu của các chuyến xe là: " + (totalUrbanRouteRevenue + totalSuburbanRouteRevenue));
        System.out.println("Tổng doanh thu của chuyến nội thành: " + totalUrbanRouteRevenue);
        System.out.println("Tổng doanh thu của chuyến ngoại thành: " + totalSuburbanRouteRevenue);

        int highestSuburbanRouteRevenue = 0;
        int highestUrbanRouteRevenue = 0;
        for(Route route : routes)
        {
            if(route.getClass().equals(UrbanRoute.class))
                highestUrbanRouteRevenue  = Math.max(route.getrevenue(), highestUrbanRouteRevenue);
            else
                highestSuburbanRouteRevenue  = Math.max(route.getrevenue(), highestSuburbanRouteRevenue);
        }

        System.out.println("\n=== Thông tin chuyến nội thành có doanh thu cao nhất ===");
        for(Route route : routes)
        {
            if(route.getClass().equals(UrbanRoute.class) && route.getrevenue() == highestUrbanRouteRevenue)
                route.output();
        }

        System.out.println("\n=== Thông tin chuyến ngoại thành có doanh thu cao nhất ===");
        for(Route route : routes)
        {
            if(route.getClass().equals(SuburbanRoute.class) && route.getrevenue() == highestSuburbanRouteRevenue)
                route.output();
        }
    }
}