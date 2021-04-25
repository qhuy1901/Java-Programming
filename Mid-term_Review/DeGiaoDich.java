package OnThiGK;

import java.util.ArrayList;
import java.util.Scanner;

class Date
{
    public int d, m, y;
    public String ToString()
    {
        return d + "/" + m + "/" + y;
    }
}

abstract class GiaoDich
{
    public String Ma;
    Date NgayGD = new Date();
    public double DonGia, DienTich;

    public GiaoDich()
    {

    }

    public GiaoDich(String ma, Date ngayGD, double donGia, double dienTich)
    {
        Ma = ma;
        NgayGD = ngayGD;
        DonGia = donGia;
        DienTich = dienTich;
    }

    public boolean Nhap(Scanner scan)
    {
        System.out.print("Nhập mã: ");
        Ma = scan.nextLine();
        if(Ma.equals(""))
            return false;
        System.out.print("Nhập ngày GD: ");
        NgayGD.d = scan.nextInt();
        NgayGD.m = scan.nextInt();
        NgayGD.y = scan.nextInt();
        System.out.print("Nhập đơn giá: ");
        DonGia = scan.nextDouble();
        System.out.print("Nhập diện tích: ");
        DienTich = scan.nextDouble();
        return true;
    }

    public void Xuat()
    {
        System.out.println("Ma: " + Ma);
        System.out.println("Ngay GD: " + NgayGD.ToString());
        System.out.println("Don gia: " + DonGia);
        System.out.println("Dien tich: " + DienTich);
    }
    abstract public double ThanhTien();
}

class Dat extends GiaoDich
{
    public String LoaiDat;

    public Dat(){}
    public Dat(String Ma, Date NgayGD, double DonGia, double DienTich, String loaiDat)
    {
        super(Ma, NgayGD, DonGia, DienTich);
        this.LoaiDat = loaiDat;
    }

    public boolean Nhap(Scanner scan)
    {
        if(super.Nhap(scan))
        {
            LoaiDat = scan.next();
            return true;
        }
        return false;
    }

    public void Xuat()
    {
        super.Xuat();
        System.out.print("Loai dat: " + LoaiDat);
    }

    public double ThanhTien()
    {
        double Tien = 0;
        if(LoaiDat.equals("Loai A"))
            Tien = DienTich * DonGia;
        else
            Tien = DienTich * DonGia * 2;
        return Tien * 0.1;
    }
}

class Nha extends GiaoDich
{
    public String LoaiNha;
    public double HeSoViTri;
    public Nha() {}
    public Nha(String ma, Date ngayGD, double donGia, double dienTich, String loaiNha, double HeSoViTri)
    {
        super(ma, ngayGD, donGia, dienTich);
        LoaiNha = loaiNha;
        this.HeSoViTri = HeSoViTri;
    }

    public boolean Nhap(Scanner scan)
    {
        if(super.Nhap(scan))
        {
            LoaiNha = scan.next();
            HeSoViTri = scan.nextDouble();
            return true;
        }
        return false;
    }

    public void Xuat()
    {
        super.Xuat();
        System.out.println("Loai nha: " + LoaiNha);
        System.out.println("He so vi tri: " + HeSoViTri);
    }

    public double ThanhTien()
    {
        double Tien = 0;
        if(LoaiNha.equals("nhà cao cấp"))
            Tien = DienTich * DonGia * HeSoViTri;
        else
            Tien = DienTich * DonGia* HeSoViTri * 1.5;
        return Tien * 0.05;
    }
}

public class DeGiaoDich 
{
    public static void Nhap(ArrayList<GiaoDich> DS, Scanner scan)
    {
        while(true)
        {
            GiaoDich GD;
            System.out.println("Chon 1 de nhap GD Dat, 2 de nhap GD nha");
            int option = scan.nextInt();
            
            if(option == 1)
                GD = new Dat();
            else GD = new Nha();
            scan.nextLine();
            if(GD.Nhap(scan))
                DS.add(GD);
            else
                break;
        }
    }

    public static void TongTien(ArrayList<GiaoDich> DS)
    {
        double TongTienDat = 0, TongTienNha = 0;
        for(GiaoDich GD : DS)
        {
            if(GD.NgayGD.m == 10 && GD.NgayGD.y == 2018)
            {
                if(GD.getClass().equals(Dat.class))
                    TongTienDat += GD.ThanhTien();
                else
                    TongTienNha += GD.ThanhTien();
            }
            
        }
        System.out.println("Tong tien cua loai GD dat la: " + TongTienDat);
        System.out.println("Tong tien cua loai GD nha là: " + TongTienNha);
    }
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        ArrayList<GiaoDich> DS = new ArrayList<>();
        Nhap(DS, scan);
        TongTien(DS);
    }
}