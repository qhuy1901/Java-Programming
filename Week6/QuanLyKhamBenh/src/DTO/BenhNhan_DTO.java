package DTO;

import java.util.Date;

public class BenhNhan_DTO 
{
    private String id;
    private String name;
    private Date dob;
    private String address;
    private String phoneNo;
    private String gender;

    public BenhNhan_DTO() {
        
    }

    public BenhNhan_DTO(String id, String name) {
        this.id = id;
        this.name = name;
    }

    
    public BenhNhan_DTO(String id, String name, Date dob, String address, String phoneNo, String gender) 
    {
        this.id = id;
        this.name = name;
        this.dob = dob;
        this.address = address;
        this.phoneNo = phoneNo;
        this.gender = gender;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Date getDob() {
        return dob;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public String getGender() {
        return gender;
    }

}
