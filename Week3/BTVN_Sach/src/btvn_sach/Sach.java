package btvn_sach;

public class Sach 
{
    private int MaSach;
    private String TenSach, TacGia, NhaXuatBan;
    private int Gia;
    
    public Sach()
    {
        
    }
    
    public Sach(int MaSach, String TenSach, String TacGia, String NhaXuatBan, int Gia)
    {
        this.MaSach = MaSach;
        this.TenSach = TenSach;
        this.TacGia = TacGia;
        this.NhaXuatBan = NhaXuatBan;
        this.Gia = Gia;
    }

    public int getMaSach() 
    {
        return MaSach;
    }

    public String getTenSach() 
    {
        return TenSach;
    }

    public String getTacGia() 
    {
        return TacGia;
    }

    public String getNhaXuatBan() 
    {
        return NhaXuatBan;
    }

    public int getGia() 
    {
        return Gia;
    }
    

    public void setMaSach(int MaSach) 
    {
        this.MaSach = MaSach;
    }

    public void setTenSach(String TenSach) 
    {
        this.TenSach = TenSach;
    }

    public void setTacGia(String TacGia) 
    {
        this.TacGia = TacGia;
    }

    public void setNhaXuatBan(String NhaXuatBan) 
    {
        this.NhaXuatBan = NhaXuatBan;
    }

    public void setGia(int Gia) 
    {
        this.Gia = Gia;
    }   
}
