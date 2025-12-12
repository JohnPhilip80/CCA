package edu.mce.john.mobile;

import edu.mce.john.mobile.models.Mobile;
import edu.mce.john.mobile.repositories.MobileRepository;
import edu.mce.john.mobile.services.MobileService;
import edu.mce.john.mobile.services.StreamServices;

import java.util.List;
import java.util.Scanner;

public class Main {
    static void main() {

        StreamServices service = new StreamServices();
        service.filterMobilesByBrand();
        //service.showAllMobiles();
    }
}

        //MobileService service = new MobileService();
        //service.readMobiles();
        //service.updateMobile();
        //service.readMobile();

        //StreamServices streamServices = new StreamServices();
        //streamServices.minPriceMobileForBrand("Samsung");
        //streamServices.maxPriceMobileForBrand("Samsung");
        //streamServices..findMobile("Samsung","Y Series 25");
        //MobileService service = new MobileService();
        //service.fillMobiles();
        //service.showMobiles();
        //service.filterMobilesByBrand();
        //service.filterMobilesByPrice();
        //service.filterMobilesByBrandAndPrice();
        //service.sortMobilesByPrice();
        //service.testMobiles();

        //service.showMobiles();

        /*Scanner scan = new Scanner(System.in);
        int choice = 0;
        while(choice != 6) {
            System.out.println("1.Create, 2.Read All, 3.Update, 4.Delete, 5.Read One, 6.Exit. Enter Your Choice:");
            choice=scan.nextInt();scan.nextLine();
            switch(choice) {
                case 1: service.createMobile();brea


         */