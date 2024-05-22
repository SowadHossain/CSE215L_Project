package entity;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;

import util.*;

public class Invoice {
    private ArrayList<Product> items;
    private ArrayList<Product> cart;
    private LocalDate date;

    public Invoice(){

    }
    public String getLocalDateTime (){
        LocalDate localDate = LocalDate.now();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return dateFormat.format(localDate);
    }
    public void addProduct(Product product){
        cart.add(product);
    }
    public void removeProduct(Product product){
        cart.remove(product);
    }
    private double calculatePriceWithoutDiscount(){
        double totalPrice = 0;
        for (Product o : cart){
            totalPrice += o.getPrice();
        }
        return totalPrice;
    }
    public boolean isFullHouseDiscountAvailable(){

        return true;
    }
    private double calculateDiscountedPrice(){
        double discountedPrice = 0,fullHousediscountPrice = 0;
        double priceWithoutDiscount = calculatePriceWithoutDiscount();
        for (Product o : cart){
            discountedPrice += o.getPrice() - o.getDiscount()*o.getPrice()/100;
        }
        if(isFullHouseDiscountAvailable()){
            fullHousediscountPrice = priceWithoutDiscount - 50*priceWithoutDiscount/100;
            if(fullHousediscountPrice < discountedPrice)
                return fullHousediscountPrice;
        }
        return discountedPrice;
    }

    public String getInvoice(){
        String bill = "";
        bill += "Date - " + getLocalDateTime();
        for (Product p : cart){
            bill += "\nName: " + p.getName() +", Price: " + p.getPrice();
        }
        bill += "\nTotal Price : " + calculatePriceWithoutDiscount();
        bill += "\nPrice after discount: " + calculateDiscountedPrice();
        return bill;
    }



}
