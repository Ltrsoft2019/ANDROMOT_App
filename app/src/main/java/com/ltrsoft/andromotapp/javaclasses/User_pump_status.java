package com.ltrsoft.andromotapp.javaclasses;

public class User_pump_status {
    public User_pump_status(String user_p_status_id, String user_id, String pump_status) {
        this.user_p_status_id = user_p_status_id;
        this.user_id = user_id;
        this.pump_status = pump_status;
    }

    private String user_p_status_id,user_id,pump_status;

    public String getUser_p_status_id() {
        return user_p_status_id;
    }

    public void setUser_p_status_id(String user_p_status_id) {
        this.user_p_status_id = user_p_status_id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getPump_status() {
        return pump_status;
    }

    public void setPump_status(String pump_status) {
        this.pump_status = pump_status;
    }

}
