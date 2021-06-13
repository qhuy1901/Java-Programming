
package DTO;

import java.util.Date;

public class KhamBenh_DTO 
{
    private String medicalExaminationId;
    private String patientId;
    private String doctorId;
    private Date examinationDate;
    private String request;
    private String conclusion;
    private int payment;

    public KhamBenh_DTO() {
    }

    public KhamBenh_DTO(String medicalExaminationId, String patientId, String doctorId, Date examinationDate, String request, String conclusion, int payment) {
        this.medicalExaminationId = medicalExaminationId;
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.examinationDate = examinationDate;
        this.request = request;
        this.conclusion = conclusion;
        this.payment = payment;
    }

    public String getMedicalExaminationId() {
        return medicalExaminationId;
    }

    public String getPatientId() {
        return patientId;
    }

    public String getDoctorId() {
        return doctorId;
    }

    public Date getExaminationDate() {
        return examinationDate;
    }

    public String getRequest() {
        return request;
    }

    public String getConclusion() {
        return conclusion;
    }

    public int getPayment() {
        return payment;
    }

    public void setMedicalExaminationId(String medicalExaminationId) {
        this.medicalExaminationId = medicalExaminationId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public void setDoctorId(String doctorId) {
        this.doctorId = doctorId;
    }

    public void setExaminationDate(Date examinationDate) {
        this.examinationDate = examinationDate;
    }

    public void setRequest(String request) {
        this.request = request;
    }

    public void setConclusion(String conclusion) {
        this.conclusion = conclusion;
    }

    public void setPayment(int payment) {
        this.payment = payment;
    }
}
    
    
