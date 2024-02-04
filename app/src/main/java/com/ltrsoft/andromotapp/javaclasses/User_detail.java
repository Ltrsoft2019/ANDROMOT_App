package com.ltrsoft.andromotapp.javaclasses;

public class User_detail {
    private String user_fname,user_mname,user_lname,email_id,user_phoneuser_image,user_address,state,
            city,country,district;

    public User_detail(String user_fname, String user_mname, String user_lname, String email_id, String user_phoneuser_image, String user_address, String state, String city, String country, String district) {
        this.user_fname = user_fname;
        this.user_mname = user_mname;
        this.user_lname = user_lname;
        this.email_id = email_id;
        this.user_phoneuser_image = user_phoneuser_image;
        this.user_address = user_address;
        this.state = state;
        this.city = city;
        this.country = country;
        this.district = district;
    }

    public String getUser_fname() {
        return user_fname;
    }

    public void setUser_fname(String user_fname) {
        this.user_fname = user_fname;
    }

    public String getUser_mname() {
        return user_mname;
    }

    public void setUser_mname(String user_mname) {
        this.user_mname = user_mname;
    }

    public String getUser_lname() {
        return user_lname;
    }

    public void setUser_lname(String user_lname) {
        this.user_lname = user_lname;
    }

    public String getEmail_id() {
        return email_id;
    }

    public void setEmail_id(String email_id) {
        this.email_id = email_id;
    }

    public String getUser_phoneuser_image() {
        return user_phoneuser_image;
    }

    public void setUser_phoneuser_image(String user_phoneuser_image) {
        this.user_phoneuser_image = user_phoneuser_image;
    }

    public String getUser_address() {
        return user_address;
    }

    public void setUser_address(String user_address) {
        this.user_address = user_address;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public User_detail() {
    }
}
