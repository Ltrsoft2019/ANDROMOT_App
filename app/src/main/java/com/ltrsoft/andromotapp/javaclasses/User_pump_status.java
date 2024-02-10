package com.ltrsoft.andromotapp.javaclasses;

public class User_pump_status {

    String fname,pumpstatus,phone,address;

    public User_pump_status(String fname, String pumpstatus, String phone, String address) {
        this.fname = fname;
        this.pumpstatus = pumpstatus;
        this.phone = phone;
        this.address = address;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getPumpstatus() {
        return pumpstatus;
    }

    public void setPumpstatus(String pumpstatus) {
        this.pumpstatus = pumpstatus;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
