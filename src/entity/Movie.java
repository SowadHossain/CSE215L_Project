package entity;

import util.StockableProduct;

import java.io.Serializable;

public class Movie extends StockableProduct implements Serializable {

    private String director ;

    public Movie(
            int productId, String name, double price, int yearPublished, String genre, double discount, int numberOfItemsStocked, String director) {
        super(name, productId, price,  genre,  yearPublished,  discount,  numberOfItemsStocked);
        this.director = director;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }


    public String toString() {
        return ""+ super.getProductId()+ " " +super.getName() +
                " " + super.getPrice() + " " + super.getYearPublished() +
                " " + super.getGenre() + " "+ super.getDiscount() +
                " " + super.getNumberOfItemsInStock() +
                " " + getDirector() ;
    }

    public String getInfo() {
        String string = "Name: " + super.getName();
        string += "\nutil.Product Id: " + super.getProductId();
        string += "\nYear Published: " + super.getYearPublished();
        string += "\nGenre: " + super.getGenre();
        string += "\nDiscount: " + super.getDiscount();
        string += "\nPrice: " + super.getPrice();
        string += "\nDirector's Name: " + getDirector();
        string += "\n";

        return string;
    }
}