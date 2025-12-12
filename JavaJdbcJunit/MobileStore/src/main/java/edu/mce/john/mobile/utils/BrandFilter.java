package edu.mce.john.mobile.utils;

import edu.mce.john.mobile.models.Mobile;
import java.util.function.Predicate;

public class BrandFilter implements Predicate<Mobile> {
    private String brand;
    public BrandFilter(String brand){
        this.brand = brand;
    }
    @Override
    public boolean test(Mobile mobile) {

        return (mobile.getBrand().equals(this.brand));
    }
}
