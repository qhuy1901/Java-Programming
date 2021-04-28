import java.util.ArrayList;

abstract class KhachHang
{
    public String Ma, Ten, DiaChi;
    public int DonGia;
    public ArrayList<String> ChiSoNuoc = new ArrayList<>();
    public ArrayList<String> ThangNam = new ArrayList<>();
    
    public KhachHang()
    {

    }

    public KhachHang(String ma, String ten, String diaChi, int donGia)
    {
        Ma = ma;
        Ten = ten;
        DiaChi = diaChi;
        DonGia = donGia;
    }

    public void GhiNhanTieuThu(String thangNam, String soM3Nuoc)
    {
        ThangNam.add(thangNam);
        ChiSoNuoc.add(soM3Nuoc);
    }

    public int LayChiSoNuoc(String thangNam)
    {
        int index = ThangNam.indexOf(thangNam);
        return Integer.parseInt(ChiSoNuoc.get(index));
    }

    public abstract int LayDinhMuc();
    public abstract int ThanhTien(String thangNam);
    public abstract boolean VuotDinhMuc(String thangNam);
}

class NuocSinhHoat extends KhachHang
{
    public int DinhMuc;

    public NuocSinhHoat()
    {

    }

    public NuocSinhHoat(String ma, String ten, String diaChi, int donGia, int dinhMuc)
    {
        super(ma, ten, diaChi, donGia);
        DinhMuc = dinhMuc;
    }

    public int ThanhTien(String thangNam)
    {
        int soM3Nuoc = LayChiSoNuoc(thangNam);
        if(soM3Nuoc <= DinhMuc)
            return soM3Nuoc * DonGia;
        else  
            return (DinhMuc * DonGia) + ((soM3Nuoc - DinhMuc) * DonGia * 2);
    }

    public int LayDinhMuc()
    {
        return DinhMuc;
    }

    public boolean VuotDinhMuc(String thangNam)
    {
        int soM3Nuoc = LayChiSoNuoc(thangNam);
        if(soM3Nuoc >= DinhMuc)
            return true;
        return false;
    }
}

class NuocSanXuat extends KhachHang
{
    public NuocSanXuat()
    {

    }

    public NuocSanXuat(String ma, String ten, String diaChi, int donGia)
    {
        super(ma, ten, diaChi, donGia);
    }

    public int ThanhTien(String thangNam)
    {
        int soM3Nuoc = LayChiSoNuoc(thangNam);
        int Tien = soM3Nuoc * DonGia;
        if(soM3Nuoc > 500)
            Tien -= Tien * 0.03;
        return Tien;
    }

    public int LayDinhMuc()
    {
        return 500;
    }

    public boolean VuotDinhMuc(String thangNam)
    {
        int soM3Nuoc = LayChiSoNuoc(thangNam);
        if(soM3Nuoc > 500)
            return true;
        return false;
    }
}


public class DeNuoc
{
    public static void ThemKHNuocSinhHoat(ArrayList<KhachHang> DS, NuocSinhHoat KH)
    {
        DS.add(KH);
    }

    public static void LietKeVuotDinhMuc(ArrayList<KhachHang> DS, String thangNam)
    {
        for(KhachHang KH: DS)
        {
            if(KH.VuotDinhMuc(thangNam))
            {
                System.out.println("Mã: " + KH.Ma);
                System.out.println("Tên: " + KH.Ten);
                System.out.println("Địa chỉ: " + KH.DiaChi);
                System.out.println("Số m3 nước tiêu thụ: " + KH.LayChiSoNuoc(thangNam));
                System.out.println("Định mức: " + KH.LayDinhMuc());
                System.out.println("Thành tiền: " + KH.ThanhTien(thangNam));
            }
        }
    }

    public static void main(String[] args)
    {
        ArrayList<KhachHang> DS = new ArrayList<>();

        NuocSinhHoat KHNSH1 = new NuocSinhHoat("2", "Trần X", "Địa chỉ A", 12, 120);
        KHNSH1.GhiNhanTieuThu("3/2021", "10000");
        NuocSanXuat KHNSX = new NuocSanXuat("1", "Nguyễn X", "Địa chỉ A", 12);
        KHNSX.GhiNhanTieuThu("3/2021", "20000");
        DS.add(KHNSX);
        ThemKHNuocSinhHoat(DS, KHNSH1);
        LietKeVuotDinhMuc(DS, "3/2021");
    } 
}
