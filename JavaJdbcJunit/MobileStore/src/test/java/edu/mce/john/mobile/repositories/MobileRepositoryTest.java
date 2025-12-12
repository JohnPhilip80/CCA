package edu.mce.john.mobile.repositories;

import edu.mce.john.mobile.models.Mobile;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MobileRepositoryTest {
    private static MobileRepository repo;

    @BeforeAll
    static void setup(){
        repo = new MobileRepository();
    }

    @Test
    void testReadMobiles(){
        List<Mobile> mobiles = repo.readMobiles();
        assertTrue(mobiles.size()>1000);
    }

    @Test
    void testCreateMobile(){
        int id=repo.createMobile(new Mobile(1L,"abc","def",1111,2222.00));
        assertTrue(id > 0);
    }

    @Test
    void testUpdateMobile(){
        int id = repo.updateMobile(new Mobile(1005L,"xxx","yyy",3333,2222.00));
        Mobile mb = repo.readMobile(1005L);
        assertEquals("xxx",mb.getBrand());
    }

    @Test
    void testDeleteMobile(){
        repo.deleteMobile(1004L);
        assertNull(repo.readMobile(1004L));
    }

    @Test
    void testReadMobile(){
        Mobile mobile = repo.readMobile(1000L);
        assertNotNull(mobile);
        assertEquals("Nokia",mobile.getBrand());
    }
}


