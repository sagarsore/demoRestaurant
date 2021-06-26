package com.task.Rudolf.task.web.data;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

public class RestaurantDto {
    private boolean servesGuest;
    private int plant;
    private String name;
    private String street;
    private String city;
    private String state;
    private String pincode;
    private MultipartFile[] files;
    private int[] openingDays;
    @Getter@Setter
    private String description;

    public int[] getOpeningDays() {
        return openingDays;
    }

    public void setOpeningDays(int[] openingDays) {
        this.openingDays = openingDays;
    }

    public boolean isServesGuest() {
        return servesGuest;
    }

    public void setServesGuest(boolean servesGuest) {
        this.servesGuest = servesGuest;
    }

    public int getPlant() {
        return plant;
    }

    public MultipartFile[] getFiles() {
        return files;
    }

    public void setFiles(MultipartFile[] files) {
        this.files = files;
    }

    public void setPlant(int plant) {
        this.plant = plant;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }
}
