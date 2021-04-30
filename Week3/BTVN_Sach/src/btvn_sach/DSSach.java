package btvn_sach;

import btvn_sach.Sach;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class DSSach 
{
    public List<Sach> DS; 

    public DSSach() 
    {
        this.DS = new ArrayList<Sach>();
    }
    
    public DSSach(ArrayList<Sach> DS) 
    {
        this.DS = DS;
    }
    
    public void ThemSach(Sach S)
    {
        if(TimSach(S.getMaSach()) == -1)
        {
            DS.add(S);
        }
        else
            JOptionPane.showConfirmDialog(null, "Không thêm được do trùng mã sách", "OK", JOptionPane.CLOSED_OPTION);
    }
    
    public int TimSach(int MaSach)
    {
        for(Sach s :DS)
        {
            if(s.getMaSach() == MaSach)
                return DS.indexOf(s);
        }
        return -1; // không tìm được sách
    }
    
    public Sach LayThongTin(int i)
    {
        return DS.get(i);
    }
    
    public int LayViTriSach(Sach s)
    {
        return DS.indexOf(s);
    }
    
    public Sach TimSachTheoMaSach(int MaSach)
    {
        for(Sach S : DS)
        {
            if(S.getMaSach() == MaSach)
                return S;
        }
        return null;
    }
    
    public void XoaSach(int MaSach)
    {
        DS.remove(this.TimSach(MaSach));
    }
    
    public int SLSach()
    {
        return DS.size();
    }
}
