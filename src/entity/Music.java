package entity;

import util.StockableProduct;

import java.io.Serializable;

public class Music extends StockableProduct implements Serializable {

    private String artistName;

    public Music( int productId, String name, double price, int yearPublished, String genre, double discount, int numberOfItemsStocked){
        super(name, productId,  price,  genre,  yearPublished,  discount,  numberOfItemsStocked);
    }
    public Music( int productId, String name, double price, int yearPublished, String genre, double discount, int numberOfItemsStocked, String artistName) {
        super(name, productId,  price,  genre,  yearPublished,  discount,  numberOfItemsStocked);
        this.artistName = artistName ;
    }

    public String getName() {
        return this.artistName;
    }

    public void setName(String artistName) {
        this.artistName = artistName;
    }


    public String toString() {
        return "entity.Music [artistName = " + artistName + "]";
    }


    public String getInfo() {
        String string = "Name: " + super.getName();
        string += "\nutil.Product Id: " + super.getProductId();
        string += "\nYear Published: " + super.getYearPublished();
        string += "\nGenre: " + super.getGenre();
        string += "\nDiscount: " + super.getDiscount();
        string += "\nPrice: " + super.getPrice();
        string += "\nArtist's Name: " + getName();
        string += "\n";

        return string;
    }
}