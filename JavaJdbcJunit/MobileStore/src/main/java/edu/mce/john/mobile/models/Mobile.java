package edu.mce.john.mobile.models;

public class Mobile {
    private Long id;
    private String brand;
    private String model;
    private Integer yearLaunched;
    private Double price;

    public Mobile() {
    }

    public Mobile(Long id, String brand, String model, Integer yearLaunched, Double price) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.yearLaunched = yearLaunched;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return String.format("%-10d%-15s%-25s%-10d%-15.2f",
                this.id,this.brand,this.model,this.yearLaunched,this.price);
    }
}
