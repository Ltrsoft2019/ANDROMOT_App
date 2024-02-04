package com.ltrsoft.andromotapp.javaclasses;

public class City {
    private String city_name,district_id;

    public City(String city_name, String district_id) {
        this.city_name = city_name;
        this.district_id = district_id;
    }

    public String getCity_name() {
        return city_name;
    }

    public void setCity_name(String city_name) {
        this.city_name = city_name;
    }

    public String getDistrict_id() {
        return district_id;
    }

    public void setDistrict_id(String district_id) {
        this.district_id = district_id;
    }

    public City() {
    }
}
