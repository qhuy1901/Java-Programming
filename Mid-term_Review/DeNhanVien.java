package OnThiGK;

import java.util.ArrayList;

abstract class NhanVien 
{
    public String Ma, TenNV, TenDV;
    public double MucLuong;
    public ArrayList<String> DSCC;

    public NhanVien()
    {

    }

    public NhanVien(String ma, String tenNV, String tenDV, double mucLuong)
    {
        Ma = ma;
        TenNV = tenNV;
        TenDV = tenDV;
        MucLuong = mucLuong;
        DSCC = new ArrayList<>();
    }

    public void ChamCong(String NgayCong)
    {
        DSCC.add(NgayCong);
    }
    public abstract double TinhLuong();
}

class NVGT extends NhanVien
{
    public NVGT()
    {

    }

    public NVGT(String ma, String tenNV, String tenDV, double mucLuong)
    {
        super(ma, tenNV, tenDV, mucLuong);     
    }

    public double TinhLuong()
    {
        double TongLuong = 0;
        for(String NgayCong : DSCC)
        {
            if(NgayCong.equals("Đi làm"))
                TongLuong += 1 * MucLuong;
            if(NgayCong.equals("Nghỉ có lý do"))
                TongLuong += 0.5 * MucLuong;
        }
        return TongLuong;
    }
}

class NVTT extends NhanVien
{
    public double HeSoPhuCap;
    public NVTT(){

    }

    public NVTT(String ma, String tenNV, String tenDV, double mucLuong, double HeSoPhuCap)
    {
        super(ma, tenNV, tenDV, mucLuong);
        this.HeSoPhuCap = HeSoPhuCap;
    }

    public double TinhLuong()
    {
        double TongLuong = 0;
        for(String NgayCong : DSCC)
        {
            if(NgayCong.equals("Ca 1"))
                TongLuong += 1 * MucLuong;
            if(NgayCong.equals("Ca 2"))
                TongLuong += 1.5 * MucLuong;
            if(NgayCong.equals("Nghỉ có lý do"))
                TongLuong += 0.5 * MucLuong;
        }
        return TongLuong * HeSoPhuCap;
    }
}

public class DeNhanVien 
{
    public static void main(String[] args)
    {
        ArrayList<NhanVien> DS = new ArrayList<>();
        NhanVien NV1 = new NVTT("1", "Nguyễn A", "DV1",  30000, 0.1);
        NhanVien NV2 = new NVTT("NV026", "Trần x", "DV1",  30000, 0.1);
        NhanVien NV3 = new NVGT("3", "Nguyễn B", "DV1",  40000);
        DS.add(NV1);
        DS.add(NV2);
        DS.add(NV3);
        ChamCongNV(DS, "Trần x", "NV026", "Ca 2");
        LietKeDSCC(DS);
    }

    public static void ChamCongNV(ArrayList<NhanVien> DS, String tenNV, String maNV, String NgayCong)
    {
        for(NhanVien NV : DS)
            if(NV.TenNV.equals(tenNV) && NV.Ma.equals(maNV))
                NV.ChamCong(NgayCong);
    }

    public static void LietKeDSCC(ArrayList<NhanVien> DS)
    {
        for(NhanVien NV : DS)
        {
            System.out.println("Mã NV: " + NV.Ma);
            System.out.println("Tên NV: " + NV.TenNV);
            System.out.println("Số ngày làm việc: " + NV.DSCC.size());
            System.out.println("Lương tháng: " + NV.TinhLuong());
        }
    }
}
