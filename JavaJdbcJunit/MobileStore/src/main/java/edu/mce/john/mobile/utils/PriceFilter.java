package edu.mce.john.mobile.utils;

import edu.mce.john.mobile.models.Mobile;

import java.util.function.Predicate;

public class PriceFilter implements Predicate<Mobile> {
    private Double price;
    public PriceFilter(Double price){
        this.price = price;
    }
    @Override
    public boolean test(Mobile mobile) {
        return mobile.getPrice() > price;
    }
}
