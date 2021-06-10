
package DAL;

import DTO.DichVu_DTO;
import Utils.DBUtils;
import java.sql.*;
import java.util.ArrayList;
import java.util.TreeMap;

public class DichVu_DAL {
    private DBUtils dbu = null;
    private Connection conn = null;
    private PreparedStatement pres = null;
    private ResultSet rs = null;
    
    public ArrayList<DichVu_DTO> getServiceList()
    {
        ArrayList<DichVu_DTO> serviceList = new ArrayList<DichVu_DTO>();
        
        String sql = "SELECT * FROM DICHVU";
        try{
            dbu = new DBUtils();
            conn = dbu.createConn();
            pres = conn.prepareStatement(sql);
            rs = pres.executeQuery(); 
            
            while(rs.next())
            {
                DichVu_DTO dv = new DichVu_DTO(rs.getString(1), rs.getString(2), rs.getInt(3));
                serviceList.add(dv);
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
        return serviceList;
    }
    
    public TreeMap<String, String> getServiceName()
    {
        TreeMap<String, String> serviceList = new TreeMap<String, String>();
        
        String sql = "SELECT MADV, TENDV FROM DICHVU";
        try{
            dbu = new DBUtils();
            conn = dbu.createConn();
            pres = conn.prepareStatement(sql);
            rs = pres.executeQuery(); 
            
            while(rs.next())
            {
                serviceList.put(rs.getString(1), rs.getString(2));
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
        return serviceList;
    }
}
