package BUS;

import DAL.BenhNhan_DAL;
import DTO.BenhNhan_DTO;

public class ThemBN_BUS 
{
    BenhNhan_DAL dalBenhNhan = new BenhNhan_DAL();
    
    public int insert(BenhNhan_DTO bn)
    {
        int result = dalBenhNhan.insert(bn);
        return result;
    }
}
