
package lab04_sinhvien;
import java.sql.* ;

public class LAB04_SinhVien 
{
    public static void main(String[] args) 
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sinhvien?useSSL=false","root","password");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM hocphi");
            while(rs.next())
                System.out.println(rs.getInt(1)+"\t"+rs.getString(2) +"\t"+rs.getString(3)+ "\t"+ rs.getInt(4));
            con.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
    
}
