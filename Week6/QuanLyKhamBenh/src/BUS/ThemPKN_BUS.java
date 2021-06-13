package BUS;

import DAL.BacSi_DAL;
import DAL.BenhNhan_DAL;
import DAL.KhamBenh_DAL;
import DTO.BacSi_DTO;
import DTO.BenhNhan_DTO;
import DTO.KhamBenh_DTO;
import java.util.ArrayList;

public class ThemPKN_BUS 
{
     BacSi_DAL dalBacSi = new BacSi_DAL();
     BenhNhan_DAL dalBenhNhan = new BenhNhan_DAL();
     KhamBenh_DAL dalKhamBenh = new KhamBenh_DAL();
    
    public ArrayList<BacSi_DTO> getDoctorList()
    {
        return dalBacSi.getDoctorList();
    }
    
    public BenhNhan_DTO getPatientInfo(String patientId)
    {
        return dalBenhNhan.getPatientInfo(patientId);
    }
    
    public String createAutomaticId()
    {
        return dalKhamBenh.createAutomaticId();
    }
    
    public int insert(KhamBenh_DTO kb)
    {
        return dalKhamBenh.insert(kb);
    }
    
    public BacSi_DTO getDoctorInfo(String doctorName)
    {
        return dalBacSi.getDoctorInfo(doctorName);
    }
}
