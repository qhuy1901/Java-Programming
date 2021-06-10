package Utils;
import java.sql.*;

public class DBUtils
{
    private Connection conn;
    
    public DBUtils() {};

    public Connection createConn()
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");

            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/QLKB?useSSL=false","root","password");

            if (conn == null)
                System.out.println("Kết nối không thành công");
            else
                System.out.println("Kết nối thành công");
            } 
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return conn;
    }

}
