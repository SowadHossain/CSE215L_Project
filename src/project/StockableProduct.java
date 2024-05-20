package project;

import javax.naming.InsufficientResourcesException;

public class StockableProduct extends Product implements Stockable {

    private int numberOfItemsStocked;

    public StockableProduct(int productId, String name, double price, String genre, int yearPublished, double discount, int numberOfItemsStocked) {
        super(productId, name, price, genre, yearPublished, discount);
        this.numberOfItemsStocked = numberOfItemsStocked;
    }



    @Override
    public void addStock(int num) {
        this.numberOfItemsStocked += num;
    }

    @Override
    public void removeStock(int num) throws InsufficientResourcesException, InsufficientStockException {
        if (this.numberOfItemsStocked >= num) {
            this.numberOfItemsStocked -= num;
        } else {
            throw new InsufficientStockException("Insufficient stock to remove " + num + " items. Current stock: " + this.numberOfItemsStocked);
        }
    }

    @Override
    public void editStock(int num) {

        if (num > 0) {
            addStock(num);
        } else if (num < 0) {
            try {
                removeStock(-num); // Convert negative num to positive for removal
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

