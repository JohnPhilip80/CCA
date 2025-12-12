package edu.mce.john.mobile.interfaces;

import edu.mce.john.mobile.models.Mobile;
import java.util.List;

public interface MobileCRUD {
    int createMobile(Mobile mobile);
    List<Mobile> readMobiles();
    int updateMobile(Mobile mobile);
    int deleteMobile(Long id);
    Mobile readMobile(Long id);
}
