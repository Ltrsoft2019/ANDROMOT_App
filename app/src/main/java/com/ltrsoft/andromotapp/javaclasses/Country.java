package com.ltrsoft.andromotapp.javaclasses;

public class Country {
    public Country(String country_name) {
        this.country_name = country_name;
    }

    private String country_name;

    public String getCountry_name() {
        return country_name;
    }

    public void setCountry_name(String country_name) {
        this.country_name = country_name;
    }

    public Country() {
    }
}
