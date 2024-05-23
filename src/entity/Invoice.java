package entity;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;

import dbMangers.LoadDataSaveData;
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
        StockableProduct tempSotckableProduct;
        for (int i = 0; i < LoadDataSaveData.getInventoryData().size(); i++) {
            tempSotckableProduct = LoadDataSaveData.getInventoryData().get(i);
            if(tempSotckableProduct.getName() == product.getName()){
                if(tempSotckableProduct.getNumberOfItemsInStock() == 0){
                    break;
                }else{
                    cart.add(product);
                    LoadDataSaveData.getInventoryData().get(i).editStock(-1);
                    break;
                }
            }
        }
    }
    public void removeProduct(Product product){
        cart.remove(product);
        StockableProduct tempSotckableProduct;
        for (int i = 0; i < LoadDataSaveData.getInventoryData().size(); i++) {
            tempSotckableProduct = LoadDataSaveData.getInventoryData().get(i);
            if(tempSotckableProduct.getName() == product.getName()){
                    LoadDataSaveData.getInventoryData().get(i).editStock(1);
                    break;
            }
        }
    }
    private double calculatePriceWithoutDiscount(){
        double totalPrice = 0;
        for (Product o : cart){
            totalPrice += o.getPrice();
        }
        return totalPrice;
    }
    public boolean isFullHouseDiscountAvailable(){
        int movies = 0,musics = 0,games = 0;
        //Product ids are 6 digits the first digit of the id represents the catagory;
        // 1 for movies
        // 2 for music
        // 3 for games
        for (Product ob : cart){
            int temp = ob.getProductId()/100000;
            if(temp == 1) movies++;
            else if (temp == 2) musics++;
            else if (temp == 3) games++;
        }
        if(movies >= 2 && musics >= 2 && games >= 2 )
            return true;
        else return false;
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
