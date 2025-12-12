package edu.mce.john.mobile.services;

import edu.mce.john.mobile.models.Mobile;
import edu.mce.john.mobile.repositories.MobileRepository;
import edu.mce.john.mobile.utils.BrandFilter;
import edu.mce.john.mobile.utils.MobilesWithDiscount;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StreamServices {
    private MobileRepository repo;
    private Scanner scan;
    private List<Mobile> mobiles;

    public StreamServices() {
        repo = new MobileRepository();
        scan = new Scanner(System.in);
        mobiles = repo.readMobiles();
    }
    public void showAllMobiles(){

        /*for(int index =0;index<mobiles.size();index++)
            System.out.println(mobiles.get(index));
        */

        /*for(Mobile mobile:mobiles)
            System.out.println(mobile);
        */

        //mobiles.forEach((mobile) -> System.out.println(mobile));

        //mobiles.forEach(System.out::println);

        //mobiles.stream().forEach(mobile -> System.out.println(mobile));
        mobiles.stream().forEach(System.out::println);
    }
    public void showFirstNMobiles(int mobileCount){
        mobiles.stream()
                .limit(mobileCount)
                .forEach(System.out::println);
    }

    public void showPagination(int pageSize,int pageNumber){
        mobiles.stream()
                .skip((pageNumber -1) * pageSize)
                .limit(pageSize)
                .forEach(System.out::println);
    }

    public void paginationWithBrandFilter(int pageSize,int pageNumber,String brand){
        mobiles.stream()
                .filter((mobile) -> (mobile.getBrand().equals(brand)))
                .skip((pageNumber -1) * pageSize)
                .limit(pageSize)
                .forEach(System.out::println);
    }

    public void countMobilesOfABrand(String brand){
        /*long total = mobiles.stream()
                .filter((mobile) -> (mobile.getBrand().equals(brand)))
                .count();
        System.out.println("Total Mobiles in " + brand + " Brand is " + total);*/

        System.out.println("Total Mobiles in " + brand + " Brand is " +
                mobiles.stream()
                        .filter((mobile) -> (mobile.getBrand().equals(brand)))
                        .count());
    }
    public void minPriceMobileForBrand(String brand)
    {
        Optional<Mobile> minPriceMobile = mobiles.stream()
                .filter((mobile) -> (mobile.getBrand().equals(brand)))
                .min(Comparator.comparingDouble(Mobile::getPrice));
        System.out.println(minPriceMobile.get());
    }
    public void maxPriceMobileForBrand(String brand)
    {
        Optional<Mobile> maxPriceMobile = mobiles.stream()
                .filter((mobile) -> (mobile.getBrand().equals(brand)))
                .max(Comparator.comparingDouble(Mobile::getPrice));
        System.out.println(maxPriceMobile.get());
    }
    public void columnValues(){
        mobiles.stream()
                .map(Mobile::getModel)
                .forEach(System.out::println);
    }

    public void uniqueColumnValues(){
        mobiles.stream()
                .map(Mobile::getBrand)
                .distinct()
                .forEach(System.out::println);
    }

    public void columnUpperCase(){
        //Show Brand Column in Uppercase
        mobiles.stream()
                .map(mobile -> new Mobile(
                        mobile.getId(),
                        mobile.getBrand().toUpperCase(),
                        mobile.getModel(),
                        mobile.getYearLaunched(),
                        mobile.getPrice()))
                //.forEach(mobile -> System.out.println(mobile));
                .forEach(System.out::println);
    }
    public void findMobile(String brand,String model){
        List<Mobile> mobiles = repo.readMobiles();
        mobiles.stream()
                .filter((mobile)->mobile.getBrand().equals(brand))
                .filter((mobile)->mobile.getModel().startsWith(model))
                .forEach(System.out::println);
    }

    public void filterMobilesByBrand() {
        String brand;
        System.out.println("Enter Brand to Filter:");
        brand = scan.nextLine();

        //mobiles.removeIf(new BrandFilter(brand));

        /*mobiles.removeIf(new Predicate<Mobile>(){
            @Override
            public boolean test(Mobile mobile) {
                return !(mobile.getBrand().equals(brand));
            }
        });*/


        //mobiles.removeIf((mobile) -> !(mobile.getBrand().equals(brand)));

        //mobiles.stream().filter(new BrandFilter(brand)).forEach(System.out::println);


        /*mobiles.stream()
                .filter(new Predicate<Mobile>(){
                    @Override
                    public boolean test(Mobile mobile) {
                        return (mobile.getBrand().equals(brand));
                    }
                })
                .forEach(System.out::println);
         */

        mobiles.stream()
                .filter((mobile) -> mobile.getBrand().equals(brand))
                .forEach(System.out::println);
    }

    public void filterMobilesByPrice() {
        Double price;
        System.out.println("Enter Price to Filter:");
        price = scan.nextDouble();scan.nextLine();

        //mobiles.removeIf(new PriceFilter(price));

        /*mobiles.removeIf(new Predicate<Mobile>(){
            @Override
            public boolean test(Mobile mobile) {
                return mobile.getPrice() > price;
            }
        });*/

        //mobiles.removeIf((mobile) -> mobile.getPrice() > price);

        /*mobiles.stream()
                .filter(new PriceFilter(price))
                .forEach(System.out::println);
        */

        /*mobiles.stream()
                .filter(new Predicate<Mobile>(){
                    @Override
                    public boolean test(Mobile mobile) {
                        return mobile.getPrice() > price;
                    }
                })
                .forEach(System.out::println);

         */

        mobiles.stream()
                .filter((mobile) -> mobile.getPrice() > price)
                .forEach(System.out::println);

    }

    public void filterMobilesByBrandAndPrice(){
        String brand;
        Double price;

        System.out.println("Enter Brand to Filter:");
        brand = scan.nextLine();

        System.out.println("Enter Price to Filter:");
        price = scan.nextDouble();scan.nextLine();

        mobiles.stream()
                .filter((mobile) -> mobile.getPrice() > price)
                .filter((mobile) -> mobile.getBrand().equals(brand))
                .forEach(System.out::println);
    }

    public void sortMobilesByPrice(){
        //Collections.sort(mobiles,new PriceSorter());

        /*Collections.sort(mobiles,new Comparator<Mobile>(){
            @Override
            public int compare(Mobile o1, Mobile o2) {
                return (int) (o1.getPrice() - o2.getPrice());
            }
        });*/

        //Collections.sort(mobiles,(o1,o2) -> (int) (o1.getPrice() - o2.getPrice()));

        //mobiles.stream().sorted(new PriceSorter()).forEach(System.out::println);

        /*mobiles.stream()
                .sorted(new Comparator<Mobile>() {
                    @Override
                    public int compare(Mobile o1, Mobile o2) {
                        return (int) (o1.getPrice() - o2.getPrice());
                    }
                })
                .forEach(System.out::println);
         */
        /*mobiles.stream()
                .sorted((o1,o2)-> (int) (o1.getPrice() - o2.getPrice()))
                .forEach(System.out::println);
        */
        mobiles.stream()
                .sorted(Comparator.comparing(Mobile::getPrice).reversed())
                .forEach(System.out::println);
    }

    public void sortMobilesByModel(){

        /*
        Collections.sort(mobiles,new ModelSorter());
        mobiles.forEach(System.out::println);
        */

        /*Collections.sort(mobiles,new Comparator<Mobile>(){
            @Override
            public int compare(Mobile o1, Mobile o2) {
                return o1.getModel().compareTo(o2.getModel());
            }
        });
        mobiles.forEach(System.out::println);
        */

        /*Collections.sort(mobiles,(o1,o2) -> o1.getModel().compareTo(o2.getModel()));
        mobiles.forEach(System.out::println);
        */

        /*
        mobiles.stream().sorted(new ModelSorter())
                .forEach(System.out::println);
        */

        /*mobiles.stream()
                .sorted(new Comparator<Mobile>() {
                    @Override
                    public int compare(Mobile o1, Mobile o2) {
                        return o1.getModel().compareTo(o2.getModel());
                    }
                })
                .forEach(System.out::println);
         */

        /*mobiles.stream()
                .sorted((o1,o2)-> o1.getModel().compareTo(o2.getModel()))
                .forEach(System.out::println);
        */

        mobiles.stream()
                .sorted(Comparator.comparing(Mobile::getModel).reversed())
                .forEach(System.out::println);
    }

    public void discountColumn(){
        //New Column with discounted price for all mobiles
        mobiles.stream()
                .map(mobile -> new MobilesWithDiscount(
                        mobile.getId(),
                        mobile.getBrand(),
                        mobile.getModel(),
                        mobile.getYearLaunched(),
                        mobile.getPrice(),
                        mobile.getPrice() - (mobile.getPrice() * 0.20)))
                .forEach(System.out::println);
    }
    public void countMobilesOnEachBrand(){
        //Count mobiles for each brand
        Map<String, Long> mobilesCount = mobiles.stream()
                .collect(Collectors.groupingBy(Mobile::getBrand,Collectors.counting()));
        mobilesCount.forEach((key, value) -> System.out.println(key + " - " + value));
    }

    public void MinMobilePriceOnEachBrand(){
        //Show Minimum Mobile price for each Brand
        Map<String, Optional<Mobile>> mobilesMin = mobiles.stream()
                .collect(
                        Collectors.groupingBy(Mobile::getBrand,
                                Collectors.minBy(Comparator.comparingDouble(Mobile::getPrice))));
        mobilesMin.forEach((key, value) -> System.out.println(value.get()));
    }

    public void MaxMobilePriceOnEachBrand(){
        //Show Maximum mobile price for each brand
        Map<String, Optional<Mobile>> mobilesMin = mobiles.stream()
                .collect(
                        Collectors.groupingBy(Mobile::getBrand,
                                Collectors.maxBy(Comparator.comparingDouble(Mobile::getPrice))));
        mobilesMin.forEach((key, value) -> System.out.println(value.get()));
    }
}
