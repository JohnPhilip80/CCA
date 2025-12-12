package edu.mce.john.mobile.utils;

public class MobileDto {
    private String brand;
    private String model;
    private Integer yearLaunched;

    public MobileDto(String brand, String model, Integer yearLaunched) {
        this.brand = brand;
        this.model = model;
        this.yearLaunched = yearLaunched;
    }

    @Override
    public String toString() {
        return String.format("%-15s%-25s%-10d",
                this.brand,this.model,this.yearLaunched);
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getYearLaunched() {
        return yearLaunched;
    }

    public void setYearLaunched(Integer yearLaunched) {
        this.yearLaunched = yearLaunched;
    }



}
