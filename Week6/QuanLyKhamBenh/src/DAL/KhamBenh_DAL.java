package DAL;

import DTO.BenhNhan_DTO;
import DTO.KhamBenh_DTO;
import Utils.DBUtils;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class KhamBenh_DAL 
{
    private DBUtils dbu = null;
    private Connection conn = null;
    private PreparedStatement pres = null;
    private ResultSet rs = null;
    
    public String createAutomaticId()
    {
        String MaKB = "";
        String sql = "SELECT MAKB FROM KHAMBENH ORDER BY MAKB DESC";
        try{
            dbu = new DBUtils();
            conn = dbu.createConn();
            pres = conn.prepareStatement(sql);
            rs = pres.executeQuery(); 
            
            if(rs.absolute(1) == false)
                MaKB = "KB0001";
            else
            {
                String MaKBHienTai = rs.getString(1);
                MaKB = MaKBHienTai.substring(2, 6);
                int MaKBMoi = Integer.parseInt(MaKB) + 1;
                if(MaKBMoi < 10)
                    MaKB = "KB000" + MaKBMoi;
                else
                    if(MaKBMoi < 100)
                        MaKB = "KB00" + MaKBMoi;
                    else
                        if(MaKBMoi < 1000)
                            MaKB = "KB0" + MaKBMoi;
                        else
                            MaKB = "KB" + MaKBMoi;
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
        return MaKB;
    }
    
     public int insert(KhamBenh_DTO kb)
    {
        
        int result = 0;
        String sql = "INSERT INTO KHAMBENH (MAKB, MABN, MABS, NGAYKHAM, YEUCAUKHAM, THANHTOAN) VALUES(?, ?, ? ,?, ?, 0)";
        try
        {
            dbu = new DBUtils();
            conn = dbu.createConn();
            pres = conn.prepareStatement(sql);
            pres.setString(1, kb.getMedicalExaminationId());
            pres.setString(2, kb.getPatientId());
            pres.setString(3, kb.getDoctorId());
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            pres.setString(4, df.format(kb.getExaminationDate()));
            pres.setString(5, kb.getRequest());
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
     
    public int update(KhamBenh_DTO kb)
    {
        int result = 0;
        String sql = "UPDATE KHAMBENH SET THANHTOAN = true WHERE MAKB = ?";
        try
        {
            dbu = new DBUtils();
            conn = dbu.createConn();
            pres = conn.prepareStatement(sql);
            pres.setString(1, kb.getMedicalExaminationId());
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
     
    public ArrayList<BenhNhan_DTO> getPatientList(String doctorId, Date examinationDate)
    {
        ArrayList<BenhNhan_DTO> patientList = new ArrayList<BenhNhan_DTO>();
        
        String sql = "SELECT KB.MABN, TENBN\n"
                + " FROM KHAMBENH KB, BENHNHAN BN\n"
                + "WHERE KB.MABN = BN.MABN\n"
                + "AND MABS = ? AND NGAYKHAM = ?\n"
                + "AND (THANHTOAN = 0 OR THANHTOAN IS NULL)";
        try{
            dbu = new DBUtils();
            conn = dbu.createConn();
            pres = conn.prepareStatement(sql);
            pres.setString(1, doctorId);
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            pres.setString(2, df.format(examinationDate));
            rs = pres.executeQuery(); 
            
            while(rs.next())
            {
                BenhNhan_DTO bn = new BenhNhan_DTO(rs.getString(1), rs.getString(2));
                patientList.add(bn);
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
        return patientList;
    }
    
    public KhamBenh_DTO getMedicalExaminationInfo(String patientId, String doctorId, Date examinationDate)
    {
        KhamBenh_DTO kb = null;
        String sql = "SELECT *"
                + " FROM KHAMBENH\n "
                + "WHERE MABN = ?\n"
                + "AND MABS = ? AND NGAYKHAM = ?\n"
                + "AND (THANHTOAN = 0 OR THANHTOAN IS NULL)";
        try{
            dbu = new DBUtils();
            conn = dbu.createConn();
            pres = conn.prepareStatement(sql);
            pres.setString(1, patientId);
            pres.setString(2, doctorId);
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            pres.setString(3, df.format(examinationDate));
            rs = pres.executeQuery(); 
            
            while(rs.next())
            {
                kb = new KhamBenh_DTO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getDate(4), rs.getString(5), rs.getString(6), rs.getInt(7));
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
        return kb;
    }
    
    public KhamBenh_DTO getMedicalExaminationInfo(String patientId, Date examinationDate)
    {
        KhamBenh_DTO kb = null;
        String sql = "SELECT *"
                + " FROM KHAMBENH\n "
                + "WHERE MABN = ? AND NGAYKHAM = ?\n";
        try{
            dbu = new DBUtils();
            conn = dbu.createConn();
            pres = conn.prepareStatement(sql);
            pres.setString(1, patientId);
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            pres.setString(2, df.format(examinationDate));
            rs = pres.executeQuery(); 
            
            while(rs.next())
            {
                kb = new KhamBenh_DTO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getDate(4), rs.getString(5), rs.getString(6), rs.getInt(7));
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
        return kb;
    }
        
    public int updateRequest(KhamBenh_DTO dtoKhamBenh)
    {
        int result = 0;
        String sql = "UPDATE KHAMBENH SET KETLUAN = ? WHERE MAKB= ?";
        try
        {
            dbu = new DBUtils();
            conn = dbu.createConn();
            pres = conn.prepareStatement(sql);
            pres.setString(1, dtoKhamBenh.getConclusion());
            pres.setString(2, dtoKhamBenh.getMedicalExaminationId());
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
