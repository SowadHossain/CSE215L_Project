package entity;

import util.StockableProduct;

import java.io.Serializable;

public class Game extends StockableProduct implements Serializable {

    private String developer;

    public Game(int productId, String name, double price, int yearPublished, String genre, double discount, int numberOfItemsStocked, String developer) {
        super(name, productId,  price,  genre,  yearPublished,  discount,  numberOfItemsStocked);
        this.developer = developer;
    }

    public String getDeveloper() {
        return this.developer;
    }

    public void setDeveloper(String developer) {
        this.developer = developer;
    }


    public String toString() {
        return ""+ super.getProductId()+ " " +super.getName() +
                " " + super.getPrice() + " " + super.getYearPublished() +
                " " + super.getGenre() + " "+ super.getDiscount() +
                " " + super.getNumberOfItemsInStock() +
                " " + getDeveloper() ;
    }

    public String getInfo() {
        String string = "Name: " + super.getName();
        string += "\nutil.Product Id: " + super.getProductId();
        string += "\nYear Published: " + super.getYearPublished();
        string += "\nGenre: " + super.getGenre();
        string += "\nDiscount: " + super.getDiscount();
        string += "\nPrice: " + super.getPrice();
        string += "\nDeveloper's Name: " + getDeveloper();
        string += "\n";

        return string;
    }
}