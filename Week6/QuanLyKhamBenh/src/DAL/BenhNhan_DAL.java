package DAL;

import DTO.BenhNhan_DTO;
import Utils.DBUtils;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class BenhNhan_DAL 
{
    private DBUtils dbu = null;
    private Connection conn = null;
    private PreparedStatement pres = null;
    private ResultSet rs = null;
    
    public int insert(BenhNhan_DTO bn)
    {
        
        int result = 0;
        String sql = "INSERT INTO BENHNHAN VALUES(?, ?, ? ,?, ?, ?)";
        try
        {
            dbu = new DBUtils();
            conn = dbu.createConn();
            pres = conn.prepareStatement(sql);
            pres.setString(1, bn.getId());
            pres.setString(2, bn.getName());
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            pres.setString(3, df.format(bn.getDob()));
            pres.setString(4, bn.getAddress());
            pres.setString(5, bn.getPhoneNo());
            if(bn.getGender().equals("Nam"))
                pres.setBoolean(6, true);
            else
                pres.setBoolean(6, false);
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
    
    public BenhNhan_DTO getPatientInfo(String patientId)
    {
        BenhNhan_DTO dtoBenhNhan = null;
        String sql = "SELECT * FROM BENHNHAN WHERE MABN = ?";
        try{
            dbu = new DBUtils();
            conn = dbu.createConn();
            pres = conn.prepareStatement(sql);
            pres.setString(1, patientId);
            rs = pres.executeQuery(); 
            
            while(rs.next())
            {
                dtoBenhNhan = new BenhNhan_DTO(rs.getString(1), rs.getString(2), rs.getDate(3), rs.getString(4), rs.getString(5), rs.getString(6));
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
        return dtoBenhNhan;
    }
}
