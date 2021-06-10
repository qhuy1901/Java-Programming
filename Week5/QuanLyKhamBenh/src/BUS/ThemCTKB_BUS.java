package BUS;

import DAL.BacSi_DAL;
import DAL.BenhNhan_DAL;
import DAL.DichVu_DAL;
import DAL.KhamBenh_DAL;
import DAL.ThuPhi_DAL;
import DTO.BacSi_DTO;
import DTO.BenhNhan_DTO;
import DTO.DichVu_DTO;
import DTO.KhamBenh_DTO;
import DTO.ThuPhi_DTO;
import java.util.ArrayList;
import java.util.Date;

public class ThemCTKB_BUS 
{
    
    BacSi_DAL dalBacSi = new BacSi_DAL();
    DichVu_DAL dalDichVu = new DichVu_DAL();
    KhamBenh_DAL dalKhamBenh = new KhamBenh_DAL();
    BenhNhan_DAL dalBenhNhan = new BenhNhan_DAL();
    ThuPhi_DAL dalThuPhi = new ThuPhi_DAL();
    
    public ArrayList<BacSi_DTO> getDoctorList()
    {
        return dalBacSi.getDoctorList();
    }
    
    public ArrayList<DichVu_DTO> getServiceList()
    {
        return dalDichVu.getServiceList();
    }
    
    public ArrayList<BenhNhan_DTO> getPatientList(String doctorId, Date examinationDate)
    {
        return dalKhamBenh.getPatientList(doctorId, examinationDate);
    }
    
    public KhamBenh_DTO getMedicalExaminationInfo(String patientId, String doctorId, Date examinationDate)
    {
        return dalKhamBenh.getMedicalExaminationInfo(patientId, doctorId, examinationDate);
    }
    
    public int insert(ThuPhi_DTO tp)
    {
        return dalThuPhi.insert(tp);
    }
    
    public int updateRequest(KhamBenh_DTO kb)
    {
        return dalKhamBenh.updateRequest(kb);
    }
}
