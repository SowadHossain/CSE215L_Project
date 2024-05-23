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

        for (Product ob : cart){
            for(StockableProduct sp : LoadDataSaveData.getInventoryData()){\
                if(ob.getProductId() == sp.getProductId()){
                    if(sp.getClass().getName().contains("Movie")) {
                        movies++;
                        break;
                    } else if (sp.getClass().getName().contains("Music")) {
                        musics++;
                        break;
                    }else if (sp.getClass().getName().contains("Game")) {
                        games++;
                        break;
                    }
                }
            }
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

    public void nuberOfItemsStockOfEachSoldProduct(){
        System.out.println("Available Stocks of Sold Products in Inventory:");
        String st = "";
        for (Product p: cart) {
            for (StockableProduct ob : LoadDataSaveData.getInventoryData()) {
                if (p.getProductId() == ob.getProductId()) {
                    String catagory = "";
                    if (ob.getClass().getName().contains("Movies")) {
                        catagory = "Movie";
                    }
                    if (ob.getClass().getName().contains("Music")) {
                        catagory = "Music";
                    }
                    if (ob.getClass().getName().contains("Game")) {
                        catagory = "Game";
                    }
                    st +="Name: " + ob.getName() + ", Category " + catagory + " Items Available: " + ob.getNumberOfItemsInStock();
                    System.out.println(st);
                    st = "";
                    break;
                }
            }
        }
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
