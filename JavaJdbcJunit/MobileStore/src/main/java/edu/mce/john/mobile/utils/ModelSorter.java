package edu.mce.john.mobile.utils;

import edu.mce.john.mobile.models.Mobile;
import java.util.Comparator;

public class ModelSorter implements Comparator<Mobile> {
    @Override
    public int compare(Mobile o1, Mobile o2) {
        return o1.getModel().compareTo(o2.getModel());
    }
}
