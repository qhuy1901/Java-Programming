package BUS;

import DAL.BenhNhan_DAL;
import DAL.DichVu_DAL;
import DAL.KhamBenh_DAL;
import DAL.ThuPhi_DAL;
import DTO.BenhNhan_DTO;
import DTO.KhamBenh_DTO;
import DTO.ThuPhi_DTO;
import java.util.ArrayList;
import java.util.Date;
import java.util.TreeMap;

public class ThanhToan_BUS 
{
    KhamBenh_DAL dalKhamBenh = new KhamBenh_DAL();
    BenhNhan_DAL dalBenhNhan = new BenhNhan_DAL();
    ThuPhi_DAL dalThuPhi = new ThuPhi_DAL();
    DichVu_DAL dalDichVu = new DichVu_DAL();
     
    public KhamBenh_DTO getMedicalExaminationInfo(String patientId, Date examinationDate)
    {
        return dalKhamBenh.getMedicalExaminationInfo(patientId, examinationDate);
    }
    public BenhNhan_DTO getPatientInfo(String patientId)
    {
        return dalBenhNhan.getPatientInfo(patientId);
    }
    
    public ArrayList<ThuPhi_DTO> getFeeList(KhamBenh_DTO kb)
    {
        return dalThuPhi.getFeeList(kb);
    }
    
    public int update(KhamBenh_DTO kb)
    {
        return dalKhamBenh.update(kb);
    }
    
    public TreeMap<String, String> getServiceName()
    {
        return dalDichVu.getServiceName();
    }
}
