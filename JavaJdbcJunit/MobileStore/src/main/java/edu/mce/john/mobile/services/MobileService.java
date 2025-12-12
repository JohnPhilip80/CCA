package edu.mce.john.mobile.services;

import edu.mce.john.mobile.models.Mobile;
import edu.mce.john.mobile.repositories.MobileRepository;
import edu.mce.john.mobile.utils.*;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public class MobileService {
    private MobileRepository repo;
    private Scanner scan;
    private List <Mobile> mobiles;

    public MobileService() {
        repo = new MobileRepository();
        scan = new Scanner(System.in);
    }
    public void readMobiles() {
        mobiles = repo.readMobiles();
        System.out.printf("%-10s%-15s%-25s%-10s%-15s\n","Id","Brand","Model","Year","Price");
        for(Mobile mobile:mobiles)
            System.out.println(mobile);
    }
    public void createMobile() {
        Mobile mobile = new Mobile();
        System.out.println("Enter Mobile Brand:");mobile.setBrand(scan.nextLine());
        System.out.println("Enter Mobile Model:");mobile.setModel(scan.nextLine());
        System.out.println("Enter Mobile Year Launched:");mobile.setYearLaunched(scan.nextInt()); scan.nextLine();
        System.out.println("Enter Mobile Price:");mobile.setPrice(scan.nextDouble()); scan.nextLine();
        repo.createMobile(mobile);
        System.out.println("Mobile Created Successfully");
    }

    public void updateMobile() {
        Mobile mobile = new Mobile();
        System.out.println("Enter Mobile Id to Update:");mobile.setId(scan.nextLong()); scan.nextLine();
        System.out.println("Enter Updated Brand value:");mobile.setBrand(scan.nextLine());
        System.out.println("Enter Updated Mobile Model value:");mobile.setModel(scan.nextLine());
        System.out.println("Enter Updated Mobile Year Launched value:");mobile.setYearLaunched(scan.nextInt()); scan.nextLine();
        System.out.println("Enter Updated Mobile Price value:");mobile.setPrice(scan.nextDouble()); scan.nextLine();
        repo.updateMobile(mobile);
        System.out.println("Mobile Updated Successfully");
    }
    public void deleteMobile() {
        Long id;
        System.out.println("Enter Mobile Id to Delete:");id = scan.nextLong(); scan.nextLine();
        repo.deleteMobile(id);
        System.out.println("Mobile Deleted Successfully");
    }
    public void readMobile() {
        Long id;
        System.out.println("Enter Mobile Id:");id = scan.nextLong(); scan.nextLine();
        Mobile mobile = repo.readMobile(id);
        System.out.printf("%-10s%-15s%-25s%-10s%-15s\n","Id","Brand","Model","Year","Price");
        System.out.println(mobile);
    }



}















