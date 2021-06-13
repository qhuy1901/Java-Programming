package DTO;

public class ThuPhi_DTO 
{
    private String medicalExaminationId;
    private String serviceId;
    private int number;
    private int amount;

    public ThuPhi_DTO(String medicalExaminationId, String serviceId, int number, int amount) {
        this.medicalExaminationId = medicalExaminationId;
        this.serviceId = serviceId;
        this.number = number;
        this.amount = amount;
    }

    public ThuPhi_DTO() {
    }

    public String getMedicalExaminationId() {
        return medicalExaminationId;
    }

    public String getServiceId() {
        return serviceId;
    }

    public int getNumber() {
        return number;
    }

    public int getAmount() {
        return amount;
    }

    public void setMedicalExaminationId(String medicalExaminationId) {
        this.medicalExaminationId = medicalExaminationId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
    
    
}
