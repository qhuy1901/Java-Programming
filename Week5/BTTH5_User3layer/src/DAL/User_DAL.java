package DAL;
import DTO.User_DTO;
import Utils.DBUtils;
import java.sql.*;
import java.util.ArrayList;

public class User_DAL
{
    private DBUtils dbu = null;
    private Connection conn = null;
    private PreparedStatement pres = null;
    private ResultSet rs = null;
    
    public ArrayList<User_DTO> getAllUser()
    {
        ArrayList<User_DTO> userList = new ArrayList<User_DTO>();
        
        String sql = "SELECT * FROM USER";
        try{
            dbu = new DBUtils();
            conn = dbu.createConn();
            pres = conn.prepareStatement(sql);
            rs = pres.executeQuery(); 
            
            while(rs.next())
            {
                User_DTO user = new User_DTO();
                user.setUserID(rs.getInt(1));
                user.setUsername(rs.getString(2));
                user.setPassword(rs.getString(3));
                user.setUserRole(rs.getString(4));
                userList.add(user);
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
        return userList;
    }
    
    public int insertUser(User_DTO user)
    {
        int result = 0;
        String sql = "INSERT INTO USER VALUES(?, ?, ? ,?)";
        try
        {
            dbu = new DBUtils();
            conn = dbu.createConn();
            pres = conn.prepareStatement(sql);
            pres.setInt(1, user.getUserID());
            pres.setString(2, user.getUsername());
            pres.setString(3, user.getPassword());
            pres.setString(4, user.getUserRole());
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
                rs.close();
            } catch(SQLException e)
            {
                e.printStackTrace();
            }
        }
        return result;
    }
    
    public int updateUser(User_DTO user)
    {
        int result = 0;
        String sql = "UPDATE USER SET username = ?, password = ?, userrole = ? WHERE userid = ?";
        try
        {
            dbu = new DBUtils();
            conn = dbu.createConn();
            pres = conn.prepareStatement(sql);
            pres.setString(1, user.getUsername());
            pres.setString(2, user.getPassword());
            pres.setString(3, user.getUserRole());
            pres.setInt(4, user.getUserID());
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
                rs.close();
            } catch(SQLException e)
            {
                e.printStackTrace();
            }
        }
        return result;
    }
    
    public int deleteUser(User_DTO user)
    {
        int result = 0;
        String sql = "DELETE FROM USER WHERE userid = ?";
        try
        {
            dbu = new DBUtils();
            conn = dbu.createConn();
            pres = conn.prepareStatement(sql);
            pres.setInt(1, user.getUserID());
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
                rs.close();
            } catch(SQLException e)
            {
                e.printStackTrace();
            }
        }
        return result;
    }
}
