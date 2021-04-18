package Week1;
import java.util.Scanner;
import java.lang.Math;
import java.util.Random;
import java.util.Arrays;

public class Week1
{
    public static void calculatePerimeter(Scanner scan)
    {
        System.out.print("Nhập bán kính r = ");
        float r = scan.nextFloat();
        double perimeter = 2 * Math.PI * r;
        System.out.print("Chu vi đường tròn là: " + perimeter);
    }

    public static void divideTwoNumbers(Scanner scan)
    {
        System.out.print("Nhập a = ");
        int a = scan.nextInt();
        System.out.print("Nhập b = ");
        int b = scan.nextInt();
        //double x = a / b;
        double x = ((double)a / b);
        System.out.printf("%.3f", x);
    }

    public static void fraction(Scanner scan)
    {
        System.out.println("Nhập phân số thứ nhất:");
        System.out.print("\tNhập tử số = ");
        int numerator1 = scan.nextInt();
        System.out.print("\tNhập mẫu số = ");
        int denominator1 = scan.nextInt();

        System.out.println("Nhập phân số thứ hai:");
        System.out.print("\tNhập tử số = ");
        int numerator2 = scan.nextInt();
        System.out.print("\tNhập mẫu số = ");
        int denominator2 = scan.nextInt();

        double add = (double)((numerator1 * denominator2) + (numerator2 * denominator1)) / (denominator1 * denominator2);
        System.out.println("Tổng hai phân số là: " + add);
        double minus = (double)((numerator1 * denominator2) - (numerator2 * denominator1)) / (denominator1 * denominator2);
        System.out.println("Hiệu hai phân số là: " + minus);
        double multiply = (double)(numerator1 * numerator2 ) / (denominator1 * denominator2);
        System.out.println("Tích hai phân số là: " + multiply);
        double divide = (double)(numerator1 *  denominator2 ) / (denominator1 * numerator2);
        System.out.println("Thương hai phân số là: " + divide);
    }

    public static void string(Scanner scan)
    {
        System.out.print("Nhập chuỗi x: ");
        String x = scan.nextLine();
        System.out.print("Nhập chuỗi y: ");
        String y = scan.nextLine();

        System.out.println("Tổng chiều dài của chuỗi x: " + x.length());

        System.out.println("Ba kí tự đầu tiên của x: " + x.substring(0, 3));

        System.out.println("Ba kí tự cuối của x: " + x.substring(x.length() - 3, x.length()));

        if(x.length() >= 6)
            System.out.println("Kí tự thứ 6 của chuỗi x: " + x.charAt(6));

        String newString = x.substring(0, 3) + y.substring(y.length() - 3, y.length());
        System.out.println("Chuỗi mới gồm 3 kí tự đầu tiên của chuỗi x và 3 kí tự cuối của chuỗi y là: " + newString);

        System.out.print("Kiểm tra 2 chuỗi phân biệt chữ hoa, thường: ");
        if(x.equals(y))
            System.out.println("Hai chuỗi bằng nhau.");
        else
            System.out.println("Hai chuỗi không bằng nhau.");
        
        System.out.print("Kiểm tra 2 chuỗi không phân biệt chữ hoa, thường: ");
        if(x.equalsIgnoreCase(y))
            System.out.println("Hai chuỗi bằng nhau.");
        else
            System.out.println("Hai chuỗi không bằng nhau.");

        if(x.indexOf(y) != -1)
        {
            System.out.println("y có xuất hiện trong x");
            System.out.println("Vị trí: " + x.indexOf(y));
        }
        else 
            System.out.println("y không xuất hiện trong x");
    }

    public static void calculateElectricBill(Scanner scan)
    {
        System.out.print("Nhập vào số điện sử dụng của tháng: ");
        int electricNumber = scan.nextInt();

        int bill;
        if(electricNumber <= 50)
            bill = 2000 * electricNumber;
        else if(electricNumber > 50 && electricNumber <= 100)
            bill = 2000 * 50 + 2500 * (electricNumber - 50);
        else 
            bill = 2000 * 50 + 2500* 50 + 3500 * (electricNumber - 100);
        System.out.println("Số tiền điện là: " + bill);
    }

    public static void isPrime(Scanner scan)
    {
        System.out.print("Nhập n = ");
        int n = scan.nextInt();

        boolean flag = true;
        for (int i = 2; i < n - 1; i++)
        {
            if (n % i == 0)
            {
                flag = false;
                break;
            }
        }
        if(flag == true)
            System.out.println(n + " là số nguyên tố");
        else
            System.out.println(n + " không là số nguyên tố");
    }

    public static void pythagoras()
    {
        for(int i = 1; i <= 10; i++)
        {
            for(int j = 1; j <= 10; j++)
            {
                System.out.print(i * j + "\t");
            }
            System.out.println();
        }
    }

    public static void array(Scanner scan, Random rand)
    {
        System.out.print("Nhập n = ");
        int n = scan.nextInt();
        int [] a = new int [n];
        for(int i = 0; i < n; i++)
            a[i] = rand.nextInt(100);
        System.out.println("Các phần tử của mảng là: " + Arrays.toString(a));

        int min = a[0], max = a[0];
        for(int i = 1; i < n; i++)
        {
            min = Math.min(min, a[i]);
            max = Math.max(max, a[i]);
        }
        System.out.println("Phần tử nhỏ nhất của mảng: " + min);
        System.out.println("Phần tử lớn nhất của mảng: " + max);

        System.out.print("Nhập x = ");
        int x = scan.nextInt();
        if(Arrays.binarySearch(a, x) != -1)
        {
            System.out.println(x + " có nằm trong mảng.");
            int count = 0;
            for(int i = 0; i < n ; i++)
            {
                if(a[i] == x)
                    count++;
            }
            System.out.println("Số phần tử có giá trị bằng x trong mảng là: " + count);
        }
        else
            System.out.println(x + " không nằm trong mảng.");

        Arrays.sort(a);
        System.out.println("Mảng sau khi sắp xếp là: " + Arrays.toString(a));
    }

    public static void printDimensionalArray(int[][] a)
    {
        for(int i = 0; i < a.length; i++)
        {
            for(int j = 0; j < a.length; j++)
            {
                System.out.print(a[i][j] + " "); 
            }
            System.out.println();
        }
    }

    public static void twoDimensionalArray(Scanner scan, Random rand)
    {
        System.out.print("Nhập n = ");
        int n = scan.nextInt();
        int [][] a = new int[n][n];

        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < n; j++)
            {
                a[i][j] = rand.nextInt(100);
            }
        }
        
        System.out.println("Xuất mảng: ");
        printDimensionalArray(a);

        int min = a[0][0];
        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < n; j++)
            {
                if(a[i][j] < min)
                    min = a[i][j];
            }
        }
        System.out.println("Giá trị nhỏ nhất của mảng 2 chiều là: " + min);


        for(int j = 0; j < n; j++)
        {
            // Sắp xếp
            for (int i = 0; i < n - 1; i++)
            {
                for (int k = n - 1; k > i; k--)
                {
                    if(a[j][k] < a[j][k - 1])
                    {
                        int temp = a[j][k];
                        a[j][k] = a[j][k - 1];
                        a[j][k - 1] = temp;
                    }
                }
            }    
        }
        System.out.println("Mảng sau khi sắp xếp các phần tử trên từng dòng tăng dần:");
        printDimensionalArray(a);

        int[] b = new int[n];
        for(int i = 0, j = 0; i < n; i++, j++)
        {
            b[i] = a[i][j];

        }
        Arrays.sort(b);
        for(int i = 0, j = 0; i < n; i++, j++)
        {
            a[i][j] = b[i];
        }
        System.out.println("Mảng sau khi sắp xếp các phần tử trên đường chéo chính tăng dần:");
        printDimensionalArray(a);

    }

    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        Random rand = new Random();

        System.out.println("##################################");
        System.out.println("1. Bài 1");
        System.out.println("2. Bài 2");
        System.out.println("3. Bài 3");
        System.out.println("4. Bài 4");
        System.out.println("5. Bài 5");
        System.out.println("6. Bài 6");
        System.out.println("7. Bài 7");
        System.out.println("8. Bài 8");
        System.out.println("9. Bài 9");
        System.out.println("10. Thoát");
        System.out.println("##################################");
        System.out.print("Chọn chức năng: ");
        int option = scan.nextInt();
        switch(option)
        {
            case 1:
                calculatePerimeter(scan);
                break;
            case 2:
                divideTwoNumbers(scan);
                break;
            case 3:
                fraction(scan);
                break;
            case 4:
                string(scan);
                break;
            case 5:
                calculateElectricBill(scan);
                break;
            case 6:
                isPrime(scan);
                break;
            case 7:
                pythagoras();
                break;
            case 8:
                array(scan, rand);
                break;
            case 9:
                twoDimensionalArray(scan, rand);
                break;
            case 10:
                break;
        }
        scan.close();
    }
}
