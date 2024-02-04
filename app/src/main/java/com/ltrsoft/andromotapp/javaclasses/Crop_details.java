package com.ltrsoft.andromotapp.javaclasses;

public class Crop_details {
    private String crop_name,description,crop_image,required_threshold_value;

    public Crop_details(String crop_name, String description, String crop_image, String required_threshold_value) {
        this.crop_name = crop_name;
        this.description = description;
        this.crop_image = crop_image;
        this.required_threshold_value = required_threshold_value;
    }

    public String getCrop_name() {
        return crop_name;
    }

    public void setCrop_name(String crop_name) {
        this.crop_name = crop_name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCrop_image() {
        return crop_image;
    }

    public void setCrop_image(String crop_image) {
        this.crop_image = crop_image;
    }

    public String getRequired_threshold_value() {
        return required_threshold_value;
    }

    public void setRequired_threshold_value(String required_threshold_value) {
        this.required_threshold_value = required_threshold_value;
    }

    public Crop_details() {
    }
}
