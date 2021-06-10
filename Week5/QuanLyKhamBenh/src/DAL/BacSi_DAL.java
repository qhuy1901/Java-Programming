package DAL;

import DTO.BacSi_DTO;
import Utils.DBUtils;
import java.sql.*;
import java.util.ArrayList;

public class BacSi_DAL 
{
    private DBUtils dbu = null;
    private Connection conn = null;
    private PreparedStatement pres = null;
    private ResultSet rs = null;
    
    public ArrayList<BacSi_DTO> getDoctorList()
    {
        ArrayList<BacSi_DTO> doctorList = new ArrayList<BacSi_DTO>();
        
        String sql = "SELECT * FROM BACSI";
        try{
            dbu = new DBUtils();
            conn = dbu.createConn();
            pres = conn.prepareStatement(sql);
            rs = pres.executeQuery(); 
            
            while(rs.next())
            {
                BacSi_DTO bs = new BacSi_DTO(rs.getString(1), rs.getString(2));
                doctorList.add(bs);
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
        return doctorList;
    }
    
    public BacSi_DTO getDoctorInfo(String doctorName)
    {
        BacSi_DTO dtoBacSi = null;
        String sql = "SELECT * FROM BACSI WHERE TENBS = ?";
        try{
            dbu = new DBUtils();
            conn = dbu.createConn();
            pres = conn.prepareStatement(sql);
            pres.setString(1, doctorName);
            rs = pres.executeQuery(); 
            
            while(rs.next())
            {
                dtoBacSi = new BacSi_DTO(rs.getString(1), rs.getString(2));
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
        return dtoBacSi;
    }
}
