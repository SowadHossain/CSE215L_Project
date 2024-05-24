package entity;

import dbMangers.LoadDataSaveData;
import util.*;

import java.util.ArrayList;


public class Inventory {
    private ArrayList<StockableProduct> items;

    public Inventory(ArrayList<StockableProduct> items){
        this.items = items;
    }
    public void addItems(StockableProduct product){
        items.add(product);
    }
    public void removeItem(int productID){
        for (int i = 0; i < items.size(); i++)
        {
            int id = items.get(i).getProductId();
            if(productID == id) {
                items.remove(i);
            }
        }
    }
    public Product getItem(int ProductID){
        System.out.println(items.size());
        for (StockableProduct p : items){
            int id = p.getProductId();
            if(ProductID == id){
                try {
                    p.removeStock(1);
                }catch (Exception e){
                    e.printStackTrace();
                }
                return p;
            }
        }
        return null;
    }
    public void addProductStock(int productID, int numberOfNewStock){
        for (StockableProduct p : items){
            int id = p.getProductId();
            if(productID == id){
                p.addStock(numberOfNewStock);
            }
        }
    }

    public void sortByPrice(){
        //Collection.sort(items,Comparator.comparingDouble(util.StockableProduct::getPrice));
        //items.sort((a,b) -> a.getPrice().compare(b.getPrice()));
        //using bubble sort
        for (int i = 0; i < items.size(); i++) {
            for (int j = 0; j < items.size(); j++) {
                if(items.get(j).getPrice() > items.get(j+1).getPrice()){
                    StockableProduct temp = items.get(j);
                    items.set(j,items.get(j+1));
                    items.set(j+1,temp);
                }

            }
        }
    }
    public ArrayList<StockableProduct> getItems(){
        return items;
    }
    public void sortByAvailableStock(){
        for (int i = 0; i < items.size(); i++) {
            for (int j = 0; j < items.size(); j++) {
                if(items.get(j).getNumberOfItemsInStock() < items.get(j+1).getNumberOfItemsInStock()){
                    StockableProduct temp = items.get(j);
                    items.set(j,items.get(j+1));
                    items.set(j+1,temp);
                }
            }
        }
    }
}
