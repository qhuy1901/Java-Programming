package DAL;

import DTO.KhamBenh_DTO;
import DTO.ThuPhi_DTO;
import Utils.DBUtils;
import java.sql.*;
import java.util.ArrayList;

public class ThuPhi_DAL 
{
    private DBUtils dbu = null;
    private Connection conn = null;
    private PreparedStatement pres = null;
    private ResultSet rs = null;
    
    public int insert(ThuPhi_DTO tp)
    {
        int result = 0;
        String sql = "INSERT INTO THUPHI (MAKB, MADV, SOLUONG, THANHTIEN) VALUES(?, ?, ?, ?)";
        try
        {
            dbu = new DBUtils();
            conn = dbu.createConn();
            pres = conn.prepareStatement(sql);
            pres.setString(1, tp.getMedicalExaminationId());
            pres.setString(2, tp.getServiceId());
            pres.setInt(3, tp.getNumber());
            pres.setInt(4, tp.getAmount());
            result = pres.executeUpdate();
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        finally{
            try{
                conn.close();
                pres.close();
            } catch(SQLException e)
            {
                e.printStackTrace();
            }
        }
        return result;
    }
    
    public ArrayList<ThuPhi_DTO> getFeeList(KhamBenh_DTO kb)
    {
        ArrayList<ThuPhi_DTO> list = new ArrayList<ThuPhi_DTO>();
        
        String sql = "SELECT * FROM THUPHI WHERE MAKB = ? ";
        try{
            dbu = new DBUtils();
            conn = dbu.createConn();
            pres = conn.prepareStatement(sql);
            pres.setString(1, kb.getMedicalExaminationId());
            rs = pres.executeQuery(); 
            
            while(rs.next())
            {
                ThuPhi_DTO tp = new ThuPhi_DTO(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getInt(4));
                list.add(tp);
            }
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        finally{
            try{
                conn.close();
                pres.close();
                rs.close();
            } catch(SQLException e)
            {
                e.printStackTrace();
            }
        }
        return list ;
    }
}
