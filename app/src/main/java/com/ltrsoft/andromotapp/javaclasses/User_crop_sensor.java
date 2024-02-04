package com.ltrsoft.andromotapp.javaclasses;

public class User_crop_sensor {
    public User_crop_sensor(String user_crop_sensor_id, String crop_id, String sensor_id) {
        this.user_crop_sensor_id = user_crop_sensor_id;
        this.crop_id = crop_id;
        this.sensor_id = sensor_id;
    }

    private String user_crop_sensor_id,crop_id,sensor_id;

    public String getUser_crop_sensor_id() {
        return user_crop_sensor_id;
    }

    public void setUser_crop_sensor_id(String user_crop_sensor_id) {
        this.user_crop_sensor_id = user_crop_sensor_id;
    }

    public String getCrop_id() {
        return crop_id;
    }

    public void setCrop_id(String crop_id) {
        this.crop_id = crop_id;
    }

    public String getSensor_id() {
        return sensor_id;
    }

    public void setSensor_id(String sensor_id) {
        this.sensor_id = sensor_id;
    }

    public User_crop_sensor() {
    }
}
