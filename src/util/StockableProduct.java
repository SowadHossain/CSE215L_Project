package util;

import javax.naming.InsufficientResourcesException;

public class StockableProduct extends Product implements Stockable {

    private int numberOfItemsStocked;

    public StockableProduct(String name , int productId, double price, String genre, int yearPublished, double discount, int numberOfItemsStocked) {
        super(name, productId, price, genre, yearPublished, discount);
        this.numberOfItemsStocked = numberOfItemsStocked;
    }



    @Override
    public void addStock(int num) {
        this.numberOfItemsStocked += num;
    }

    @Override
    public void removeStock(int num)throws InsufficientResourcesException , InsufficientStockException {
        if (this.numberOfItemsStocked >= num) {
            this.numberOfItemsStocked -= num;
        } else {
            try {
                throw new InsufficientStockException("Insufficient stock to remove " + num + " items. Current stock: " + this.numberOfItemsStocked);
            } catch (InsufficientStockException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public void editStock(int num) {

        if (num > 0) {
            addStock(num);
        } else if (num < 0) {
            try {
                removeStock(-num);
            } catch (InsufficientResourcesException | InsufficientStockException e) {

            }
        } else {

        }
    }

    @Override
    public String getInfo() {

        return null;
    }

    public int getNumberOfItemsInStock() {
        return numberOfItemsStocked;
    }


}
class InsufficientStockException extends Exception {
    public InsufficientStockException(String message) {
        super(message);
    }
}


