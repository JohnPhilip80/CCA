package edu.mce.john.mobile.utils;

public class MobilesWithDiscount {
    private Long id;
    private String brand;
    private String model;
    private Integer yearLaunched;
    private Double price;
    private Double discountedPrice;

    public MobilesWithDiscount(Long id, String brand, String model, Integer yearLaunched, Double price, Double discountedPrice) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.yearLaunched = yearLaunched;
        this.price = price;
        this.discountedPrice = discountedPrice;
    }

    public MobilesWithDiscount() {
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

    public Double getDiscountedPrice() {
        return discountedPrice;
    }

    public void setDiscountedPrice(Double discountedPrice) {
        this.discountedPrice = discountedPrice;
    }

    @Override
    public String toString() {
        return String.format("%-10d%-15s%-25s%-10d%-15.2f%-15.2f",
                this.id,this.brand,this.model,this.yearLaunched,this.price,this.discountedPrice);
    }
}
