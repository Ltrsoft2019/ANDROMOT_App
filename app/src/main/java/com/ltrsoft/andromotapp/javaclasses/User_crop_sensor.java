package com.ltrsoft.andromotapp.javaclasses;

public class User_crop_sensor {


    String id;
    static String name;
    String des;
    String cropimg;
    String vallue;
    String created_at;

    public User_crop_sensor(String id, String name, String des, String cropimg, String vallue, String created_at) {
        this.id = id;
        this.name = name;
        this.des = des;
        this.cropimg = cropimg;
        this.vallue = vallue;
        this.created_at = created_at;
    }

    public User_crop_sensor(String stateId, String stateName, String countryId) {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public static String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public String getCropimg() {
        return cropimg;
    }

    public void setCropimg(String cropimg) {
        this.cropimg = cropimg;
    }

    public String getVallue() {
        return vallue;
    }

    public void setVallue(String vallue) {
        this.vallue = vallue;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }
}
