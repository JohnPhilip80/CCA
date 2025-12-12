package edu.mce.john.mobile.utils;

import edu.mce.john.mobile.models.Mobile;
import java.util.Comparator;

public class PriceSorter implements Comparator<Mobile> {
    @Override
    public int compare(Mobile o1, Mobile o2) {
        return (int) (o1.getPrice() - o2.getPrice());
    }
}
